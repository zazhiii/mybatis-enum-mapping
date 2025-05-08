package com.zazhi.mybatis_enum_mapping.config;

import com.zazhi.mybatis_enum_mapping.enums.GenderEnum;
import com.zazhi.mybatis_enum_mapping.handler.GenericEnumTypeHandler;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyBatisEnumConfig2 {

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                TypeHandlerRegistry registry = configuration.getTypeHandlerRegistry();

                // 注册你所有的枚举类型
                registry.register(GenderEnum.class, new GenericEnumTypeHandler<>(GenderEnum.class));

                // 如果有其他枚举，也一样添加
                // registry.register(Status.class, new GenericEnumTypeHandler<>(Status.class));
            }
        };
    }
}
