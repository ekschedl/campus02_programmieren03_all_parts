package beispiel_to_analyse;


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
        String url = "https://twitter.com/sessions";
        String email = "yourname@gmail.com";
        String password = "yourpass";

        try {
            //URL-Objekt erstellen:
            URL urlObj = new URL(url);

            HttpURLConnection httpCon = (HttpURLConnection) urlObj.openConnection();

            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("POST");

            String parameters = "username=" + email;
            parameters += "password=" + password;

            OutputStreamWriter writer = new OutputStreamWriter(
                    httpCon.getOutputStream());
            writer.write(parameters);
            writer.flush();

            System.out.println(httpCon.getResponseCode());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
