package org.menina.redis.adapter.template;

import redis.clients.jedis.Jedis;
import redis.clients.util.Pool;

/**
 * Created by Menina
 */
public abstract class AbstractTemplate implements Template{

    protected Pool<Jedis> resourcePool;

    @Override
    public void setDataSource(Pool<Jedis> resourcePool) {
        this.resourcePool = resourcePool;
    }

    @Override
    public void returnResource(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
