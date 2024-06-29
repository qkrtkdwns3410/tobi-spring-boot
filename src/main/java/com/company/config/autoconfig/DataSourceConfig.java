package com.company.config.autoconfig;

import com.company.config.ConditionalMyOnClass;
import com.company.config.MyAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

/**
 * packageName    : com.company.config.autoconfig
 * fileName       : DataSourceConfig
 * author         : ipeac
 * date           : 24. 6. 29.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 29.        ipeac       최초 생성
 */
@MyAutoConfiguration
@ConditionalMyOnClass("org.springframework.jdbc.core.JdbcOperations")
public class DataSourceConfig {
    @Bean
    DataSource dataSource(DataSourceProperties properties) {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        
        dataSource.setDriverClass(org.h2.Driver.class);
        dataSource.setUrl("jdbc:h2:mem:testdb");
        
        return dataSource;
    }
}