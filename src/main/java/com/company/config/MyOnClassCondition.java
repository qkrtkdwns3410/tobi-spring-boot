package com.company.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;
import org.springframework.util.MultiValueMap;

/**
 * packageName    : com.company.config
 * fileName       : MyOnClassCondition
 * author         : ipeac
 * date           : 24. 6. 23.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 23.        ipeac       최초 생성
 */
public class MyOnClassCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        MultiValueMap<String, Object> attrs = metadata.getAllAnnotationAttributes(ConditionalMyOnClass.class.getName());
        String className = (String) attrs.getFirst("value");
        return ClassUtils.isPresent(className, context.getClassLoader());
    }
}