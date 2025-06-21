package com.Project.NotionCounter.services;

import org.springframework.stereotype.Service;

@Service
public class NotionCounterService {
	
	public NotionDataGetService notionDataGetService;
	public NotionDataSendService notionDataSendService;
	
	public NotionCounterService(NotionDataGetService notionDataGetService, NotionDataSendService notionDataSendService) {
		this.notionDataGetService = notionDataGetService;
		this.notionDataSendService = notionDataSendService;
	}
	
	public void decreaseCount() {
		
		
	}

}
