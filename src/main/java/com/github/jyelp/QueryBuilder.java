package com.github.jyelp;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.github.jyelp.model.GeoBoundingBox;
import com.github.jyelp.model.GeoCoordinate;
import com.github.jyelp.model.Locale;

public class QueryBuilder {

    private String term;
    private Integer limit;
    private Integer searchOffset;
    private Integer sortMode;
    private List<String> categoryFilter;
    private Integer searchRadius;
    private Boolean dealsOnly;
    private Locale locale;
    private GeoBoundingBox boundingBox;
    private GeoCoordinate geoCoordinate;
    private String location;
    
    @Override
    public String toString() {
        String queryStr = "";
        
        List<String> parameters = new ArrayList<String>();
        if(term != null && term.isEmpty() == false) {
            parameters.add("term=" + getTerm());
        }
        if(limit != null) {
            parameters.add("limit=" + getLimit());
        }
        if(searchOffset != null) {
            parameters.add("offset=" + getSearchOffset());
        }
        if(sortMode != null) {
            parameters.add("sort=" + getSortMode());
        }
        if(categoryFilter != null) {
            String catFilter = "";
            for(String category : getCategoryFilter()) {
                catFilter += category + ",";
            }
            if(catFilter.endsWith(",")) // remove ending comma
                catFilter = "category_filter=" + catFilter.substring(0, catFilter.length() - 1);
            parameters.add(catFilter);
        }
        if(searchRadius != null) {
            parameters.add("radius_filter=" + getSearchRadius());
        }
        if(dealsOnly != null) {
            parameters.add("deals_filter=" + getDealsOnly());
        }
        if(locale != null) {
            parameters.add(locale.toString());
        }
        if(boundingBox != null) {
            parameters.add(boundingBox.toString());
        }
        if(geoCoordinate != null) {
            parameters.add(geoCoordinate.toString());
        }
        if(location != null && location.isEmpty() == false) {
            parameters.add("location=" + getLocation());
        }
        
        // Construct Query String
        for(String param : parameters) {
            queryStr += param + "&";
        }
        if(queryStr.endsWith("&")) // remove ending ampersand
            queryStr = queryStr.substring(0, queryStr.length() - 1);
        
        return queryStr;
    }
    
    public QueryBuilder() {
        
    }
    
    public String getTerm() {
        try {
            return URLEncoder.encode(term, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setTerm(String term) {
        this.term = term;
    }



    public Integer getLimit() {
        return limit;
    }



    public void setLimit(Integer limit) {
        this.limit = limit;
    }



    public Integer getSearchOffset() {
        return searchOffset;
    }



    public void setSearchOffset(Integer searchOffset) {
        this.searchOffset = searchOffset;
    }



    public Integer getSortMode() {
        return sortMode;
    }



    public void setSortMode(Integer sortMode) {
        this.sortMode = sortMode;
    }



    public List<String> getCategoryFilter() {
        return categoryFilter;
    }



    public void setCategoryFilter(List<String> categoryFilter) {
        this.categoryFilter = categoryFilter;
    }



    public Integer getSearchRadius() {
        return searchRadius;
    }



    public void setSearchRadius(Integer searchRadius) {
        this.searchRadius = searchRadius;
    }



    public Boolean isDealsOnly() {
        return dealsOnly;
    }

    public void setDealsOnly(Boolean dealsOnly) {
        this.dealsOnly = dealsOnly;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public GeoBoundingBox getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(GeoBoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

    public GeoCoordinate getGeoCoordinate() {
        return geoCoordinate;
    }

    public void setGeoCoordinate(GeoCoordinate geoCoordinate) {
        this.geoCoordinate = geoCoordinate;
    }

    public String getLocation() {
        try {
            return URLEncoder.encode(location, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getDealsOnly() {
        return dealsOnly;
    }    
}
