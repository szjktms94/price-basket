package com.adthena;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PriceBasket {
    public static void main(String[]args){
        Map<String, Long> counted = Arrays.stream(args)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Long applesCounter = counted.get("apples");
        Long soupCounter = counted.get("soup");
        Long breadCounter = counted.get("bread");
        Long milkCounter = counted.get("milk");

        if(applesCounter == null) {
            applesCounter = (long)0;
        }
        if(soupCounter == null) {
            soupCounter = (long)0;
        }
        if(breadCounter  == null) {
            breadCounter = (long)0;
        }
        if(milkCounter == null) {
            milkCounter = (long)0;
        }

        long total = applesCounter * 100 + milkCounter * 130 + soupCounter * 65 + breadCounter * 80;
        long subTotal;

        if (soupCounter >= 2 && breadCounter > 0 ) {
            subTotal = (long) (applesCounter * 100 * 0.9 + milkCounter * 130 + soupCounter * 65 + breadCounter * 80 - 1 * 80 * 0.5);
        } else {
            subTotal = (long) (applesCounter * 100 * 0.9 + milkCounter * 130 + soupCounter * 65 + breadCounter * 80);
        }

        String line1 = "Subtotal: £" + subTotal/100 + "\n";
        String line2 = "Apples 10% off: -£" + applesCounter*10 + "p" + "\n";
        String line3 = "Two soups discount 50% off from bread: -£40" + "\n";
        String line4 = "Total: £" + total/100;

        String bill = line1;

        if (applesCounter > 0) {
            bill = bill + line2;
        }
        if (soupCounter >= 2 && breadCounter > 0 ) {
            bill = bill + line3;
        }
        bill = bill + line4;

        System.out.println(bill);
    }
}
