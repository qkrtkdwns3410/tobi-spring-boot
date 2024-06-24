package com.company.config.autoconfig;

import org.springframework.beans.factory.annotation.Value;

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
public class ServerProperties {
    @Value("${contextPath:}")
    private String contextPath;
    
    @Value("${port:8080}")
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