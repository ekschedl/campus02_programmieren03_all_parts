package _FILE____;

import java.io.File;

public class _05___create_5_dirs {

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
//

        File multiLevelFolder = new File("/Users/kaaatkina/CAMPUS02_2025/Projekt_2/eins/zwei/drei/vier/five");
        if (!multiLevelFolder.exists()) {
            boolean antwort = multiLevelFolder.mkdirs();
            System.out.println("Wurde das Verzeichnis erstellt: " + antwort);
            System.out.println("-- Ordners erstellt --");
        } else {
            System.out.println("-- Ordner nicht erstellt, bereits existieren --");
        }
    }
}
