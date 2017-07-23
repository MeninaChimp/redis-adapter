package org.menina.redis.adapter.extend;

/**
 * author: Menina
 */
public interface ExtendOperationSupport {

    <T> T get(String key, Class<T> mapperTo);

    void set(String key, Object value);
}
