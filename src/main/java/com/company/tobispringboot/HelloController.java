package com.company.tobispringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
    @GetMapping("/hello")
    public String hello(String name) {
        return name + ", world!";
    }
}