/*
 * @Rectangle.java
 *
 * Created by Igor Koval
 */


package com.geekhub.homework2;

class Rectangle extends Shape {
    private byte lengthA;
    private byte lengthB;
    private Triangle triangle = new Triangle();

    @Override
    int calculateArea() {
        triangle.setLengthA(lengthA);
        triangle.setLengthB(lengthB);
        byte diagonal = (byte) Math.sqrt(lengthA * lengthA + lengthB * lengthB);
        triangle.setLengthC(diagonal);
        return lengthA * lengthB;
    }

    @Override
    int calculatePerimeter() {
        return 2 * (lengthA + lengthB);
    }

    boolean setProperties(String... params) {
        try {
            lengthA = Byte.parseByte(params[0]);
            lengthB = Byte.parseByte(params[1]);
            if (lengthA <= 0 || lengthB <= 0) {
                throw new NumberFormatException();
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Rectangle is incorrect! Length of side must be from 1 to 127.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Area of rectangle is " + calculateArea() + "\nPerimeter of rectangle is " + calculatePerimeter() + "\n" + triangle.toString();
    }
}
