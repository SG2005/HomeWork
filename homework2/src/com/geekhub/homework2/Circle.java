/*
 * @Circle.java
 *
 * Created by Igor Koval
 */


package com.geekhub.homework2;

class Circle extends Shape {
    private byte radius;

    @Override
    int calculateArea() {
       return (int) (Math.PI * (this.radius * this.radius));
    }

    @Override
    int calculatePerimeter() {
       return (int) (2 * Math.PI * this.radius);
    }

    @Override
    boolean setProperties(String... params) {
            try {
                radius = Byte.parseByte(params[0]);
                if (radius <= 0) {
                    throw new NumberFormatException();
                }
                return true;
            }
            catch (NumberFormatException e) {
                System.out.println("Circle is incorrect! Radius must be from 1 to 127");
                return false;
            }
    }

    @Override
    public String toString() {
        return "Area of circle is " + calculateArea() + "\nPerimeter of circle is " + calculatePerimeter();
    }
}
