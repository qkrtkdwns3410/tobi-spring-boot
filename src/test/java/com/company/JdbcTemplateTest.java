package com.company;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * packageName    : com.company
 * fileName       : JdbcTemplateTest
 * author         : ipeac
 * date           : 24. 6. 30.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 30.        ipeac       최초 생성
 */
@HellobootTest
public class JdbcTemplateTest {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @BeforeEach
    void init() {
        jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key , count int)");
    }
    
    @Test
    void insertAndQuery() {
        jdbcTemplate.update("insert into hello values (?, ?)", "ipeac", 1);
        jdbcTemplate.update("insert into hello values (?, ?)", "tobi", 3);
        
        Long count = jdbcTemplate.queryForObject(
                "select count(*) from hello",
                Long.class
        );
        
        Assertions.assertThat(count).isEqualTo(2);
    }
}