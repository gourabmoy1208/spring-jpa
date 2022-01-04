package com.poc.spring.jpa.springdatajpatutorial.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.poc.spring.jpa.springdatajpatutorial.entity.Course;
import com.poc.spring.jpa.springdatajpatutorial.entity.Student;
import com.poc.spring.jpa.springdatajpatutorial.entity.Teacher;

@SpringBootTest
public class CourseRepositoryTest {
	
	@Autowired
	CourseRepository courseRepository;
	

	@Test
	public void printAllCourse(){
		List<Course> courses =  courseRepository.findAll();
		courses.forEach(s ->System.out.println(s));
	}

	@Test
	public void updateCourse(){
		courseRepository.updateCourseByIdNativeNamedParam("1", "C#");
	}
	@Test
	public void saveCourseWithTeacher() {
		Course course = new Course();
		course.setCourseTitle("English");
		course.setCredit(6);
		Teacher teacher = new Teacher();
		teacher.setFirstName("Arindom");
		teacher.setLastName("Sil");
		course.setTeacher(teacher);
		courseRepository.save(course);
	}
	@Test
	public void findAllPagination() {
		Pageable firstPaginationWithThreeRecords = PageRequest.of(0, 3);
		PageRequest secondPaginationWithThreeRecords = PageRequest.of(1, 2);
		List<Course> courses = courseRepository.findAll(firstPaginationWithThreeRecords).getContent();
		Long totalElements = courseRepository.findAll(firstPaginationWithThreeRecords).getTotalElements();
		
		int totalPages = courseRepository.findAll(firstPaginationWithThreeRecords).getTotalPages();
		
		System.out.println("totalPages after 1st Pagination : "+totalPages);
		System.out.println("totalElements after 1st Pagination : "+totalElements);
		System.out.println(courses);
		Long totalElements1 = courseRepository.findAll(secondPaginationWithThreeRecords).getTotalElements();
		
		int totalPages1 = courseRepository.findAll(secondPaginationWithThreeRecords).getTotalPages();
	
		System.out.println("totalPages after 2nd Pagination : "+totalPages1);
		System.out.println("totalElements after 2nd Pagination : "+totalElements1);
	
	}
	@Test
	public void findAllSorting() {
		
		Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("courseTitle"));
		Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
		Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("courseTitle").and(Sort.by("credit").descending()));
		
		List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
		System.out.println("Course Sorted with Title : "+courses);
		
		List<Course> courses1 = courseRepository.findAll(sortByCreditDesc).getContent();
		System.out.println("Course Sorted with sortByCreditDesc : "+courses1);
		
		List<Course> courses2 = courseRepository.findAll(sortByTitleAndCreditDesc).getContent();
		System.out.println("Course Sorted with sortByTitleAndCreditDesc : "+courses2);
	}
	@Test
	public void findPageTitleWithContaining() {
		
		Pageable firstPageTenRecords = PageRequest.of(0, 10);
		List<Course> courses = courseRepository.findByCourseTitleContaining("P", firstPageTenRecords).getContent();
		
		System.out.println("courses :: "+courses);
	}
	
	@Test
	public void saveCourseWithStudentAndTeacher() {
		
		Course course = new Course();
		course.setCourseTitle("Fuzzy Logic");
		course.setCredit(8);
		Teacher teacher = new Teacher();
		teacher.setFirstName("Adish");
		teacher.setLastName("Chakratoborty");
		course.setTeacher(teacher);
		
		Student student = new Student();
		student.setFirstName("Sumanta");
		student.setLastName("Singha Roy");
		student.setEmailId("roysumanta88@gmail.com");
		course.addStudents(student);
		
		courseRepository.save(course);
		
	}
	
}


