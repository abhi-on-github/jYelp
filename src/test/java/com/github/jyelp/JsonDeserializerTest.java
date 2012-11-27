package com.github.jyelp;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import junit.framework.AssertionFailedError;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.github.jyelp.model.Business;
import com.github.jyelp.model.Coordinate;
import com.github.jyelp.model.Deal;
import com.github.jyelp.model.DealOption;
import com.github.jyelp.model.ErrorResponse;
import com.github.jyelp.model.GiftCertificate;
import com.github.jyelp.model.GiftCertificateOption;
import com.github.jyelp.model.Location;
import com.github.jyelp.model.Region;
import com.github.jyelp.model.RegionCenter;
import com.github.jyelp.model.RegionSpan;
import com.github.jyelp.model.Review;
import com.github.jyelp.model.ReviewUser;
import com.github.jyelp.model.SearchResponse;
import com.github.jyelp.model.YelpResponse;

public class JsonDeserializerTest {
    
    @Test
    public void testBusinessAPIResponseDeserialization() throws IOException {
        InputStream is = getClass().getResourceAsStream("/businessResponse.txt");
        String businessResponseJson = IOUtils.toString(is);
        
        JsonDeserializer jsond = new JsonDeserializer();
        Business business = (Business)jsond.deserializeBusiness(businessResponseJson);
        
        // Verify all members of each class are populated with the Json data
        assertEquals("urban-curry-san-francisco", business.getId());
        assertTrue(business.getIs_claimed());
        assertFalse(business.getIs_closed());
        assertEquals("Urban Curry", business.getName());
        assertEquals("http://s3-media4.ak.yelpcdn.com/bphoto/Hv5vsWpqeaUKepr9nffJnw/ms.jpg", business.getImage_url());
        assertEquals("http://www.yelp.com/biz/urban-curry-san-francisco", business.getUrl());
        assertEquals("http://m.yelp.com/biz/EFjaNaqg2foSIM--mML49g", business.getMobile_url());
        assertEquals("4156779744", business.getPhone());
        assertEquals("+1-415-677-9744", business.getDisplay_phone());
        assertEquals(new Integer(227), business.getReview_count());
        
        // distance not provided in the json response example
        // will have to search with lat/long to get this value
        // private Double distance;
        
        assertEquals(new Double(4.0), business.getRating());
        assertEquals("http://media2.ak.yelpcdn.com/static/201012164084228337/img/ico/stars/stars_4.png", business.getRating_img_url());
        assertEquals("http://media2.ak.yelpcdn.com/static/20101216418129184/img/ico/stars/stars_small_4.png", business.getRating_img_url_small());
        assertEquals("http://media4.ak.yelpcdn.com/static/20101216169592178/img/ico/stars/stars_large_4.png", business.getRating_img_url_large());
        assertEquals("Shame on me for taking so long to update a review.\n\nI have been there several times now and love it everytime.\n\nDevour:  My fav the Lamb Tikka Masala, my...", business.getSnippet_text());
        assertEquals("http://s3-media1.ak.yelpcdn.com/photo/39c5Vpe0cFCtZ-rmgAr3YQ/ms.jpg", business.getSnippet_image_url());
        
        assertEquals("indpak", business.getCategories().get("Indian"));
        assertEquals("pakistani", business.getCategories().get("Pakistani"));
        
        Location loc = business.getLocation();
        assertEquals("523 Broadway", loc.getAddress().get(0));
        assertEquals("San Francisco", loc.getCity());
        assertEquals("US", loc.getCountry_code());
        assertEquals("Kearny St & Romolo Pl", loc.getCross_streets());
        assertEquals("523 Broadway", loc.getDisplay_address().get(0));
        assertEquals("(b/t Kearny St & Romolo Pl)", loc.getDisplay_address().get(1));
        assertEquals("North Beach/Telegraph Hill", loc.getDisplay_address().get(2));
        assertEquals("San Francisco, CA 94133", loc.getDisplay_address().get(3));
        assertEquals(new Integer(8), loc.getGeo_accuracy());
        assertEquals("North Beach/Telegraph Hill", loc.getNeighborhoods().get(0));
        assertEquals("94133", loc.getPostal_code());
        assertEquals("CA", loc.getState_code());
        
        Coordinate coord = loc.getCoordinate();
        assertEquals(new Double(37.797745900000002), coord.getLatitude());
        assertEquals(new Double(-122.40586399999999), coord.getLongitude());
        
        assertEquals(new Integer(1), new Integer(business.getDeals().size()));
        Deal deal = business.getDeals().get(0);
        assertEquals("USD", deal.getCurrency_code());
        assertEquals("http://s3-media4.ak.yelpcdn.com/dphoto/ShQGf5qi-52HwPiKyZTZ3w/m.jpg", deal.getImage_url());
        assertEquals("http://www.yelp.com/biz/urban-curry-san-francisco?deal=1", deal.getUrl());
        assertTrue(deal.getIs_popular());
        assertEquals(new Long(1317414369), deal.getTime_start());
        assertEquals("$10 for $20 voucher", deal.getTitle());
        
        DealOption doption = deal.getOptions().get(0);
        assertEquals("$20", doption.getFormatted_original_price());
        assertEquals("$10", doption.getFormatted_price());
        assertTrue(doption.getIs_quantity_limited());
        assertEquals(new Double(2000), doption.getOriginal_price());
        assertEquals(new Double(1000), doption.getPrice());
        assertEquals("http://www.yelp.com/deal/cC24ccQGIH8mowfu5Vbe0Q/view", doption.getPurchase_url());
        assertEquals(new Integer(36), doption.getRemaining_count());
        assertEquals("$10 for $20 voucher", doption.getTitle());
        
        GiftCertificate gcert = business.getGift_certificates().get(0);
        assertEquals("USD", gcert.getCurrency_code());
        assertEquals("http://s3-media4.ak.yelpcdn.com/bphoto/Hv5vsWpqeaUKepr9nffJnw/m.jpg", gcert.getImage_url());
        assertEquals("http://www.yelp.com/gift-certificates/some-donut-place-pasadena", gcert.getUrl());
        assertEquals("ZZy5EwrI3wyHw8y54jZruA", gcert.getId());
        assertEquals("CREDIT", gcert.getUnused_balances());
        
        GiftCertificateOption goption1 = gcert.getOptions().get(0);
        assertEquals("$25", goption1.getFormatted_price());
        assertEquals(new Double(2500), goption1.getPrice());
        GiftCertificateOption goption2 = gcert.getOptions().get(1);
        assertEquals("$50", goption2.getFormatted_price());
        assertEquals(new Double(5000), goption2.getPrice());
        
        Review review1 = business.getReviews().get(0);
        assertEquals("I gave this restaurant two stars just because of the extremely quick delivery and friendly delivery guy, but the food was nothing I would order again....", review1.getExcerpt());
        assertEquals("-RDZxLTUExM9Q02x4hZmHg", review1.getId());
        assertEquals(new Double(2), review1.getRating());
        assertEquals("http://media2.ak.yelpcdn.com/static/20101216220207235/img/ico/stars/stars_large_2.png", review1.getRating_image_large_url());
        assertEquals("http://media4.ak.yelpcdn.com/static/201012164278297776/img/ico/stars/stars_small_2.png", review1.getRating_image_small_url());
        assertEquals("http://media4.ak.yelpcdn.com/static/201012163489049252/img/ico/stars/stars_2.png", review1.getRating_image_url());
        assertEquals(new Long(1317939620), review1.getTime_created());
        ReviewUser user1 = review1.getUser();
        assertEquals("AUEDVbP9XNlOcgYOAfR8yg", user1.getId());
        assertEquals("http://s3-media2.ak.yelpcdn.com/photo/0CX0RSoz8NkPlOTo7Ckqdg/ms.jpg", user1.getImage_url());
        assertEquals("Holly E.", user1.getName());
        
        Review review2 = business.getReviews().get(1);
        assertEquals("word on the streets!...get the goat!...quick call to check on the goat...goat is available!...pre-drinking before dinner...no alcohol at urban...", review2.getExcerpt());
        assertEquals("Zpfqx8FI8Pdpo-QVi8BCFA", review2.getId());
        assertEquals(new Double(3), review2.getRating());
        assertEquals("http://media3.ak.yelpcdn.com/static/201012161053250406/img/ico/stars/stars_large_3.png", review2.getRating_image_large_url());
        assertEquals("http://media1.ak.yelpcdn.com/static/201012162337205794/img/ico/stars/stars_small_3.png", review2.getRating_image_small_url());
        assertEquals("http://media1.ak.yelpcdn.com/static/201012161694360749/img/ico/stars/stars_3.png", review2.getRating_image_url());
        assertEquals(new Long(1317918655), review2.getTime_created());
        ReviewUser user2 = review2.getUser();
        assertEquals("JnGtgOPpkjyWOvWM0SYEXg", user2.getId());
        assertEquals("http://s3-media4.ak.yelpcdn.com/photo/On-6060NIAqIS_PfAVwDrg/ms.jpg", user2.getImage_url());
        assertEquals("hen a.", user2.getName());
        
        Review review3 = business.getReviews().get(2);
        assertEquals("Urban Curry was okay. Friendly service and quick delivery but the food was very average in my opinion.\n\nThe best part of the meal was the vegetable pakoras...", review3.getExcerpt());
        assertEquals("FPagv5DTlPQ2h_Son5N0UA", review3.getId());
        assertEquals(new Double(3), review3.getRating());
        assertEquals("http://media3.ak.yelpcdn.com/static/201012161053250406/img/ico/stars/stars_large_3.png", review3.getRating_image_large_url());
        assertEquals("http://media1.ak.yelpcdn.com/static/201012162337205794/img/ico/stars/stars_small_3.png", review3.getRating_image_small_url());
        assertEquals("http://media1.ak.yelpcdn.com/static/201012161694360749/img/ico/stars/stars_3.png", review3.getRating_image_url());
        assertEquals(new Long(1317746299), review3.getTime_created());
        ReviewUser user3 = review3.getUser();
        assertEquals("tZA9Uztmj69tgvlHiiMKsg", user3.getId());
        assertEquals("http://s3-media3.ak.yelpcdn.com/photo/I87X9o6NgGrkO1lfBL5-4Q/ms.jpg", user3.getImage_url());
        assertEquals("Chelsea J.", user3.getName());
    }
    
