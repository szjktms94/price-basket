package com.adthena;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PriceBasket {

    private final int APPLES_PRICE = 100;
    private final int SOUP_PRICE = 65;
    private final int BREAD_PRICE = 80;
    private final int MILK_PRICE = 130;

    public String createBill(String[] itemList) {
        Map<String, Long> counted = Arrays.stream(itemList)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Long applesCounter = counted.get("apples") == null ? 0L : counted.get("apples");
        Long soupCounter = counted.get("soup") == null ? 0L : counted.get("soup");
        Long breadCounter = counted.get("bread") == null ? 0L : counted.get("bread");
        Long milkCounter = counted.get("milk") == null ? 0L : counted.get("milk");

        long subtotal = applesCounter * APPLES_PRICE + milkCounter * MILK_PRICE + soupCounter * SOUP_PRICE + breadCounter * BREAD_PRICE;
        long total = (long) (applesCounter * APPLES_PRICE * 0.9 + milkCounter * MILK_PRICE + soupCounter * SOUP_PRICE + breadCounter * BREAD_PRICE);

        if (soupCounter >= 2 && breadCounter > 0) {
            total = (long) (total - 1 * 80 * 0.5);
        }

        String line1 = "Subtotal: £" + (double) subtotal / 100 + "\n";
        String line2 = "Apples 10% off: -" + applesCounter * 10 + "p" + "\n";
        String line3 = "Two soups discount 50% off from bread: -40 p" + "\n";
        String line4 = "Total: £" + (double) total / 100;

        StringBuilder bill = new StringBuilder();
        bill.append(line1);

        if (applesCounter > 0) {
            bill.append(line2);
        }
        if (soupCounter >= 2 && breadCounter > 0) {
            bill.append(line3);
        }
       bill.append(line4);

        return bill.toString();
    }
}
