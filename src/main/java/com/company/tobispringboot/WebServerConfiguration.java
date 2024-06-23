package com.company.tobispringboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * packageName    : com.company.tobispringboot
 * fileName       : WebServerConfiguration
 * author         : ipeac
 * date           : 24. 6. 23.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 23.        ipeac       최초 생성
 */
@Configuration(proxyBeanMethods = false)
public class WebServerConfiguration {
    @Bean
    public ServletWebServerFactory servletWebServerFactory() {
        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        serverFactory.setPort(9090);
        
        return serverFactory;
    }
}