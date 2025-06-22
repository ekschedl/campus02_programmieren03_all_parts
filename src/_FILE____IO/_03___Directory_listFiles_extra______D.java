package _FILE____IO;

import java.io.*;
import java.util.*;

public class _03___Directory_listFiles_extra______D {

    public static void main(String[] args) {
        File dir = new File("/Users/kaaatkina/CAMPUS02_2025/Programmieren_3");
        listOfFiles(dir.getAbsolutePath());
        listAllFilesRecursive(dir);
        listTxtFiles(dir);
        listFilesWithSize(dir);
        listFilesSortedByName(dir);
        listFilesSortedBySize(dir);
        listFilesSortedByDate(dir);
        countFilesAndDirs(dir);
        listHiddenFiles(dir);
        listFilePermissions(dir);
        listFilesModifiedRecently(dir, 7);
    }

    // Aufgabe: Nur Dateien und Ordner im gegebenen Verzeichnis anzeigen
    public static void listOfFiles(String path) {
        File root = new File(path);
        File[] list = root.listFiles();
        for (File f : list) {
            if (f.isDirectory()) {
                System.out.println("Dir: " + f.getAbsoluteFile());
            } else {
                System.out.println("File: " + f.getAbsoluteFile());
            }
        }
    }

    // 1. Rekursive Auflistung
    public static void listAllFilesRecursive(File dir) {
        File[] list = dir.listFiles();
        for (File f : list) {
            if (f.isDirectory()) {
                System.out.println("Dir: " + f.getAbsolutePath());
                listAllFilesRecursive(f);
            } else {
                System.out.println("File: " + f.getAbsolutePath());
            }
        }
    }

    // 2. Nur .txt-Dateien
    public static void listTxtFiles(File dir) {
        File[] list = dir.listFiles((d, name) -> name.endsWith(".txt"));
        System.out.println("\nNur .txt-Dateien:");
        for (File f : list) {
            System.out.println(f.getAbsolutePath());
        }
    }

    // 3. Dateien mit Größe
    public static void listFilesWithSize(File dir) {
        File[] list = dir.listFiles();
        System.out.println("\nDateien mit Größe:");
        for (File f : list) {
            if (f.isFile()) {
                System.out.println(f.getName() + " - " + f.length() + " Bytes");
            }
        }
    }

    // 4. Sortierung nach Name
    public static void listFilesSortedByName(File dir) {
        File[] list = dir.listFiles();
        Arrays.sort(list, Comparator.comparing(File::getName));
        System.out.println("\nSortiert nach Name:");
        for (File f : list) {
            System.out.println(f.getName());
        }
    }

    // 5. Sortierung nach Größe
    public static void listFilesSortedBySize(File dir) {
        File[] list = dir.listFiles();
        Arrays.sort(list, Comparator.comparingLong(File::length));
        System.out.println("\nSortiert nach Größe:");
        for (File f : list) {
            System.out.println(f.getName() + " - " + f.length() + " Bytes");
        }
    }

    // 6. Sortierung nach Änderungsdatum
    public static void listFilesSortedByDate(File dir) {
        File[] list = dir.listFiles();
        Arrays.sort(list, Comparator.comparingLong(File::lastModified));
        System.out.println("\nSortiert nach Datum:");
        for (File f : list) {
            System.out.println(f.getName() + " - " + new Date(f.lastModified()));
        }
    }

    // 7. Zähle Dateien und Verzeichnisse
    public static void countFilesAndDirs(File dir) {
        File[] list = dir.listFiles();
        int files = 0, dirs = 0;
        for (File f : list) {
            if (f.isFile()) files++;
            else if (f.isDirectory()) dirs++;
        }
        System.out.println("\nAnzahl Dateien: " + files);
        System.out.println("Anzahl Verzeichnisse: " + dirs);
    }

    // 8. Versteckte Dateien anzeigen
    public static void listHiddenFiles(File dir) {
        File[] list = dir.listFiles(File::isHidden);
        System.out.println("\nVersteckte Dateien:");
        for (File f : list) {
            System.out.println(f.getName());
        }
    }

    // 9. Rechte anzeigen
    public static void listFilePermissions(File dir) {
        File[] list = dir.listFiles();
        System.out.println("\nRechte:");
        for (File f : list) {
            System.out.println(f.getName() + ": R=" + f.canRead() + ", W=" + f.canWrite() + ", X=" + f.canExecute());
        }
    }

    // 10. Nur Dateien der letzten x Tage anzeigen
    public static void listFilesModifiedRecently(File dir, int tage) {
        long grenze = System.currentTimeMillis() - (tage * 24L * 60 * 60 * 1000);
        System.out.println("\nZuletzt geändert in letzten " + tage + " Tagen:");
        for (File f : dir.listFiles()) {
            if (f.lastModified() > grenze) {
                System.out.println(f.getName() + " - " + new Date(f.lastModified()));
            }
        }
    }
    // Rekursive Auflistung aller Dateien und Unterordner
    public static void printDirectoryRecursive(File dir) {
        if (dir.isDirectory()) {
            File[] list = dir.listFiles();
            if (list != null) {
                for (File f : list) {
                    if (f.isDirectory()) {
                        System.out.println("[Ordner] " + f.getAbsolutePath());
                        printDirectoryRecursive(f);
                    } else {
                        System.out.println("[Datei]  " + f.getAbsolutePath() + " (" + readableSize(f.length()) + ")");
                    }
                }
            }
        }
    }

    // Nur .txt-Dateien anzeigen
    public static void printOnlyTxtFiles(File dir) {
        File[] files = dir.listFiles((d, name) -> name.toLowerCase().endsWith(".txt"));
        if (files != null) {
            for (File file : files) {
                System.out.println("TXT-Datei: " + file.getName());
            }
        }
    }

    // Versteckte Dateien anzeigen
    public static void printHiddenFiles(File dir) {
        File[] files = dir.listFiles(File::isHidden);
        if (files != null) {
            for (File file : files) {
                System.out.println("Versteckt: " + file.getAbsolutePath());
            }
        }
    }

    // Dateien nach Größe sortiert anzeigen
    public static void sortFilesBySize(File dir) {
        File[] files = dir.listFiles(File::isFile);
        if (files != null) {
            Arrays.sort(files, Comparator.comparingLong(File::length));
            for (File file : files) {
                System.out.println(file.getName() + " - " + readableSize(file.length()));
            }
        }
    }

    // Dateien mit Schreib-/Lese-/Ausführ-Rechten anzeigen
    public static void printFilePermissions(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                System.out.printf("%s - Read: %b, Write: %b, Execute: %b\n",
                        f.getName(), f.canRead(), f.canWrite(), f.canExecute());
            }
        }
    }

    // Zeige Dateien mit Änderung in den letzten X Tagen
    public static void printRecentModifiedFiles(File dir, int tage) {
        long grenze = System.currentTimeMillis() - (tage * 24L * 60 * 60 * 1000);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.lastModified() >= grenze) {
                    System.out.println("Kürzlich geändert: " + f.getAbsolutePath());
                }
            }
        }
    }

    // Hilfsmethode für besser lesbare Größenangabe
    public static String readableSize(long bytes) {
        if (bytes < 1024) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(1024));
        String pre = "KMGTPE".charAt(exp - 1) + "";
        return String.format("%.1f %sB", bytes / Math.pow(1024, exp), pre);
    }
}

