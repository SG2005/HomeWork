package com.geekhub.homework5.task1.source;


import java.io.IOException;

public class SourceLoadingException extends IOException {

    public SourceLoadingException(String text) {
        super(text);
    }
}
