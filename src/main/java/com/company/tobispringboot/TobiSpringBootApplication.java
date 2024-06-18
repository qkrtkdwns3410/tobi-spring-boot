package com.company.tobispringboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class TobiSpringBootApplication {
    @Bean
    public HelloController helloController(HelloService helloService) {
        return new HelloController(helloService);
    }
    
    @Bean
    public HelloService helloService() {
        return new SimpleHelloService();
    }
    
    public static void main(String[] args) {
        // 변경된 부분.. GenericApplicationContext 이라는 스프링 컨테이너를 사용한다.
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();
                
                ServletWebServerFactory factory = new TomcatServletWebServerFactory();
                
                WebServer webServer = factory.getWebServer(servletContext -> {
                    servletContext.addServlet("dispatcherServlet",
                            new DispatcherServlet(this)
                    ).addMapping("/*");
                });
                
                webServer.start();
            }
        };
        applicationContext.register(TobiSpringBootApplication.class);
        applicationContext.refresh();
    }
}