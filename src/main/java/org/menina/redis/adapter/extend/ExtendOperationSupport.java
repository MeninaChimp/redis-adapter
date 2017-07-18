package org.menina.redis.adapter.extend;

/**
 * author: Menina
 */
public interface ExtendOperationSupport<T> {

    T get(String key);

    void set(String key, T value);
}
