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
    private final HelloRepository helloRepository;
    
    public SimpleHelloService(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }
    
    @Override
    public String hello(String name) {
        this.helloRepository.increaseCount(name);
        
        return "hello, " + name;
    }
    
    @Override
    public int countOf(String name) {
        return this.helloRepository.countOf(name);
    }
}