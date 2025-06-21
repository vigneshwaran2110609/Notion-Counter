package com.Project.NotionCounter.models;

import java.util.List;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NotionData {
	
	private String object;
    private List<Result> results;
    
    @JsonProperty("next_cursor")
    private String nextCursor;
    
    @JsonProperty("has_more")
    private boolean hasMore;
    
    private String type;
    private HashMap block;
    
    @JsonProperty("developer_survey")
    private String developerSurvey;
    
    @JsonProperty("request_id")
    private String requestId;

    // Getters and Setters
    public String getObject() { return object; }
    public void setObject(String object) { this.object = object; }

    public List<Result> getResults() { return results; }
    public void setResults(List<Result> results) { this.results = results; }

    public String getNextCursor() { return nextCursor; }
    public void setNextCursor(String nextCursor) { this.nextCursor = nextCursor; }

    public boolean isHasMore() { return hasMore; }
    public void setHasMore(boolean hasMore) { this.hasMore = hasMore; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDeveloperSurvey() { return developerSurvey; }
    public void setDeveloperSurvey(String developerSurvey) { this.developerSurvey = developerSurvey; }

    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }

    public static class Result {
        private String object;
        private String id;
        private Parent parent;

        @JsonProperty("created_time")
        private String createdTime;

        @JsonProperty("last_edited_time")
        private String lastEditedTime;

        @JsonProperty("created_by")
        private User createdBy;

        @JsonProperty("last_edited_by")
        private User lastEditedBy;

        @JsonProperty("has_children")
        private boolean hasChildren;

        private boolean archived;

        @JsonProperty("in_trash")
        private boolean inTrash;

        private String type;
        private Paragraph paragraph;

        // Getters and Setters...
        public String getObject() { return object; }
        public void setObject(String object) { this.object = object; }

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public Parent getParent() { return parent; }
        public void setParent(Parent parent) { this.parent = parent; }

        public String getCreatedTime() { return createdTime; }
        public void setCreatedTime(String createdTime) { this.createdTime = createdTime; }

        public String getLastEditedTime() { return lastEditedTime; }
        public void setLastEditedTime(String lastEditedTime) { this.lastEditedTime = lastEditedTime; }

        public User getCreatedBy() { return createdBy; }
        public void setCreatedBy(User createdBy) { this.createdBy = createdBy; }

        public User getLastEditedBy() { return lastEditedBy; }
        public void setLastEditedBy(User lastEditedBy) { this.lastEditedBy = lastEditedBy; }

        public boolean isHasChildren() { return hasChildren; }
        public void setHasChildren(boolean hasChildren) { this.hasChildren = hasChildren; }

        public boolean isArchived() { return archived; }
        public void setArchived(boolean archived) { this.archived = archived; }

        public boolean isInTrash() { return inTrash; }
        public void setInTrash(boolean inTrash) { this.inTrash = inTrash; }

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public Paragraph getParagraph() { return paragraph; }
        public void setParagraph(Paragraph paragraph) { this.paragraph = paragraph; }
    }

    public static class Parent {
        private String type;

        @JsonProperty("page_id")
        private String pageId;

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public String getPageId() { return pageId; }
        public void setPageId(String pageId) { this.pageId = pageId; }
    }

    public static class User {
        private String object;
        private String id;

        public String getObject() { return object; }
        public void setObject(String object) { this.object = object; }

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
    }

    public static class Paragraph {
        @JsonProperty("rich_text")
        private List<RichText> richText;

        private String color;

        public List<RichText> getRichText() { return richText; }
        public void setRichText(List<RichText> richText) { this.richText = richText; }

        public String getColor() { return color; }
        public void setColor(String color) { this.color = color; }
    }

    public static class RichText {
        private String type;
        private Text text;
        private Annotations annotations;

        @JsonProperty("plain_text")
        private String plainText;

        private String href;

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public Text getText() { return text; }
        public void setText(Text text) { this.text = text; }

        public Annotations getAnnotations() { return annotations; }
        public void setAnnotations(Annotations annotations) { this.annotations = annotations; }

        public String getPlainText() { return plainText; }
        public void setPlainText(String plainText) { this.plainText = plainText; }

        public String getHref() { return href; }
        public void setHref(String href) { this.href = href; }
    }

    public static class Text {
        private String content;
        private String link;

        public String getContent() { return content; }
        public void setContent(String content) { this.content = content; }

        public String getLink() { return link; }
        public void setLink(String link) { this.link = link; }
    }

    public static class Annotations {
        private boolean bold;
        private boolean italic;
        private boolean strikethrough;
        private boolean underline;
        private boolean code;
        private String color;

        public boolean isBold() { return bold; }
        public void setBold(boolean bold) { this.bold = bold; }

        public boolean isItalic() { return italic; }
        public void setItalic(boolean italic) { this.italic = italic; }

        public boolean isStrikethrough() { return strikethrough; }
        public void setStrikethrough(boolean strikethrough) { this.strikethrough = strikethrough; }

        public boolean isUnderline() { return underline; }
        public void setUnderline(boolean underline) { this.underline = underline; }

        public boolean isCode() { return code; }
        public void setCode(boolean code) { this.code = code; }

        public String getColor() { return color; }
        public void setColor(String color) { this.color = color; }
    }

}
