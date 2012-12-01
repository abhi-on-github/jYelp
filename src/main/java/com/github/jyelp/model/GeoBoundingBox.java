package com.github.jyelp.model;

public class GeoBoundingBox {
    private Double sw_latitude;
    private Double sw_longitude;
    private Double ne_latitude;
    private Double ne_longitude;
    
    public GeoBoundingBox(Double sw_latitude, Double sw_longitude,
                          Double ne_latitude, Double ne_longitude) {
        this.sw_latitude = sw_latitude;
        this.sw_longitude = sw_longitude;
        this.ne_latitude = ne_latitude;
        this.ne_longitude = ne_longitude;
    }
    
    public Double getSw_latitude() {
        return sw_latitude;
    }
    public void setSw_latitude(Double sw_latitude) {
        this.sw_latitude = sw_latitude;
    }
    
    public Double getSw_longitude() {
        return sw_longitude;
    }
    public void setSw_longitude(Double sw_longitude) {
        this.sw_longitude = sw_longitude;
    }
    
    public Double getNe_latitude() {
        return ne_latitude;
    }
    public void setNe_latitude(Double ne_latitude) {
        this.ne_latitude = ne_latitude;
    }
    
    public Double getNe_longitude() {
        return ne_longitude;
    }
    public void setNe_longitude(Double ne_longitude) {
        this.ne_longitude = ne_longitude;
    }
    
    @Override
    public String toString() {
        return "bounds=" + getSw_latitude() + "," + getSw_longitude() + "|" +
                           getNe_latitude() + "," + getNe_longitude(); 
    }
}
