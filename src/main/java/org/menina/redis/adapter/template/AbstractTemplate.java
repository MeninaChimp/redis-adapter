package org.menina.redis.adapter.template;

import org.menina.redis.adapter.serialize.Serializer;
import org.menina.redis.adapter.serialize.json.JacksonSerializer;
import redis.clients.jedis.Jedis;
import redis.clients.util.Pool;

/**
 * Created by Menina
 */
public abstract class AbstractTemplate implements Template{

    protected Pool<Jedis> resourcePool;

    protected Serializer serializer = new JacksonSerializer();

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

    public void setSerializer(Serializer serializer){
        this.serializer = serializer;
    }

    @Override
    public Serializer getSerializer() {
        return this.serializer;
    }
}
