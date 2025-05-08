package com.zazhi.mybatis_enum_mapping;

import com.zazhi.mybatis_enum_mapping.enums.GenderEnum;
import com.zazhi.mybatis_enum_mapping.mapper.StudentMapper;
import com.zazhi.mybatis_enum_mapping.pojo.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisEnumMappingApplicationTests {
	@Autowired
	StudentMapper studentMapper;
	@Test
	void insert() {
		Student student = new Student();
		student.setAge(18);
		student.setGender(GenderEnum.WALMART_SHOPPING_BAG);
		studentMapper.insert(student);
	}
	@Test
	void select(){
		Student student = studentMapper.getAll();
		System.out.println(student);
		System.out.println(student.getGender());
	}
}
