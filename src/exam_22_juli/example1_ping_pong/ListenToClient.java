package exam_22_juli.example1_ping_pong;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/*
✅ Server auf Port 1111
✅ Liest vom Client Text (über Telnet/Putty)
✅ Antwortet mit “pong” auf “ping”
✅ Beendet Verbindung mit “stop”
✅ Nach zufälliger Rundenzahl sendet der Server “ende” und beendet die Verbindung
*/
// todo - can be edited, if needed.

public class ListenToClient {

    public static void main(String[] args) {
        try {
            // Schritt 1: ServerSocket auf Port 1111 erstellen
            ServerSocket serverSocket = new ServerSocket(1111);
            System.out.println(" Server läuft auf Port 1111, wartet auf Verbindung...");

            // Endlosschleife, damit immer wieder neue Clients verbunden werden können
            while (true) {

                // Schritt 2: Auf Client warten (blockiert bis Verbindung aufgebaut wird)
                Socket clientSocket = serverSocket.accept();
                System.out.println("Neuer Client verbunden: " + clientSocket.getInetAddress());

                // Schritt 3: Streams zum Empfangen und Senden vorbereiten
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                // Schritt 4: Zufällige Rundenzahl bestimmen, wann der Server von selbst beendet
                int rounds = new Random().nextInt(10) + 1; // Mindestens 1 Runde, maximal 10
                int counter = 0; // Zähler für empfangene "ping"-Nachrichten

                System.out.println("Maximale Ping-Pong-Runden für diesen Client: " + rounds);

                String eingabe;

                // Schritt 5: Schleife zum Bearbeiten der Nachrichten vom Client
                while ((eingabe = in.readLine()) != null) {

                    if (eingabe.equalsIgnoreCase("ping")) {
                        // Client hat "ping" geschickt, Server antwortet mit "pong"
                        counter++;
                        if (counter >= rounds) {
                            // Maximale Anzahl an Pings erreicht, Server beendet Verbindung
                            out.write("ende\n");
                            out.flush();
                            System.out.println("Maximale Runden erreicht, Verbindung wird beendet.");
                            break;
                        } else {
                            out.write(" > pong\n");
                            out.flush();
                        }

                    } else if (eingabe.equalsIgnoreCase("stop")) {
                        // Client will den Server beenden
                        out.write("Server wird gestoppt!\n");
                        out.flush();
                        System.out.println("Client hat 'stop' gesendet, Server wird beendet.");
                        clientSocket.close();
                        serverSocket.close();
                        return; // Komplette Anwendung sauber beenden
                    } else {
                        // Unbekannter Befehl vom Client
                        out.write("Unbekannter Befehl\n");
                        out.flush();
                    }
                }

                // Verbindung schließen, wenn Client sich trennt oder "ende" kam
                clientSocket.close();
                System.out.println("🔌 Client getrennt.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/* u variante

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ListenToClient {

    public static void main(String[] args) {
        int port = 1111;
        // Erstellen eines ServerSockets, der auf Port 1111 lauscht
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            // Endlosschleife, um kontinuierlich Verbindungen von Clients zu akzeptieren
            while (true) {
                // Akzeptieren einer eingehenden Verbindung (blockiert, bis eine Verbindung hergestellt wird)
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("New client connected");

                    // BufferedReader zum Lesen von Daten vom Client
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                    // PrintWriter zum Senden von Daten an den Client
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

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
                        // Bei unbekannten Befehlen eine entsprechende Nachricht senden
                        else {
                            out.println("Unknown command");
                        }
                    }

                    // Nachricht ausgeben, wenn der Client die Verbindung trennt
                    System.out.println("Client disconnected");
                } catch (IOException e) {
                    // Fehlerbehandlung und Ausgabe der Fehlermeldung bei Problemen mit der Client-Verbindung
                    System.out.println("Exception in client connection: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            // Fehlerbehandlung und Ausgabe der Fehlermeldung bei Problemen mit dem Server
            System.out.println("Exception in server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
 */