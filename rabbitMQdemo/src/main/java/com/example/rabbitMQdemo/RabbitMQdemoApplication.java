package com.example.rabbitMQdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class RabbitMQdemoApplication {
	
	@Profile("usage_message")
	@Bean
	public CommandLineRunner usage() {
		return args -> {
			System.out.println("This app uses Profiles to control its behaviour. \n");
			System.out.println("Simple usage: java-jar rabbit-tutorials.jar --spring.profiles.active=hello-world,sender");
		};
	}
	
	@Profile("!usage_message")
	@Bean
	public CommandLineRunner tutorial() {
		return new RabbitAmqpTutorialsRunner();
	}

	public static void main(String[] args) {
		SpringApplication.run(RabbitMQdemoApplication.class, args);
	}

}
