package com.rest.webservices.restful_web_services.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservices.restful_web_services.bean.Name;
import com.rest.webservices.restful_web_services.bean.PersonV1;
import com.rest.webservices.restful_web_services.bean.PersonV2;

@RestController
public class VersioningPersonController {

	@GetMapping(path = "/V1/person")
	public PersonV1 getFirstPerson() {
		return new PersonV1("Bob Charlie");

	}

	@GetMapping(path = "/V2/person")
	public PersonV2 getSecondPerson() {
		return new PersonV2(new Name("Bob", "Charlie"));

	}

	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getFirstPersonParam() {
		return new PersonV1("Bob Charlie");

	}

	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getSecondPersonParam() {
		return new PersonV2(new Name("Bob", "Charlie"));

	}

	@GetMapping(path = "/person/header", headers = "X-API=1")
	public PersonV1 getFirstPersonHeader() {
		return new PersonV1("Bob Charlie");

	}

	@GetMapping(path = "/person/header", headers = "X-API=2")
	public PersonV2 getSecondPersonHeader() {
		return new PersonV2(new Name("Bob", "Charlie"));

	}
	
	@GetMapping(path = "/person/header", produces  = "application/vnd.company.app-v1+json")
	public PersonV1 getFirstPersonProduces() {
		return new PersonV1("Bob Charlie");

	}

	@GetMapping(path = "/person/header",  produces = "application/vnd.company.app-v2+json")
	public PersonV2 getSecondPersonProduces() {
		return new PersonV2(new Name("Bob", "Charlie"));

	}

}
