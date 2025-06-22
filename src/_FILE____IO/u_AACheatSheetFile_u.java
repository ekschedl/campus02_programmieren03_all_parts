package _FILE____IO;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class
u_AACheatSheetFile_u {
    public static void main(String[] args) {

        //------CREATE A FILE-----
        File file = new File("code.iml");

        //---ERSTELLE EINE DATEI INKLUSIVE PFAD-----
        //hier wird der pfad mit neuen unterordnern erstellt
        File file11 = new File("C:\\Users\\Julia\\julia\\workingwoman\\SWENG C&M\\SWENG\\FH CAMPUS 02\\Seminare\\Programmieren 3\\UEBUNGENFUERPRUEFUNG\\test\\uebung_10\\uebung10.txt");
        File directory = file11.getParentFile();
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                // perform mkdirs to try create a directory - returns true if success, returns false if no success
                System.out.println("Directory " + directory.getAbsolutePath() + " wurde erstellt.");
            } else {
                System.out.println("Directory " + directory.getAbsolutePath() + " konnte nicht erstellt werden.");
            }
        }

        //------WICHTIGE FILE INFORMATIONEN AD 16----------
        readFileInformation(file);

        //------ALLE FILES IN EINEM UNTERVERZEICHNIS AUFLISTEN AD 71----------
        File dir = new File("C:\\Users\\Work\\Desktop\\PR3-21\\01 - File IO");
        listf(dir.getAbsolutePath());

        //---HIER ALS REKURSIVER AUFRUF   AD 76-----
        File dir1 = new File("C:\\Users\\Work\\Desktop\\PR3-21\\01 - File IO");
        System.out.println("Original Path: " + dir1.getAbsolutePath());
        listFilesAndDirectoriesWithSubFolders(dir1.getAbsolutePath());

        //----GIB ALLE RELEVANTEN DETAILS DES FILES INKL SPEICHERPLATZ IN KONSOLE AUS   AD 90-----
        File dir2 = new File("C:\\Users\\Work\\Desktop\\PR3-21\\00 - Vorstellung");
        printDirectoryContent(dir2);

        //DIRECTORIES ERSTELLEN MIT CHECK OB SCHON VORHANDEN UND OB FILE  AD 112--------
        File dir3 = new File("C:\\test\\alt1");
        createDirectories(dir3);

        //---ERSTELLEN MIT RANDOM RENAME DELETE AUSGABE IN KONSOLE AB 130-----
        File dir4 = new File("C:\\test\\alt");
        //---ERSTELLEN VON MEHREREN FILES MIT RANDOM ad 130------
        createFiles(dir4);
        //---RENAME VON MEHREREN FILES MIT RANDOM ad 149------
        rename_files(dir4);
        //---LOESCHEN VON MEHREREN FILES MIT RANDOM ad 162------
        delete_files(dir4);
    }

    //------WICHTIGE FILE INFORMATIONEN----------
    public static void readFileInformation(File file) {
        //Existiert das file
        System.out.println("Does this file exists? " + file.exists());
        //Name des files
        System.out.println("The name of file is  " + file.getName());
//parent Directory of the file
        System.out.println("Parent Directory of this file  " + file.getParent());
//Pfad zu dem File
        System.out.println("Path to this file " + file.getPath());
//absoluter Pfad
        System.out.println("The full path to this file " + file.getAbsolutePath());
//ist das file ein ordner
        System.out.println("Is this a Directory? " + file.isDirectory());
//ist das file ein file
        System.out.println("Is this a File? " + file.isFile());
//ist das file versteckt
        System.out.println("Is this a hidden file " + file.isHidden());
//kann man das file lesen
        System.out.println("Is this File readable ? " + file.canRead());
//kann man in das file schreiben
        System.out.println("Is this File writable ? " + file.canWrite());
//laenge des files
        System.out.println("File Size: " + file.length());
    }

    //------ALLE FILES IN EINEM UNTERVERZEICHNIS AUFLISTEN----------
    //------SONST ALLE VERZEICHNISSE MITAUFLISTEN-------------------
    public static void listf(String path) {

        File root = new File(path);
        File[] list = root.listFiles();

        for (File f : list) {
            if (f.isDirectory()) {//WENN DAS FILE EIN VERZEICHNIS IST
                System.out.println("Dir:" + f.getAbsoluteFile());
            } else {//WENN DAS FILE EIN FILE IST
                System.out.println("File:" + f.getAbsoluteFile());
            }
        }
    }

    //------ALLE FILES IN EINEM UNTERVERZEICHNIS AUFLISTEN----------
    //------SONST ALLE VERZEICHNISSE MITAUFLISTEN-------------------
    //---HIER ALS REKURSIVER AUFRUF-----

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
    //----GIB ALLE RELEVANTEN DETAILS DES FILES INKL SPEICHERPLATZ IN KONSOLE AUS -----
    public static void printDirectoryContent(File f) {
        if (f.isDirectory()) {
            // Variable initialized
            long filesize = 0;
            // Go trough the directory; listFiles() returns an array of Files (Objects)
            //f.listfile() gibt ein array aller filesObjects in dem directory zurück
            //f.list()  gibt ein Array von Strings zurück
            for (File file : f.listFiles()) {
                if (file.isFile()) {
                    System.out.println("Filename: " + file.getName() + " Size: " + file.length());
                    filesize +=  file.length();
                }
            }
            // print out the complete size of the directory
            System.out.println(filesize);
        } else {
            System.out.println("No Directory");
        }
    }
    public static void createDirectories(File f) {
        // check if file is a file or directory
        if (f.isDirectory()) {
            // perform mkdirs to try create a directory - returns true if success, returns false if no success
            System.out.println("Directory " + f.getAbsolutePath() + " is not created: " + f.mkdir());
        } else {
            System.out.println("Directory " + f.getAbsolutePath() + " created?: " + f.mkdir());
        }
    }
    //---ERSTELLEN VON MEHREREN FILES MIT RANDOM ------
    public static void createFiles(File fileList) {
        for (int i = 0; i < 10; i++) {
            try {
                File myObj = new File(fileList.getAbsolutePath() + "//"
                        + Math.abs(ThreadLocalRandom.current().nextInt()) + ".mp3");
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
    //---RENAME VON MEHREREN FILES MIT RANDOM ad ------
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
    //---LOESCHEN VON MEHREREN FILES MIT RANDOM ad ------
    public static void delete_files(File directory) {
        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                file.delete();
                System.out.println("DELETED: " + file.getAbsolutePath());
            }
        }
    }
}
