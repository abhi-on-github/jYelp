package com.github.jyelp;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.github.jyelp.model.GeoBoundingBox;
import com.github.jyelp.model.GeoCoordinate;

public class QueryBuilderTest {

    @Test
    public void testEmptyQuery() {
        String expectedParameters = "";
        QueryBuilder query = new QueryBuilder();
        assertEquals(expectedParameters, query.toString());
    }
    
    @Test
    public void testQueries() {
        // Term and Location
        String expectedParameters = "term=food&location=San+Francisco";
        QueryBuilder query = new QueryBuilder();
        query.setTerm("food");
        query.setLocation("San Francisco");
        
        assertEquals(expectedParameters, query.toString());
        
        // Term, Limit, and Bounds
        expectedParameters = "term=food&limit=3&bounds=37.9,-122.5|37.788022,-122.399797";
        query = new QueryBuilder();
        query.setTerm("food");
        GeoBoundingBox boundingBox = new GeoBoundingBox(37.900000, -122.500000, 37.788022, -122.399797);
        query.setBoundingBox(boundingBox);
        query.setLimit(3);
        
        assertEquals(expectedParameters, query.toString());
        
        // Term and Coordinate
        expectedParameters = "term=food&ll=37.788022,-122.399797";
        query = new QueryBuilder();
        query.setTerm("food");
        GeoCoordinate coord = new GeoCoordinate(37.788022, -122.399797);
        query.setGeoCoordinate(coord);
        
        assertEquals(expectedParameters, query.toString());
    }

}
