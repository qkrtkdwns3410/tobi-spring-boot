package com.company.config.autoconfig;

import com.company.config.MyAutoConfiguration;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * packageName    : com.company.config.autoconfig
 * fileName       : PropertyPostProcessorConfig
 * author         : ipeac
 * date           : 24. 6. 25.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 25.        ipeac       최초 생성
 */
@MyAutoConfiguration
public class PropertyPostProcessorConfig {
    @Bean
    public BeanPostProcessor propertyPostProcessor(Environment env) {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) {
                MyConfigurationProperties annotation = AnnotationUtils.findAnnotation(bean.getClass(), MyConfigurationProperties.class);
                if (annotation == null) return bean;
                
                Map<String, Object> attrs = AnnotationUtils.getAnnotationAttributes(annotation);
                String prefix = (String) attrs.get("prefix");
                
                return Binder.get(env).bindOrCreate(prefix, bean.getClass());
            }
        };
    }
}