package com.springboot.learn_jpa_hibernate.jdbc;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJPARepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert(Course course) {
		entityManager.persist(course);
	}
	
	public Course getData(long id) {
		return  entityManager.find(Course.class, id);
	}
	
	public void delete(long id) {
		Course find = entityManager.find(Course.class, id);
		entityManager.remove(find);
	}

}
