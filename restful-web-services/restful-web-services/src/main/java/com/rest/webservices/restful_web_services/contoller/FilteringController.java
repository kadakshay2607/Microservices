package com.rest.webservices.restful_web_services.contoller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.rest.webservices.restful_web_services.bean.SomeBean;

@RestController
public class FilteringController {

	@GetMapping("/getFiltering")
	public SomeBean getFilter() {
		return new SomeBean("value1", "value2", "value3");

	}

	@GetMapping("/getFilter")
	public MappingJacksonValue getFilters() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3");

		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;

	}

	@GetMapping("/getFiltering-list")
	public List<SomeBean> getFilterList() {
		return Arrays.asList(new SomeBean("value1", "value2", "value3"), new SomeBean("value4", "value5", "value6"));

	}

}
