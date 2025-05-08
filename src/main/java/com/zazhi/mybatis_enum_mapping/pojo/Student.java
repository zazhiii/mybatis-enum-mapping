package com.zazhi.mybatis_enum_mapping.pojo;

import com.zazhi.mybatis_enum_mapping.enums.GenderEnum;

/**
 * @author zazhi
 * @date 2025/5/7
 * @description: 学生类
 */
public class Student {
    private Integer age;
    private GenderEnum gender;

    public Student() {
    }

    public Student(Integer age, GenderEnum gender) {
        this.age = age;
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", gender=" + gender +
                '}';
    }
}
