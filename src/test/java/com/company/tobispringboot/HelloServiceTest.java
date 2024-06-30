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
        HelloService helloService = new SimpleHelloService(getHelloRepositoryStub);
        
        String result = helloService.hello("jun");
        
        assertThat(result).isEqualTo("hello, jun");
    }
    
    private static HelloRepository getHelloRepositoryStub =
            new HelloRepository() {
                @Override
                public Hello findHello(String name) {
                    return null;
                }
                
                @Override
                public void increaseCount(String name) {
                
                }
            };
    
    @Test
    void helloDecorator() {
        HelloDecorator helloDecorator = new HelloDecorator(new HelloService() {
            @Override
            public String hello(String name) {
                return "";
            }
            
            @Override
            public int countOf(String name) {
                return 0;
            }
        });
        
        String result = helloDecorator.hello("jun");
        
        assertThat(result).isEqualTo("*jun*");
    }
    
}