package org.menina.redis.adapter.pool;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.menina.redis.adapter.balance.Balance;
import org.menina.redis.adapter.balance.BalanceStrategy;
import org.menina.redis.adapter.balance.RoundRobinBalance;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisException;
import redis.clients.util.Pool;

import java.util.Map;

/**
 * author: Menina
 */
@Slf4j
public class CodisPool extends Pool<Jedis> implements BalanceStrategy {

    private CuratorFramework zkClient;
    private String nodePath;
    private JedisPoolConfig jedisPoolConfig;
    private int sessionTimeout;
    private int connectionTimeout;
    private String password;
    private int db;
    private String clientName;
    private PathChildrenCache watcher;
    private volatile Balance balance = new RoundRobinBalance();
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private volatile ImmutableList<PooledObject> pools = ImmutableList.of();
    private static final ImmutableSet<PathChildrenCacheEvent.Type> WATCHER_EVENT_TYPE = Sets.immutableEnumSet(
            PathChildrenCacheEvent.Type.CHILD_ADDED,
            PathChildrenCacheEvent.Type.CHILD_UPDATED,
            PathChildrenCacheEvent.Type.CHILD_REMOVED);

    private CodisPool() {
    }

    private CodisPool(Builder builder) {
        this.zkClient = builder.zkClient;
        this.nodePath = builder.nodePath;
        this.jedisPoolConfig = builder.jedisPoolConfig;
        this.sessionTimeout = builder.sessionTimeout;
        this.connectionTimeout = builder.connectionTimeout;
        this.password = builder.password;
        this.db = builder.db;
        this.clientName = builder.clientName;
        this.init();
    }

    public void init() {
        this.zkClient.start();
        watcher = new PathChildrenCache(this.zkClient, this.nodePath, true);
        watcher.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                if (WATCHER_EVENT_TYPE.contains(pathChildrenCacheEvent.getType())) {
                    resetPool();
                }
            }
        });

        try{
            watcher.start(PathChildrenCache.StartMode.BUILD_INITIAL_CACHE);
        }catch (Exception e){
            throw new JedisException(e.getMessage(), e);
        }

        resetPool();

    }

    @Override
    public void setBalanceStrategy(Balance balance) {
        this.balance = balance;
    }

    private static final class PooledObject{
        private String proxyAddress;
        private Pool<Jedis> pool;

        public PooledObject(String proxyAddress, Pool<Jedis> pool){
            this.proxyAddress = proxyAddress;
            this.pool = pool;
        }
    }

    @Data
    @JsonIgnoreProperties(
            ignoreUnknown = true
    )
    private static class CodisProxyInfo{
        private String proxy_addr;
    }

    public static class Builder {

        private CuratorFramework zkClient;
        private String nodePath;
        private JedisPoolConfig jedisPoolConfig;
        private int sessionTimeout;
        private int connectionTimeout;
        private String password;
        private int db;
        private String clientName;

        public Builder(CuratorFramework zkClient, String nodePath, JedisPoolConfig jedisPoolConfig) {
            this.zkClient = zkClient;
            this.nodePath = nodePath;
            this.jedisPoolConfig = jedisPoolConfig;
        }

        public Builder sessionTimeout(int sessionTimeout) {
            this.sessionTimeout = sessionTimeout;
            return this;
        }

        public Builder connectionTimeout(int connectionTimeout) {
            this.connectionTimeout = connectionTimeout;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder db(int db) {
            this.db = db;
            return this;
        }

        public Builder clientName(String clientName) {
            this.clientName = clientName;
            return this;
        }

        public CodisPool build() {
            return new CodisPool(this);
        }
    }

    private void resetPool() {
        Map<String, PooledObject> record = Maps.newHashMapWithExpectedSize(this.pools.size());
        ImmutableList.Builder<PooledObject> builder = ImmutableList.builder();
        for (PooledObject pooledObject : this.pools){
            record.put(pooledObject.proxyAddress, pooledObject);
        }

        for (ChildData childData : watcher.getCurrentData()){
            try{
                CodisProxyInfo codisProxyInfo = MAPPER.readValue(childData.getData(), CodisProxyInfo.class);
                PooledObject pooledObject = record.remove(codisProxyInfo.proxy_addr);
                if (pooledObject == null) {
                    log.info("Add new proxy: " + codisProxyInfo.proxy_addr);
                    String[] hostAndPort = codisProxyInfo.proxy_addr.split(":");
                    String host = hostAndPort[0];
                    int port = Integer.parseInt(hostAndPort[1]);
                    pooledObject = new PooledObject(codisProxyInfo.proxy_addr, new JedisPool(
                            this.jedisPoolConfig,
                            host,
                            port,
                            this.connectionTimeout,
                            this.sessionTimeout,
                            this.password,
                            this.db,
                            this.clientName));
                }

                builder.add(pooledObject);
            } catch (Throwable t) {
                log.warn("parse " + childData.getPath() + " failed", t);
            }
        }

        this.pools = builder.build();
        for (PooledObject pool: record.values()) {
            log.info("Remove proxy: " + pool.proxyAddress);
            pool.pool.close();
        }
    }

    public Jedis getResource() {
        if(pools.isEmpty()){
            throw new JedisException("没有可用的codis proxy");
        }

        balance.setProviders(this.pools);
        return ((PooledObject)balance.getNode()).pool.getResource();
    }
}