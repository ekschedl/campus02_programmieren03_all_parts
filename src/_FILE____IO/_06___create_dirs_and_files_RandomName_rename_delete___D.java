package _FILE____IO;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class _06___create_dirs_and_files_RandomName_rename_delete___D {
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


        //Plattformunabhängig
//        String path = System.getProperty("user.home") + File.separator +
//                "CAMPUS02_2025" + File.separator +
//                "Programmieren_3" + File.separator +
//                "dir_for_ue_05" + File.separator +
//                "1_eins" + File.separator +
//                "2_zwei" + File.separator +
//                "3_drei" + File.separator +
//                "4_vier" + File.separator +
//                "5_five";

        // oder so
        String path = "/Users/kaaatkina/CAMPUS02_2025/Programmieren_3/dir_for_ue_06";
        // Zielordner
        File dir = new File(path);

        if (!dir.exists()) {
            boolean erstellt = dir.mkdirs();
            System.out.println("Ordner erstellt? " + erstellt);
        }


        // 1 Dateien erstellen
        createFiles(dir);

        // 2 Dateien umbenennen
        renameFiles(dir);

        // 3 Dateien löschen
        //deleteFiles(dir);
    }

    // erstellt 10 neue Dateien mit zufälligen Namen in einem angegebenen Verzeichnis
    public static void createFiles(File directory) {
        for (int i = 0; i < 10; i++) {
            // Versuch, den Code darin auszuführen – falls ein Fehler passiert (z.b. Pfad ungültig), wird er im catch-Block behandelt.
            try {
                // fileList.getAbsolutePath() → das ist der Pfad zu dem Ordner, in dem die Datei gespeichert werden soll.
                // ThreadLocalRandom.current().nextInt() → erzeugt eine zufällige Zahl
                // ".mp3" wird als Dateiendung angehängt
                File dir = new File(directory.getAbsolutePath() +
                        File.separator + ThreadLocalRandom.current().nextInt() + ".mp3");

                // Datei erstellen
                if (dir.createNewFile()) {
                    System.out.println("ERSTELLT: " + dir.getAbsolutePath());
                } else {
                    System.out.println("Datei existiert bereits: " + dir.getAbsolutePath());
                }

            } catch (IOException e) {
                // Falls ein Fehler beim Erstellen passiert
                System.out.println("Fehler beim Erstellen der Datei");
                e.printStackTrace();
            }
        }
    }
//Warum erscheinen negative Zahlen bei ThreadLocalRandom.current().nextInt()?
//gibt eine zufällige Ganzzahl im Bereich von Integer.MIN_VALUE bis Integer.MAX_VALUE zurück.
//    Das bedeutet: Minimalwert: -2_147_483_648   Maximalwert: +2_147_483_647
//    Ergebnis kann also negativ oder positiv sein – beides ist korrekt.
// Was tun, wenn du keine negativen Dateinamen willst?
//     int randomNumber = ThreadLocalRandom.current().nextInt();
//    File file = new File(path + File.separator + Math.abs(randomNumber) + ".mp3");


    public static void renameFiles(File directory) {
        // Prüfen, ob das übergebene File-Objekt wirklich ein Verzeichnis ist
        if (directory.isDirectory()) {

            // Schleife über alle enthaltenen Elemente im Verzeichnis
            for (File oldFile : directory.listFiles()) {

                // Nur echte Dateien umbenennen, keine Verzeichnisse!
                if (oldFile.isFile()) {

                    // Neuen Namen zusammenbauen mit "1_" vor dem alten Namen
                    File newFile = new File(oldFile.getParent() + File.separator + "1_" + oldFile.getName());

                    // Versuch, umzubenennen
                    if (oldFile.renameTo(newFile)) {
                        System.out.println("UMBENANNT: " + oldFile.getName() + " → " + newFile.getName());
                    } else {
                        System.out.println("Konnte nicht umbenannt werden: " + oldFile.getName());
                    }
                } else {
                    // Nur zur Kontrolle – falls du aus Versehen Ordner erstellt hast
                    System.out.println("Nicht umbenannt (kein File): " + oldFile.getName());
                }
            }
        }
    }
    public static void deleteFiles(File directory) {
        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                file.delete();
                System.out.println("DELETED: " + file.getAbsolutePath());
            }
        }
    }
}
