package ue_2;

import java.io.File;

public class ue_2 {

    public static void main(String[] args) {
        /*
        Write a program, which lists all files of a subdirectory
         */

        File dir= new File("/Users/kaaatkina/CAMPUS02_2025/Projekt_1");
        listf(dir.getAbsolutePath());
    }

    public static void listf(String path) {

        File root = new File(path);
        File[] list = root.listFiles();


        for (File f : list) {
            if (f.isDirectory()) {
                System.out.println("Dir:" + f.getAbsoluteFile());
            } else {
                System.out.println("File:" + f.getAbsoluteFile());
            }
        }
    }
}


