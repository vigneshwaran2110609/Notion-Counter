package com.Project.NotionCounter.services;

import com.Project.NotionCounter.models.NotionData;
import org.springframework.stereotype.Service;

@Service
public class NumberGetService {
	
	public String extractNumberFromNotionData(NotionData notionData) {
		
		if (notionData.getResults() != null && !notionData.getResults().isEmpty()) {
			
			for (NotionData.Result result : notionData.getResults()) {
				
				if (result.getParagraph() != null &&
						result.getParagraph().getRichText() != null &&
						!result.getParagraph().getRichText().isEmpty()) {
					
					NotionData.RichText richText = result.getParagraph().getRichText().get(0);
					
					if (richText.getText() != null && richText.getText().getContent() != null) {
						return richText.getText().getContent();
					}
				}
			}
		}
		return null;
	}
	
	public String extractIdFromNotionData(NotionData notionData, String str) {
		
		if (notionData.getResults() != null && !notionData.getResults().isEmpty()) {
			
			for (NotionData.Result result : notionData.getResults()) {
				
				if (result.getParagraph() != null &&
						result.getParagraph().getRichText() != null &&
						!result.getParagraph().getRichText().isEmpty()) {
					
					NotionData.RichText richText = result.getParagraph().getRichText().get(0);
					
					if (richText.getText() != null && richText.getText().getContent() != null) {
						String s = richText.getText().getContent();
						if (s.equalsIgnoreCase(str)) {
							return result.getId();
						}
					}
				}
			}
		}
		return null;
	}

}
