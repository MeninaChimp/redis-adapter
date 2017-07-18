package org.menina.redis.adapter.extend;

import org.menina.redis.adapter.template.RedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * author: Menina
 */
public abstract class AbstractRedisTemplateDelegator<T> extends SerializeAdapter implements ExtendOperationSupport<T> {

    @Autowired
    protected RedisTemplate redisTemplate;

    @Override
    public T get(String key) {
        return this.getSerializer().deserialize(redisTemplate.get(key.getBytes()));
    }

    @Override
    public void set(String key, T value) {
        redisTemplate.set(key.getBytes(), this.getSerializer().serialize(value));
    }
}
