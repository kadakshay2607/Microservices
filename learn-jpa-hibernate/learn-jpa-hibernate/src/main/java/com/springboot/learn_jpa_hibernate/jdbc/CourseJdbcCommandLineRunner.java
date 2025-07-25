package com.springboot.learn_jpa_hibernate.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner { // Interface used to indicate that a bean should
																		// run while start of spring.

//	@Autowired
//	private CourseJdbcRepo repo;
	
//	@Autowired
//	private CourseJPARepository repo;
	
	@Autowired
	private CourseSpringDataJPARepo repo;

	@Override
	public void run(String... args) throws Exception {
		repo.save(new Course(1, "Learn AWS now", "in28minutes"));
		repo.save(new Course(2, "Learn Azure now", "in28minutes"));
		repo.save(new Course(3, "Learn Docker now", "in28minutes"));
		
		repo.deleteById(2l);

		System.out.println("for 2 "+repo.findById(1l));
		System.out.println("for 3 "+repo.findById(3l));

	}

}
