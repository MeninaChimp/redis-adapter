package org.menina.redis.adapter.register;

import lombok.Data;

/**
 * author: Menina
 */
@Data
public class Register {

    private RegisterType registerType;
    private Class<?> registerClass;

    private Register(){}

    public Register(RegisterType registerType, Class<?> clz){
        this.registerType = registerType;
        this.registerClass = clz;
    }
}
