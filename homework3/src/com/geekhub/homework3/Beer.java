/*
 * @Beer.java
 *
 * Copyright(c) Igor Koval
 */


package com.geekhub.homework3;

public class Beer extends Product {
    private int alcoholByVolume;

    public Beer(String name, double price, int quantity, int alcoholByVolume) {
        super(name, price, quantity);
        this.alcoholByVolume = alcoholByVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Beer beer = (Beer) o;

        return alcoholByVolume == beer.alcoholByVolume;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + alcoholByVolume;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + ", alcohol by volume: "
                + this.alcoholByVolume + "%";
    }
}
