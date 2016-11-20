package com.geekhub.homework5.task1.source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Implementation for loading content from specified URL.<br/>
 * Valid paths to load are http://someurl.com, https://secureurl.com, ftp://frpurl.com etc.
 */
public class URLSourceProvider implements SourceProvider {

    @Override
    public boolean isAllowed(String pathToSource) {
        URL url = null;
        try {
            url = new URL(pathToSource);
        } catch (MalformedURLException e) {
            return false;
        }
        try {
            url.toURI();
        } catch (URISyntaxException e) {
            return false;
        }
        return true;
    }

    @Override
    public String load(String pathToSource) throws SourceLoadingException {
        String text = "";
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(new URL(pathToSource).openStream()))) {
            String input;
            while ((input = in.readLine()) != null) {
                text += input;
            }
        } catch (IOException e) {
            throw new SourceLoadingException("Loading of text from URL source is failed!");
        }
        return text;
    }
}
