package com.company.config.autoconfig;

/**
 * packageName    : com.company.config.autoconfig
 * fileName       : MyDataSourceProperties
 * author         : ipeac
 * date           : 24. 6. 30.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 30.        ipeac       최초 생성
 */
@MyConfigurationProperties(prefix = "data")
public class MyDataSourceProperties {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    
    
    public String getDriverClassName() {
        return driverClassName;
    }
    
    public String getUrl() {
        return url;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
}