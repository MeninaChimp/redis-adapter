package org.menina.redis.adapter.balance;

import java.util.List;

/**
 * author: Menina
 */

public abstract class AbstractBalance<T> implements Balance<T>{

    protected volatile List<T> providers;

}
