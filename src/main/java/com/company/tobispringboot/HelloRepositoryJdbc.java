package com.company.tobispringboot;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * packageName    : com.company.tobispringboot
 * fileName       : HelloRepositoryJdbc
 * author         : ipeac
 * date           : 24. 6. 30.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 30.        ipeac       최초 생성
 */
@Repository
public class HelloRepositoryJdbc implements HelloRepository {
    private final JdbcTemplate jdbcTemplate;
    
    public HelloRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public Hello findHello(String name) {
        try {
            return jdbcTemplate.queryForObject(
                    "select * from hello where name = '" + name + "'",
                    (rs, rowNum) -> new Hello(rs.getString("name"), rs.getInt("count"))
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    
    @Override
    public void increaseCount(String name) {
        Hello hello = findHello(name);
        if (hello == null) {
            jdbcTemplate.update("insert into hello(name, count) values(?, ?)", name, 1);
        } else {
            jdbcTemplate.update("update hello set count = count + 1 where name = ?", name);
        }
    }
    
    @Override
    public int countOf(String name) {
        return jdbcTemplate.queryForObject(
                "select count(*) from hello where name = ?", new Object[]{name}, Integer.class
        );
    }
}