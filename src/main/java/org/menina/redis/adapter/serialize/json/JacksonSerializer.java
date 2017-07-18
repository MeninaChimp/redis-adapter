package org.menina.redis.adapter.serialize.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.menina.redis.adapter.serialize.SerializerAdapter;

import java.io.IOException;

/**
 * author: Menina
 */
public class JacksonSerializer extends SerializerAdapter {

    private static ObjectMapper mapper = new ObjectMapper();

    @Override
    protected byte[] doSerialize(Object value) {
        return new byte[0];
    }

    @Override
    protected <T> T doDeserialize(byte[] bytes) {
        try {
            return (T)mapper.readValue(bytes, Object.class);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
}
