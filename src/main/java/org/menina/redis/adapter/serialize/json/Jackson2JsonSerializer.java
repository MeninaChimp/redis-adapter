package org.menina.redis.adapter.serialize.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.menina.redis.adapter.serialize.SerializeAdapter;

/**
 * author: Menina
 */

@Slf4j
public class Jackson2JsonSerializer extends SerializeAdapter {

    private static ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T doDeserialize(byte[] data) {
        try {
            return (T)mapper.readValue(data, Object.class);
        } catch (Throwable t) {
            log.error(t.getMessage(), t);
            throw new RuntimeException(t.getMessage(), t);
        }
    }

    @Override
    public <T> byte[] doSerialize(T t) {
        try {
            return mapper.writeValueAsBytes(t);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
