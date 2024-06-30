package com.company.tobispringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TobiSpringBootApplication {
    private final JdbcTemplate jdbcTemplate;
    
    public TobiSpringBootApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @PostConstruct
    void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
    }
    
    public static void main(String[] args) {
        SpringApplication.run(TobiSpringBootApplication.class, args);
    }
}