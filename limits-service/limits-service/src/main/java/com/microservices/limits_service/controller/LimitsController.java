package com.microservices.limits_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.limits_service.bean.Limits;
import com.microservices.limits_service.configuration.Configuration;

@RestController
public class LimitsController {

	@Autowired
	private Configuration con;

	@GetMapping("/limits")
	public Limits retriveLimits() {
		return new Limits(con.getMinimum(), con.getMaximum());

	}

}
