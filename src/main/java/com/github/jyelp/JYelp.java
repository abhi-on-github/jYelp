package com.github.jyelp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

import com.github.jyelp.model.YelpResponse;

public class JYelp {

    private String consumer_key;
    private String consumer_secret;
    private String access_token;
    private String token_secret;
    
    private String YELP_SEARCH_URL = "http://api.yelp.com/v2/search";
    private String YELP_BUSINESS_URL = "http://api.yelp.com/v2/business";
    
    private OAuthConsumer consumer;
    
    public JYelp() {
        
    }
    
    public JYelp(String consumer_key, String consumer_secret, 
            String access_token, String token_secret) {
        this.consumer_key = consumer_key;
        this.consumer_secret = consumer_secret;
        this.access_token = access_token;
        this.token_secret = token_secret;
        updateOAuthConsumer();
    }
    
    public void updateOAuthConsumer() {
        consumer = new DefaultOAuthConsumer(consumer_key, consumer_secret);
        consumer.setTokenWithSecret(access_token, token_secret);
    }
    
    public YelpResponse search(String query) {
        try {
            URL url = new URL(YELP_SEARCH_URL + "?" + query);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            consumer.sign(request);
            request.connect();
            return JsonDeserializer.deserializeSearch(IOUtils.toString(request.getInputStream()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (OAuthMessageSignerException e) {
            e.printStackTrace();
        } catch (OAuthExpectationFailedException e) {
            e.printStackTrace();
        } catch (OAuthCommunicationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public YelpResponse getBusiness(String businessId) {
        try {
            URL url = new URL(YELP_BUSINESS_URL + "/" + businessId);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            consumer.sign(request);
            request.connect();
            return JsonDeserializer.deserializeBusiness(IOUtils.toString(request.getInputStream()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (OAuthMessageSignerException e) {
            e.printStackTrace();
        } catch (OAuthExpectationFailedException e) {
            e.printStackTrace();
        } catch (OAuthCommunicationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String getConsumer_key() {
        return consumer_key;
    }
    public void setConsumer_key(String consumer_key) {
        this.consumer_key = consumer_key;
    }
    
    public String getConsumer_secret() {
        return consumer_secret;
    }
    public void setConsumer_secret(String consumer_secret) {
        this.consumer_secret = consumer_secret;
    }
    
    public String getAccess_token() {
        return access_token;
    }
    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
    
    public String getToken_secret() {
        return token_secret;
    }
    public void setToken_secret(String token_secret) {
        this.token_secret = token_secret;
    }
    
    
}
