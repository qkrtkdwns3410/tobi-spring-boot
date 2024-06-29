package com.company.config.autoconfig;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;

/**
 * packageName    : com.company.config.autoconfig
 * fileName       : MyConfigurationPropertiesImportSelector
 * author         : ipeac
 * date           : 24. 6. 25.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 24. 6. 25.        ipeac       최초 생성
 */
public class MyConfigurationPropertiesImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        MultiValueMap<String, Object> attrs = importingClassMetadata.getAllAnnotationAttributes(EnableMyConfigurationProperties.class.getName());
        Class propertyClass = (Class) attrs.getFirst("value");
        return new String[]{propertyClass.getName()};
    }
}