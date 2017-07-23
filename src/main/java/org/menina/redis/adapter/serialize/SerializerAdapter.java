package org.menina.redis.adapter.serialize;

/**
 * author: Menina
 */

public abstract class SerializerAdapter implements Serializer {

    @Override
    public byte[] serialize(Object value) {
        if (value == null) {
            return new byte[0];
        }

        return this.doSerialize(value);
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> mapperTo) {
        if (isEmpty(bytes)) {
            return null;
        }

        return this.doDeserialize(bytes, mapperTo);
    }

    protected boolean isEmpty(byte[] data) {
        return (data == null || data.length == 0);
    }

    protected abstract byte[] doSerialize(Object value);

    protected abstract <T> T doDeserialize(byte[] bytes, Class<T> mapperTo);
}
