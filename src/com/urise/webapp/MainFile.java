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
        int counter = 0;
        getFiles(dir, counter);
    }

    public static void getFiles(File directory, int counter) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("Dir: " + checkForDeep(counter) + file.getName());
                    counter++;
                    getFiles(file, counter);
                    counter = 0;
                } else if (file.isFile()) {
                    System.out.println("File: " + checkForDeep(counter) + file.getName());
                }
            }
        }
    }

    private static String checkForDeep(int counter) {
        int i = 0;
        String space = "";
        while (i < counter) {
            space = space + "|   ";
            i++;
        }
        return space;
    }


}
