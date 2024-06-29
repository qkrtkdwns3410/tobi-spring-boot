package com.company.config.autoconfig;

import org.springframework.stereotype.Component;

/**
 * packageName    : com.company.config.autoconfig
 * fileName       : ServerProperties
 * author         : ipeac
 * date           : 24. 6. 24.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 24.        ipeac       최초 생성
 */
@Component
@MyConfigurationProperties(prefix = "server")
public class ServerProperties {
    private String contextPath;
    
    private int port;
    
    public String getContextPath() {
        return contextPath;
    }
    
    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }
    
    public int getPort() {
        return port;
    }
    
    public void setPort(int port) {
        this.port = port;
    }
}