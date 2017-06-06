package org.menina.redis.adapter.autoconfig.conditions;

import org.menina.redis.adapter.template.RedisTemplate;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by Menina on 2017/6/6.
 */
public class ConditionOnMissingRedisTemplate implements Condition, ApplicationContextAware{

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return applicationContext.getBean(RedisTemplate.class) == null;
    }
}
