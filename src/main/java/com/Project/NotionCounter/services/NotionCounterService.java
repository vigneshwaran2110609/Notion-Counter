package com.Project.NotionCounter.services;

import org.springframework.stereotype.Service;
import com.Project.NotionCounter.models.NotionData;

@Service
public class NotionCounterService {
	
	private final NotionDataGetService notionDataGetService;
	private final NotionDataSendService notionDataSendService;
	private final NumberGetService numberGetService;
	
	public NotionCounterService(NotionDataGetService notionDataGetService, NotionDataSendService notionDataSendService, NumberGetService numberGetService) {
		this.notionDataGetService = notionDataGetService;
		this.notionDataSendService = notionDataSendService;
		this.numberGetService = numberGetService;
	}
	
	public void decreaseCount() {
		NotionData notionData = this.notionDataGetService.getNotionData();
		String num = this.numberGetService.extractNumberFromNotionData(notionData);
		int num1 = Integer.parseInt(num);
		String id = this.numberGetService.extractIdFromNotionData(notionData, num);
		num1 = num1 - 1;
		String ns = Integer.toString(num1);
		this.notionDataSendService.sendNotionData(id, ns);
	}

}
