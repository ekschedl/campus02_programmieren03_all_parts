package _NETZWERK___;


import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class SubmitPostRequest {

    public static void main(String[] args) {
        //Das Programm sendet eine HTTP-POST-Anfrage an einen
        // Webserver, um zum Beispiel ein Login-Formular auszufüllen.
        // In diesem Fall ist es die URL https://twitter.com/sessions,
        // aber zur Übung funktioniert es auch mit anderen Test-URLs.

            // Das Programm sendet eine HTTP-POST-Anfrage an einen Webserver (z.B. für Login-Formular)
            String url = "https://twitter.com/sessions";           // Zieladresse für die POST-Anfrage
            String email = "yourname@gmail.com";                   // Beispiel-Daten (normalerweise Benutzereingabe)
            String password = "yourpass";                          // Beispiel-Passwort

            try {
                URL urlObj = new URL(url);                         // URL-Objekt erstellen
                HttpURLConnection httpCon = (HttpURLConnection) urlObj.openConnection();  // Verbindung aufbauen

                httpCon.setDoOutput(true);                         // Output aktivieren (für POST-Daten)
                httpCon.setRequestMethod("POST");                  // Methode explizit auf POST setzen

                String parameters = "username=" + email;           // POST-Parameter zusammenbauen
                parameters += "&password=" + password;              // Achtung: hier fehlt & zum Trennen mehrerer Parameter


                OutputStreamWriter writer = new OutputStreamWriter(
                        httpCon.getOutputStream());                // Datenstrom zum Server öffnen
                writer.write(parameters);                          // Parameter senden
                writer.flush();                                    // Sicherstellen, dass alle Daten rausgehen

                System.out.println(httpCon.getResponseCode());     // Antwortcode des Servers anzeigen (z.B. 200 = OK)

            } catch (IOException e) {
                e.printStackTrace();                               // Bei Fehler: Stacktrace auf Konsole
            }
        }
    }