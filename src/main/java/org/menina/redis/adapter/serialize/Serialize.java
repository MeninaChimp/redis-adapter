package org.menina.redis.adapter.serialize;

/**
 * author: Menina
 */

public interface Serialize{

    <T> T deserialize(byte[] data);

    <T> byte[] serialize(T t);

}
