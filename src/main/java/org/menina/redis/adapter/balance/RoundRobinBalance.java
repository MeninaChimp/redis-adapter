package org.menina.redis.adapter.balance;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * author: Menina
 */

public class RoundRobinBalance<T> extends AbstractBalance<T> {

    private AtomicInteger currentIndex = new AtomicInteger(-1);

    public RoundRobinBalance() {
    }

    public RoundRobinBalance(List<T> providers) {
        this.providers = providers;
    }

    @Override
    public void setProviders(List<T> providers) {
        this.providers = providers;
    }

    @Override
    public T getNode() {
        while (true){
            int index = currentIndex.get();
            int next = index >= providers.size() - 1 ? 0 : index + 1;
            if (currentIndex.compareAndSet(index, next)){
                return providers.get(next);
            }
        }
    }
}
