package com.github.jyelp.model;

/**
 * Class representing the Review object returned from Yelp API
 */
public class Review {
    private String id;
    private Double rating;
    private String rating_image_url;
    private String rating_image_small_url;
    private String rating_image_large_url;
    private String excerpt;
    private Long time_created;
    private ReviewUser user;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    public Double getRating() {
        return rating;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }
    
    public String getRating_image_url() {
        return rating_image_url;
    }
    public void setRating_image_url(String rating_image_url) {
        this.rating_image_url = rating_image_url;
    }
    
    public String getRating_image_small_url() {
        return rating_image_small_url;
    }
    public void setRating_image_small_url(String rating_image_small_url) {
        this.rating_image_small_url = rating_image_small_url;
    }
    
    public String getRating_image_large_url() {
        return rating_image_large_url;
    }
    public void setRating_image_large_url(String rating_image_large_url) {
        this.rating_image_large_url = rating_image_large_url;
    }
    
    public String getExcerpt() {
        return excerpt;
    }
    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }
    
    public Long getTime_created() {
        return time_created;
    }
    public void setTime_created(Long time_created) {
        this.time_created = time_created;
    }
    
    public ReviewUser getUser() {
        return user;
    }
    public void setUser(ReviewUser user) {
        this.user = user;
    }
}
