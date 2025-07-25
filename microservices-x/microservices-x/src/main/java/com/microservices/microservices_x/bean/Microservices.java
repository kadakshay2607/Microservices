package com.microservices.microservices_x.bean;

public class Microservices {

	private int minimum;
	private int maximum;

	public Microservices() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Microservices(int minimum, int maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

}
