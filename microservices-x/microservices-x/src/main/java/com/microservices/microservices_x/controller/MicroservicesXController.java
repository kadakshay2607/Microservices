package com.microservices.microservices_x.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.microservices_x.bean.Microservices;
import com.microservices.microservices_x.configuration.Configuration;

@RestController
public class MicroservicesXController {

	@Autowired
	private Configuration config;
	
	@GetMapping("/limits-x")
	public Microservices fetchLimits() {
		return new Microservices(config.getMinimum(),config.getMaximum());
		
	}
}
