package _FILE____IO;

import java.io.File;

public class _04___Directory_Content_with_attributes_size___D {
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
        //Zielordner definieren – hier wird geprüft, welche Dateien sich darin befinden
        File dir = new File("/Users/kaaatkina/CAMPUS02_2025/Programmieren_3");
        printDirectoryContent(dir);
        printDirectoryContentTable(dir);

    }

    /**
     * Gibt alle Dateien im Verzeichnis aus + Gesamtgröße in Bytes
     */
    public static void printDirectoryContent(File f) {
        if (f.isDirectory()) {
            long filesizeTotal = 0;

            File[] files = f.listFiles(); // Holt alle Dateien & Ordner im Verzeichnis
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("Datei: " + file.getName());
                        System.out.println("Pfad: " + file.getAbsolutePath());
                        System.out.println("Größe: " + file.length() + " Bytes\n");
                        filesizeTotal += file.length();
                    }
                }
                System.out.println("Gesamtgröße aller Dateien: " + filesizeTotal + " Bytes");
            } else {
                System.out.println("Fehler beim Lesen des Verzeichnisses.");
            }
        } else {
            System.out.println("Das ist kein Verzeichnis.");
        }
    }

    /**
     * Gibt alle Dateien im Verzeichnis in Tabellenform aus + Gesamtgröße
     * •	System.out.printf(...) statt System.out.println(...) → für schön formatierte Spalten
     * •	%-Formatierung mit Platzhalter:
     * •	%-30s → linksbündig, 30 Zeichen für Dateinamen
     * •	%-70s → Pfad
     * •	%-10d → Dateigröße in Bytes
     */
    public static void printDirectoryContentTable(File f) {
        if (f.isDirectory()) {
            long filesizeTotal = 0;

            File[] files = f.listFiles(); // Holt alle Dateien & Ordner im Verzeichnis
            if (files != null) {
                System.out.printf("%-30s %-70s %-10s\n", "Dateiname", "Pfad", "Größe (B)");
                System.out.println("=".repeat(115));

                for (File file : files) {
                    if (file.isFile()) {
                        System.out.printf("%-30s %-70s %-10d\n",
                                file.getName(), file.getAbsolutePath(), file.length());
                        filesizeTotal += file.length();
                    }
                }

                System.out.println("=".repeat(115));
                System.out.printf("%-101s %-10d\n", "Gesamtgröße aller Dateien:", filesizeTotal);
            } else {
                System.out.println("Fehler beim Lesen des Verzeichnisses (null zurückgegeben).");
            }
        } else {
            System.out.println("Das ist kein Verzeichnis.");
        }
    }

}

    //Variante Herr Fuchs
//public class ue_4 {
//
//    public static void main(String[] args) {
//        /*
//        Goal: Write a program, which prints all files + relevant attributes of the files to the console. And we also want to know how much storage they need. (Print the total storage of the files to the console at the end.)
//        Tip: use listFiles()
//
//        Details:
//        Create a method, which takes a file as parameter. (Directory Path)
//        - Check if the File is a Directory
//        - All files of the given directory need to be printed, with the following content:
//                - File Name
//                - File Path
//                - File Size
//
//        - In the end we also want to know, what is the size of all files together? (Print it to console)
//
//        Question: What is the difference between:
//            - File.list()
//            - File.listFiles()
//
//         */
//
//        File dir = new File("C:\\Users\\Work\\Desktop\\PR3-21\\00 - Vorstellung");
//        printDirectoryContent(dir);
//    }
//
//    public static void printDirectoryContent(File f) {
//        if (f.isDirectory()) {
//            // Variable initialized
//            long filesize = 0;
//            // Go trough the directory; listFiles() returns an array of Files (Objects)
//            for (File file : f.listFiles()) {
//                if (file.isFile()) {
//                    System.out.println("Filename: " + file.getName() + " Size: " + file.length());
//                    filesize = filesize + file.length();
//                }
//            }
//            // print out the complete size of the directory
//            System.out.println(filesize);
//        } else {
//            System.out.println("No Directory");
//        }
//    }


//}

