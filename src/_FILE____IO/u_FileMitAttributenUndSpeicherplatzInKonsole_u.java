package _FILE____IO;

import java.io.File;
public class u_FileMitAttributenUndSpeicherplatzInKonsole_u {

    public static void main(String[] args) {
        /*
        Goal: Write a program, which prints all files + relevant attributes of the files to the console. And we also want to know how much storage they need. (Print the total storage of the files to the console at the end.)
        Tip: use listFiles()

        Details:
        Create a method, which takes a file as parameter. (Directory Path)
        - Check if the File is a Directory
        - All files of the given directory need to be printed, with the following content:
                - File Name
                - File Path
                - File Size

        - In the end we also want to know, what is the size of all files together? (Print it to console)

        Question: What is the difference between:
            - File.list()
            - File.listFiles()

         */

        File dir = new File("C:\\Users\\Work\\Desktop\\PR3-21\\00 - Vorstellung");
        printDirectoryContent(dir);
    }

    public static void printDirectoryContent(File f) {
        if (f.isDirectory()) {
            // Variable initialized
            long filesize = 0;
            // Go trough the directory; listFiles() returns an array of Files (Objects)
            for (File file : f.listFiles()) {
                if (file.isFile()) {
                    System.out.println("Filename: " + file.getName() + " Size: " + file.length());
                    filesize = filesize + file.length();
                }
            }
            // print out the complete size of the directory
            System.out.println(filesize);
        } else {
            System.out.println("No Directory");
        }
    }
}

