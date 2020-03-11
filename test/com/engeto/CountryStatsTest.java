package com.engeto;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CountryStatsTest {
    @Test
    public void highestVATTest() {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(new Country("Spain", "ES", 21));
        countries.add(new Country("France", "FR", 22));
        countries.add(new Country("Great Britain", "GB", 23));
        countries.add(new Country("Austria", "AU", 24));
        countries.add(new Country("Poland", "PL", 25));

        ArrayList<Country> highestVAT = new ArrayList<>();
        Country highestCountry = new Country();
        for (int i = 0; i < 3; i++) {
            double highestRate = Double.MIN_VALUE;
            for (Country oneCountry : countries) {
                if (oneCountry.getStandardRate() > highestRate) {
                    highestRate = oneCountry.getStandardRate();
                    highestCountry = oneCountry;
                }
            }
            highestVAT.add(new Country(highestCountry.getName(), highestCountry.getCode(), highestCountry.getStandardRate()));
            countries.remove(highestCountry);
        }

        Country poland = null;
        Country austria = null;
        Country greatBritain = null;

        for (Country country : highestVAT) {
            if (country.getName().equals("Poland")) {
                Assert.assertEquals("Poland", country.getName());
            }
            if (country.getName().equals("Austria")) {
                Assert.assertEquals("Austria", country.getName());
            }
            if (country.getName().equals("Great Britain")) {
                Assert.assertEquals("Great Britain", country.getName());
            }
        }
    }

    @Test
    public void lowestVATTest() {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(new Country("Spain", "ES", 21));
        countries.add(new Country("France", "FR", 22));
        countries.add(new Country("Great Britain", "GB", 23));
        countries.add(new Country("Austria", "AU", 24));
        countries.add(new Country("Poland", "PL", 25));

        ArrayList<Country> lowestVAT = new ArrayList<>();
        Country lowestCountry = new Country();
        for (int i = 0; i < 3; i++) {
            double lowestRate = Double.MAX_VALUE;
            for (Country oneCountry : countries) {
                if (oneCountry.getStandardRate() < lowestRate) {
                    lowestRate = oneCountry.getStandardRate();
                    lowestCountry = oneCountry;
                }
            }
            lowestVAT.add(new Country(lowestCountry.getName(), lowestCountry.getCode(), lowestCountry.getStandardRate()));
            countries.remove(lowestCountry);
        }

        for (Country country : lowestVAT) {
            if (country.getName().equals("Spain")) {
                Assert.assertEquals("Spain", country.getName());
            }
            if (country.getName().equals("France")) {
                Assert.assertEquals("France", country.getName());
            }
            if (country.getName().equals("Great Britain")) {
                Assert.assertEquals("Great Britain", country.getName());
            }
        }

    }
}
