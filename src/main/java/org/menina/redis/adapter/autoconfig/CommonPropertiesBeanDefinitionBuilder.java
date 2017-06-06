package org.menina.redis.adapter.autoconfig;

import lombok.extern.slf4j.Slf4j;
import org.menina.redis.adapter.properties.CommonProperties;
import org.menina.redis.adapter.utils.Constant;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * author: Menina
 */

@Component
@Slf4j
public class CommonPropertiesBeanDefinitionBuilder implements BeanFactoryPostProcessor, PriorityOrdered, InitializingBean {

    private static final Properties COMMMONPROPERTIES = new Properties();

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        DefaultListableBeanFactory applicationContext = ((DefaultListableBeanFactory) beanFactory);
        PropertiesBeanDefinitionBuilder builder = new PropertiesBeanDefinitionBuilder(BeanDefinitionBuilder.rootBeanDefinition(CommonProperties.class));
        if (Boolean.parseBoolean(COMMMONPROPERTIES.getProperty(Constant.ENABLE_CODIS_CONFIG, "false"))) {
            builder.registerProperty(Constant.ENABLE_CODIS_CONFIG, "true")
                    .registerProperty("pass")
                    .registerProperty("timeout", 3000)
                    .registerProperty("maxIdle", 1000)
                    .registerProperty("minIdle", 0)
                    .registerProperty("maxTotal", 2000)
                    .registerProperty("maxWaitMillis", 2000)
                    .registerProperty("timeBetweenEvictionRunsMillis", 30000)
                    .registerProperty("minEvictableIdleTimeMillis", 30000)
                    .registerProperty("testOnBorrow", true)
                    .registerProperty("testOnCreate", false)
                    .registerProperty("encode", "UTF-8")
                    .registerProperty("unlock", false)
                    .registerProperty("db", 0)
                    .registerProperty("clientName")
                    .registerProperty("zookeeperAddress")
                    .registerProperty("zookeeperSessionTimeout", 60 * 1000)
                    .registerProperty("zookeeperConnectTimeout", 1000)
                    .registerProperty("nodePath");
            applicationContext.registerBeanDefinition("commonProperties", builder.build().getBeanDefinition());
            return;
        }

        if (Boolean.parseBoolean(COMMMONPROPERTIES.getProperty(Constant.ENABLE_READWRITE_CONFIG, "false"))) {
            builder.registerProperty(Constant.ENABLE_READWRITE_CONFIG, true)
                    .registerProperty("read.host")
                    .registerProperty("read.port")
                    .registerProperty("read.pass")
                    .registerProperty("read.timeout", 3000)
                    .registerProperty("read.maxIdle", 1000)
                    .registerProperty("read.minIdle", 0)
                    .registerProperty("read.maxTotal", 2000)
                    .registerProperty("read.maxWaitMillis", 2000)
                    .registerProperty("read.timeBetweenEvictionRunsMillis", 30000)
                    .registerProperty("read.minEvictableIdleTimeMillis", 30000)
                    .registerProperty("read.testOnBorrow", true)
                    .registerProperty("read.testOnCreate", false)
                    .registerProperty("read.encode", "UTF-8")
                    .registerProperty("read.unlock", false)
                    .registerProperty("read.db", 0)
                    .registerProperty("read.clientName")

                    .registerProperty("write.host")
                    .registerProperty("write.port")
                    .registerProperty("write.pass")
                    .registerProperty("write.timeout", 3000)
                    .registerProperty("write.maxIdle", 1000)
                    .registerProperty("write.minIdle", 0)
                    .registerProperty("write.maxTotal", 2000)
                    .registerProperty("write.maxWaitMillis", 2000)
                    .registerProperty("write.timeBetweenEvictionRunsMillis", 30000)
                    .registerProperty("write.minEvictableIdleTimeMillis", 30000)
                    .registerProperty("write.testOnBorrow", true)
                    .registerProperty("write.testOnCreate", false)
                    .registerProperty("write.encode", "UTF-8")
                    .registerProperty("write.unlock", false)
                    .registerProperty("write.db", 0)
                    .registerProperty("write.clientName");
            applicationContext.registerBeanDefinition("commonProperties", builder.build().getBeanDefinition());
            return;
        }

        builder.registerProperty(Constant.ENABLE_CODIS_CONFIG, false)
                .registerProperty(Constant.ENABLE_READWRITE_CONFIG, false)
                .registerProperty("host")
                .registerProperty("port")
                .registerProperty("pass")
                .registerProperty("timeout", 3000)
                .registerProperty("maxIdle", 1000)
                .registerProperty("minIdle", 0)
                .registerProperty("maxTotal", 2000)
                .registerProperty("maxWaitMillis", 2000)
                .registerProperty("timeBetweenEvictionRunsMillis", 30000)
                .registerProperty("minEvictableIdleTimeMillis", 30000)
                .registerProperty("testOnBorrow", true)
                .registerProperty("testOnCreate", false)
                .registerProperty("encode", "UTF-8")
                .registerProperty("unlock", "false")
                .registerProperty("db", 0)
                .registerProperty("clientName");
        applicationContext.registerBeanDefinition("commonProperties", builder.build().getBeanDefinition());
    }

    private void loadRedisProperties() {
        InputStream in = TemplateAutoConfiguration.class.getClassLoader().getResourceAsStream("redis.properties");
        if (in == null) {
            throw new RuntimeException("redis.properties not found");
        }

        try {
            COMMMONPROPERTIES.load(in);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }

    private static class PropertiesBeanDefinitionBuilder {

        private BeanDefinitionBuilder beanDefinitionBuilder;

        private PropertiesBeanDefinitionBuilder(BeanDefinitionBuilder beanDefinitionBuilder) {
            this.beanDefinitionBuilder = beanDefinitionBuilder;
        }

        public PropertiesBeanDefinitionBuilder registerProperty(String key) {
            beanDefinitionBuilder.addPropertyValue(removeSepatator(key), COMMMONPROPERTIES.getProperty(key));
            return this;
        }

        public PropertiesBeanDefinitionBuilder registerProperty(String key, Object defaultValue) {

            beanDefinitionBuilder.addPropertyValue(removeSepatator(key), COMMMONPROPERTIES.getProperty(key, defaultValue.toString()));
            return this;
        }


        public BeanDefinitionBuilder build() {
            return this.beanDefinitionBuilder;
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.loadRedisProperties();
    }

    /**
     * 去掉分隔符，转换为驼峰命名
     * @param target
     * @return
     */
    private static String removeSepatator(String target){
        StringBuilder stringBuilder = null;
        if(target.contains(".")){
            String[] parts = target.split("\\.");
            stringBuilder = new StringBuilder(parts[0]);
            for(int i = 1; i < parts.length; i++){
                stringBuilder.append(parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1));
            }
        }

        return stringBuilder == null ? target : stringBuilder.toString();
    }
}

