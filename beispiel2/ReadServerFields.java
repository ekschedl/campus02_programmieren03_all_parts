package at.campus02.pr3.network.beispiel2;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class ReadServerFields {

    public static void main(String[] args) throws IOException {

        String url = "https://google.com";
        URL urlObj = new URL(url);
        URLConnection urlCon = urlObj.openConnection();

        Map<String, List<String>> map = urlCon.getHeaderFields();


        for (String key : map.keySet()) {
            System.out.println(key + ":");

            List<String> values = map.get(key);

            for (String aValue : values) {
                System.out.println("\t" + aValue);
            }
        }
    }
}
