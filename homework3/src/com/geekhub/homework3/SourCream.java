/*
 * @SourCream.java
 *
 * Copyright(c) Igor Koval
 */


package com.geekhub.homework3;

public class SourCream extends Product {
    private int fatContent;

    public SourCream(String name, double price, int quantity, int fatContent) {
        super(name, price, quantity);
        this.fatContent = fatContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SourCream sourCream = (SourCream) o;

        return fatContent == sourCream.fatContent;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + fatContent;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + ", fat content: " + this.fatContent + "%";
    }
}
