package com.company.tobispringboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * packageName    : com.company.tobispringboot
 * fileName       : HelloControllerTest
 * author         : ipeac
 * date           : 24. 6. 18.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 18.        ipeac       최초 생성
 */
public class HelloControllerTest {
    @Test
    void helloController() {
        HelloController helloController = new HelloController(name -> name);
        
        String ret = helloController.hello("Test");
        
        Assertions.assertThat(ret).isEqualTo("Test");
    }
    
    @Test
    void failHelloController() {
        HelloController helloController = new HelloController(name -> name);
        
        Assertions.assertThatThrownBy(() -> {
            String ret = helloController.hello(null);
        }).isInstanceOf(IllegalArgumentException.class);
        
        Assertions.assertThatThrownBy(() -> {
            String ret = helloController.hello("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}