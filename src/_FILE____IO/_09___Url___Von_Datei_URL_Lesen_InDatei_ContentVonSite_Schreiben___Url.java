package _FILE____IO;

import java.io.*;
import java.net.URL;

public class _09___Url___Von_Datei_URL_Lesen_InDatei_ContentVonSite_Schreiben___Url {
    public static void main(String[] args) throws IOException {
        // Erstellen Sie ein Programm, das eine Internetadresse aus einer Textdatei liest, und den Inhalt dieser URL in eine Datei “content.html” schreibt.

        // Plattformunabhängige Pfade zur Eingabedatei (URL) und zur Ausgabedatei (HTML-Content)
        File inputFile = new File(System.getProperty("user.home"), "CAMPUS02_2025/Programmieren_3/src/url_ue_09.txt"); // Datei mit URL
        File outputFile = new File(System.getProperty("user.home"), "CAMPUS02_2025/Programmieren_3/src/url_content_ue_09.html"); // Datei zum Speichern des Webseiteninhalts

        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));


        String urlString = bufferedReader.readLine(); // liest die erste Zeile

        bufferedReader.close(); // muss geschlossen werden, da neuer bufferedReader geöffnet wird

        URL url = new URL(urlString); // Text aus url.txt wird in eine URL verwandelt

        // liest den HTML-Text der Seite, die in url.txt steht
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
        // Schreiben des Inhalts aus dem Netz in die Datei

        String inputfile; // Variable für den HTML-Content der Seite
        while ((inputfile = in.readLine()) != null) { // Schleife, solange noch Inhalt vorhanden ist
            bufferedWriter.write(inputfile); // schreibt den Inhalt in die Datei
            bufferedWriter.newLine(); // Zeilenumbruch
        }

        bufferedWriter.flush(); // sicherstellen, dass alles geschrieben wurde
        in.close();              // Reader schließen
        bufferedWriter.close(); // Writer schließen
    }
}