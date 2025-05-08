package com.zazhi.mybatis_enum_mapping.mapper;

import com.zazhi.mybatis_enum_mapping.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper {
    /**
     * 插入学生
     *
     * @param student 学生对象
     */
    @Insert("insert into student(age, gender) values(#{age}, #{gender})")
    void insert(Student student);

    /**
     * 查询所有学生
     * @return
     */
    @Select("select * from student")
    Student getAll();
}
