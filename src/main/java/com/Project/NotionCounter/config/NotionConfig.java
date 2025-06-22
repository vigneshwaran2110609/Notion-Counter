package com.Project.NotionCounter.config;

//NotionConfig is a configuration binding class that pulls in values 
//from your application.properties

import org.springframework.stereotype.Component;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Component
@ConfigurationProperties(prefix = "notion")
public class NotionConfig {
	
	private Api api = new Api();
    private Block block = new Block();
    
    public static class Api {
    	
        private String key;
        private String version;
        
        public void setKey(String key) {
        	this.key = key;
        }
        
        public void setVersion(String version) {
        	this.version = version;
        }
        
        public String getKey() {
        	return this.key;
        }
        
        public String getVersion() {
        	return this.version;
        }
    }
    
    public static class Block {
    	
        private String id;
        
        public String getId() {
        	return this.id;
        }

        public void setId(String id) {
        	this.id = id;
        }
    }
    
    public Api getApi() { return api; }
    public void setApi(Api api) { this.api = api; }

    public Block getBlock() { return block; }
    public void setBlock(Block block) { this.block = block; }

}
