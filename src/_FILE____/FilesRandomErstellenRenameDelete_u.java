package _FILE____;

import java.io.File;
import java.io.IOException;

import java.util.concurrent.ThreadLocalRandom;

public class FilesRandomErstellenRenameDelete_u {

    public static void main(String[] args) {
        /*
    Goal: Create 10 Files + Rename all files (only files) of the given directory (not for subdirectories)

    1. Create a method, which creates 10 files, in a given directory (= Method Parameter) and with a random file name/number (Tip: concatenate for final filepath)
    2. Create a method, which renames all files (only files and not directories!) within a given folder (= Method Parameter)
        2.1 for example: test.txt to 1_test.txt
            2.1.1 for the new file name - concatenate a string with .getParent(), separator + pre_id +  getName()
            2.1.2 use renameTo() method
            2.1.3 Check if the rename was a success (via if) and print the according message to the console
    3. Write a method, which deletes all files within this directory. (Comment out this or other methods to test it..)

    Tip: Random Number:
        ThreadLocalRandom.current().nextInt()

         */

        File dir = new File("C:\\test\\alt");
        createFiles(dir);
        rename_files(dir);
        delete_files(dir);
    }

    public static void createFiles(File fileList) {
        for (int i = 0; i < 10; i++) {
            try {
                File myObj = new File(fileList.getAbsolutePath() + "//"
                        + ThreadLocalRandom.current().nextInt() + ".mp3");
                if (myObj.createNewFile()) {
                    System.out.println("CREATE: " + myObj.getAbsolutePath());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

    public static void rename_files(File directory) {
        if (directory.isDirectory()) {
            for (File oldFile : directory.listFiles()) {
                File newFile = new File(oldFile.getParent() + "\\1_" + oldFile.getName());
                if (oldFile.renameTo(newFile)) {
                    System.out.println("RENAME: " + oldFile.getAbsolutePath() + " to " + newFile.getAbsolutePath());
                } else {
                    System.out.println("Sorry! the file can't be renamed");
                }
            }
        }
    }

    public static void delete_files(File directory) {
        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                file.delete();
                System.out.println("DELETED: " + file.getAbsolutePath());
            }
        }
    }
}