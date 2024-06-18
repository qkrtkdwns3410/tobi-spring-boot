package com.company.tobispringboot;

import org.springframework.stereotype.Service;

/**
 * packageName    : com.company.tobispringboot
 * fileName       : SimpleHelloService
 * author         : ipeac
 * date           : 24. 6. 17.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 17.        ipeac       최초 생성
 */
@Service
public class SimpleHelloService implements HelloService {
    
    @Override
    public String hello(String name) {
        return "hello, " + name;
    }
}