package _NETZWERK___.server_with_MultipleClients;

import java.io.*;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CommunicationTask implements Runnable {

    private Socket socket; // Jeder Client bekommt seinen eigenen Socket (Verbindung zum Client)

    // Konstruktor bekommt den Socket vom verbundenen Client übergeben
    public CommunicationTask(Socket socket) {
        this.socket = socket;  // Übergabe der aktiven Verbindung (Socket) zum jeweiligen Client
    }

    @Override
    public void run() {
        // Der Name des Threads wird gesetzt, damit im Log leichter erkennbar ist, welcher Client gerade arbeitet
        Thread.currentThread().setName("Client Port " + socket.getPort()); // Thread bekommt Namen → bessere Lesbarkeit in Konsole
        System.out.println(Thread.currentThread().getName() + " wurde gestartet."); // Bestätigung: Thread aktiv für Client

        try {
            // Server-Antwort zum Kunden
            // OutputStream → OutputStreamWriter → BufferedWriter = schreiben von Text (Zeile für Zeile) zum Client
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())); // Vorbereiten für Antwort an Client
            bufferedWriter.write("HELLO"); // Begrüßungsnachricht an Client
            bufferedWriter.newLine(); // Zeilenumbruch hinzufügen (sonst bleibt Text zusammen)
            bufferedWriter.flush(); // Inhalt zwischenspeichern und losschicken

            // Einlesen von Input vom Client über Putty/Telnet/Java-Programm
            // InputStream → InputStreamReader → BufferedReader = zeilenweises Lesen von Text vom Client
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())); // Eingehende Nachrichten vom Client lesen
            String command; // Variable für empfangene Kommandos

            while ((command = bufferedReader.readLine()) != null) { // Solange Client etwas sendet
                System.out.println(Thread.currentThread().getName() + " führt folgendes Kommando aus -> " + command); // Empfangenes anzeigen


                if ("TIME".equalsIgnoreCase(command)) { // Kommando: aktuelle Uhrzeit senden
                    Calendar cal = GregorianCalendar.getInstance(); // Aktuelle Zeit holen
                    bufferedWriter.write(cal.get(Calendar.HOUR_OF_DAY) + " : " + cal.get(Calendar.MINUTE) + " : " + cal.get(Calendar.SECOND)); // Uhrzeit senden
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                } else if ("PORT".equalsIgnoreCase(command)) { // Kommando: Portnummer des Clients senden
                    bufferedWriter.write("PORT: " + socket.getLocalPort()); // Port senden, über den Client verbunden ist
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                } else if ("END".equalsIgnoreCase(command)) { // Kommando: Verbindung sauber beenden
                    bufferedWriter.write("BYE"); // Abschiedstext
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    break; // while-Schleife verlassen → beendet die Kommunikation
                } else { // Wenn der Befehl unbekannt ist
                    bufferedWriter.write("unknown command"); // Hinweis senden
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
            }

            bufferedReader.close(); // Lesestream schließen
            bufferedWriter.close(); // Schreibstream schließen
            System.out.println(Thread.currentThread().getName() + " wurde beendet."); // Bestätigung, dass Thread fertig

        } catch (IOException e) { // Bei IO-Fehler (z.B. Verbindung abgebrochen)
            e.printStackTrace(); // Fehlerdetails in Konsole
        }
    }
}