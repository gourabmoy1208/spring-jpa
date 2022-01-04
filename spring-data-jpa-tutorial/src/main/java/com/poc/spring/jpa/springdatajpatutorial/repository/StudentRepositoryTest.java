package com.poc.spring.jpa.springdatajpatutorial.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.poc.spring.jpa.springdatajpatutorial.entity.Guardian;
import com.poc.spring.jpa.springdatajpatutorial.entity.Student;

@SpringBootTest
public class StudentRepositoryTest {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Test
	public void saveStudent() {
		Guardian guardian = new Guardian();
		guardian.setGuardianEmail("guardian1@gmail.com");
		guardian.setGuardianMobile("9888888888");
		guardian.setGuardianName("Guardian1"); Student student = new Student();
		student.setEmailId("pooja93@gmail.com"); student.setFirstName("Pooja");
		student.setLastName("Baksi Ghosh"); student.setGuardian(guardian);
		studentRepository.save(student);
		Guardian guardian1 = new Guardian();
		guardian1.setGuardianEmail("guardian2@gmail.com");
		guardian1.setGuardianMobile("9777777777");
		guardian1.setGuardianName("Guardian2");
		Student student1 = new Student();
		student1.setEmailId("gouranga53@gmail.com");
		student1.setFirstName("Gouranga");
		student1.setLastName("Ghosh");
		student1.setGuardian(guardian);
		studentRepository.save(student1);
	}
	
	@Test
	public void printall() {
		
		List<Student> students =  studentRepository.findAll();
		students.forEach(s -> System.out.println(s));
		
	}

	
	@Test
	public void printStudentByFirstName() {
		
		List<Student> students =  studentRepository.getStudentByFirstName("Pooja");
		students.forEach(s -> System.out.println(s.getFirstName()));
		
	}

	@Test
	public void printStudentByLastName() {
		
		List<Student> students =  studentRepository.getStudentByLastName("Ghosh");
		students.forEach(s -> System.out.println(s.getFirstName()));
		
	}
	@Test
	public void printStudentByLastNameAndFirstName() {
		
		List<Student> students =  studentRepository.getStudentByFirstNameAndLastName("Gourabmoy","Ghosh");
		students.forEach(s -> System.out.println(s));
		
	}
	
	@Test
	public void printgetStudentByEmailAddress() {
		
		Student student =  studentRepository.getStudentByEmailAddress("gourabmoy89@gmail.com");
		System.out.println(student);
		
	}
	
	@Test
	public void printgetStudentFirstNameByEmailAddress() {
		
		String student =  studentRepository.getStudentFirstNameByEmailAddress("gourabmoy89@gmail.com");
		System.out.println(student);
		
	}
	
	@Test
	public void printgetStudentByEmailAddressNative() {
		
		Student student =  studentRepository.getStudentByEmailAddressNative("gourabmoy89@gmail.com");
		System.out.println(student);
		
	}
	
	@Test
	public void updateStudentByEmailAddressNative() {
		
		int updated = studentRepository.updateStudentByEmailAddressNativeNamedParam("gourabmoy89@gmail.com","Gourab");
		System.out.println(updated);
		
	}
	
	
	
}
