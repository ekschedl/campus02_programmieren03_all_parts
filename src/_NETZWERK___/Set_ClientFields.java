package _NETZWERK___;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class Set_ClientFields {

    public static void main(String[] args) throws IOException {

        URL urlObj = new URL("https://www.google.com");  // URL-Objekt für die Zielseite erstellen
        URLConnection urlCon = urlObj.openConnection();   // Verbindung zur URL öffnen (noch kein Datenabruf)

        // ➡️ Client-Header-Felder setzen (geben dem Server Infos über den Client)
        urlCon.setRequestProperty("User-Agent", "Java Client; Mac OS ich sascha");  // Wer ist der Client? (Browser/Programm)
        urlCon.setRequestProperty("Accept", "text/html");                            // Was will der Client empfangen? (HTML)
        urlCon.setRequestProperty("Accept-Language", "en-US");                      // Bevorzugte Sprache
        urlCon.setRequestProperty("Connection", "close");                           // Verbindung nach Antwort schließen

        System.out.println(urlCon.getRequestProperties());  // Zeigt alle gesetzten Header im Überblick
    }
}