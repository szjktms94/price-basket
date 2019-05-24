package com.adthena;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BillCreatorTest {
    private BillCreator billCreator;

    @Parameterized.Parameter()
    public String[] items;

    @Parameterized.Parameter(1)
    public String[] expectedBill;

    @Parameterized.Parameters
    public static Collection testCases() {
        String expectedBill = "Subtotal: £3.55\n" +
                "Total: £3.55";

        String expectedBill1 = "Subtotal: £4.9\n" +
                "Apples 10% off: -20p\n" +
                "Two soups discount 50% off from bread: -40 p\n" +
                "Total: £4.3";

        String expectedBill2 = "Subtotal: £3.6\n" +
                "Apples 10% off: -10p\n" +
                "Total: £3.5";

        return Arrays.asList(new String[][][] {
                {{"milk","soup","bread", "bread"},{expectedBill}},
                {{"apples","apples","soup", "soup", "bread", "bread"},{expectedBill1}},
                {{"apples","soup","soup","milk"},{expectedBill2}},
        });
    }

    @Before
    public void initialize() {
        billCreator = new BillCreator();
    }

    @Test
    public void testCreateBill() {
//        GIVEN items and WHEN create bill
        String bill = billCreator.createBill(items);

//        THEN bill equals expected bill
        assertEquals(expectedBill[0],bill);
    }
}
