package com.engeto;

import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

import java.util.ArrayList;

public class CountryExtractor {

    public ArrayList<Country> extractCountries(JSONObject jsonObject) {
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
        return countries;
    }

}
