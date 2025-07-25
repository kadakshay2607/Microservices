package com.springboot.learn_jpa_hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//http://localhost:8080/h2-console
//H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:a8b571ae-e662-4aec-86f2-08c5697a4da9'
@SpringBootApplication
public class LearnJpaHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnJpaHibernateApplication.class, args);
	}

}
