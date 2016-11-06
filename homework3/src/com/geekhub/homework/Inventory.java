/*
 * @Inventory.java
 *
 * Copyright(c) Igor Koval
 */


package com.geekhub.homework;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Inventory {

    static double sumInventoryValue(List<Product> products, Product product) {
        double result = 0;
        for (Product tempProd : products) {
            if (product.equals(tempProd)) {
                result += tempProd.getQuantity() * tempProd.getPrice();
            }
        }
        return result;
    }

    static double sumInventoryValue(List<Product> products) {
        double result = 0;
        for (Product product : products) {
            result += product.getQuantity() * product.getPrice();
        }
        return result;
    }

    static void productSearch(List<Product> products, String nameOfProduct) {
        boolean flag = false;
        for (Product product : products) {
            if (nameOfProduct.equalsIgnoreCase(product.getName())) {
                System.out.println("The search was successfully completed. "
                                   + nameOfProduct + " is in stock.");
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("The search has not given any results. "
                               + nameOfProduct + " is out of stock.");
        }
    }

    static void sortByName(List<Product> products) {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product product1, Product product2) {
                return product1.getName().compareToIgnoreCase(product2.getName());
            }
        });
    }

    static void sortByKind(List<Product> products) {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product product1, Product product2) {
                return product1.getClass().getSimpleName().compareToIgnoreCase(product2.getClass().getSimpleName());
            }
        });
    }

    static void sortByPrice(List<Product> products) {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product product1, Product product2) {
                return Double.compare(product1.getPrice(), product2.getPrice());
            }
        });
    }

    static void sortByQuantity(List<Product> products) {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product product1, Product product2) {
                return product1.getQuantity() - product2.getQuantity();
            }
        });
    }
}
