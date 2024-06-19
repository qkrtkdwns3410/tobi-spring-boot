package com.company.tobispringboot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * packageName    : com.company.tobispringboot
 * fileName       : HelloDecorator
 * author         : ipeac
 * date           : 24. 6. 19.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 19.        ipeac       최초 생성
 */
@Service
@Primary
public class HelloDecorator implements HelloService {
    private final HelloService helloService;
    
    public HelloDecorator(HelloService helloService) {
        this.helloService = helloService;
    }
    
    @Override
    public String hello(String name) {
        return "*" + helloService.hello(name) + "*";
    }
}