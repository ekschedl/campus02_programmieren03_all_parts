package _NETZWERK___;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class Demo_ApiHttpPost_antwort_speichern_me {
    public static void main(String[] args) {

        String url = "https://httpbin.org/post"; // Test-API, die POST-Daten zurückspiegelt
        String email = "yourname@gmail.com";
        String password = "yourpass";

        try {
            // Verbindung aufbauen
            URL urlObj = new URL(url);
            HttpURLConnection httpCon = (HttpURLConnection) urlObj.openConnection();

            httpCon.setDoOutput(true);           // Wir wollen Daten senden
            httpCon.setRequestMethod("POST");    // Methode explizit POST

            // Parameter vorbereiten
            String parameters = "username=" + email + "&password=" + password;

            // Parameter senden
            OutputStreamWriter writer = new OutputStreamWriter(httpCon.getOutputStream());
            writer.write(parameters);
            writer.flush();

            // Antwort lesen
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(httpCon.getInputStream())
            );

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line).append("\n");
            }
            reader.close();

            // Antwort auf Konsole ausgeben
            System.out.println("Antwort vom Server:");
            System.out.println(response);

            // Antwort zusätzlich in Datei speichern
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter("src/_NETZWERK___/server_antwort.txt"));
            fileWriter.write(response.toString());
            fileWriter.close();

            System.out.println("Antwort wurde auch in server_antwort.txt gespeichert.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}