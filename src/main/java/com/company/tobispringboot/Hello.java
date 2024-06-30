package com.company.tobispringboot;

/**
 * packageName    : com.company.tobispringboot
 * fileName       : Hello
 * author         : ipeac
 * date           : 24. 6. 30.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 30.        ipeac       최초 생성
 */
public class Hello {
    private String name;
    private int count;
    
    public Hello(String name, int count) {
        this.name = name;
        this.count = count;
    }
    
    public String getName() {
        return name;
    }
    
    public int getCount() {
        return count;
    }
}