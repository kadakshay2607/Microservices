package com.rest.webservices.restful_web_services.security;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

	public SecurityFilterChain filterChain (HttpSecurity security) throws Exception {
		
		// all request autheticated 
		security.authorizeHttpRequests(auth-> auth.anyRequest().authenticated());
		
		security.httpBasic(withDefaults());
		
		security.csrf().disable();
		return security.build();
		
	}
}
