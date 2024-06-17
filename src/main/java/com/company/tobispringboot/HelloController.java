package com.company.tobispringboot;

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
public class HelloController {
    
    public String hello(String name) {
        SimpleHelloService helloService = new SimpleHelloService();
        
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}