package P_R_O_B_E_pruefung_PR3_von_2023;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*Empfohlenes Verhalten (wie echte Chat-Programme):
	•	Nach h (Hilfe): Server schickt Hilfe → Client zeigt es an → Benutzer darf wieder eingeben.
	•	Nach q (Beenden): Server verabschiedet sich → beide schließen.*/

public class Main_Server_speichern_append {

        public static void main(String[] args) {
            System.out.println("Hallo, hier ist das Netzwerk-Projekt");  // Begrüßung auf der Server-Konsole

            try (ServerSocket serverSocket = new ServerSocket(8787)) {  // Server lauscht auf Port 8787
                System.out.println("Server gestartet, wartet auf Verbindungen...");

                Socket clientSocket = serverSocket.accept();  // Warten auf Client
                System.out.println("Ein Client hat sich verbunden: " + clientSocket.getInetAddress());

                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                // Logdatei im Projektverzeichnis, im Append-Modus
                BufferedWriter protokoll = new BufferedWriter(new FileWriter("chat_protokoll_server.txt", true));
                protokoll.write("------ Neue Session gestartet ------\n");
                protokoll.flush();

                // Begrüßung senden
                out.write("Hallo Client!\n");
                out.write("Bitte Buchstaben eingeben: h - Hilfe bekommen, q - Programm beenden\n");
                out.flush();

                protokoll.write("Server: Hallo Client!\n");
                protokoll.write("Server: Bitte Buchstaben eingeben: h - Hilfe bekommen, q - Programm beenden\n");
                protokoll.flush();

                String userChoice;
                while ((userChoice = in.readLine()) != null) {  // Solange Client Daten schickt

                    protokoll.write("Client: " + userChoice + "\n");
                    protokoll.flush();

                    if (userChoice.equalsIgnoreCase("h")) {
                        out.write("Das ist die Hilfe\n");
                        out.flush();
                        protokoll.write("Server: Das ist die Hilfe\n");
                        protokoll.flush();
                        System.out.println("Hilfe wurde an Client gesendet.");
                    } else if (userChoice.equalsIgnoreCase("q")) {
                        out.write("Auf Wiedersehen\n");
                        out.flush();
                        protokoll.write("Server: Auf Wiedersehen\n");
                        protokoll.flush();
                        System.out.println("Client hat das Programm beendet.");
                        break;
                    } else {
                        out.write("Ungültige Eingabe\n");
                        out.flush();
                        protokoll.write("Server: Ungültige Eingabe\n");
                        protokoll.flush();
                    }
                }

                protokoll.write("------ Session beendet ------\n");
                protokoll.flush();
                protokoll.close();

                clientSocket.close();
                System.out.println("Ende des Netzwerk-Projekts");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }