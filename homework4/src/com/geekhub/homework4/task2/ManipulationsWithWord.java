package com.geekhub.homework4.task2;

public class ManipulationsWithWord {

    static String replaceLongWords(String word) {
        String changingWord;
        if (word.length() > 10) {
            changingWord = "" + word.charAt(0) + (word.length() - 2)
                    + word.charAt(word.length() - 1);
        } else {
            changingWord = word;
        }
        return changingWord;
    }
}
