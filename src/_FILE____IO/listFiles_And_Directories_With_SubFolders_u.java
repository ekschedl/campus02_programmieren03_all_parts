package _FILE____IO;

import java.io.File;

public class listFiles_And_Directories_With_SubFolders_u {
    public static void main(String[] args) {
        File dir= new File("/Users/kaaatkina/CAMPUS02_2025/Projekt_1");
        System.out.println("Original Path: " + dir.getAbsolutePath());
        listFilesAndDirectoriesWithSubFolders(dir.getAbsolutePath());
    }

    /*Write a program, which lists all files / directories of the given directory + their sub directories
    Tip: - Recursive call
    ---- Example Output:----
    Original Path: C:\Users\n50348\Desktop
    File: C:\Users\n50348\Desktop\desktop.ini
    Directory: C:\Users\n50348\Desktop\losewljhol*/
    public static void listFilesAndDirectoriesWithSubFolders(String path) {
        File root = new File(path);
        File[] list = root.listFiles();

        if (list == null) return;

        for (File f : list) {
            if (f.isDirectory()) {
                // rekursiver Aufruf
                System.out.println("Directory: " + f.getAbsolutePath());
                listFilesAndDirectoriesWithSubFolders(f.getAbsolutePath());
            } else {
                System.out.println("File: " + f.getAbsolutePath());
            }
        }

    }
}

