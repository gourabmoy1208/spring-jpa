package com.poc.spring.jpa.springdatajpatutorial.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Teacher {
	
	@Id
	@SequenceGenerator(
	name = "teacher_sequence",
	sequenceName = "teacher_sequence",
	allocationSize = 1
	)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "teacher_sequence" )
	private Long teacherId;
	private String firstName;
	private String lastName;
	
	/*
	 * @OneToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "teacher_id",referencedColumnName = "teacherId") private
	 * List<Course> courses;
	 * 
	 * 
	 * 
	 * public List<Course> getCourses() { return courses; } public void
	 * setCourses(List<Course> courses) { this.courses = courses; }
	 */
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	

}
