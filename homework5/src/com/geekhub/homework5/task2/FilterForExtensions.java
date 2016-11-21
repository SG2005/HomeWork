package com.geekhub.homework5.task2;

import java.io.File;
import java.io.FilenameFilter;

public class FilterForExtensions implements FilenameFilter {
    private String[] extensions;

    public FilterForExtensions(String[] extensions) {
        this.extensions = extensions;
    }

    @Override
    public boolean accept(File dir, String name) {
        for (String extension : this.extensions) {
            if (name.toLowerCase().endsWith(extension.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
