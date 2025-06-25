package com.Project.NotionCounter.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.Project.NotionCounter.config.*;
import com.Project.NotionCounter.models.NotionData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.web.client.RestTemplate;
import java.util.*;

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
	
	public void updateParagraphBlock(String blockId, String content) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
		RestTemplate newRestTemplate = new RestTemplate(factory);
		String url = String.format("https://api.notion.com/v1/blocks/%s", blockId);
		
		Map<String, Object> textMap = Map.of("content",content);
		Map<String, Object> richTextItem = Map.of("type","text","text",textMap);
		Map<String, Object> paragraphMap = Map.of("rich_text",List.of(richTextItem));
		Map<String, Object> body = Map.of("paragraph",paragraphMap);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth(this.notionConfig.getApi().getKey());
		headers.set("Notion-Version", this.notionConfig.getApi().getVersion());
		
		HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
		
		newRestTemplate.exchange(url, HttpMethod.PATCH, request, String.class);
	}
	
}
