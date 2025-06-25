package _NETZWERK___;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
/*
Ohne Header-Felder:
Java stellt die Verbindung trotzdem her und holt sich den Inhalt. Viele Server akzeptieren das aus Höflichkeit oder Standard, vor allem Seiten wie Google liefern trotzdem was zurück.

Mit Header-Feldern:
➡️ Du „sagst“ dem Server, wie du behandelt werden möchtest:
	•	User-Agent: Wer bist du? Browser oder ein Script? Manche Seiten blockieren Anfragen ohne sinnvollen User-Agent.
	•	Accept: Was willst du empfangen? Nur Text, nur Bilder, etc.
	•	Accept-Language: Sprache der Antwort
	•	Connection: close: Nach Antwort direkt Verbindung schließen

Wozu sinnvoll?
	•	Manche Server geben anderen Inhalt zurück, wenn Header fehlen
	•	Manche Server blockieren Bots ohne korrekten User-Agent
	•	In APIs musst du oft exakt definieren, was du akzeptierst (z.B. JSON statt HTML)
	•	Bei Sicherheitsmaßnahmen (Bot-Schutz, Firewalls) können fehlende Header zum Block führen
 */
public class SetClientFieldsUndSpeichern {

    public static void main(String[] args) throws IOException {

        // Zielseite, die wir abrufen wollen
        URL urlObj = new URL("https://www.google.com");

        // Verbindung zur URL aufbauen
        URLConnection urlCon = urlObj.openConnection();

        // ➡️ Header-Felder setzen (sich als Browser "tarnen" oder Sprache wählen)
        urlCon.setRequestProperty("User-Agent", "Java Client für Katja 😊");
        urlCon.setRequestProperty("Accept", "text/html");
        urlCon.setRequestProperty("Accept-Language", "de-DE");
        urlCon.setRequestProperty("Connection", "close");

        // Zeige alle gesetzten Header in der Konsole
        System.out.println("Gesetzte Header:");
        System.out.println(urlCon.getRequestProperties());

        // Datei zum Speichern vorbereiten
        File file = new File("seite_von_google.html");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        // ➡️ Jetzt wirklich Daten abrufen (Seiteninhalt lesen)
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));

        System.out.println("\nInhalt der Seite:");
        String zeile;
        while ((zeile = reader.readLine()) != null) {
            System.out.println(zeile);  // Zeilen der Webseite auf Konsole ausgeben
            writer.write(zeile);        // Zeile in Datei speichern
            writer.newLine();           // Plattformunabhängiger Zeilenumbruch
        }

        // Streams schließen
        reader.close();
        writer.close();

        System.out.println("\nFertig. Inhalt gespeichert in: " + file.getAbsolutePath());
    }
}

/*
Ohne Header-Felder:
Java stellt die Verbindung trotzdem her und holt sich den Inhalt. Viele Server akzeptieren das aus Höflichkeit oder Standard, vor allem Seiten wie Google liefern trotzdem was zurück.

Mit Header-Feldern:
➡️ Du „sagst“ dem Server, wie du behandelt werden möchtest:
	•	User-Agent: Wer bist du? Browser oder ein Script? Manche Seiten blockieren Anfragen ohne sinnvollen User-Agent.
	•	Accept: Was willst du empfangen? Nur Text, nur Bilder, etc.
	•	Accept-Language: Sprache der Antwort
	•	Connection: close: Nach Antwort direkt Verbindung schließen

Wozu sinnvoll?
	•	Manche Server geben anderen Inhalt zurück, wenn Header fehlen
	•	Manche Server blockieren Bots ohne korrekten User-Agent
	•	In APIs musst du oft exakt definieren, was du akzeptierst (z.B. JSON statt HTML)
	•	Bei Sicherheitsmaßnahmen (Bot-Schutz, Firewalls) können fehlende Header zum Block führen
 */