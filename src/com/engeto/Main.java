package com.engeto;

import kong.unirest.json.JSONObject;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        JSONObject jsonObject = new JsonDownloader().downloadFrom("http://jsonvat.com/");
        ArrayList<Country> countries = new CountryExtractor().extractCountries(jsonObject);

        CountryStats countryStats = new CountryStats();
        countryStats.highestVAT(countries);
        countryStats.lowestVAT(countries);

        countryStats.printHighest();
        System.out.println("");
        countryStats.printLowest();
    }
}
