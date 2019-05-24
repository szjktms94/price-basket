package com.adthena;

public class PriceBasket {
    private static BillCreator billCreator = new BillCreator();

    public static void main(String[]args){
        System.out.println(billCreator.createBill(args));
    }
}
