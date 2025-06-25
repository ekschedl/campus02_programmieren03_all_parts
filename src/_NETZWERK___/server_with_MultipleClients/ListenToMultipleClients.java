package _NETZWERK___.server_with_MultipleClients;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class ListenToMultipleClients {

    public static void main(String[] args) {
        List<Thread> clients = new ArrayList<>();  // Liste für alle gestarteten Client-Threads

        System.out.println("Starte Server ...");

        ServerSocket serverSocket = null;
        try {

            serverSocket = new ServerSocket(9090);  // Server lauscht auf Port 9090
            serverSocket.setSoTimeout(30000); // 30 sek Timeout für Verbindungsanfragen
        } catch (IOException e) {
            e.printStackTrace();  // Fehler beim Erzeugen des Sockets
        }

        while (true) {
            try {
                /*  ✅ Der Server lauscht ständig am Port (z.B. 9090).
                ✅ Wenn ein Client eine Verbindung aufbaut → accept() erstellt ein Socket für diese Verbindung.
                ✅ Ab dann kannst du über dieses Socket-Objekt mit genau diesem Client Daten austauschen (lesen/schreiben).
                Ohne Client bleibt der Befehl accept() so lange blockiert, bis wirklich jemand anklopft.*/
                Socket socket = serverSocket.accept();  // Warten auf neue Client-Verbindung
                // Wenn ein Client verbunden ist, wird ein neuer Thread gestartet,
                // der für die Kommunikation mit diesem Client zuständig ist
                Thread thread = new Thread(new CommunicationTask(socket)); // Worker Class -> Runnable-Implementierung
                thread.start();  // Thread starten, Bearbeitung im Hintergrund
                clients.add(thread);  // Thread zur Liste hinzufügen
            } catch (SocketTimeoutException e) {
                System.out.println("Server TIMEOUT");  // Keine Verbindung innerhalb der gesetzten Zeit
                break;  // Schleife abbrechen
            } catch (IOException e) {
                e.printStackTrace();  // Sonstige Verbindungsfehler
            }
        }

        // Alle gestarteten Threads sauber beenden (Warten bis fertig)
        for (Thread t : clients) {
            try {
                t.join();  // Warten bis Thread t vollständig fertig ist
            } catch (InterruptedException e) {
                e.printStackTrace();  // Fehler beim Warten
            }
        }

        System.out.println("ENDE");  // Alle Threads abgeschlossen, Server beendet
    }
}

/*[Server läuft am Port 9090]

           ⬇️ accept() wartet
Client 1 ── Verbindet sich
           ⬇️ accept() gibt neues Socket zurück
Server kann mit Client 1 sprechen

           ⬇️ accept() wartet wieder
Client 2 ── Verbindet sich
           ⬇️ neues Socket für Client 2*/