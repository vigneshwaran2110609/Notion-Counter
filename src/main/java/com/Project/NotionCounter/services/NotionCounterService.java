package com.Project.NotionCounter.services;

import org.springframework.stereotype.Service;
import com.Project.NotionCounter.models.NotionData;

@Service
public class NotionCounterService {
	
	public NotionDataGetService notionDataGetService;
	public NotionDataSendService notionDataSendService;
	
	public NotionCounterService(NotionDataGetService notionDataGetService, NotionDataSendService notionDataSendService) {
		this.notionDataGetService = notionDataGetService;
		this.notionDataSendService = notionDataSendService;
	}
	
	public void decreaseCount() {
		NotionData notionData = this.notionDataGetService.getNotionData();
		
	}

}
