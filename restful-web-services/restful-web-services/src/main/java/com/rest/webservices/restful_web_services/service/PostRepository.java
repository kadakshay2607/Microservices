package com.rest.webservices.restful_web_services.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.webservices.restful_web_services.bean.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
