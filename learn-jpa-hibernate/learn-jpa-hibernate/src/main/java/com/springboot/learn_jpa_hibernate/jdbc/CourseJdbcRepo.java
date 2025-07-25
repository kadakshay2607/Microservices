package com.springboot.learn_jpa_hibernate.jdbc;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepo {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static String query="insert into course (id,name,author) values(3,'Leran Kubernet','in28minutes');";
	
	private static String querydy="insert into course (id,name,author) values(?,?,?);";

	private static String deleteQuery = "delete from course where id=? ;";
	
	private static String selectQuery = "select * from course where id= ? ";
	public void insert(Course course) {
		//jdbcTemplate.update(query);
		
		jdbcTemplate.update(querydy,course.getId(),course.getName(),course.getAuthor());
	}
	
	public void delete(Course course) {
		jdbcTemplate.update(deleteQuery,course.getId());

	}
	
	public Optional<Course> getData(long id) {
		try {
			return Optional.of(jdbcTemplate.queryForObject(selectQuery, new BeanPropertyRowMapper<>(Course.class),id));

		} catch (Exception e) {
			return Optional.empty();
		}
		

	}

}
