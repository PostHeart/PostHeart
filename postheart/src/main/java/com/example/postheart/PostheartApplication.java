package com.example.postheart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;

@SpringBootApplication
@Async
public class PostheartApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostheartApplication.class, args);
	}

}
