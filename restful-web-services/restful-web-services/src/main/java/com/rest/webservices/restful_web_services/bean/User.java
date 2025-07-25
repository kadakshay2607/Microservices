package com.rest.webservices.restful_web_services.bean;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name="users_details")
public class User {

	
	public User() {
	}

	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> post;
	
	@Size(min = 2, message = "Name Should be have atleast 2 characters.")
//	@JsonProperty("user_name")
	private String name;
	
	@Past(message = "BirthDate Should be in the Past.")
//	@JsonProperty("birth_date")
	private LocalDate birthDate;

	public User(Integer id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

}
