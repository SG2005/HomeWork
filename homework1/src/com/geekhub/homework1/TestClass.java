/*
 * @Main.java
 *
 * Copyright(c) Igor Koval
 */


package com.geekhub.homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestClass {

    public static void main(String[] args) throws IOException {
        String phoneNum;
        boolean flag = false;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print("Enter the phone number : ");
            phoneNum = reader.readLine();
            if (validityCheck(phoneNum)) {
                System.out.println("Phone number is correct");
                int count = 0;
                while (phoneNum.length() != 1) {
                    phoneNum = calculateSum(phoneNum);
                    count++;
                    System.out.println(count + " part of calculation, sum is -- "
                            + phoneNum);
                }
                System.out.print("Final result is ");
                switch (phoneNum) {
                    case "1":
                        System.out.println("One");
                        break;
                    case "2":
                        System.out.println("Two");
                        break;
                    case "3":
                        System.out.println("Three");
                        break;
                    case "4":
                        System.out.println("Four");
                        break;
                    default:
                        System.out.println(phoneNum);
                }
                flag = true;
            } else {
                System.out.println("Invalid phone number format!"
                        + " Please, try to enter it again in the"
                        + " format 380XXXXXXXXX.");
            }
        } while (!flag);
    }

    private static boolean validityCheck(String phoneNumber) {
        String prefix = "";

        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!((phoneNumber.charAt(i) >= '0') && (phoneNumber.charAt(i) <= '9'))) {
                return false;
            } else if (i < 3) {
                prefix += phoneNumber.charAt(i);
            }
        }
        return !((phoneNumber.length() != 12) || (!(prefix.equals("380"))));
    }

    private static String calculateSum(String phoneNumber) {
        int result = 0;

        for (int i = 0; i < phoneNumber.length(); i++) {
            result += Integer.parseInt(phoneNumber.charAt(i) + "");
        }
        return Integer.toString(result);
    }
}



