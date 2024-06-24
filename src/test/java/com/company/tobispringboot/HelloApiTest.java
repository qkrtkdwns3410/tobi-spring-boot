package com.company.tobispringboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName    : com.company.tobispringboot
 * fileName       : HelloApiTest
 * author         : ipeac
 * date           : 24. 6. 18.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 18.        ipeac       최초 생성
 */
public class HelloApiTest {
    @Test
    void helloApi() {
        // given
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        
        ResponseEntity<String> response =
                testRestTemplate.getForEntity("http://localhost:9090/app/hello?name={name}", String.class, "jun");
        
        // status code 200
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        // header content-type: text/plain
        assertThat(response.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        // body: hello, jun
        assertThat(response.getBody()).isEqualTo("*hello, jun*");
    }
    
    @Test
    void failshelloApi() {
        // given
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        
        ResponseEntity<String> response =
                testRestTemplate.getForEntity("http://localhost:9090/app/hello?name=", String.class);
        
        // status code 200
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}