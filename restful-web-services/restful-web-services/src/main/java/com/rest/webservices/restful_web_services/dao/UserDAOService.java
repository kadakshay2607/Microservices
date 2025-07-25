package com.rest.webservices.restful_web_services.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rest.webservices.restful_web_services.bean.User;

import java.util.function.Predicate;

@Component
public class UserDAOService {

	private static List<User> users = new ArrayList<>();

	private static int count = 0;
	static {
		users.add(new User(count++, "Akshay", LocalDate.now().minusYears(28)));
		users.add(new User(count++, "Jack", LocalDate.now().minusYears(56)));
		users.add(new User(count++, "Scott", LocalDate.now().minusYears(908)));

	}

	public List<User> findAll() {
		return users;

	}

	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}

	public User createUser(User user) {
		user.setId(count++);
		users.add(user);
		return user;
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}

}
