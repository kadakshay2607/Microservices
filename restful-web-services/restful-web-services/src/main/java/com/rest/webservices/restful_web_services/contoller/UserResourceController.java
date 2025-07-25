package com.rest.webservices.restful_web_services.contoller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.webservices.restful_web_service.exception.UserNotFound;
import com.rest.webservices.restful_web_services.bean.Post;
import com.rest.webservices.restful_web_services.bean.User;
import com.rest.webservices.restful_web_services.dao.UserDAOService;

import jakarta.validation.Valid;

@RestController
public class UserResourceController {

	@Autowired
	private UserDAOService userDAOService;

	@GetMapping(path = "/users")
	public List<User> retriveAllUsers() {
		return userDAOService.findAll();

	}

	@GetMapping(path = "/users/{id}")
	public EntityModel<User>  getUserDetail(@PathVariable int id) throws UserNotFound {

		EntityModel<User> user = EntityModel.of(userDAOService.findOne(id));
		if (null == user) {
			throw new UserNotFound("id" + id);
		}
		
		WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).retriveAllUsers());
		user.add(linkBuilder.withRel("all-users"));
		return user;

	}

	@PostMapping(path = "/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User createUser = userDAOService.createUser(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path = "/users/{id}")
	public void deleteUserDetail(@PathVariable int id) throws UserNotFound {

	 userDAOService.deleteById(id);

	}
	
	
}
