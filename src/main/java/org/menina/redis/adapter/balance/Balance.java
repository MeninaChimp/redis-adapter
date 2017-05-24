package org.menina.redis.adapter.balance;

import java.util.List;

/**
 * author: Menina
 */

public interface Balance<T> {

    void setProviders(List<T> providers);

    T getNode();
}
