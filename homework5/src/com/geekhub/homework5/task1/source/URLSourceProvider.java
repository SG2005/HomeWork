package com.geekhub.homework5.task1.source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Implementation for loading content from specified URL.<br/>
 * Valid paths to load are http://someurl.com, https://secureurl.com, ftp://frpurl.com etc.
 */
public class URLSourceProvider implements SourceProvider {

    @Override
    public boolean isAllowed(String pathToSource) {
        return ((pathToSource.contains("http://") || pathToSource.contains("https://")
                || pathToSource.contains("ftp://")) && pathToSource.contains(".com"));
    }

    @Override
    public String load(String pathToSource) throws SourceLoadingException {
        StringBuilder text = new StringBuilder();
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(new URL(pathToSource).openStream()))) {
            String input;
            while ((input = in.readLine()) != null) {
                text.append(input);
            }
        } catch (IOException e) {
            throw new SourceLoadingException(e.getMessage());
        }
        return text.toString();
    }
}
