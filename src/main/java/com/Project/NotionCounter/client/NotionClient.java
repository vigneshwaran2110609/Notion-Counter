package com.Project.NotionCounter.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.Project.NotionCounter.config.*;
import com.Project.NotionCounter.models.NotionData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;

@Component
public class NotionClient {
	
	private final RestTemplate restTemplate;
	private final NotionConfig notionConfig;
	
	public NotionClient(NotionConfig notionConfig) {
        this.restTemplate = new RestTemplate();
        this.notionConfig = notionConfig;
    }
	
	public NotionData getChildrenBlocks() {
        String url = String.format("https://api.notion.com/v1/blocks/%s/children?page_size=100",
                this.notionConfig.getBlock().getId());

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(this.notionConfig.getApi().getKey());
        headers.set("Notion-Version", this.notionConfig.getApi().getVersion());

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<NotionData> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, NotionData.class);

        return response.getBody();
    }
	
}
