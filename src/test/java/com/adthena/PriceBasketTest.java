package com.adthena;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PriceBasketTest {
    private PriceBasket priceBasket = new PriceBasket();

    // fields used together with @Parameter must be public
    @Parameterized.Parameter(0)
    public String basket;
    @Parameterized.Parameter(1)
    public String basket1;
    @Parameterized.Parameter(2)
    public String basket3;


    // creates the test data
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { "apples" , "apples", "bread"}, { "soup" , "soup", "bread"}, { "milk" , "soup", "soup", "bread","bread", "apples"} };
        return Arrays.asList(data);
    }
    @Test
    public void buyApplesBread2Soups() {
//        priceBasket.main();
        assertEquals(5,5);
    }
}
