package org.menina.redis.adapter.extend;

import org.menina.redis.adapter.serialize.Serializer;

/**
 * author: Menina
 */
public interface Serialize {

    void setSerializer(Serializer serializer);

    Serializer getSerializer();
}
