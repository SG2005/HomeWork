/*
 * @Triangle.java
 *
 * Created by Igor Koval
 */


package com.geekhub.homework2;

class Triangle extends Shape {
    private byte lengthA;
    private byte lengthB;
    private byte lengthC;

    @Override
    int calculateArea() {
        int perimeter = calculatePerimeter();
        return (int) Math.sqrt(perimeter * (perimeter - lengthA) * (perimeter - lengthB) * (perimeter - lengthC));
    }

    @Override
    int calculatePerimeter() {
        return lengthA + lengthB + lengthC;
    }

    @Override
    boolean setProperties(String... params) {
        try {
            lengthA = Byte.parseByte(params[0]);
            lengthB = Byte.parseByte(params[1]);
            lengthC = Byte.parseByte(params[2]);
            if ((lengthA + lengthB < lengthC) || (lengthA + lengthC < lengthB) || (lengthB + lengthC < lengthA) ||
                    (lengthA <= 0) || (lengthB <= 0) || (lengthC <= 0)) {
                throw new NumberFormatException();
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Triangle is incorrect! Length of side must be from 1 to 127. The sum of any two sides must be bigger than third side.");
            return false;
        }
    }

    public void setLengthC(byte lengthC) {
        this.lengthC = lengthC;
    }

    public void setLengthB(byte lengthB) {
        this.lengthB = lengthB;
    }

    public void setLengthA(byte lengthA) {
        this.lengthA = lengthA;
    }

    @Override
    public String toString() {
        return "Area of triangle is " + calculateArea() + "\nPerimeter of triangle is " + calculatePerimeter();
    }
}

