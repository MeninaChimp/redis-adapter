package org.menina.redis.adapter.autoconfig.conditions;

import org.menina.redis.adapter.properties.CommonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by Menina on 2017/6/6.
 */
public class ReadWriteCondition implements Condition{

    @Autowired
    private CommonProperties commonProperties;

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return commonProperties.isEnableReadwriteConfig();
    }
}
