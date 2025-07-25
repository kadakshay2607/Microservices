package com.in28minutes.spring.learn_springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.in28minutes.spring.learn_springframework.controller.WebController;
import com.in28minutes.spring.learn_springframework.game.GameRunner;

@SpringBootApplication
public class LearnSpringframeworkApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LearnSpringframeworkApplication.class, args);
//		MarioGame game = new MarioGame();
//		SuperContra game = new SuperContra();
//		GameRunner runner = new GameRunner(game);
		GameRunner runner = context.getBean(GameRunner.class);
		runner.run();
		
		WebController bean = context.getBean(WebController.class);
		System.out.println(bean.getSumValue());
	}

}
