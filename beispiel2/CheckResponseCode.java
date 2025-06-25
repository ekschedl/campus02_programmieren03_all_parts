package at.campus02.pr3.network.beispiel2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class CheckResponseCode {

    public static void main(String[] args) throws IOException {

        URL urlObj = new URL("https://www.google.com");
        HttpURLConnection httpCon = (HttpURLConnection) urlObj.openConnection();

        int responseCode = httpCon.getResponseCode();

        if (responseCode != HttpURLConnection.HTTP_OK) {
            System.out.println("Server returned response code " + responseCode + ". Download failed.");
        }
        else {
            System.out.println(responseCode);
        }

    }
}
