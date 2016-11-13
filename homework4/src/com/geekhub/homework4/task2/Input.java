package com.geekhub.homework4.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    static int enterNumOfWords() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numOfWords;
        while (true) {
            try {
                numOfWords = Integer.parseInt(reader.readLine());
                if (numOfWords < 1 || numOfWords > 100) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. " +
                        "Enter the correct number of words.");
            }
        }
        return numOfWords;
    }

    static String enterWord() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word;
        while (true) {
            try {
                word = reader.readLine().toLowerCase();
                if ((word.contains(" ")) || (word.length() > 100)
                        || (word.length() < 1)) {
                    throw new Exception();
                }
                for (int i = 0; i < word.length(); i++) {
                    if (!Character.isLetter(word.charAt(i))) {
                        throw new Exception();
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid word. " + "Enter the word without" +
                        " digits and spaces and other symbols.");
            }
        }
        return word;
    }
}
