package com.github.jyelp;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.github.jyelp.model.Business;
import com.github.jyelp.model.SearchResponse;

public class JYelpTest {
    
    // Provide Yelp Developer keys to run this test
    String consumer_key = "";
    String consumer_secret = "";
    String access_token = "";
    String token_secret = "";

    //@Test
    @Ignore
    public void businessSearchTest() {
        JYelp jyelp = new JYelp(consumer_key, consumer_secret, access_token, token_secret);
        Business business = (Business)jyelp.getBusiness("song-que-falls-church");
        System.out.println(business.getName());
        assertEquals("Song Que", business.getName());
    }
    
    //@Test
    @Ignore
    public void searchAPITest() {
        JYelp jyelp = new JYelp(consumer_key, consumer_secret, access_token, token_secret);
        QueryBuilder query = new QueryBuilder();
        query.setTerm("food");
        query.setLocation("San Francisco");
        SearchResponse sresponse = (SearchResponse)jyelp.search(query.toString());
        assertTrue(sresponse.getTotal() > 0);
    }

}
