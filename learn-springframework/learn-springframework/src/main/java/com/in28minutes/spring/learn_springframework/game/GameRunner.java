package com.in28minutes.spring.learn_springframework.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

	@Autowired
	private GamingConsole game;

	public GameRunner(GamingConsole game2) {
		this.game = game2;
	}

	public void run() {
		game.up();
		game.down();
		game.left();
		game.right();
	}

}
