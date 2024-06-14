package com.company.tobispringboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

public class TobiSpringBootApplication {
    
    public static void main(String[] args) {
        ServletWebServerFactory factory = new TomcatServletWebServerFactory();
        
        WebServer webServer = factory.getWebServer();
        webServer.start();
    }
}