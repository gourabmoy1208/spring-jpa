package com.poc.spring.jpa.springdatajpatutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.spring.jpa.springdatajpatutorial.entity.Teacher;

public interface TeacherRepository  extends JpaRepository<Teacher, Long>{

}
