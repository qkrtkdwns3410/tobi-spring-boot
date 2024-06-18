package com.company.tobispringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping("/hello")
public class HelloController {
    private final HelloService helloService;
    
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }
    
    @GetMapping
    @ResponseBody
    public String hello(String name) {
        return helloService.hello(Objects.requireNonNull(name));
    }
}