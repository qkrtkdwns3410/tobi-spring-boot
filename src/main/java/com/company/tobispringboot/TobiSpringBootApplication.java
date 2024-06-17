package com.company.tobispringboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TobiSpringBootApplication {
    
    public static void main(String[] args) {
        //변경된 부분.. GenericApplicationContext 이라는 스프링 컨테이너를 사용한다.
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean(HelloController.class);
        context.refresh();
        //빈을 등록하고 초기화하는 작업을 수행한다.
        
        ServletWebServerFactory factory = new TomcatServletWebServerFactory();
        
        WebServer webServer = factory.getWebServer(servletContext -> {
            
            servletContext.addServlet("frontController", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
                    if (req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
                        String name = req.getParameter("name");
                        
                        //추가 - 빈을 가져와서 사용한다.
                        HelloController helloController = context.getBean(HelloController.class);
                        String ret = helloController.hello(name);
                        
                        resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
                        resp.getWriter().println(ret);
                    } else {
                        resp.setStatus(HttpStatus.NOT_FOUND.value());
                    }
                    
                }
            }).addMapping("/*");
        });
        
        webServer.start();
    }
}