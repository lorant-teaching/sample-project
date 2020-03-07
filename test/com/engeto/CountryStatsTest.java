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
        Assert.assertEquals("Poland", highestVAT.get(0).getName());
        Assert.assertEquals("Austria", highestVAT.get(1).getName());
        Assert.assertEquals("Great Britain", highestVAT.get(2).getName());
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
        Assert.assertEquals("Spain", lowestVAT.get(0).getName());
        Assert.assertEquals("France", lowestVAT.get(1).getName());
        Assert.assertEquals("Great Britain", lowestVAT.get(2).getName());
    }
}
