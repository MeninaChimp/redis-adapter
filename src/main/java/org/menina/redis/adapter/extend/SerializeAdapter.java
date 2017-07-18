package org.menina.redis.adapter.extend;

import org.menina.redis.adapter.serialize.Serializer;
import org.menina.redis.adapter.serialize.json.JacksonSerializer;

/**
 * author: Menina
 */
public abstract class SerializeAdapter implements Serialize{

    protected Serializer serializer = new JacksonSerializer();

    public void setSerializer(Serializer serializer){
        this.serializer = serializer;
    }

    @Override
    public Serializer getSerializer() {
        return this.serializer;
    }
}
