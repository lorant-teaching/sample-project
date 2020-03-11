package com.engeto;

import kong.unirest.GetRequest;
import kong.unirest.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        JsonDownloader jsonDownloader = new JsonDownloader();
        GetRequest request = jsonDownloader.getRequestFrom("http://jsonvat.com/");
        JSONObject jsonObject = jsonDownloader.getAsJson(request);
        ArrayList<Country> countries = new CountryExtractor().extractCountries(jsonObject);

        CountryStats countryStats = new CountryStats();
        List<Country> highestVAT = countryStats.getHighestVAT(countries);
        List<Country> lowestVAT = countryStats.getLowestVAT(countries);

        System.out.println("Countries with highest standard interest rates are following: ");
        for (Country country : highestVAT) {
            System.out.println(country);
        }

        System.out.println("");

        System.out.println("Countries with highest standard interest rates are following: ");
        for (Country country : lowestVAT) {
            System.out.println(country);
        }


    }
}
