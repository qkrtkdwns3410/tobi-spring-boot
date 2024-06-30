package com.company.config.autoconfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * packageName    : com.company.config.autoconfig
 * fileName       : DataSourceConfigTest
 * author         : ipeac
 * date           : 24. 6. 30.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 30.        ipeac       최초 생성
 */
@JdbcTest
class DataSourceConfigTest {
    @Autowired
    DataSource dataSource;
    
    @Test
    void connect() throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.close();
    }
}