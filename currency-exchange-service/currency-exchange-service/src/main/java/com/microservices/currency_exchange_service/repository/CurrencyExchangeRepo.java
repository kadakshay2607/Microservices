package com.microservices.currency_exchange_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.currency_exchange_service.bean.ExchangeCurrency;

public interface CurrencyExchangeRepo extends JpaRepository<ExchangeCurrency, Long>{
	
	ExchangeCurrency findByFromAndTo(String from, String to);

}
