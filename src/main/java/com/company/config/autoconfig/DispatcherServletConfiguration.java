package com.company.config.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * packageName    : com.company.config
 * fileName       : DispatcherServletConfiguration
 * author         : ipeac
 * date           : 24. 6. 19.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 19.        ipeac       최초 생성
 */
@Configuration
public class DispatcherServletConfiguration {
    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }
}