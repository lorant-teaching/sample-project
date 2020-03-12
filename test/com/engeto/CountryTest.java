package com.engeto;

import org.junit.Assert;
import org.junit.Test;

public class CountryTest {
    @Test
    public void getNameTest() {
        Country countryTest = new Country("America", "USA", 21.0);
        Assert.assertEquals("America", countryTest.getName());
    }

    @Test
    public void getCodeTest() {
        Country countryTest = new Country("America", "USA", 21.0);
        Assert.assertEquals("USA", countryTest.getCode());
    }

    @Test
    public void getStandardRateTest() {
        Country countryTest = new Country("America", "USA", 21.0);
        Assert.assertEquals(21.0, countryTest.getStandardRate(), 0.01);
    }

}
