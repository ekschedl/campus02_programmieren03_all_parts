package _NETZWERK___;
import java.io.*;
import java.net.URL;

public class ReadFromURLandSaveToFile_____URL___toFile {
    public static void main(String[] args) {
        try {
            System.out.println("Main starting up...");
            System.out.println("Bitte die gewünschte URL eingeben: ");
            BufferedReader userInput = new BufferedReader(
                    new InputStreamReader(System.in)); // Liest Benutzereingabe von Konsole

//        String user_url = userInput.readLine();
            String user_url = "https://ipof.me"; // nur zum Testen, feste URL statt Benutzereingabe
            System.out.println("Habe folgende URL bekommen: '" + user_url + "'");

            //URL auslesen
            URL myURL = new URL(user_url); // Erstellt URL-Objekt aus String
            InputStreamReader isr = new InputStreamReader(myURL.openStream()); // Öffnet Verbindung zur Webseite
            BufferedReader br = new BufferedReader(isr); // Puffer für effizientes Lesen

            //neues File
            File f = new File("content.html"); // Neue Datei namens content.html wird angelegt
            FileWriter fw = new FileWriter(f); // Datei wird zum Schreiben geöffnet
            BufferedWriter bw = new BufferedWriter(fw); // Puffer für schnelleres Schreiben
//        BufferedWriter bw = new BufferedWriter(new FileWriter("content.html")); // alles in 1ner Zeile
            System.out.println("---Output Datei ist hier: " + f.getAbsolutePath()); // Vollständiger Pfad zur Datei

            String one_line;
            //jede Zeile von Website -> auf Konsole schreiben
            while ((one_line = br.readLine()) != null) { // Solange Zeilen verfügbar sind
                System.out.println(one_line); // Zeile auf Konsole anzeigen
                bw.write(one_line); // Zeile in Datei schreiben
                bw.newLine(); // Zeilenumbruch hinzufügen
            }

            bw.flush(); // Restliche Daten aus dem Puffer in die Datei schreiben
            bw.close(); // Datei korrekt schließen

        } catch (IOException e) {
            throw new RuntimeException(e); // Laufzeitfehler weiterwerfen, falls IO-Problem auftritt
        }
    }}
