package com.engeto;

import java.util.ArrayList;
import java.util.List;

public class CountryStats {


    public List<Country> getHighestVAT(List<Country> countries) {
        List<Country> highestVAT = new ArrayList();
        Country highestCountry = null;
        for (int i = 0; i < 3; i++) {
            double highestRate = Double.MIN_VALUE;
            for (Country oneCountry : countries) {
                if (oneCountry.getStandardRate() > highestRate) {
                    highestRate = oneCountry.getStandardRate();
                    highestCountry = oneCountry;
                }
            }
            highestVAT.add(highestCountry);
            countries.remove(highestCountry);
        }
        return highestVAT;
    }

    public List<Country> getLowestVAT(List<Country> countries) {
        List<Country> lowestVAT = new ArrayList<>();
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
        return lowestVAT;
    }
}
