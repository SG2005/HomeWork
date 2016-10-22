package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestClass {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the phone number : ");
        String phoneNum = reader.readLine();
        while (!validityCheck(phoneNum)) {
            System.out.println("Invalid phone number format! Please, try to enter it again in the format 380XXXXXXXXX.");
            System.out.print("Enter the phone number : ");
            phoneNum = reader.readLine();
        }
        System.out.println("Phone number is correct");

        //calculations
        int result = 0;
        int count = 0;
        for (int i = 0; i < phoneNum.length(); i++) {
            result += (phoneNum.charAt(i) - '0');
        }
        count++;
        System.out.println("1 part of calculation, sum is -- " + result);
        while (Integer.toString(result).length() != 1) {
            result = (Integer.toString(result).charAt(0) - '0') + (Integer.toString(result).charAt(1) - '0');
            count++;
            System.out.println(count + " part of calculation, sum is -- " + result);
        }
        System.out.print("Final result is ");
        switch (result) {
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            case 4:
                System.out.println("Four");
                break;
            default:
                System.out.println(result);
        }
    }

    private static boolean validityCheck(String number) {
        if (number.length() != 12) {
            return false;
        }
        String prefix = "";
        char digit;
        for (int i = 0; i < number.length(); i++) {
            digit = number.charAt(i);
            if (!(digit >= '0' && digit <= '9')) {
                return false;
            }
            if (i < 3) {
                prefix += number.charAt(i);
            }
        }
        if (!(prefix.equals("380"))) {
            return false;
        }
        return true;
    }
}

