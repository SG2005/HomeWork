/*
 * @Square.java
 *
 * Created by Igor Koval
 */


package com.geekhub.homework2;

class Square extends Shape {
    private byte lengthA;
    private Triangle triangle = new Triangle();

    @Override
    int calculateArea() {
        triangle.setLengthA(lengthA);
        triangle.setLengthB(lengthA);
        byte diagonal = (byte) (Math.sqrt(2) * lengthA);
        triangle.setLengthC(diagonal);
        return lengthA * lengthA;
    }

    @Override
    int calculatePerimeter() {
        return 4 * lengthA;
    }

    boolean setProperties(String... params) {
        try {
            this.lengthA = Byte.parseByte(params[0]);
            if (lengthA <= 0) {
                throw new NumberFormatException();
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Square is incorrect! Length must be from 1 to 127");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Area of square is " + calculateArea() + "\nPerimeter of square is " + calculatePerimeter() + "\n" + triangle.toString();
    }
}
