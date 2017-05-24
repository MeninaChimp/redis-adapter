package org.menina.redis.adapter.pool;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.menina.redis.adapter.properties.CommonProperties;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.util.Pool;

/**
 * author: Menina
 */

@Component("defaultPoolFactory")
public class DefaultPoolFactory implements PoolFactory<Jedis>, InitializingBean {

    private boolean codisPoolFactory;
    private boolean readWritePoolFactory;

    @Autowired
    private CommonProperties commonProperties;

    @Override
    public boolean isCodisPoolFactory() {
        return this.codisPoolFactory;
    }

    @Override
    public boolean isReadWritePoolFactory() {
        return this.readWritePoolFactory;
    }

    @Override
    public Pool<Jedis> getPool() {
        JedisPoolConfig jedisPoolConfig = this.jedisPoolConfig(
                commonProperties.getMaxTotal(),
                commonProperties.getMaxIdle(),
                commonProperties.getMinIdle(),
                commonProperties.getMaxWaitMillis(),
                commonProperties.getTimeBetweenEvictionRunsMillis(),
                commonProperties.getMinEvictableIdleTimeMillis(),
                commonProperties.isTestOnBorrow(),
                commonProperties.isTestOnCreate());

        JedisPool jedisPool = this.jedisPool(jedisPoolConfig,
                commonProperties.getHost(),
                commonProperties.getPort(),
                commonProperties.getTimeout(),
                "".equals(commonProperties.getPass()) ? null : commonProperties.getPass(),
                commonProperties.getDb(),
                commonProperties.getClientName());

        return jedisPool;
    }

    @Override
    public Pool<Jedis> getCodisPool() {
        JedisPoolConfig jedisPoolConfig = this.jedisPoolConfig(
                commonProperties.getMaxTotal(),
                commonProperties.getMaxIdle(),
                commonProperties.getMinIdle(),
                commonProperties.getMaxWaitMillis(),
                commonProperties.getTimeBetweenEvictionRunsMillis(),
                commonProperties.getMinEvictableIdleTimeMillis(),
                commonProperties.isTestOnBorrow(),
                commonProperties.isTestOnCreate());
        CuratorFramework zkClient = CuratorFrameworkFactory.newClient(commonProperties.getZookeeperAddress(),
                commonProperties.getZookeeperSessionTimeout(),
                commonProperties.getZookeeperConnectTimeout(),
                new ExponentialBackoffRetry(1000, 3));

        return new CodisPool.Builder(zkClient, commonProperties.getNodePath(), jedisPoolConfig)
                .connectionTimeout(commonProperties.getTimeout())
                .sessionTimeout(commonProperties.getTimeout())
                .password("".equals(commonProperties.getPass()) ? null : commonProperties.getPass())
                .db(commonProperties.getDb())
                .clientName(commonProperties.getClientName())
                .build();
    }

    @Override
    public Pool<Jedis> getReadPool() {
        JedisPoolConfig jedisPoolConfig = this.jedisPoolConfig(
                commonProperties.getReadMaxTotal(),
                commonProperties.getReadMaxIdle(),
                commonProperties.getReadMinIdle(),
                commonProperties.getReadMaxWaitMillis(),
                commonProperties.getReadTimeBetweenEvictionRunsMillis(),
                commonProperties.getReadMinEvictableIdleTimeMillis(),
                commonProperties.isTestOnBorrow(),
                commonProperties.isTestOnCreate());

        JedisPool jedisPool = this.jedisPool(jedisPoolConfig,
                commonProperties.getReadHost(),
                commonProperties.getReadPort(),
                commonProperties.getReadTimeout(),
                "".equals(commonProperties.getReadPass()) ? null : commonProperties.getReadPass(),
                commonProperties.getReadDb(),
                commonProperties.getReadClientName());

        return jedisPool;
    }

    @Override
    public Pool<Jedis> getWritePool() {
        JedisPoolConfig jedisPoolConfig = this.jedisPoolConfig(
                commonProperties.getWriteMaxTotal(),
                commonProperties.getWriteMaxIdle(),
                commonProperties.getWriteMinIdle(),
                commonProperties.getWriteMaxWaitMillis(),
                commonProperties.getWriteTimeBetweenEvictionRunsMillis(),
                commonProperties.getWriteMinEvictableIdleTimeMillis(),
                commonProperties.isTestOnBorrow(),
                commonProperties.isTestOnCreate());

        JedisPool jedisPool = this.jedisPool(jedisPoolConfig,
                commonProperties.getWriteHost(),
                commonProperties.getWritePort(),
                commonProperties.getWriteTimeout(),
                "".equals(commonProperties.getWritePass()) ? null : commonProperties.getWritePass(),
                commonProperties.getWriteDb(),
                commonProperties.getWriteClientName());

        return jedisPool;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (this.commonProperties.isEnableCodisConfig()) {
            this.codisPoolFactory = true;
        }

        if (this.commonProperties.isEnableReadwriteConfig()) {
            this.readWritePoolFactory = true;
        }
    }

    private JedisPoolConfig jedisPoolConfig(int maxTotal,
                                            int maxIdle,
                                            int minIdle,
                                            long maxWaitMills,
                                            int timeBetweenEvictionRunsMillis,
                                            int minEvictableIdleTimeMillis,
                                            boolean testOnBorrow,
                                            boolean testOnCreate) {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        jedisPoolConfig.setTestOnCreate(testOnCreate);
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        jedisPoolConfig.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMills);
        return jedisPoolConfig;
    }

    private JedisPool jedisPool(JedisPoolConfig jedisPoolConfig,
                                String host,
                                int port,
                                int timeout,
                                String pass,
                                int db,
                                String clientName) {
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, pass, db, clientName);
        return jedisPool;
    }
}
