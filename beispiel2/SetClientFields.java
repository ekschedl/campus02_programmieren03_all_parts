package at.campus02.pr3.network.beispiel2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class SetClientFields {

    public static void main(String[] args) throws IOException {

        URL urlObj = new URL("https://www.google.com");
        URLConnection urlCon = urlObj.openConnection();

        urlCon.setRequestProperty("User-Agent", "Java Client; Mac OS ich sascha");
        urlCon.setRequestProperty("Accept", "text/html");
        urlCon.setRequestProperty("Accept-Language", "en-US");
        urlCon.setRequestProperty("Connection", "close");

        System.out.println(urlCon.getRequestProperties());


    }
}
