package com.github.jyelp.model;

/**
 * Class representing the Business object returned from Yelp API
 */
public class RegionSpan {
    private Double latitude_delta;
    private Double longitude_delta;
    
    public Double getLatitude_delta() {
        return latitude_delta;
    }
    public void setLatitude_delta(Double latitude_delta) {
        this.latitude_delta = latitude_delta;
    }
    
    public Double getLongitude_delta() {
        return longitude_delta;
    }
    public void setLongitude_delta(Double longitude_delta) {
        this.longitude_delta = longitude_delta;
    }
    
    
}
