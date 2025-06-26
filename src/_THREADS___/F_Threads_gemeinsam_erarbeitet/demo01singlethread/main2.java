package _THREADS___.F_Threads_gemeinsam_erarbeitet.demo01singlethread;

import java.io.File;

public class main2 {
    public static void main(String[] args) {
        // readFileInformation("/Users/kaaatkina/CAMPUS02_2025/FUCHS/Programmieren3/test.txt");

        File theDir = new File("eins/zwei/drei/vier/five");
        if (!theDir.exists()) {
            boolean antwort = theDir.mkdirs();
            System.out.println("Wurde das Verzeichnis erstellt: " + antwort);
            System.out.println("-- Ordners erstellt --");
        } else {
            System.out.println("-- Ordner nicht erstellt, bereits existieren --");

        }


    }
}
