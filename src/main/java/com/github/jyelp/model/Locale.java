package com.github.jyelp.model;

import java.util.ArrayList;
import java.util.List;

public class Locale {
    private String cc;
    private String lang;
    private Boolean lang_filter;
    
    public String getCc() {
        return cc;
    }
    public void setCc(String cc) {
        this.cc = cc;
    }
    
    public String getLang() {
        return lang;
    }
    public void setLang(String lang) {
        this.lang = lang;
    }
    
    public Boolean getLang_filter() {
        return lang_filter;
    }
    public void setLang_filter(Boolean lang_filter) {
        this.lang_filter = lang_filter;
    }
    
    @Override
    public String toString() {
        String params = "";
        List<String> parameters = new ArrayList<String>();
        
        if(cc != null && cc.length() > 0) {
            parameters.add("cc=" + getCc());
        }
        if(lang != null && lang.length() > 0) {
            parameters.add("lang=" + getLang());
        }
        if(lang_filter != null) {
            parameters.add("lang_filter=" + getLang_filter());
        }
        
        // Construct Query String
        for(String param : parameters) {
            params += param + "&";
        }
        if(params.endsWith("&")) // remove ending ampersand
            params.substring(0, params.length());
        
        return params;
    }
}
