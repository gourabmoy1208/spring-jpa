package com.poc.spring.jpa.springdatajpatutorial.repository;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poc.spring.jpa.springdatajpatutorial.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

	@Modifying
	@Transactional
	@Query(value = "update course set course_title=:title where course_id= :id", nativeQuery = true)
	int updateCourseByIdNativeNamedParam(@Param("id") String id, @Param("title") String title);
	
	Page<Course> findByCourseTitleContaining(String string, Pageable pageable);
	
	
}
