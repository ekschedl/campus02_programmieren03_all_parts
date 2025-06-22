package _FILE____IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _05___create_5_dirs___und_extra____D {

    public static void main(String[] args) {
        /*Tip: use mkdirs()
        Write a method, which creates multiple directories. Example: "C:\\campus02\\test\\demo4" (Campus, Test, Demo4 will be created)
                - It should also be checked, if the given directory has been created -> print it to the console:
                -> IF Yes: Directory C:\campus02\test\demo4 created?: true
                -> IF No: Directory C:\campus02\test\demo4 created?: false

        Question: What is the difference between mkdirs() and mkdir() ?
        Question: What does mkdirs() return?
        Question: What does mkdir() return?*/

        //  •	mkdir() → erstellt nur das letzte Verzeichnis, wenn übergeordnete schon da sind.
        //	•	mkdirs() → erstellt den gesamten Pfad inkl. aller nicht existierenden Zwischenverzeichnisse.
        //	•	exists() → prüft, ob Datei/Ordner schon vorhanden ist.

        // Hauptbeispiel
        File multiLevelFolder = new File("/Users/kaaatkina/CAMPUS02_2025/Projekt_2/eins/zwei/drei/vier/five");
        if (!multiLevelFolder.exists()) {
            boolean antwort = multiLevelFolder.mkdirs();
            System.out.println("Wurde das Verzeichnis erstellt: " + antwort);
            System.out.println("-- Ordners erstellt --");
        } else {
            System.out.println("-- Ordner nicht erstellt, bereits existieren --");
        }

        // Erweiterung 1: Ordner mit mkdir() → funktioniert nur, wenn Eltern-Ordner schon existieren
        File ordner1 = new File("ausgabe/neuesVerzeichnis");
        if (!ordner1.exists()) {
            boolean erstellt = ordner1.mkdir();
            System.out.println("Einzelordner erstellt (mkdir): " + erstellt);
        }

        // Erweiterung 2: Prüfung + Erstellen eines Verzeichnisses mit Datum im Namen
        String today = java.time.LocalDate.now().toString(); // z. B. 2025-06-22
        File tagesOrdner = new File("tagebuch/" + today);
        if (!tagesOrdner.exists()) {
            boolean ok = tagesOrdner.mkdirs();
            System.out.println("Tagesordner " + today + " erstellt: " + ok);
        }

        // Erweiterung 3: Datei in einem neuen Unterordner erstellen
        File unterordner = new File("berichte/2025/maerz");
        if (!unterordner.exists()) unterordner.mkdirs();

        File datei = new File(unterordner, "bericht.txt");
        try {
            if (datei.createNewFile()) {
                System.out.println("Datei erstellt: " + datei.getAbsolutePath());
            } else {
                System.out.println("Datei existiert bereits: " + datei.getAbsolutePath());
            }
        }catch (FileNotFoundException e) {
            System.out.println("❌ Datei nicht gefunden: " + e.getMessage());
        } catch (SecurityException e) {
            System.out.println("🔒 Kein Zugriff auf Datei: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("⚠️ Allgemeiner Ein-/Ausgabefehler: " + e.getMessage());
        }

        // Erweiterung 4: Ordnerstruktur mit Zähler automatisch erzeugen
        for (int i = 1; i <= 5; i++) {
            File ordner = new File("berichte_2025/projekt_" + i);
            if (!ordner.exists()) {
                ordner.mkdirs();
                System.out.println("Projektordner erstellt: " + ordner.getAbsolutePath());
            }
        }
    }
}