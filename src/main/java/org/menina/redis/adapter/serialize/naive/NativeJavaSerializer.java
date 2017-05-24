package org.menina.redis.adapter.serialize.naive;

import lombok.extern.slf4j.Slf4j;
import org.menina.redis.adapter.serialize.SerializeAdapter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * author: Menina
 */

@Slf4j
public class NativeJavaSerializer extends SerializeAdapter {

    @Override
    public <T> T doDeserialize(byte[] data) {
        Object result = null;
        if (data.length == 0) {
            return null;
        }

        try {
            ByteArrayInputStream byteStream = new ByteArrayInputStream(data);
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(byteStream);
                try {
                    result = objectInputStream.readObject();
                } catch (ClassNotFoundException ex) {
                    throw new Exception("Failed to deserialize object type", ex);
                }
            } catch (Throwable ex) {
                throw new Exception("Failed to deserialize", ex);
            }
        } catch (Exception e) {
            log.error("Failed to deserialize", e);
        }

        return (T) result;
    }

    @Override
    public <T> byte[] doSerialize(T t) {
        byte[] result = null;
        try {
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream(128);
            try {
                if (!(t instanceof Serializable)) {
                    throw new IllegalArgumentException(NativeJavaSerializer.class.getSimpleName() + " requires a Serializable payload " +
                            "but received an object of type [" + t.getClass().getName() + "]");
                }
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteStream);
                objectOutputStream.writeObject(t);
                objectOutputStream.flush();
                result = byteStream.toByteArray();
            } catch (Throwable ex) {
                throw new Exception("Failed to serialize", ex);
            }
        } catch (Exception ex) {
            log.error("Failed to serialize", ex);
        }

        return result;
    }
}
