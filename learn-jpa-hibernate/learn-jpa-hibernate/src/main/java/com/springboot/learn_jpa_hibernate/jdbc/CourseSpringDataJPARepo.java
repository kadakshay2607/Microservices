package com.springboot.learn_jpa_hibernate.jdbc;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseSpringDataJPARepo extends JpaRepository<Course, Long> {

	
}
