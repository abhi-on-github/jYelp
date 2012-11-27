package com.github.jyelp.model;

/**
 * Class representing the Region object returned from Yelp API
 */
public class Region {
    private RegionCenter center;
    private RegionSpan span;
    
    public RegionCenter getCenter() {
        return center;
    }
    public void setCenter(RegionCenter center) {
        this.center = center;
    }
    
    public RegionSpan getSpan() {
        return span;
    }
    public void setSpan(RegionSpan span) {
        this.span = span;
    }
}
