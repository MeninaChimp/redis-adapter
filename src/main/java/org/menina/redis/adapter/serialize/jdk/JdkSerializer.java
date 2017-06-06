package org.menina.redis.adapter.serialize.jdk;

import lombok.extern.slf4j.Slf4j;
import org.menina.redis.adapter.serialize.SerializerAdapter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by zhenghao on 2017/5/31.
 */
@Slf4j
public class JdkSerializer extends SerializerAdapter {

    @Override
    protected byte[] doSerialize(Object value) {
        byte[] result = null;
        try {
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream(256);
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteStream);
                objectOutputStream.writeObject(value);
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


    @Override
    protected <T> T doDeserialize(byte[] bytes) {
        T result = null;
        try {
            ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(byteStream);
                try {
                    result = (T) objectInputStream.readObject();
                } catch (ClassNotFoundException ex) {
                    throw new Exception("Failed to deserialize object type", ex);
                }
            } catch (Throwable ex) {
                throw new Exception("Failed to deserialize", ex);
            }
        } catch (Exception e) {
            log.error("Failed to deserialize", e);
        }

        return result;
    }
}
