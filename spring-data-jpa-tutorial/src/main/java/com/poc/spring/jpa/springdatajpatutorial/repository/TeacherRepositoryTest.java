package com.poc.spring.jpa.springdatajpatutorial.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.poc.spring.jpa.springdatajpatutorial.entity.Course;
import com.poc.spring.jpa.springdatajpatutorial.entity.Teacher;

import lombok.ToString;

@SpringBootTest
@ToString(exclude = "course")
public class TeacherRepositoryTest {
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Test
	public void saveTeacher() {
	
		Course courseC = new Course();
		courseC.setCourseTitle("C#");
		courseC.setCredit(7);
		Course coursePy = new Course();
		coursePy.setCourseTitle("Python");
		coursePy.setCredit(7);
		
		Teacher teacher = new Teacher();
		teacher.setFirstName("Atanu");
		teacher.setLastName("Bhattacharya");
	//	teacher.setCourses(List.of(courseC,coursePy));
		teacherRepository.save(teacher);
		
	}
	
}
