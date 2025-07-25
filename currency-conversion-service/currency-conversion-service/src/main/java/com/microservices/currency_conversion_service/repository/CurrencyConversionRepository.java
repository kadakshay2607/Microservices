package com.microservices.currency_conversion_service.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.currency_conversion_service.bean.CurrencyConversion;

public interface CurrencyConversionRepository  extends JpaRepository<CurrencyConversion, Long>{
	
//	CurrencyConversion findByFromAndToQuantity(String from, String to,BigDecimal quantity);

}