    @Test
    public void testSearchAPIResponseDeserialization() throws IOException {
        /* testBusinessAPIResponseDeserialization test covers all Business data
         * that will appear in a search. This test asserts the fields outside of
         * these objects.
         */
        InputStream is = getClass().getResourceAsStream("/searchResponse.txt");
        String searchResponseJson = IOUtils.toString(is);
        
        JsonDeserializer jsond = new JsonDeserializer();
        SearchResponse sresponse = (SearchResponse)jsond.deserializeSearch(searchResponseJson);
        
        assertEquals(new Integer(1), new Integer(sresponse.getBusinesses().size()));
        
        RegionCenter center = sresponse.getRegion().getCenter();
        assertEquals(new Double(37.786138600000001), center.getLatitude());
        assertEquals(new Double(-122.40262130000001), center.getLongitude());
        
        RegionSpan span = sresponse.getRegion().getSpan();
        assertEquals(new Double(0.0), span.getLatitude_delta());
        assertEquals(new Double(0.0), span.getLatitude_delta());
        
        assertEquals(new Long(10651), sresponse.getTotal());
    }
    
    @Test
    public void testBusinessAPIError() throws IOException {
        // Test Error Response
        InputStream is = getClass().getResourceAsStream("/errorResponse.txt");
        String businessResponseJson = IOUtils.toString(is);
        
        JsonDeserializer jsond = new JsonDeserializer();
        YelpResponse business = jsond.deserializeBusiness(businessResponseJson);
        assertTrue(business instanceof ErrorResponse);
        
        // Test Successful Response (Business)
        is = getClass().getResourceAsStream("/businessResponse.txt");
        businessResponseJson = IOUtils.toString(is);
        
        business = jsond.deserializeBusiness(businessResponseJson);
        assertTrue(business instanceof Business);
    }
    
    @Test
    public void testSearchAPIError() throws IOException {
        // Test Error Response
        InputStream is = getClass().getResourceAsStream("/errorResponse.txt");
        String searchResponseJson = IOUtils.toString(is);
        
        JsonDeserializer jsond = new JsonDeserializer();
        YelpResponse sresponse = jsond.deserializeSearch(searchResponseJson);
        assertTrue(sresponse instanceof ErrorResponse);
        
        // Test Successful Response (SearchResponse)
        is = getClass().getResourceAsStream("/searchResponse.txt");
        searchResponseJson = IOUtils.toString(is);
        
        sresponse = jsond.deserializeSearch(searchResponseJson);
        assertTrue(sresponse instanceof SearchResponse);
    }
}

