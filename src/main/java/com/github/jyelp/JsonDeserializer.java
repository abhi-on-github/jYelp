package com.github.jyelp;

import java.util.ArrayList;
import java.util.List;

import com.github.jyelp.model.Business;
import com.github.jyelp.model.ErrorResponse;
import com.github.jyelp.model.SearchResponse;
import com.github.jyelp.model.YelpResponse;
import com.google.gson.*;

public class JsonDeserializer {

    public YelpResponse deserializeSearch(String searchJson) {
        JsonParser jparser = new JsonParser();
        JsonElement json = jparser.parse(searchJson);
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        Gson gson = gsonBuilder.create();
        
        if(json.getAsJsonObject().get("error") == null) {
            return gson.fromJson(searchJson, SearchResponse.class);
        }
        else {
            return gson.fromJson(searchJson, ErrorResponse.class);
        }
    }
    
    public YelpResponse deserializeBusiness(String businessJson) {
        JsonParser jparser = new JsonParser();
        JsonElement json = jparser.parse(businessJson);
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        Gson gson = gsonBuilder.create();
        
        if(json.getAsJsonObject().get("error") == null) {
            return gson.fromJson(businessJson, Business.class);
        }
        else {
            return gson.fromJson(businessJson, ErrorResponse.class);
        }
    }
}
