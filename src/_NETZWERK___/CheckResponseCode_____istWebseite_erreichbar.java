package _NETZWERK___;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

//Das Programm prüft, ob eine Website erfolgreich erreichbar ist,
// indem es den HTTP-Statuscode der Antwort vom Server überprüft.
//
//⸻
public class CheckResponseCode_____istWebseite_erreichbar {

    public static void main(String[] args) throws IOException {
//Ein URL-Objekt wird erstellt.
// Es repräsentiert die Adresse, die überprüft werden soll – in diesem Fall https://www.google.com.
        URL urlObj = new URL("https://ekschedl.com");

        /*Öffnet eine Verbindung zur URL und wandelt sie in eine HTTP-Verbindung um.
       Jetzt können HTTP-spezifische Methoden wie getResponseCode() verwendet werden.*/
        HttpURLConnection httpCon = (HttpURLConnection) urlObj.openConnection();

        /*Hier wird der HTTP-Antwortcode vom Server abgefragt, z.B.:
	•	200 → OK
	•	404 → Seite nicht gefunden
	•	403 → Zugriff verboten
	•	500 → Serverfehler*/
        int responseCode = httpCon.getResponseCode();


        /*Hier wird geprüft, ob der Antwortcode nicht gleich 200 OK ist. HTTP_OK ist eine Konstante für 200.*/
        if (responseCode != HttpURLConnection.HTTP_OK) {
            System.out.println("Server returned response code " + responseCode + ". Download failed.");
        } else {
            System.out.println(responseCode); // // Wenn alles gut: Statuscode anzeigen, z.B. 200, Wenn der Server z.B. 403, 404 oder 500 zurückgibt, wird hier eine Fehlermeldung ausgegeben.
        }

    }
}
