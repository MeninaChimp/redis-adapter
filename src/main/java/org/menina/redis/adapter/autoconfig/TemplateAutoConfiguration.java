package org.menina.redis.adapter.autoconfig;

import lombok.extern.slf4j.Slf4j;
import org.menina.redis.adapter.pool.PoolFactory;
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

    @Bean
    public RedisTemplate redisClientTemplate() {
        if(defaultPoolFactory.isCodisPoolFactory()){
            RedisTemplate template = new RedisTemplate();
            template.setDataSource(defaultPoolFactory.getCodisPool());
            return template;
        }

        if(defaultPoolFactory.isReadWritePoolFactory()){
            this.readRedisTemplate = new RedisTemplate();
            this.readRedisTemplate.setDataSource(defaultPoolFactory.getReadPool());
            this.writeRedisTemplate = new RedisTemplate();
            this.writeRedisTemplate.setDataSource(defaultPoolFactory.getWritePool());
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(RedisTemplate.class);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    if(WriteOperation.isWriteOperation(method.getName())){
                        return method.invoke(writeRedisTemplate, objects);
                    }

                    return method.invoke(readRedisTemplate, objects);
                }
            });

            return (RedisTemplate)enhancer.create();
        }

        RedisTemplate template = new RedisTemplate();
        template.setDataSource(defaultPoolFactory.getPool());
        return template;
    }
}
