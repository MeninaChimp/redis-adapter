package org.menina.redis.adapter.register;

import java.util.List;

/**
 * author: Menina
 */
public class RegisterHolder {

    private List<Register> registers;

    public RegisterHolder addRegister(RegisterType registerType, Class<?> clz){
        if(!clz.isInstance(registerType.getType())){
            throw new IllegalArgumentException(String.format("Illegal register type, %s not instance of %s", clz, registerType.getType()));
        }

        Register register = new Register(registerType, clz);
        registers.add(register);
        return this;
    }
}
