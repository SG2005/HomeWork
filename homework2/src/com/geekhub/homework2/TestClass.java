/*
 * @TestClass.java
 *
 * Created by Igor Koval
 */


package com.geekhub.homework2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestClass {
    private static ShapeType type;
    private static String[] properties;

    public static void main(String[] args) throws IOException {
        String strTypeOfShape;
        Shape shape = null;
        String lengthA, lengthB, lengthC, radius;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print("Please, enter the type of shape: ");
            strTypeOfShape = reader.readLine().toUpperCase();
        } while (!checkValidationOfShapeType(strTypeOfShape));
        do {
            switch (type) {
                case CIRCLE:
                    shape = new Circle();
                    System.out.print("Enter the radius of circle: ");
                    radius = reader.readLine().replaceAll(" ", "");
                    setParams(radius);
                    break;
                case TRIANGLE:
                    shape = new Triangle();
                    System.out.print("Enter the length of A side: ");
                    lengthA = reader.readLine().replaceAll(" ", "");
                    System.out.print("Enter the length of B side: ");
                    lengthB = reader.readLine().replaceAll(" ", "");
                    System.out.print("Enter the length of C side: ");
                    lengthC = reader.readLine().replaceAll(" ", "");
                    setParams(lengthA, lengthB, lengthC);
                    break;
                case RECTANGLE:
                    shape = new Rectangle();
                    System.out.print("Enter the length of A side: ");
                    lengthA = reader.readLine().replaceAll(" ", "");
                    System.out.print("Enter the length of B side: ");
                    lengthB = reader.readLine().replaceAll(" ", "");
                    setParams(lengthA, lengthB);
                    break;
                case SQUARE:
                    shape = new Square();
                    System.out.print("Enter the length of A side: ");
                    lengthA = reader.readLine().replaceAll(" ", "");
                    setParams(lengthA);
                    break;
            }
        } while (!shape.setProperties(getParams()));
        System.out.println(shape.toString());
    }

    private static boolean checkValidationOfShapeType(String strTypeOfShape) {
        strTypeOfShape = strTypeOfShape.replaceAll(" ", "");
        try {
            type = ShapeType.valueOf(strTypeOfShape);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid type of shape!" +
                    " (Type must be a square, triangle, rectangle or circle).");
            return false;
        }
        return true;
    }

    private static void setParams(String... params) {
        properties = params;
    }

    private static String[] getParams() {
        return properties;
    }
}

