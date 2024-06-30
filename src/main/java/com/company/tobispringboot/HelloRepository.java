package com.company.tobispringboot;

/**
 * packageName    : com.company
 * fileName       : HelloRepository
 * author         : ipeac
 * date           : 24. 6. 30.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 30.        ipeac       최초 생성
 */
public interface HelloRepository {
    Hello findHello(String name);
    
    void increaseCount(String name);
    
    default int countOf(String name) {
        Hello hello = findHello(name);
        return hello == null ? 0 : hello.getCount();
    }
}