package com.rest.webservices.restful_web_services.contoller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
import com.rest.webservices.restful_web_services.service.PostRepository;
import com.rest.webservices.restful_web_services.service.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserRJPAesourceController2 {

	@Autowired
	private UserRepository repo;

	@Autowired
	private PostRepository postRepo;

	@GetMapping(path = "/jpa/users")
	public List<User> retriveAllUsers() {
		return repo.findAll();

	}

	@GetMapping(path = "/jpa/users/{id}")
	public EntityModel<Optional<User>> getUserDetail(@PathVariable int id) throws UserNotFound {

		EntityModel<Optional<User>> user = EntityModel.of(repo.findById(id));
		if (null == user) {
			throw new UserNotFound("id" + id);
		}

		WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).retriveAllUsers());
		user.add(linkBuilder.withRel("all-users"));
		return user;

	}

	@PostMapping(path = "/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User createUser = repo.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path = "/jpa/users/{id}")
	public void deleteUserDetail(@PathVariable int id) throws UserNotFound {

		repo.deleteById(id);

	}

	@GetMapping(path = "/users/{id}/posts")
	public List<Post> getUserPostDetail(@PathVariable int id) throws UserNotFound {

		Optional<User> user = repo.findById(id);
		if (null == user) {
			throw new UserNotFound("id" + id);
		}

		return user.get().getPost();

	}

	@PostMapping(path = "/users/{id}/posts")
	public ResponseEntity<Object> createUserPostDetail(@PathVariable int id, @Valid @RequestBody Post post)
			throws UserNotFound {

		Optional<User> user = repo.findById(id);
		if (null == user) {
			throw new UserNotFound("id" + id);
		}
		post.setUser(user.get());
		Post savePost = postRepo.save(post);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savePost.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
