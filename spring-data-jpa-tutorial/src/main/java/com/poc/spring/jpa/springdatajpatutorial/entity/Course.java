package com.poc.spring.jpa.springdatajpatutorial.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

	@Id
	@SequenceGenerator(
	name = "course_sequence",
	sequenceName = "course_sequence",
	allocationSize = 1
	)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
	generator = "course_sequence"
	)
	private Long courseId;
	private String courseTitle;
	private Integer credit;
	
	@OneToOne(mappedBy = "course")
	private CourseMaterial courseMaterial;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacher_id",referencedColumnName = "teacherId")
	private Teacher teacher;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="course_student_map",
			joinColumns = @JoinColumn(
					name="course_id",referencedColumnName = "courseId"
			),
			inverseJoinColumns = @JoinColumn(
					name="student_id",referencedColumnName = "studentId"
			)
		)
	private List<Student> students;
	
	public void addStudents(Student student) {
		if(students == null)students = new ArrayList<>();
		students.add(student);
	}
	
	
	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}


	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public CourseMaterial getCourseMaterial() {
		return courseMaterial;
	}
	public void setCourseMaterial(CourseMaterial courseMaterial) {
		this.courseMaterial = courseMaterial;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseTitle=" + courseTitle + ", credit=" + credit
				+ ", getCourseId()=" + getCourseId() + ", getCourseTitle()=" + getCourseTitle() + ", getCredit()="
				+ getCredit() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
