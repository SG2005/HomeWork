package com.geekhub.homework4.task2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.print("Enter the number of words: ");
        int numOfWords = Input.enterNumOfWords();
        String word;
        System.out.println("Enter " + numOfWords + " words");
        for (int i = 0; i < numOfWords; i++) {
            System.out.println((i + 1) + ".");
            word = Input.enterWord();
            System.out.println(ManipulationsWithWord.replaceLongWords(word));
        }
    }
}
