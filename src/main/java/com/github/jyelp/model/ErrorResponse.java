package com.github.jyelp.model;

/**
 * Class representing an Error Response returned from Yelp API
 */
public class ErrorResponse implements YelpResponse {
    private String text;
    private String id;
    private String field;
    
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    public String getField() {
        return field;
    }
    public void setField(String field) {
        this.field = field;
    }
}
