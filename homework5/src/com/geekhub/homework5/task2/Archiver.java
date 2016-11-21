package com.geekhub.homework5.task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Archiver {
    private FileManager fileManager;

    public Archiver(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public void archive(String pathToDir, FileType fileType) throws ArchiveException {
        List<File> listOfFiles = fileManager.findFiles(pathToDir, fileType);
        if (listOfFiles.isEmpty()) {
            System.out.println("This directory hasn't a " +
                    fileType.name().toLowerCase() + " files.");
            return;
        }
        byte[] buf = new byte[1024];
        try (ZipOutputStream out = new ZipOutputStream(
                new FileOutputStream("d:/" + fileType.name().toLowerCase() + ".zip"))) {
            for (File file : listOfFiles) {
                FileInputStream in = new FileInputStream(file);
                out.putNextEntry(new ZipEntry(file.getName()));
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
            }
        } catch (IOException e) {
            throw new ArchiveException(e.getMessage() + ". Archiving is failed!");
        }
        listOfFiles.clear();
        fileManager.setListOfFilesOFOneType(listOfFiles);
    }
}
