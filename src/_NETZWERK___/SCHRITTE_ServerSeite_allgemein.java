package _NETZWERK___;

// SERVER-SEITE SCHRITTWEISE

import java.io.*;
import java.net.*;

public class SCHRITTE_ServerSeite_allgemein {
    public static void main(String[] args) throws IOException {
        // Schritt 1: ServerSocket erstellen
        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("Server läuft, wartet auf Verbindungen...");

        // Schritt 2: Auf Client warten
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client verbunden.");

        // Schritt 3: Reader und Writer vorbereiten
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        // Schritt 4: Begrüßung senden
        out.write("Hallo Client!\n");
        out.flush();

        // Schritt 5: Nachrichten empfangen und antworten
        String nachricht;
        while ((nachricht = in.readLine()) != null) {
            System.out.println("Empfangen vom Client: " + nachricht);
            out.write("Server sagt: " + nachricht + "\n");
            out.flush();
        }
        // ----------------MIT SCHLIEFE  mit exit :
        /*
        // Schritt 5: Nachrichten empfangen und antworten
        while (true) {
            String nachricht = in.readLine();
            if (nachricht == null || nachricht.equalsIgnoreCase("exit")) break;
            System.out.println("Empfangen vom Client: " + nachricht);
            out.write("Server sagt: " + nachricht + "\n");
            out.flush();
        }*/


        // Schritt 6: Aufräumen
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
        System.out.println("Server beendet.");
    }
}
