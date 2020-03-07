package com.engeto;

import kong.unirest.GetRequest;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CountryExtractorTest {
    @Test
    public void extractCountriesTest() {
        GetRequest request = Unirest.get("http://jsonvat.com/");
        HttpResponse<JsonNode> jsonResponse = request.asJson();
        JsonNode json = jsonResponse.getBody();
        JSONObject jsonObject = json.getObject();

        JSONArray list = jsonObject.getJSONArray("rates");
        ArrayList<Country> countries = new ArrayList<>();

        for (Object elements : list) {
            JSONObject jsonElements = (JSONObject) elements;
            String name = jsonElements.getString("name");
            String code = jsonElements.getString("code");

            JSONObject periods = jsonElements.getJSONArray("periods").getJSONObject(0);
            JSONObject rates = periods.getJSONObject("rates");
            double standard = rates.getInt("standard");
            Country country = new Country(name, code, standard);
            countries.add(country);

        }
        Assert.assertEquals("Spain", countries.get(0).getName());
        Assert.assertEquals("BG", countries.get(1).getCode());
        Assert.assertEquals(27.0, countries.get(2).getStandardRate(), 0.01);
    }
}
