package _NETZWERK___;
//  Das Programm verbindet sich mit einem Zeitserver (time.nist.gov) über TCP-Port 37
// und liest die aktuelle Zeit in Sekunden seit 1900. Diese Zeit wird in ein lesbares Datum
// umgerechnet und auf der Konsole angezeigt.
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Zeit_von_timeserver {
    public static void main(String[] args) {
        System.out.println("Hello world!");                   // Testausgabe beim Start
        final String DEFAULT_TIME_SERVER = "time.nist.gov";   // Zeitserver-Adresse (wird unten fix verwendet)
        final SimpleDateFormat DATUMFORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // Datumsformat für lesbare Ausgabe
        final long SEKUNDEN_1900_1970 = 2208988800L;          // Differenz in Sekunden zwischen 1900 und 1970 (wegen Unix-Timestamp)

        Socket so = null;   // Socket-Verbindung initialisieren
        InputStream in = null;  // Datenstrom vom Server
        long time = 0;      // Variable zur Speicherung der Serverzeit

        try {
            so = new Socket("time.nist.gov", 37);  // TCP-Verbindung zum Zeitserver auf Port 37 aufbauen
            in = so.getInputStream();                         // Eingabestrom öffnen

            // Zeitwert in 4 Bytes lesen, von links nach rechts zusammenbauen:
            for (int i = 3; i >= 0; i--) {
                time ^= (long) in.read() << i * 8;           // Bitweise Aufaddierung, jedes Byte wird verschoben und zusammengefügt
            }

            // Der Time Server liefert Sekunden seit 1900, Java erwartet Millisekunden seit 1970:
            System.out.println(DATUMFORMAT.format(
                    new Date((time - SEKUNDEN_1900_1970) * 1000)  // Differenz abziehen, in Millisekunden umrechnen
            ));

        } catch (Exception ex) {
            System.out.println(ex);                           // Fehlerausgabe bei Verbindungs- oder Lesefehler
        } finally {
            if (in != null) try { in.close(); } catch (IOException ex) {/*ok*/ }   // Sicher Eingabestrom schließen
            if (so != null) try { so.close(); } catch (IOException ex) {/*ok*/ }   // Socket schließen
        }
    }
}
