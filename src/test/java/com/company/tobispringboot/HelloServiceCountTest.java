package com.company.tobispringboot;

import com.company.HellobootTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.IntStream;

/**
 * packageName    : com.company.tobispringboot
 * fileName       : HelloServiceCountTest
 * author         : ipeac
 * date           : 24. 6. 30.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 30.        ipeac       최초 생성
 */
@HellobootTest
class HelloServiceCountTest {
    @Autowired
    HelloService helloService;
    
    @Autowired
    HelloRepository helloRepository;
    
    @Test
    void sayHelloIncreaseCount() {
        //1 ~ 10 까지 반복
        IntStream.range(1, 11).forEach(count -> {
            helloService.hello("Toby");
            Assertions.assertThat(helloRepository.countOf("Toby")).isEqualTo(count);
        });
    }
    
    @Test
    void countOf() {
    
    }
}