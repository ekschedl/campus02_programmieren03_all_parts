package exam_22_juli.example1_ping_pong;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class ClientHandler extends Thread {
    private Socket clientSocket;

    // Konstruktor, der den Socket des Clients übergeben bekommt
    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    // Methode, die ausgeführt wird, wenn der Thread gestartet wird
    public void run() {
        // Ressourcen automatisch schließen durch try-with-resources
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true))
        {
            out.write("Willkommen im Ping-Pong-Server!\n");
            out.flush();
            // Zufällige Anzahl von Runden zwischen 1 und 10
            int rounds = new Random().nextInt(10) + 1;
            int count = 0;

            String inputLine;
            // Schleife, die Eingaben vom Client liest
            while ((inputLine = in.readLine()) != null) {
                // Wenn der Client "ping" sendet
                if (inputLine.equalsIgnoreCase("ping")) {
                    // Solange die Anzahl der Runden nicht erreicht ist, "pong" zurücksenden
                    if (count < rounds) {
                        out.println("pong");
                        count++;
                    } else {
                        // Wenn die Anzahl der Runden erreicht ist, "ende" senden und die Schleife beenden
                        out.println("ende");
                        break;
                    }
                }
                // Wenn der Client "stop" sendet
                else if (inputLine.equalsIgnoreCase("stop")) {
                    System.out.println("Server stopping...");
                    out.println("Server stopped");
                    System.exit(0); // Server beenden
                }
                // ODER!!!   Wenn du willst, dass nur die Verbindung zum einzelnen Client geschlossen wird, dann besser so:
//                else if (inputLine.equalsIgnoreCase("stop")) {
//                    System.out.println("Client möchte die Verbindung beenden.");
//                    out.println("Verbindung wird beendet");
//                    break;  // Nur diesen Client trennen, Server bleibt aktiv
//                }
                // Bei unbekannten Befehlen eine entsprechende Nachricht senden
                else {
                    out.println("Unknown command");
                }
            }

            // Nachricht ausgeben, wenn der Client die Verbindung trennt
            System.out.println("Client disconnected");
        } catch (IOException e) {
            // Fehlerbehandlung und Ausgabe der Fehlermeldung
            System.out.println("Exception in client handler: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
