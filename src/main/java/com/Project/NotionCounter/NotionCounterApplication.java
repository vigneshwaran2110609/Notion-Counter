package com.Project.NotionCounter;

import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableScheduling
public class NotionCounterApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotionCounterApplication.class, args);
	}

}
