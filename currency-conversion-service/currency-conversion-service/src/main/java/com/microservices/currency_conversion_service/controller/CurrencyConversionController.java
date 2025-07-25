package com.microservices.currency_conversion_service.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.currency_conversion_service.bean.CurrencyConversion;
import com.microservices.currency_conversion_service.bean.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {

	@Autowired
	private Environment env;
	
	@Autowired
	private CurrencyExchangeProxy proxy;

//	@Autowired
//	private CurrencyConversionRepository repo;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateConvertionRates(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		HashMap<String,  String> map = new HashMap<String, String>();
		map.put("from", from);
		map.put("to", to);
		
		ResponseEntity<CurrencyConversion> respo = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class,map);
		CurrencyConversion body = respo.getBody();
		
		CurrencyConversion conversion = new CurrencyConversion(body.getId(), from, to, 
				body.getConversionMultiple(),quantity.multiply(body.getConversionMultiple()),quantity, body.getEnvironment());
				//repo.findByFromAndToQuantity(from, to, quantity);
//		conversion.setEnvironment(env.getProperty("local.server.port"));
		return conversion;

	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateConvertionRatesFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		
		CurrencyConversion body = proxy.retrieveCurrencyExchange(from, to);
		
		CurrencyConversion conversion = new CurrencyConversion(body.getId(), from, to, 
				body.getConversionMultiple(),quantity.multiply(body.getConversionMultiple()),quantity, body.getEnvironment());
				//repo.findByFromAndToQuantity(from, to, quantity);
//		conversion.setEnvironment(env.getProperty("local.server.port"));
		return conversion;

	}

}
