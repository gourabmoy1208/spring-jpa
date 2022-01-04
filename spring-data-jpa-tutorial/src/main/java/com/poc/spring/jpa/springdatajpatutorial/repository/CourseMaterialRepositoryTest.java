package com.poc.spring.jpa.springdatajpatutorial.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.poc.spring.jpa.springdatajpatutorial.entity.Course;
import com.poc.spring.jpa.springdatajpatutorial.entity.CourseMaterial;

@SpringBootTest
public class CourseMaterialRepositoryTest {
	
	@Autowired
	CourseMaterialRepository courseMaterialRepository;
	
	@Test
	public void saveCourseMaterial() {
		CourseMaterial courseMaterial = new CourseMaterial();
		courseMaterial.setUrl("www.google.com");
		Course course = new Course();
		course.setCourseTitle(".NET");
		course.setCredit(6);
		courseMaterial.setCourse(course);
		courseMaterialRepository.save(courseMaterial);
		CourseMaterial courseMaterial1 = new CourseMaterial();
		courseMaterial1.setUrl("www.google1.com");
		Course course1 = new Course();
		course1.setCourseTitle("AWS");
		course1.setCredit(6);
		courseMaterial1.setCourse(course1);
		courseMaterialRepository.save(courseMaterial1);
	}

	@Test
	public void printAllCourse(){
		List<CourseMaterial> courseMaterials =  courseMaterialRepository.findAll();
		courseMaterials.forEach(s ->System.out.println(s));
	}
}
