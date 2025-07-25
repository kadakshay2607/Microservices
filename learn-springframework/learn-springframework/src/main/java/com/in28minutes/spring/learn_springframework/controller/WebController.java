package com.in28minutes.spring.learn_springframework.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WebController {

	@Autowired
	private WebService webService;
	
	public long getSumValue() {
		return webService.getalldata();

	}

}

@Component
class WebService {

	@Autowired
	private DataService dataService;

	public long getalldata() {
		List<Integer> data = dataService.getData();
		return data.stream().reduce(Integer::sum).get();

	}
}

@Component
class DataService {

	public List<Integer> getData() {
		return Arrays.asList(2, 3, 5);

	}
}
