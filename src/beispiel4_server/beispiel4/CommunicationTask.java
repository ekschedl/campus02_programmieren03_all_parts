package beispiel4_server.beispiel4;

import java.io.*;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;


// verwendt TCP verbindung -ServerSocket  und Socket, für jede verbindung einzeln senden ,  UDP andere Befehle schickt gleich an alle irgendwie so , gpt fragne
// Worker-Klasse für die Kommunikation mit einem einzelnen Client
// Sie implementiert Runnable, damit sie in einem eigenen Thread ausgeführt werden kann
public class CommunicationTask implements Runnable {

    private Socket socket; // Jeder Client bekommt seinen eigenen Socket (Verbindung zum Client)

    // Konstruktor bekommt den Socket vom verbundenen Client übergeben
    public CommunicationTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Der Name des Threads wird gesetzt, damit im Log leichter erkennbar ist, welcher Client gerade arbeitet
        Thread.currentThread().setName("Client Port " + socket.getPort());
        System.out.println(Thread.currentThread().getName() + " wurde gestartet.");

        try {
            // Server-Antwort zum Kunden
            // OutputStream → OutputStreamWriter → BufferedWriter = schreiben von Text (Zeile für Zeile) zum Client
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("HELLO"); // Begrüßung an den Client
            bufferedWriter.newLine();      // Neue Zeile hinzufügen (wichtig für readline() auf der Client-Seite)
            bufferedWriter.flush();        // Senden der Daten erzwingen (leert den Schreibpuffer)

            // Einlesen von Input vom Client über Putty/Telnet/Java-Programm
            // InputStream → InputStreamReader → BufferedReader = zeilenweises Lesen von Text vom Client
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String command;

            // Solange der Client etwas sendet, wird es gelesen und verarbeitet
            while ((command = bufferedReader.readLine()) != null) {
                System.out.println(Thread.currentThread().getName() + " führt folgendes Kommando aus -> " + command);

                // Wenn der Client "TIME" sendet, schickt der Server die aktuelle Uhrzeit zurück
                if ("TIME".equals(command)) {
                    Calendar cal = GregorianCalendar.getInstance(); // aktuelle Zeit holen
                    bufferedWriter.write(cal.get(Calendar.HOUR_OF_DAY) + " : " +
                            cal.get(Calendar.MINUTE) + " : " + cal.get(Calendar.SECOND));
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                    // Wenn der Client "PORT" sendet, bekommt er den Port des Servers
                } else if ("PORT".equals(command)) {
                    bufferedWriter.write("PORT: " + socket.getLocalPort()); // -> 9090
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                    // Wenn der Client "END" sendet, beendet der Server die Verbindung
                } else if ("END".equals(command)) {
                    bufferedWriter.write("BYE"); // Verabschiedung
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    break; // Schleife verlassen → Verbindung wird danach geschlossen

                    // Wenn der Befehl unbekannt ist
                } else {
                    bufferedWriter.write("unknown command");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
            }

            // Streams schließen (Verbindung beenden)
            bufferedReader.close();
            bufferedWriter.close();

            System.out.println(Thread.currentThread().getName() + " wurde beendet.");

        } catch (IOException e) {
            // Fehler beim Lesen/Schreiben oder bei der Verbindung
            e.printStackTrace();
        }
    }
}