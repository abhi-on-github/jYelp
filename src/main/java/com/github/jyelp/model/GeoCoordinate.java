package com.github.jyelp.model;

public class GeoCoordinate {
    private Double latitude;
    private Double longitude;
    private Double accuracy;
    private Double altitude;
    private Double altitude_accuracy;
    
    public GeoCoordinate(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public Double getLatitude() {
        return latitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    
    public Double getLongitude() {
        return longitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    
    public Double getAccuracy() {
        return accuracy;
    }
    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }
    
    public Double getAltitude() {
        return altitude;
    }
    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }
    
    public Double getAltitude_accuracy() {
        return altitude_accuracy;
    }
    public void setAltitude_accuracy(Double altitude_accuracy) {
        this.altitude_accuracy = altitude_accuracy;
    }
    
    @Override
    public String toString() {
        String params = "ll=" + getLatitude() + "," + getLongitude();
        if(accuracy != null)
            params += "," + getAccuracy();
        if(altitude != null)
            params += "," + getAltitude();
        if(altitude_accuracy != null)
            params += "," + getAltitude_accuracy();
        
        return params;
    }
}
