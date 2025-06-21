package com.Project.NotionCounter.scheduler;

import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;
import com.Project.NotionCounter.services.NotionCounterService;

@Component
public class JobScheduler {
	
	private final NotionCounterService notionCounterService;
	
	public JobScheduler(NotionCounterService notionCounterService) {
		this.notionCounterService = notionCounterService;
	}
	
	@Scheduled(cron = "0 5 0 * * *")
	public void run() {
		notionCounterService.decreaseCount();
	}
}
