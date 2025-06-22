package com.Project.NotionCounter.services;

import com.Project.NotionCounter.models.NotionData;

public class NumberGetService {
	
	public String extractNumberFromNotionData(NotionData notionData) {
		
		if (notionData.getResults() != null && !notionData.getResults().isEmpty()) {
			
			for (NotionData.Result result : notionData.getResults()) {
				
				if (result.getParagraph() != null &&
						result.getParagraph().getRichText() != null &&
						!result.getParagraph().getRichText().isEmpty()) {
					
					NotionData.RichText richText = result.getParagraph().getRichText().get(0);
				}
			}
		}
	}

}
