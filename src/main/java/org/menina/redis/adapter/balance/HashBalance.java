package org.menina.redis.adapter.balance;

import java.util.List;

/**
 * Created by Menina
 * Hash 负载均衡实现不了了，有点遗憾。
 */
public class HashBalance<T> extends AbstractBalance<T>{
    @Override
    public void setProviders(List<T> providers) {
        this.providers = providers;
    }

    @Override
    public T getNode() {
//        int index = condition.hashCode() % this.providers.size();
//        return this.providers.get(index);
        return null;
    }
}
