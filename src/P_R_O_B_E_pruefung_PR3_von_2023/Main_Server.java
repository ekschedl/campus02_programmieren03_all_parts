package P_R_O_B_E_pruefung_PR3_von_2023;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*Empfohlenes Verhalten (wie echte Chat-Programme):
	•	Nach h (Hilfe): Server schickt Hilfe → Client zeigt es an → Benutzer darf wieder eingeben.
	•	Nach q (Beenden): Server verabschiedet sich → beide schließen.*/

public class Main_Server {
    public static void main(String[] args) {
        System.out.println("Hallo, hier ist das Netzwerk-Projekt");  // Begrüßung auf der Server-Konsole

        try (ServerSocket serverSocket = new ServerSocket(8787)) {  // Server lauscht auf Port 8787
            System.out.println("Server gestartet, wartet auf Verbindungen...");  // Info auf Konsole

            Socket clientSocket = serverSocket.accept();  // Blockiert hier bis sich ein Client verbindet
            System.out.println("Ein Client hat sich verbunden: " + clientSocket.getInetAddress()); // Zeigt IP vom Client

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));  // Ausgangsstrom zum Client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));     // Eingangsstrom vom Client

            // Begrüßung senden
            out.write("Hallo Client!\n");  // Erste Begrüßung
            out.write("Bitte Buchstaben eingeben: h - Hilfe bekommen, q - Programm beenden\n");  // Anweisungen
            out.flush();  // Alles losschicken

            String userChoice;
            while ((userChoice = in.readLine()) != null) {  // Solange Client Daten schickt
                if (userChoice.equalsIgnoreCase("h")) {  // Wenn "h" kommt
                    out.write("Das ist die Hilfe\n");  // Hilfe senden
                    out.flush();
                    System.out.println("Hilfe wurde an Client gesendet.");  // Auf Server-Konsole anzeigen
                } else if (userChoice.equalsIgnoreCase("q")) {  // Wenn "q" kommt
                    out.write("Auf Wiedersehen\n");  // Verabschiedung senden
                    out.flush();
                    System.out.println("Client hat das Programm beendet.");  // Server meldet Beenden
                    break;  // Server beendet Verbindung
                } else {
                    out.write("Ungültige Eingabe\n");  // Falls Eingabe unbekannt
                    out.flush();
                }
            }

            clientSocket.close();  // Verbindung schließen
            System.out.println("Ende des Netzwerk-Projekts");  // Server beendet sich

        } catch (IOException e) {
            e.printStackTrace();  // Fehlerbehandlung
        }
    }
}