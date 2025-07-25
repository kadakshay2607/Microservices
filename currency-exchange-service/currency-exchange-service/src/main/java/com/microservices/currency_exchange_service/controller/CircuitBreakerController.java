package com.microservices.currency_exchange_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
//	@Retry(name = "sample-api",fallbackMethod = "hardCodedResponse")
//	@CircuitBreaker(name = "default",fallbackMethod = "hardCodedResponse")
	@RateLimiter(name = "default")
	public String getAPI() {
		logger.info("calling Sample API");
//		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/sampl/dummy", String.class);
		return "sample API";
//		return forEntity.getBody();
	}
	
	public String hardCodedResponse(Exception ex) {
		return "fallback-Response";
		
	}

}
