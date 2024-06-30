package com.company.tobispringboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * packageName    : com.company.tobispringboot
 * fileName       : HelloRepositoryJdbcTest
 * author         : ipeac
 * date           : 24. 6. 30.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 30.        ipeac       최초 생성
 */
@SpringBootTest
class HelloRepositoryJdbcTest {
    @Autowired
    HelloRepository helloRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Test
    void findHelloFailed() {
        Hello hello = helloRepository.findHello("ipeac");
        Assertions.assertThat(hello).isNull();
    }
    
    @Test
    void increaseCount() {
        helloRepository.increaseCount("ipeac");
        Hello hello = helloRepository.findHello("ipeac");
        Assertions.assertThat(hello.getCount()).isEqualTo(1);
        
        helloRepository.increaseCount("ipeac");
        hello = helloRepository.findHello("ipeac");
        Assertions.assertThat(hello.getCount()).isEqualTo(2);
    }
}