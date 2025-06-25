
/*
✔ Lies eine Textdatei (urls_extra_aufgaben.txt), in der mehrere URLs stehen – jede URL in einer neuen Zeile
✔ Öffne jede URL, lade die HTML-Inhalte herunter
✔ Speichere nur die Zeilen mit <p>-Tags in eine eigene .html-Datei auf deinem Computer
✔ Jede Webseite bekommt einen eigenen Dateinamen wie seite1.html, seite2.html, …
✔ Zeige die Zeilen außerdem auf der Konsole an
✔ Ungültige URLs oder Lesefehler werden abgefangen*/

package _FILE____IO;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class _09___Url_verschiedene_aufgaben_extra___Url {

    public static void main(String[] args) {
        System.out.println("Starte URL-Download...");

        File urlDatei = new File("src/urls_extra_aufgaben.txt"); // Datei mit allen URLs
        int urlCounter = 1; // Zähler für unterschiedliche Dateinamen (seite1.html, seite2.html, ...)

        try (BufferedReader urlReader = new BufferedReader(new FileReader(urlDatei))) {
            String urlZeile;

            while ((urlZeile = urlReader.readLine()) != null) { // Zeile für Zeile URLs lesen
                System.out.println("Lese URL: " + urlZeile);
                bearbeiteEineUrl(urlZeile, urlCounter); // Pro URL separate Methode aufrufen
                urlCounter++; // Zähler erhöhen für Dateinamen
            }

        } catch (FileNotFoundException e) {
            System.out.println("Datei urls_extra_aufgaben.txt nicht gefunden."); // Datei fehlt
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen der URL-Datei: " + e.getMessage()); // Anderer Lesefehler
        }

        System.out.println("Fertig!");
    }

    // Diese Methode verarbeitet eine einzelne URL
    public static void bearbeiteEineUrl(String urlZeile, int zaehler) {
        try {
            URL url = new URL(urlZeile); // Prüft, ob die URL gültig ist
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream())); // Verbindung aufbauen

            String dateiname = "seite" + zaehler + ".html"; // Speichert jede Seite mit eigenem Namen
            BufferedWriter writer = new BufferedWriter(new FileWriter(dateiname)); // Datei zum Schreiben öffnen

            ladeUndFiltereHtml(reader, writer); // HTML-Inhalt lesen und filtern

            writer.close(); // Wichtig: Writer schließen
            reader.close(); // Wichtig: Reader schließen
            System.out.println("Gespeichert in: " + dateiname); // Bestätigung auf Konsole

        } catch (MalformedURLException e) {
            System.out.println("Ungültige URL: " + urlZeile); // URL nicht korrekt
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen/Schreiben: " + e.getMessage()); // Fehler beim Laden oder Speichern
        }
    }

    // Diese Methode liest den HTML-Inhalt und speichert nur Zeilen mit <p>
    public static void ladeUndFiltereHtml(BufferedReader reader, BufferedWriter writer) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) { // Jede Zeile lesen
            System.out.println(line); // Zeile auf Konsole ausgeben

            if (line.contains("<p>")) { // Nur Zeilen mit <p> speichern
                writer.write(line); // Zeile schreiben
                writer.write(System.lineSeparator()); // Zeilenumbruch hinzufügen
            }
        }
    }
}