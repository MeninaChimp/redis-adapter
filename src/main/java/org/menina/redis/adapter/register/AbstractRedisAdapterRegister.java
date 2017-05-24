package org.menina.redis.adapter.register;

/**
 * author: Menina
 */
public abstract class AbstractRedisAdapterRegister {

    private RegisterHolder registerHolder = new RegisterHolder();

    public abstract RegisterHolder register();

    public RegisterHolder getRegisterHolder() {
        return registerHolder;
    }

}
