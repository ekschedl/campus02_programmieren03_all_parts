package P_R_O_B_E_pruefung_PR3_von_2023;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/*Empfohlene Verhalten (wie echte Chat-Programme):
	•	Nach h (Hilfe): Server schickt Hilfe → Client zeigt es an → Benutzer darf wieder eingeben.
	•	Nach q (Beenden): Server verabschiedet sich → beide schließen.*/

public class Main_Client {
    public static void main(String[] args) {
        System.out.println("Verbinde mit dem Server...");  // Info auf Konsole

        try (Socket socket = new Socket("localhost", 8787)) {  // Verbindung zum Server aufbauen (Port 8787)

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));  // Eingabestrom vom Server
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // Ausgabestrom zum Server
            Scanner scanner = new Scanner(System.in);  // Scanner für Benutzereingaben

            // Begrüßung lesen (zwei Zeilen)
            System.out.println("---> Server: " + bufferedReader.readLine());  // Erste Zeile vom Server lesen
            System.out.println("---> Server: " + bufferedReader.readLine());  // Zweite Zeile lesen (Anweisungen)

            // Solange der Server Daten sendet oder bis q kommt
            while (true) {
                System.out.print("(h/q): ");  // Benutzer zur Eingabe auffordern
                String userChoice = scanner.nextLine();  // Eingabe lesen

                // An Server schicken
                bufferedWriter.write(userChoice);  // Eingabe senden
                bufferedWriter.newLine();  // Wichtig: Zeilenumbruch für den Server
                bufferedWriter.flush();  // Senden abschließen

                // Antwort vom Server lesen
                String serverAntwort = bufferedReader.readLine();  // Antwort empfangen
                System.out.println("---> Server: " + serverAntwort);  // Antwort ausgeben

                if (userChoice.equalsIgnoreCase("q")) {  // Bei "q" wird beendet
                    break;
                }
            }

            System.out.println("Ende der Verbindung");  // Info: Verbindung beendet

        } catch (IOException e) {
            e.printStackTrace();  // Fehlerbehandlung
        }
    }
}