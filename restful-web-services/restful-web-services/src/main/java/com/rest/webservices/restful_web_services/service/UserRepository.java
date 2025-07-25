package com.rest.webservices.restful_web_services.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.webservices.restful_web_services.bean.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
