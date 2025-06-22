package Probepruefung_PR3_von_2023;


import java.io.*;
import java.net.URL;
// UrlDownload (20 pt):
//        • Erstellen Sie ein neues Projekt mit dem Namen „UrlDownload“ und erstellen Sie darin
//          ein Package mit einem passenden Namen.
//        • Dieses Projekt lädt die Daten der URL
//          https://de.wikipedia.org/wiki/Objektorientierte_Programmierung und gibt alle Zeilen in die Datei
//        „content.html“ aus. Die Zeilen der Datei „content.html“ haben die für Windows üblichen
//          Zeilenumbrüche (nehmen Sie die integrierte Funktion um die Zeilenumbrüche zu realisieren)
public class UrlDownload {
    public static void main(String[] args) {
        try {
            // 1. URL der Wikipedia-Seite vorbereiten
            URL url = new URL("https://de.wikipedia.org/wiki/Objektorientierte_Programmierung");

            // 2. BufferedReader zum Lesen der Seite öffnen
            BufferedReader bufferedReaderreader = new BufferedReader(
                    new InputStreamReader(url.openStream()));

            // 3. Zieldatei "content.html" im aktuellen Projektordner vorbereiten
            File file = new File("content_probepruefung2023.html");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

            // 4. Jede Zeile lesen und mit Zeilenumbruch in Datei schreiben
            String line;
            while ((line = bufferedReaderreader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine(); // erzeugt Windows-Zeilenumbruch (CRLF bei Windows)
            }

            // 5. Ressourcen schließen
            bufferedReaderreader.close();
            bufferedWriter.close();

            System.out.println("Download abgeschlossen: content.html wurde erstellt.");
        } catch (IOException e) {
            System.out.println("Fehler beim Herunterladen: " + e.getMessage());
        }
    }
}