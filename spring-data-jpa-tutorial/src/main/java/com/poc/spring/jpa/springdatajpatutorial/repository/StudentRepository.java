package com.poc.spring.jpa.springdatajpatutorial.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poc.spring.jpa.springdatajpatutorial.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	public List<Student> getStudentByFirstName(String name);
	
	public List<Student> getStudentByLastName(String name);
	
	public List<Student> getStudentByFirstNameAndLastName(String firstname,String lastname);
	
	//JPQL example 
	@Query("select s from Student s where s.emailId=?1")
	public Student getStudentByEmailAddress(String email);
	
	@Query("select s.firstName from Student s where s.emailId=?1")
	public String getStudentFirstNameByEmailAddress(String email);
	
	
	//Native Query
	@Query(value = "select * from tbl_student s where s.email_address=?1", nativeQuery = true)
	public Student getStudentByEmailAddressNative(String email);
		
	//Native Query Named Params
	@Query(value = "select * from tbl_student s where s.email_address= :emailId", nativeQuery = true)
	public Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String email);
	
	
	//Native Query Named Params with Modyfying and Transactional
		@Modifying
		@Transactional
		@Query(value = "update tbl_student set first_name=:firstName where email_address= :emailId", nativeQuery = true)
		int updateStudentByEmailAddressNativeNamedParam(@Param("emailId") String email, @Param("firstName") String firstName);
		
		
		
}
