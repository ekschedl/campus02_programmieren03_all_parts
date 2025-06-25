package _NETZWERK___;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class Demo_ApiHttpPost_me {
    public static void main(String[] args) {

        String apiUrl = "https://httpbin.org/post";  // Test-API, die zeigt, was du geschickt hast
        String name = "Katja";
        String hobby = "Programmieren";

        try {
            URL urlObj = new URL(apiUrl);  // URL-Objekt für die API
            HttpURLConnection httpCon = (HttpURLConnection) urlObj.openConnection();

            httpCon.setDoOutput(true);     // Aktiviert Senden von Daten
            httpCon.setRequestMethod("POST");  // POST-Methode festlegen

            // Typischer Header, den viele APIs erwarten
            httpCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            // Parameter sauber mit & trennen
            String parameters = "name=" + name + "&hobby=" + hobby;

            // Daten an den Server senden
            OutputStreamWriter writer = new OutputStreamWriter(httpCon.getOutputStream());
            writer.write(parameters);
            writer.flush();
            writer.close();

            // Server-Antwort prüfen
            int responseCode = httpCon.getResponseCode();
            System.out.println("Antwort vom Server: " + responseCode);


            // Antwort-Inhalt ausgeben
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
            String line;
            System.out.println("Antwort-Text:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
