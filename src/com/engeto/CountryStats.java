package com.engeto;

import java.util.ArrayList;

public class CountryStats {
    private ArrayList<Country> highestVAT;
    private ArrayList<Country> lowestVAT;

    public void highestVAT(ArrayList<Country> countries) {
        this.highestVAT = new ArrayList<>();
        Country highestCountry = new Country();
        for (int i = 0; i < 3; i++) {
            double highestRate = Double.MIN_VALUE;
            for (Country oneCountry : countries) {
                if (oneCountry.getStandardRate() > highestRate) {
                    highestRate = oneCountry.getStandardRate();
                    highestCountry = oneCountry;
                }
            }
            this.highestVAT.add(new Country(highestCountry.getName(), highestCountry.getCode(), highestCountry.getStandardRate()));
            countries.remove(highestCountry);
        }
    }

    public void lowestVAT(ArrayList<Country> countries) {
        this.lowestVAT = new ArrayList<>();
        Country lowestCountry = new Country();
        for (int i = 0; i < 3; i++) {
            double lowestRate = Double.MAX_VALUE;
            for (Country oneCountry : countries) {
                if (oneCountry.getStandardRate() < lowestRate) {
                    lowestRate = oneCountry.getStandardRate();
                    lowestCountry = oneCountry;
                }
            }
            this.lowestVAT.add(new Country(lowestCountry.getName(), lowestCountry.getCode(), lowestCountry.getStandardRate()));
            countries.remove(lowestCountry);
        }
    }

    public void printHighest() {
        System.out.println("Countries with highest standard interest rates are following: ");
        for (Country country : this.highestVAT) {
            System.out.println(country);
        }
    }

    public void printLowest() {
        System.out.println("Countries with highest standard interest rates are following: ");
        for (Country country : this.lowestVAT) {
            System.out.println(country);
        }
    }
}
