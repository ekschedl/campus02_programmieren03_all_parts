package _NETZWERK___.server_with_MultipleClients_me;

import java.io.*;
import java.net.*;
/*Warum läuft bei ihm der Server weiter, obwohl ein Client “exit” schreibt?

👉 Weil er den Server so programmiert hat, dass jeder Client einzeln in einem eigenen Thread läuft.
👉 Wenn ein Client "exit" schickt, wird nur seine Verbindung beendet, der Server läuft trotzdem weiter und nimmt neue Verbindungen an.*/

public class ServerSeiteMehrereClients {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("Server läuft, wartet auf Verbindungen...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Neuer Client verbunden: " + clientSocket.getInetAddress());

            // Für jeden Client eigenen Thread starten
            ClientHandler handler = new ClientHandler(clientSocket);
            new Thread(handler).start();
        }
        // Server läuft dauerhaft, kann nur durch manuelles Stoppen (z.b. Prozess beenden) gestoppt werden.
    }
}