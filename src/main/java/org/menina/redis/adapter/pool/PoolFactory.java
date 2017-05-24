package org.menina.redis.adapter.pool;

import redis.clients.util.Pool;

/**
 * author: Menina
 */

public interface PoolFactory<T> {

    boolean isCodisPoolFactory();

    boolean isReadWritePoolFactory();

    Pool<T> getPool();

    Pool<T> getCodisPool();

    Pool<T> getReadPool();

    Pool<T> getWritePool();

}
