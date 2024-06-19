package com.company.config;

import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName    : com.company.config
 * fileName       : MyAutoConfigImportSelector
 * author         : ipeac
 * date           : 24. 6. 19.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 19.        ipeac       최초 생성
 */
public class MyAutoConfigImportSelector implements DeferredImportSelector {
    private final ClassLoader classLoader;
    
    public MyAutoConfigImportSelector(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }
    
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        List<String> autoConfigs = new ArrayList<>();
        
        ImportCandidates.load(MyAutoConfiguration.class, classLoader).forEach(autoConfigs::add);
        
        return autoConfigs.toArray(String[]::new);
    }
}