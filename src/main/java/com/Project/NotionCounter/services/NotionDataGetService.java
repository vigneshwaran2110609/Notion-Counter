package com.Project.NotionCounter.services;

import org.springframework.stereotype.Service;
import com.Project.NotionCounter.client.*;
import com.Project.NotionCounter.models.*;

@Service
public class NotionDataGetService {
	
	private final NotionClient notionClient;
	
	public NotionDataGetService(NotionClient notionClient) {
		this.notionClient = notionClient;
	}
	
	public NotionData getNotionData() {
		NotionData notionData = notionClient.getChildrenBlocks();
		return notionData;
	}

}
