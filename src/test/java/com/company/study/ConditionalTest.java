package com.company.study;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName    : com.company.study
 * fileName       : ConditionalTest
 * author         : ipeac
 * date           : 24. 6. 21.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 21.        ipeac       최초 생성
 */
public class ConditionalTest {
    @Test
    void conditional() {
        // true
        ApplicationContextRunner contextRunner = new ApplicationContextRunner()
                                                         .withUserConfiguration(Config1.class)
                                                         .run(context -> {
                                                             assertThat(context).hasSingleBean(MyBean.class);
                                                             assertThat(context).hasSingleBean(Config1.class);
                                                         });
        
        // false
        ApplicationContextRunner contextRunner2 = new ApplicationContextRunner()
                                                          .withUserConfiguration(Config2.class)
                                                          .run(context -> {
                                                              assertThat(context).doesNotHaveBean(MyBean.class);
                                                              assertThat(context).doesNotHaveBean(Config2.class);
                                                          });
    }
    
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @Conditional(BooleanCondition.class)
    @interface BooleanConditional {
        boolean value();
    }
    
    static class BooleanCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return (boolean) Objects.requireNonNull(metadata.getAnnotationAttributes(BooleanConditional.class.getName())).get("value");
        }
    }
    
    @Configuration
    @BooleanConditional(true)
    static class Config1 {
        @Bean
        MyBean myBean() {
            return new MyBean();
        }
    }
    
    @Configuration
    @BooleanConditional(false)
    static class Config2 {
        @Bean
        MyBean myBean() {
            return new MyBean();
        }
    }
    
    static class MyBean {
    
    }
    
    static class TrueCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return true;
        }
    }
    
    static class FalseCondition implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return false;
        }
    }
}