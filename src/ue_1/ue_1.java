package ue_1;

import java.io.File;

public class ue_1 {

    public static void main(String[] args) {
        /*
        Uebung_1:
        Create a method, which has the parameter File
            The method should print the following information of a file on the console:
            - Does this file exist?
            - Name of the File
            - Parent Directory of the File
            - Path to this File
            - Is this a directory?
            - Is this a file?
            - Is this file readable?
            - Is this File writeable
            - File Size
            - ...
         */
        File file = new File("/Users/kaaatkina/CAMPUS02_2025/Projekt_1");
        readFileInformation(file);
    }

    public static void readFileInformation(File file) {
        System.out.println("Does this file exists? \t\t\t" + file.exists());
        System.out.println("The name of file is  \t\t\t" + file.getName());
        System.out.println("Parent Directory of this file   " + file.getParent());
        System.out.println("Path to this file \t\t\t\t" + file.getPath());
        System.out.println("The full path to this file \t\t" + file.getAbsolutePath());
        System.out.println("Is this a Directory? \t\t\t" + file.isDirectory());
        System.out.println("Is this a File? \t\t\t\t" + file.isFile());
        System.out.println("Is this a hidden file \t\t\t" + file.isHidden());
        System.out.println("Is this File readable ? \t\t" + file.canRead());
        System.out.println("Is this File writable ? \t\t" + file.canWrite());
        System.out.println("File Size: \t\t\t\t\t\t" + file.length());
    }
}