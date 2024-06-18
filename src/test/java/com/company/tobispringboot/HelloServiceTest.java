package com.company.tobispringboot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName    : com.company.tobispringboot
 * fileName       : HelloServiceTest
 * author         : ipeac
 * date           : 24. 6. 18.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 18.        ipeac       최초 생성
 */
public class HelloServiceTest {
    @Test
    void SimpleHelloService() {
        HelloService helloService = new SimpleHelloService();
        
        String result = helloService.hello("jun");
        
        assertThat(result).isEqualTo("hello, jun");
    }
    
}