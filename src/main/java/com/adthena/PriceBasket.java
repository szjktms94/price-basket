package com.adthena;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PriceBasket {
    public static void main(String[]args){

        //● Soup – 65p per tin
        //● Bread – 80p per loaf
        //● Milk – £1.30 per bottle
        //● Apples – £1.00 per bag

        //Current special offers:
        //● Apples have a 10% discount off their normal price this week
        //● Buy 2 tins of soup and get a loaf of bread for half price

        //For example:
        //PriceBasket Apples Milk Bread
        //Output should be to the console, for example:
        //Subtotal: £3.10
        //Apples 10% off: ­10p
        //Total: £3.00
        //If no special offers are applicable the code should output:
        //Subtotal: £1.30
        //(No offers available)
        //Total price: £1.30
        Map<String, Long> counted = Arrays.stream(args)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long total = 0;
        long subTotal = 0;
        boolean isMoreThan2Soups = false;

        for (Map.Entry<String, Long> entry : counted.entrySet()) {
            switch (entry.getKey()) {
                case "apples":
                    total = total + 100 * entry.getValue();
                    subTotal = (long) (subTotal + 100 * entry.getValue() * 0.9);
                    break;
                case "soup":
                    if(entry.getValue() >= 2) {
                        isMoreThan2Soups = true;
                    }
                    total = total + 65 * entry.getValue();
                    subTotal = total;
                    break;
                case "bread":
                    total = total + 80 * entry.getValue();
                    if(isMoreThan2Soups) {
                        subTotal = (long) (subTotal + 80 * entry.getValue() * 0.5);
                    } else {
                        subTotal = total;
                    }
                    break;
                case "milk":
                    total = total + 130 * entry.getValue();
                    subTotal = total;
                    break;
            }
        }
        System.out.println("Total:" + total + ", Subtotal:" + subTotal);
    }
}
