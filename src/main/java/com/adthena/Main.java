package com.adthena;

public class Main {
    private static PriceBasket priceBasket = new PriceBasket();

    public static void main(String[]args){

        System.out.println(priceBasket.createBill(args));
    }
}
