package com.geekhub.homework5.task1;

import com.geekhub.homework5.task1.source.SourceLoader;
import com.geekhub.homework5.task1.source.URLSourceProvider;

import java.io.IOException;
import java.util.Scanner;

public class TranslatorController {

    public static void main(String[] args) throws IOException, TranslateException {
        //initialization
        SourceLoader sourceLoader = new SourceLoader();
        Translator translator = new Translator(new URLSourceProvider());
        String command;
        Scanner scanner = new Scanner(System.in);
        while (!"exit".equals(command = scanner.next())) {
            try {
                String source = sourceLoader.loadSource(command);
                String translation = translator.translate(source);
                System.out.println("Original: " + source);
                System.out.println("Translation: " + translation);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Please, enter the another path!" +
                        " Or type \"exit\" to exit from program");
            }
        }
    }
}
