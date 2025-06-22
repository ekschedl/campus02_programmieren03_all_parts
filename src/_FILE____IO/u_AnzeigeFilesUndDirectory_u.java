package _FILE____IO;

import java.io.File;

public class u_AnzeigeFilesUndDirectory_u {
    public static void main(String[] args) {
        // Provide full path for directory(change
        // accordingly)
        //Dir:C:\$Recycle.Bin
        //File:C:\3DEXP_Mkt_SW_6.29.743.exe
        //Dir:C:\Android
        //Dir:C:\BrAutomation
        //Dir:C:\Dokumente und Einstellungen
        //File:C:\DumpStack.log.tmp
        // Provide full path for directory(change
        // accordingly)
        // Provide full path for directory (change accordingly)
        //C:\Users\s54828\IdeaProjects\PruefungProbe\src\Main.java
        String maindirpath = "C:\\Users\\s54828\\IdeaProjects\\PruefungProbe\\src";
        // File object
        File maindir = new File(maindirpath);
        String maindirpath1 = "C:\\Users\\s54828\\IdeaProjects\\PruefungProbe\\src\\Main.java";
        File maindir1 = new File(maindirpath1);
        if (maindir.exists() || maindir.isDirectory()) {
            System.out.println("**********************************************");
            System.out.println("Files and directories from main directory : " + maindir);
            System.out.println("**********************************************");



            int sum = listFilesAndDirectories(maindir, 0);
            System.out.println("Summe der Files: " + sum);

            // Calling method to list files and directories


        }
    }

    private static int listFilesAndDirectories(File directory, int sum) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : directory.listFiles()) {
                if (file.isFile()) {
                    System.out.println("\tFile: " + file.getName() + "\n\t\tPath: " + file.getPath() + "\n\t\tSize: " + file.length());
                    sum +=  (int)file.length();
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    listFilesAndDirectories(file, sum);
                }
            }
        }
        return sum;


    }
}




