package com.company.tobispringboot;

import com.company.config.MySpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MySpringBootApplication
public class TobiSpringBootApplication {
    
    @Bean
    ApplicationRunner applicationRunner(Environment env) {
        return args -> {
            env.getProperty("my.name");
            System.out.println("Hello, " + env.getProperty("my.name"));
        };
    }
    
    public static void main(String[] args) {
        MySpringApplication.run(TobiSpringBootApplication.class, args);
    }
}