package _FILE____IO;

import java.io.*;
import java.net.URL;

public class _09___Url_To_File_Downloader___Url {
    public static void main(String[] args) {
        try {
            // 1. URL angeben
            URL url = new URL("https://ekschedl.com");

            // 2. InputStream von der URL öffnen/
            BufferedReader bfreader = new BufferedReader(
                    new InputStreamReader(url.openStream())); // öffnet Lese-Stream zur Webseite

            // 3. Datei vorbereiten (Ziel: html-Datei auf Festplatte)
            BufferedWriter bwriter = new BufferedWriter(
                    new FileWriter("url_ekschedl_content.html")); // erstellt Writer zum Speichern

            // 4. Zeile für Zeile lesen und speichern
            String one_line; // speichert jeweils eine Zeile der Website
            while ((one_line = bfreader.readLine()) != null) {
                bwriter.write(one_line); // schreibt die aktuelle Zeile in die Datei
                bwriter.newLine(); // neue Zeile, sonst steht alles auf eine Zeile
                System.out.println(one_line); //auf Konsole ausgeben!!!

            }

            // 5. Ressourcen schließen (sehr wichtig!)
            bfreader.close(); // bfreader schließen
            bwriter.close(); //  bwriter schließen


            System.out.println("Download abgeschlossen.");// Erfolgsmeldung
        } catch (IOException e) {
            System.out.println("Fehler: " + e.getMessage());// Fehlerbehandlung
        }
    }
}
/*
URL url = new URL(...)
→ verbindet sich mit einer Webseite

url.openStream()
→ öffnet einen Datenstrom von der URL

BufferedReader
→ liest die Daten zeilenweise

BufferedWriter
→ schreibt Daten in eine Datei

newLine()
→ sorgt für Zeilenumbruch im Ausgabefile
*/

