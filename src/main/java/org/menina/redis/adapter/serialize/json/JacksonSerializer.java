package org.menina.redis.adapter.serialize.json;

import com.fasterxml.jackson.core.JsonProcessingException;
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
        try {
            return mapper.writeValueAsBytes(value);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    @Override
    protected <T> T doDeserialize(byte[] bytes, Class<T> mapperTo) {
        try {
            return mapper.readValue(bytes, mapperTo);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
}
