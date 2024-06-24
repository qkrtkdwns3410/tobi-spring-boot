package com.company.config.autoconfig;

import com.company.config.MyAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * packageName    : com.company.config.autoconfig
 * fileName       : PropertyPlaceholderConfig
 * author         : ipeac
 * date           : 24. 6. 24.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 24.        ipeac       최초 생성
 */
@MyAutoConfiguration
public class PropertyPlaceholderConfig {
    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}