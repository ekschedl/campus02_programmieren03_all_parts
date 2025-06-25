package _NETZWERK___;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class Read_ServerHeaderFields {

    public static void main(String[] args) throws IOException {

        String url = "https://ekschedl.com";         // Die Webseite, von der wir die Header auslesen wollen
        URL urlObj = new URL(url);                 // URL-Objekt erstellen
        URLConnection urlCon = urlObj.openConnection(); // Verbindung zur Seite aufbauen

        Map<String, List<String>> map = urlCon.getHeaderFields(); // Alle Header-Felder holen

        // Alle Header-Felder und ihre Werte ausgeben
        for (String key : map.keySet()) {
            System.out.println(key + ":"); // Feldname anzeigen (zb. Content-Type)

            List<String> values = map.get(key); // Liste der möglichen Werte holen (manche Felder haben mehrere Werte)

            for (String aValue : values) {
                System.out.println("\t" + aValue); // Jeden Wert ausgeben, eingerückt
            }
        }
    }
}
/*Wozu das?
Mit diesem Code kannst du alle Header-Informationen, die ein Server bei einer Anfrage mitschickt, auslesen.
Das ist nützlich, um technische Details der Antwort zu sehen, z.B.:

✅ Server-Typ
✅ Datum & Zeit
✅ Sicherheits-Infos ( z.B. Cookies, Caching)
✅ Content-Typ ( z.B.. text/html, application/json)

Das brauchst du oft beim Testen von Webseiten, Schnittstellen (APIs) oder wenn du verstehen willst, was der Server “im Hintergrund” zurückschickt.*/