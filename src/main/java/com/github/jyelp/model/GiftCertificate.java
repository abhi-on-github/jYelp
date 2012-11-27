package com.github.jyelp.model;

import java.util.List;

/**
 * Class representing the Gift Certificate object returned from Yelp API
 */
public class GiftCertificate {
    private String id;
    private String url;
    private String image_url;
    private String currency_code;
    private String unused_balances;
    private List<GiftCertificateOption> options;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getImage_url() {
        return image_url;
    }
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
    
    public String getCurrency_code() {
        return currency_code;
    }
    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }
    
    public String getUnused_balances() {
        return unused_balances;
    }
    public void setUnused_balances(String unused_balances) {
        this.unused_balances = unused_balances;
    }
    
    public List<GiftCertificateOption> getOptions() {
        return options;
    }
    public void setOptions(List<GiftCertificateOption> options) {
        this.options = options;
    }
}
