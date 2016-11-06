/*
 * @TestClass.java
 *
 * Copyright(c) Igor Koval
 */


package com.geekhub.homework;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {
        List<Product> listOfProducts = new ArrayList<Product>();

        SweetWater fanta = new SweetWater("Fanta", 15, 5, "blue");
        Beer carlsberg = new Beer("Carlsberg", 10, 8, 13);
        SourCream prostokvashino = new SourCream("Prostokvashino", 16, 10, 15);
        Beer carlsberg2 = new Beer("Carlsberg", 20, 10, 13);
        SweetWater fanta2 = new SweetWater("Fanta", 15, 6, "blue");

        listOfProducts.add(fanta);
        listOfProducts.add(carlsberg);
        listOfProducts.add(prostokvashino);
        listOfProducts.add(carlsberg2);
        listOfProducts.add(fanta2);

        System.out.println("The sum of inventory value of all product is "
                           + Inventory.sumInventoryValue(listOfProducts));
        Inventory.productSearch(listOfProducts, "CARLSBERG");
        System.out.println("The sum of inventory value of one type of product is "
                           + Inventory.sumInventoryValue(listOfProducts, fanta));

        Inventory.sortByName(listOfProducts);
        System.out.println("Sort by name");
        for (Product product : listOfProducts) {
            System.out.println(product);
        }
        Inventory.sortByKind(listOfProducts);
        System.out.println("Sort by kind");
        for (Product product : listOfProducts) {
            System.out.println(product);
        }
        Inventory.sortByPrice(listOfProducts);
        System.out.println("Sort by price");
        for (Product product : listOfProducts) {
            System.out.println(product);
        }
        Inventory.sortByQuantity(listOfProducts);
        System.out.println("Sort by quantity");
        for (Product product : listOfProducts) {
            System.out.println(product);
        }
    }
}
