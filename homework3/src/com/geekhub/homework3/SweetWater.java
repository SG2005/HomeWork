/*
 * @SweetWater.java
 *
 * Copyright(c) Igor Koval
 */


package com.geekhub.homework3;

public class SweetWater extends Product {
    private String color;

    public SweetWater(String name, double price, int quantity, String color) {
        super(name, price, quantity);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SweetWater that = (SweetWater) o;

        return color.equals(that.color);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + color.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + ", color: " + this.color;
    }
}
