package com.microservices.currency_exchange_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.currency_exchange_service.bean.ExchangeCurrency;
import com.microservices.currency_exchange_service.repository.CurrencyExchangeRepo;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment env;

	@Autowired
	private CurrencyExchangeRepo repo;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeCurrency retrieveCurrencyExchange(@PathVariable String from, @PathVariable String to) {
		// ExchangeCurrency exchangeCurrency = new ExchangeCurrency(100L, from, to,
		// BigDecimal.valueOf(50.34));
		ExchangeCurrency exchangeCurrency = repo.findByFromAndTo(from, to);
		if(exchangeCurrency == null) {
			throw new RuntimeException("unable to find valid currency rates");
		}
		exchangeCurrency.setEnvironment(env.getProperty("local.server.port"));
		return exchangeCurrency;

	}

}
