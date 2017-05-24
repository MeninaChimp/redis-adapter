package org.menina.redis.adapter.register;

import org.menina.redis.adapter.balance.Balance;
import org.menina.redis.adapter.serialize.Serialize;

/**
 * author: Menina
 */
public enum RegisterType {

    SERIALIZE(Serialize.class),
    BALANCE(Balance.class);

    private Class<?> clz;

    private RegisterType(Class<?> clz){
        this.clz = clz;
    }

    public Class<?> getType(){
        return this.clz;
    }
}
