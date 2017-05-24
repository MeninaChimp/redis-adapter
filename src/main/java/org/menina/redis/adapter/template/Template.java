package org.menina.redis.adapter.template;

import redis.clients.jedis.Jedis;
import redis.clients.util.Pool;

/**
 * author: Menina
 */
public abstract class Template {

    protected Pool<Jedis> resourcePool;

    public abstract void setDataSource(Pool<Jedis> resourcePool);

    public abstract void returnResource(Jedis jedis);

}
