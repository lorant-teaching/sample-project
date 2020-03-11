package com.engeto;

import kong.unirest.GetRequest;

import kong.unirest.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


public class CountryExtractorTest {
    @Test
    public void extractCountriesTest() {
        JsonDownloader jsonDownloader = new JsonDownloader();
        GetRequest request = jsonDownloader.getRequestFrom("http://jsonvat.com/");
        JSONObject jsonObject = jsonDownloader.getAsJson(request);
        ArrayList<Country> countries = new CountryExtractor().extractCountries(jsonObject);


        for (Country country : countries) {
            if (country.getName().equals("Spain")) {
                Assert.assertEquals("Spain", country.getName());
            }
            if (country.getName().equals("Bulgaria")) {
                Assert.assertEquals("BG", countries.get(1).getCode());
            }
            if (country.getName().equals("Hungary")) {
                Assert.assertEquals(27.0, countries.get(2).getStandardRate(), 0.01);
            }
        }
    }
}
