package com.geekhub.homework5.task2;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileManager {
    private List<File> listOfFilesOFOneType = new ArrayList<>();

    public List<File> findFiles(String pathToDir, FileType fileType) {
        File file = new File(pathToDir);
        File[] masFiles = file.listFiles(new FilterForExtensions(fileType.getExtensions()));
        Collections.addAll(this.listOfFilesOFOneType, masFiles);
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                findFiles(f.getAbsolutePath(), fileType);
            }
        }
        return this.listOfFilesOFOneType;
    }

    public void setListOfFilesOFOneType(List<File> listOfFilesOFOneType) {
        this.listOfFilesOFOneType = listOfFilesOFOneType;
    }
}

