package org.menina.redis.adapter.autoconfig;

import lombok.extern.slf4j.Slf4j;
import org.menina.redis.adapter.balance.Balance;
import org.menina.redis.adapter.extend.ExtendOperationSupport;
import org.menina.redis.adapter.extend.RedisTemplateDelegator;
import org.menina.redis.adapter.pool.CodisPool;
import org.menina.redis.adapter.pool.PoolFactory;
import org.menina.redis.adapter.properties.CommonProperties;
import org.menina.redis.adapter.serialize.Serializer;
import org.menina.redis.adapter.template.RedisTemplate;
import org.menina.redis.adapter.utils.WriteOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.annotation.Bean;
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

    @Autowired
    private CommonProperties commonProperties;

    @Autowired(required = false)
    private Serializer serializer;

    @Autowired (required = false)
    private Balance balance;

    @Bean
    public RedisTemplate redisTemplate() {
        if(this.commonProperties.isEnableCodisConfig()){
            RedisTemplate template = new RedisTemplate();
            CodisPool codisPool = (CodisPool)defaultPoolFactory.getCodisPool();
            if(null != this.balance){
                codisPool.setBalanceStrategy(balance);
            }

            template.setDataSource(codisPool);
            return template;
        }

        if(this.commonProperties.isEnableReadwriteConfig()){
            this.readRedisTemplate = new RedisTemplate();
            this.writeRedisTemplate = new RedisTemplate();
            this.readRedisTemplate.setDataSource(defaultPoolFactory.getReadPool());
            this.writeRedisTemplate.setDataSource(defaultPoolFactory.getWritePool());
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

        RedisTemplate template = new RedisTemplate();
        template.setDataSource(defaultPoolFactory.getPool());
        return template;
    }

    @Bean
    public ExtendOperationSupport redisTemplateDelegator(){
        RedisTemplateDelegator delegator = new RedisTemplateDelegator();
        if(null != this.serializer){
            delegator.setSerializer(serializer);
        }

        return delegator;
    }
}
