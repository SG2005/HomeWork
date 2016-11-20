package com.geekhub.homework5.task1.source;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Implementation for loading content from local file system.
 * This implementation supports absolute paths to local file system without specifying file:// protocol.
 * Examples c:/1.txt or d:/pathToFile/file.txt
 */
public class FileSourceProvider implements SourceProvider {

    @Override
    public boolean isAllowed(String pathToSource) {
        File file = new File(pathToSource);
        return (file.exists() && file.isFile() && file.getName().contains(".txt"));
    }

    @Override
    public String load(String pathToSource) throws SourceLoadingException {
        StringBuilder text = new StringBuilder();
        try (InputStream in = new FileInputStream(pathToSource)) {
            int data;
            while ((data = in.read()) != -1) {
                text.append((char) data);
            }
        } catch (IOException e) {
            throw new SourceLoadingException(e.getMessage());
        }
        return text.toString();
    }
}
