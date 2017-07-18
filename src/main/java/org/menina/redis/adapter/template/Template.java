package org.menina.redis.adapter.template;

import org.menina.redis.adapter.serialize.Serializer;
import redis.clients.jedis.Jedis;
import redis.clients.util.Pool;

/**
 * author: Menina
 */
public interface Template {

    void setDataSource(Pool<Jedis> resourcePool);

    void returnResource(Jedis jedis);

}
