package com.poc.spring.jpa.springdatajpatutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.spring.jpa.springdatajpatutorial.entity.CourseMaterial;

public interface CourseMaterialRepository  extends JpaRepository<CourseMaterial, Long>{

}
