package org.menina.redis.adapter.autoconfig;

import lombok.extern.slf4j.Slf4j;
import org.menina.redis.adapter.autoconfig.conditions.CodisConditon;
import org.menina.redis.adapter.autoconfig.conditions.ConditionOnMissingRedisTemplate;
import org.menina.redis.adapter.autoconfig.conditions.ReadWriteCondition;
import org.menina.redis.adapter.balance.Balance;
import org.menina.redis.adapter.pool.CodisPool;
import org.menina.redis.adapter.pool.PoolFactory;
import org.menina.redis.adapter.serialize.Serializer;
import org.menina.redis.adapter.template.RedisTemplate;
import org.menina.redis.adapter.utils.WriteOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * author: Menina
 */

@Configuration
@Slf4j
public class TemplateAutoConfiguration {

    private RedisTemplate readRedisTemplate;
    private RedisTemplate writeRedisTemplate;

    @Autowired
    private PoolFactory defaultPoolFactory;

    @Autowired (required = false)
    private Serializer serializer;

    @Autowired (required = false)
    private Balance balance;

    @Bean
    @Conditional(CodisConditon.class)
    public RedisTemplate redisTemplateForCodis() {
        RedisTemplate template = new RedisTemplate();
        CodisPool codisPool = (CodisPool)defaultPoolFactory.getCodisPool();
        if(null != this.balance){
            codisPool.setBalanceStrategy(balance);
        }

        if(null != this.serializer){
            template.setSerializer(serializer);
        }

        template.setDataSource(codisPool);
        return template;
    }

    @Bean
    @Conditional(ReadWriteCondition.class)
    public RedisTemplate redisTemplateForReadWrite() {
        this.readRedisTemplate = new RedisTemplate();
        this.writeRedisTemplate = new RedisTemplate();
        this.readRedisTemplate.setDataSource(defaultPoolFactory.getReadPool());
        this.writeRedisTemplate.setDataSource(defaultPoolFactory.getWritePool());
        if(null != this.serializer){
            this.readRedisTemplate.setSerializer(serializer);
            this.writeRedisTemplate.setSerializer(serializer);
        }

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RedisTemplate.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                if (WriteOperation.isWriteOperation(method.getName())) {
                    return method.invoke(writeRedisTemplate, objects);
                }

                return method.invoke(readRedisTemplate, objects);
            }
        });

        return (RedisTemplate) enhancer.create();
    }

    @Bean
    @Conditional(ConditionOnMissingRedisTemplate.class)
    public RedisTemplate redisTemplate() {
        RedisTemplate template = new RedisTemplate();
        if(null != this.serializer){
            template.setSerializer(serializer);
        }

        template.setDataSource(defaultPoolFactory.getPool());
        return template;
    }
}
