package org.menina.redis.adapter.balance;

import org.menina.redis.adapter.utils.NetUtils;

import java.util.List;

/**
 * Created by Menina
 */
public class IpHashBalance<T> extends AbstractBalance<T>{
    @Override
    public void setProviders(List<T> providers) {
        this.providers = providers;
    }

    @Override
    public T getNode() {
        int index = NetUtils.getLocalAddress().hashCode() % this.providers.size();
        return this.providers.get(index);
    }
}
