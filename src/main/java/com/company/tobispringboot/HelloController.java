package com.company.tobispringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * packageName    : com.company.tobispringboot
 * fileName       : HelloControlle
 * author         : ipeac
 * date           : 24. 6. 14.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 14.        ipeac       최초 생성
 */
@RestController
public class HelloController {
    private final HelloService helloService;
    
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }
    
    @GetMapping("/hello")
    public String hello(String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        
        return helloService.hello(name);
    }
    
    @GetMapping("/count")
    public String count(String name) {
        return name + " count is " + helloService.countOf(name);
    }
}