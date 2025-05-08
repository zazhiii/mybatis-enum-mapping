package com.zazhi.mybatis_enum_mapping.config;

import com.zazhi.mybatis_enum_mapping.enums.BaseEnum;
import com.zazhi.mybatis_enum_mapping.enums.GenderEnum;
import com.zazhi.mybatis_enum_mapping.handler.GenericEnumTypeHandler;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.stereotype.Component;

import java.util.Set;

//@Component
public class MyBatisEnumConfig {
    private static final String BASE_PACKAGE = "com.zazhi.mybatis_enum_mapping.enums";

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                TypeHandlerRegistry registry = configuration.getTypeHandlerRegistry();

                Set<Class<?>> enumClasses = scanBaseEnumEnums(BASE_PACKAGE);

                for (Class<?> clazz : enumClasses) {
                    // 泛型擦除，强转需要保证正确
                    @SuppressWarnings("unchecked")
                    Class<? extends Enum<?>> enumClass = (Class<? extends Enum<?>>) clazz;
                    registry.register(enumClass, new GenericEnumTypeHandler(enumClass));
                }
            }
        };
    }

    private Set<Class<?>> scanBaseEnumEnums(String basePackage) {
        ClassPathScanningCandidateComponentProvider scanner =
                new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AssignableTypeFilter(BaseEnum.class));
        scanner.setResourceLoader(new DefaultResourceLoader());

        Set<BeanDefinition> candidates = scanner.findCandidateComponents(basePackage);
        Set<Class<?>> result = new java.util.HashSet<>();

        for (BeanDefinition candidate : candidates) {
            try {
                Class<?> clazz = Class.forName(candidate.getBeanClassName());
                if (clazz.isEnum() && BaseEnum.class.isAssignableFrom(clazz)) {
                    result.add(clazz);
                }
                System.out.println("Found enum class: " + clazz.getName());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Failed to load enum class", e);
            }
        }

        return result;
    }
}