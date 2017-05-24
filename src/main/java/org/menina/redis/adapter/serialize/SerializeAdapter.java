package org.menina.redis.adapter.serialize;

/**
 * author: Menina
 */

public abstract class SerializeAdapter implements Serialize {

    public <T> T deserialize(byte[] data) {
        if (data == null || data.length == 0) {
            return null;
        }

        return doDeserialize(data);
    }

    public <T> byte[] serialize(T t) {
        if (t == null) {
            return null;
        }

        return doSerialize(t);
    }

    public abstract <T> T doDeserialize(byte[] data);

    public abstract <T> byte[] doSerialize(T t);
}
