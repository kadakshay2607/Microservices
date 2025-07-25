package com.in28minutes.spring.learn_springframework.game;

import org.springframework.stereotype.Component;

@Component
public class MarioGame implements GamingConsole {

	public void up() {
		System.out.println("Mup");
	}
	public void down() {
		System.out.println("Mdown");
	}
	
	public void left() {
		System.out.println("Mleft");
	}
	
	public void right() {
		System.out.println("Mright");
	}
}
