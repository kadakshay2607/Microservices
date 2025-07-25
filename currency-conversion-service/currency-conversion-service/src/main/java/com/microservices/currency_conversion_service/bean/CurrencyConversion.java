package com.microservices.currency_conversion_service.bean;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CurrencyConversion {
	
	@Id
	private long id;
	
	@Column(name = "conversion_from")
	private String from;
	
	@Column(name = "conversion_to")
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal totalCalculatedAmount;
	private BigDecimal quantity;
	private String environment;
	
	public CurrencyConversion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CurrencyConversion(long id, String from, String to, BigDecimal conversionMultiple,
			BigDecimal totalCalculatedAmount, BigDecimal quantity, String environment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.quantity = quantity;
		this.environment = environment;
	}
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}
	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	
	

}
