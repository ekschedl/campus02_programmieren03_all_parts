package beispiel4_server.beispiel4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class ListenToMultipleClients {

    public static void main(String[] args) {
        // Liste für alle gestarteten Client-Threads
        List<Thread> clients = new ArrayList<>();

        System.out.println("Starte Server ...");

        ServerSocket serverSocket = null;
        try {
            // ServerSocket wird auf Port 9090 geöffnet
            serverSocket = new ServerSocket(9090);
            // Der Server wartet maximal 30 Sekunden auf eine neue Verbindung
            serverSocket.setSoTimeout(30000); // 30 Sekunden
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Endlosschleife zum Akzeptieren mehrerer Clients
        while (true) {
            try {
                // Wartet auf eingehende Client-Verbindung (blockierend)
                Socket socket = serverSocket.accept();

                // Wenn ein Client verbunden ist, wird ein neuer Thread gestartet,
                // der für die Kommunikation mit diesem Client zuständig ist
                Thread thread = new Thread(new CommunicationTask(socket)); // CommunicationTask ist eine eigene Klasse, die Runnable implementiert
                thread.start();

                // Der gestartete Thread wird zur Liste hinzugefügt, um später darauf warten zu können
                clients.add(thread);
            } catch (SocketTimeoutException e) {
                // Wenn 30 Sekunden lang kein Client verbunden wurde → Abbruch der Schleife
                System.out.println("Server TIMEOUT");
                break;
            } catch (IOException e) {
                // Fehler beim Verbindungsaufbau
                e.printStackTrace();
            }
        }

        // Hier wird darauf gewartet, dass alle Client-Threads fertig sind
        for (Thread t : clients) {
            try {
                t.join(); // Wartet, bis der Thread beendet ist
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Wenn alle Threads fertig sind, wird der Server beendet
        System.out.println("ENDE");
    }
}