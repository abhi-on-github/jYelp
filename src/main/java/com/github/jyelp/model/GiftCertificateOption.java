package com.github.jyelp.model;

/**
 * Class representing the Gift Certificate Option object returned from Yelp API
 */
public class GiftCertificateOption {
    private Double price;
    private String formatted_price;
    
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public String getFormatted_price() {
        return formatted_price;
    }
    public void setFormatted_price(String formatted_price) {
        this.formatted_price = formatted_price;
    }
    
    
}
