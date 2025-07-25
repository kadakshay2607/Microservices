package com.rest.webservices.restful_web_services.bean;

import java.time.LocalDate;

public class ErrorDetails {

	private LocalDate localDate;
	private String message;
	private String details;

	public ErrorDetails(LocalDate localDate, String message, String details) {
		super();
		this.localDate = localDate;
		this.message = message;
		this.details = details;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "ErrorDetails [localDate=" + localDate + ", message=" + message + ", details=" + details + "]";
	}

}
