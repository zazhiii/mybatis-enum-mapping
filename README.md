# MyBatis 枚举通用映射 Demo

这是一个基于 **Spring Boot + MyBatis** 的示例项目，演示如何通过自定义通用 `TypeHandler` 实现数据库字段值与 Java 枚举类之间的自动双向转换，并支持 **自动扫描注册所有实现了 `BaseEnum` 接口的枚举类**，简化枚举映射的配置和维护工作。

## ✨ 功能亮点

- ✅ 支持所有实现了 `BaseEnum<T>` 接口的枚举类通用处理  
- ✅ 枚举值与数据库字段自动双向转换  
- ✅ 启动时自动扫描并注册，无需手动一个个配置  
- ✅ 实现优雅、灵活、可拓展的枚举映射方案  

## 使用与原理
https://zhuanlan.zhihu.com/p/1903806420081672877
