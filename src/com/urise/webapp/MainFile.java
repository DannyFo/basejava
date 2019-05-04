package com.urise.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) throws IOException {
        String filePath = ".\\.gitignore";
        File file = new File(".\\.gitignore");
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        File dir = new File(".\\src\\com\\urise\\webapp");
        System.out.println(dir.isDirectory());
        String[] list = dir.list();

        if (list != null) {
            for (String name : list) {
                System.out.println(name);
            }
        }

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //ДЗ

        File[] files = new File(".\\src\\com\\urise\\webapp").listFiles();
        if (files != null)
            getFiles(files);

    }

    public static void getFiles(File[] files) {
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("Dir: " + file);
                getFiles(file.listFiles());
            } else {
                System.out.println("        File: " + file);
            }
        }
    }
}
