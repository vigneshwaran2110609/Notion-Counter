package com.Project.NotionCounter;

import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.Project.NotionCounter.config.*;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties(NotionConfig.class)
public class NotionCounterApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotionCounterApplication.class, args);
	}

}
