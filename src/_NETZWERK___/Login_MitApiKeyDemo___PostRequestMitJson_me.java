package _NETZWERK___;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Login_MitApiKeyDemo___PostRequestMitJson_me {

    public static void main(String[] args) {

        String url = "https://reqres.in/api/login";  // Die API-Adresse für den Login-Test
        String json = "{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}";  // Login-Daten im JSON-Format

        try {
            URL urlObj = new URL(url);  // URL-Objekt erstellen
            HttpURLConnection httpCon = (HttpURLConnection) urlObj.openConnection();  // Verbindung aufbauen

            httpCon.setRequestMethod("POST");  // Wir verwenden POST-Methode
            httpCon.setRequestProperty("Content-Type", "application/json");  // Sagen dem Server: JSON-Daten kommen
            httpCon.setRequestProperty("x-api-key", "reqres-free-v1");  // API-Schlüssel mitsenden /genommen auf https://reqres.in/signup
            httpCon.setDoOutput(true);  // Output aktivieren (wir schicken Daten)

            // JSON-Daten an den Server senden
            try (OutputStreamWriter writer = new OutputStreamWriter(httpCon.getOutputStream())) {
                writer.write(json);  // JSON reinschreiben
                writer.flush();  // Daten losschicken
            }

            int responseCode = httpCon.getResponseCode();  // Antwortcode vom Server holen
            System.out.println("Antwortcode vom Server: " + responseCode);  // Auf Konsole zeigen

            // Server-Antwort lesen, egal ob Erfolg (200) oder Fehler
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                    (responseCode >= 200 && responseCode < 400) ? httpCon.getInputStream() : httpCon.getErrorStream()
            ))) {
                String line;
                System.out.println("Server-Antworttext:");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);  // Antwortzeilen einzeln anzeigen
                }
            }

        } catch (IOException e) {
            e.printStackTrace();  // Fehler auf Konsole zeigen
        }
    }
}