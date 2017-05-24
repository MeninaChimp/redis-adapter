package org.menina.redis.adapter.properties;

import lombok.Data;

/**
 * author: Menina
 */

@Data
public class CommonProperties {

    private boolean enableCodisConfig;
    private boolean enableReadwriteConfig;
    private String host;
    private int port;
    private String pass;
    private int timeout;
    private int maxIdle;
    private int minIdle;
    private int maxTotal;
    private long maxWaitMillis;
    private int timeBetweenEvictionRunsMillis;
    private int minEvictableIdleTimeMillis;
    private boolean testOnBorrow;
    private boolean testOnCreate;
    private String encode;
    private int db;
    private boolean unlock;
    private String clientName;

    private String readHost;
    private int readPort;
    private String readPass;
    private int readTimeout;
    private int readMaxIdle;
    private int readMinIdle;
    private int readMaxTotal;
    private long readMaxWaitMillis;
    private int readTimeBetweenEvictionRunsMillis;
    private int readMinEvictableIdleTimeMillis;
    private boolean readTestOnBorrow;
    private boolean readTestOnCreate;
    private String readEncode;
    private int readDb;
    private boolean readUnlock;
    private String readClientName;

    private String writeHost;
    private int writePort;
    private String writePass;
    private int writeTimeout;
    private int writeMaxIdle;
    private int writeMinIdle;
    private int writeMaxTotal;
    private long writeMaxWaitMillis;
    private int writeTimeBetweenEvictionRunsMillis;
    private int writeMinEvictableIdleTimeMillis;
    private boolean writeTestOnBorrow;
    private boolean writeTestOnCreate;
    private String writeEncode;
    private int writeDb;
    private boolean writeUnlock;
    private String writeClientName;

    private String zookeeperAddress;
    private int zookeeperSessionTimeout;
    private int zookeeperConnectTimeout;
    private String nodePath;
}
