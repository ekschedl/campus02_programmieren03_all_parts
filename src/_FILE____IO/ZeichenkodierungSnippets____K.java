package _FILE____IO;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ZeichenkodierungSnippets____K {

    public static void main(String[] args) throws IOException {
        // aufgabe1_utf8Lesen("utf8.txt");
        // aufgabe2_iso88591Lesen("iso.txt");
        // aufgabe3_utf8Schreiben("neu_utf8.txt");
        // aufgabe4_iso88591Schreiben("neu_iso.txt");
        // aufgabe5_konvertiereTextdateiMitAndererKodierung("iso.txt", "utf8_konvertiert.txt", StandardCharsets.ISO_8859_1, StandardCharsets.UTF_8);
        // aufgabe6_unlesbarWegenFalscherKodierung("utf8.txt");
        // aufgabe7_erkenneUndKorrigiereFehlerhafteKodierung("vermischt.txt");
        // aufgabe8_utf16SchreibenUndLesen("utf16.txt");
    }

    // Aufgabe 1: UTF-8-Datei lesen und anzeigen
    public static void aufgabe1_utf8Lesen(String pfad) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(pfad), StandardCharsets.UTF_8));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    // Aufgabe 2: ISO-8859-1-Datei lesen und anzeigen
    public static void aufgabe2_iso88591Lesen(String pfad) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(pfad), StandardCharsets.ISO_8859_1));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    // Aufgabe 3: Schreibe eine Datei in UTF-8
    public static void aufgabe3_utf8Schreiben(String pfad) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pfad), StandardCharsets.UTF_8));
        writer.write("Zeile mit Umlauten: äöüß\nNoch eine Zeile.");
        writer.close();
    }

    // Aufgabe 4: Schreibe eine Datei in ISO-8859-1
    public static void aufgabe4_iso88591Schreiben(String pfad) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pfad), StandardCharsets.ISO_8859_1));
        writer.write("Zeile mit Umlauten: äöüß\nNoch eine Zeile.");
        writer.close();
    }

    // Aufgabe 5: Konvertiere Textdatei von einem Zeichensatz in einen anderen
    public static void aufgabe5_konvertiereTextdateiMitAndererKodierung(String quelle, String ziel, Charset quellCharset, Charset zielCharset) throws IOException {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(quelle), quellCharset));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ziel), zielCharset))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    // Aufgabe 6: Datei wird mit falscher Kodierung gelesen – Ergebnis unlesbar
    public static void aufgabe6_unlesbarWegenFalscherKodierung(String pfad) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(pfad), StandardCharsets.ISO_8859_1));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line); // wird fehlerhaft sein, wenn Datei UTF-8 ist
        }
        reader.close();
    }

    // Aufgabe 7: Erkenne fehlerhafte Kodierung (z.B. typische Zeichenfehler)
    public static void aufgabe7_erkenneUndKorrigiereFehlerhafteKodierung(String pfad) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(pfad), Charset.defaultCharset()));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains("Ã") || line.contains("�")) {
                System.out.println("Warnung: Zeichenfehler erkannt → Datei evtl. falsche Kodierung!");
            }
            System.out.println(line);
        }
        reader.close();
    }

    // Aufgabe 8: UTF-16 Textdatei schreiben und lesen
    public static void aufgabe8_utf16SchreibenUndLesen(String pfad) throws IOException {
        // Schreiben
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pfad), StandardCharsets.UTF_16));
        writer.write("UTF-16 Text – enthält Emoji 😊\n");
        writer.write("Zweite Zeile mit Umlauten: äöü\n");
        writer.close();

        // Lesen
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(pfad), StandardCharsets.UTF_16));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}

