package com.Project.NotionCounter.scheduler;

import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;
import com.Project.NotionCounter.services.NotionCounterService;

//Cron for 12:05 AM - @Scheduled(cron = "0 5 0 * * *")
//Cron for every 5 seconds - @Scheduled(cron = "*/5 * * * * *")

@Component
public class JobScheduler {
	
	private final NotionCounterService notionCounterService;
	
	public JobScheduler(NotionCounterService notionCounterService) {
		this.notionCounterService = notionCounterService;
	}
	
	@Scheduled(cron = "*/5 * * * * *")
	public void run() {
		notionCounterService.decreaseCount();
	}
}
