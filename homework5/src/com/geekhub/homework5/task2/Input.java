package com.geekhub.homework5.task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    public String enterPath() throws IOException, InputException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        if (validityPath(path)) {
            return path;
        }
        return null;
    }

    private boolean validityPath(String path) throws InputException {
        File file = new File(path);
        if (file.isDirectory()) {
            return true;
        }
        throw new InputException("Path to main directory is incorrect!");
    }
}
