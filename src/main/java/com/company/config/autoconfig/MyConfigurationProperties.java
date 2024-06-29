package com.company.config.autoconfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * packageName    : com.company.config.autoconfig
 * fileName       : MyConfigurationProperties
 * author         : ipeac
 * date           : 24. 6. 25.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 25.        ipeac       최초 생성
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyConfigurationProperties {
    String prefix();
}