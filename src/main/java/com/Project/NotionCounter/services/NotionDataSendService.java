package com.Project.NotionCounter.services;

import org.springframework.stereotype.Service;
import com.Project.NotionCounter.client.*;

@Service
public class NotionDataSendService {
	
	private final NotionClient notionClient;
	
	public NotionDataSendService(NotionClient notionClient) {
		this.notionClient = notionClient;
	}
	
	public void sendNotionData(String blockId, String content) {
		this.notionClient.updateParagraphBlock(blockId, content);
	}

}
