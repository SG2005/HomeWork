package com.geekhub.homework5.task2;

import java.io.IOException;

public class ArchiveController {
    public static void main(String[] args) throws IOException {
        while (true) {
            Input input = new Input();
            try {
                String pathToDir = input.enterPath();
                Archiver archiver = new Archiver(new FileManager());
                for (int i = 0; i < FileType.values().length; i++) {
                    archiver.archive(pathToDir, FileType.values()[i]);
                }
                System.out.println("Archiving is finished successfully!");
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Please, enter the another path to directory," +
                        " which have audio, video or image file.");
            }
        }
    }
}

