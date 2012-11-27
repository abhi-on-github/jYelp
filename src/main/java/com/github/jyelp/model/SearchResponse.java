package com.github.jyelp.model;

import java.util.List;

/**
 * Class representing the Search Response object returned from Yelp API
 */
public class SearchResponse implements YelpResponse {
    private List<Business> businesses;
    private Region region;
    private Long total;
    
    public List<Business> getBusinesses() {
        return businesses;
    }
    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }
    public Region getRegion() {
        return region;
    }
    public void setRegion(Region region) {
        this.region = region;
    }
    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    } 
}
