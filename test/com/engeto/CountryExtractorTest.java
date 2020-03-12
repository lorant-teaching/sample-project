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
        GetRequest request = jsonDownloader.getRequestFrom("https://my-json-server.typicode.com/chvatalp/sample-api/db");
        JSONObject jsonObject = jsonDownloader.getAsJson(request);
        ArrayList<Country> countries = new CountryExtractor().extractCountries(jsonObject);

        for (Country country : countries) {
            if (country.getName().equals("SampleCountry")) {
                Assert.assertEquals("SampleCountry", country.getName());
            }
            if (country.getName().equals("SampleCountry")) {
                Assert.assertEquals("SC", country.getCode());
            }
            if (country.getName().equals("SampleCountry2")) {
                Assert.assertEquals(21.0, country.getStandardRate(), 0.01);
            }
        }
    }
}
