DROP DATABASE IF EXISTS `mybatis_enum_mapping`;
CREATE DATABASE `mybatis_enum_mapping`;

create table Student
(
    id     int auto_increment primary key,
    age    int null comment '年龄',
    gender int null comment '性别'
) comment '学生表';