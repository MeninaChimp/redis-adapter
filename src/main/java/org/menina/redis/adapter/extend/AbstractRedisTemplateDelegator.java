package org.menina.redis.adapter.extend;

import org.menina.redis.adapter.template.RedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * author: Menina
 */
public abstract class AbstractRedisTemplateDelegator extends SerializeAdapter implements ExtendOperationSupport {

    @Autowired
    protected RedisTemplate redisTemplate;

    @Override
    public <T> T get(String key, Class<T> mapperTo) {
        return this.getSerializer().deserialize(redisTemplate.get(key.getBytes()), mapperTo);
    }

    @Override
    public void set(String key, Object value) {
        redisTemplate.set(key.getBytes(), this.getSerializer().serialize(value));
    }
}
