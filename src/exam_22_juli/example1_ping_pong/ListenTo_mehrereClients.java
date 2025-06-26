package exam_22_juli.example1_ping_pong;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
// todo - can be edited, if needed.


/*
Mehrere Clients können sich gleichzeitig verbinden.
Jeder Client läuft dabei in einem eigenen Thread.
Der Server bleibt dauerhaft aktiv, bis du ihn manuell stoppst (z. B. über IDE oder Terminal).
*/

public class ListenTo_mehrereClients {

    public static void main(String[] args) {
        int port = 1112;  // Port auf dem der Server lauscht

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server läuft und wartet auf Port " + port);

            // Endlosschleife: Server nimmt immer wieder neue Clients an
            while (true) {
                Socket clientSocket = serverSocket.accept();  // Blockiert hier, bis sich ein Client verbindet
                System.out.println("Neuer Client verbunden: " + clientSocket.getInetAddress());

                // Für jeden neuen Client wird ein eigener Thread gestartet
                new ClientHandler(clientSocket).start();
            }

        } catch (IOException e) {
            System.out.println("Fehler im Server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}