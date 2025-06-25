package _NETZWERK___.server_with_SingleClient;
/*Was macht das Programm konkret?

Es startet einen einfachen Server, der auf Port 9090 wartet
Er kann über Telnet oder Netcat (nc) getestet werden
Der Server verarbeitet einfache Textbefehle vom Client*/


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ListenToSingleClient {

    // Starte über Kommandozeile (cmd): nc localhost 9090 auf Mac
    public static void main(String[] args) throws IOException {
        System.out.println("Warte auf eingehende Verbindungen - Starte über Kommandozeile mit nc localhost 9090 auf Mac, telnet localhost 9090");

        // Wir arbeiten hier auf localhost = Rechner selbst
        // Wir haben Port 9090 für unseren ServerSocket festgelegt
        // Teste die Server-Implementierung mit Putty oder Telnet (siehe Moodle-Tutorial)

        ServerSocket serverSocket = new ServerSocket(9090);

        // Wartet auf eine Verbindung zum Socket und akzeptiert sie, blockiert solange
        Socket socket = serverSocket.accept();

        // Bereitet Stream zum Schreiben an den Client vor
        BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream())
        );

        bufferedWriter.write("HELLO");  // Begrüßungsnachricht an den Client senden
        bufferedWriter.newLine();
        bufferedWriter.flush();

        // Bereitet Stream zum Lesen von Nachrichten vom Client vor
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );

        String command;  // Variable speichert empfangene Befehle vom Client

        // Solange Daten empfangen werden, bleibt die Schleife aktiv
        while ((command = bufferedReader.readLine()) != null) {

            System.out.println(command);  // Befehl auf Konsole anzeigen

            if ("TIME".equalsIgnoreCase(command)) {
                // Wenn Befehl TIME → aktuelle Uhrzeit an Client senden
                Calendar cal = GregorianCalendar.getInstance();
                bufferedWriter.write(cal.get(Calendar.HOUR_OF_DAY) + " : " +
                        cal.get(Calendar.MINUTE) + " : " +
                        cal.get(Calendar.SECOND));
                bufferedWriter.newLine();
                bufferedWriter.flush();

            } else if ("PORT".equalsIgnoreCase(command)) {
                // Wenn Befehl PORT → den aktuellen Port (9090) an Client senden
                bufferedWriter.write("PORT: " + socket.getLocalPort());
                bufferedWriter.newLine();
                bufferedWriter.flush();

            } else if ("END".equalsIgnoreCase(command)) {
                // Wenn Befehl END → saubere Verbindungsbeendigung
                bufferedWriter.write("BYE");
                bufferedWriter.newLine();
                bufferedWriter.flush();
                break;  // Schleife verlassen

            } else {
                // Bei unbekanntem Befehl → Rückmeldung senden
                bufferedWriter.write("unknown command");
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }

        // Streams schließen, Ressourcen freigeben
        bufferedReader.close();
        bufferedWriter.close();
        System.out.println("Beendet.");
    }
}