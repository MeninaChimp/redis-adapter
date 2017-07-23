package org.menina.redis.adapter.serialize;

/**
 * author: Menina
 */

public interface Serializer {

    byte[] serialize(Object value);

    <T> T deserialize(byte[] bytes, Class<T> mapperTo);
}
