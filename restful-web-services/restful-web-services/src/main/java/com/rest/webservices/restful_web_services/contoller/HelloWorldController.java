package com.rest.webservices.restful_web_services.contoller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservices.restful_web_services.bean.HelloBean;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;

//	public HelloWorldController(MessageSource source) {
//		this.source = source;
//	}

	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	public String helloWolrd() {
		return "hi Akshay";

	}

//	@GetMapping(path="/getMap")
//	public String hello() {
//		return "get Mapping";
//		
//	}

//	
//	@GetMapping(path="/getMap-bean")
//	public HelloBean helloBean() {
//		return new HelloBean("get Mapping bean m");
//		}

	@GetMapping(path = "/getMap/{name}")
	public HelloBean helloname(@PathVariable String name) {
		return new HelloBean(String.format("show my name , %s", name));

	}

	@GetMapping(path = "/helloWorldInterNational")
	public String helloWorlInterNational() {

		Locale locale = LocaleContextHolder.getLocale();
		System.out.println("Resolved Locale: " + locale);

		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
	}

}
