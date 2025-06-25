// 🔧 Das Programm ist ein einfacher TCP-Client, der sich mit einem Server auf localhost:9090 verbindet. 
// Es empfängt eine Begrüßungsnachricht, sendet den Befehl "TIME" an den Server und gibt die Server-Antwort aus.

package _NETZWERK___.server_with_SingleClient;

import java.io.*;
import java.net.Socket;

public class ClientToServer {

    public static void main(String[] args) {
        String command = "TIME";                                      // Befehl, der an den Server geschickt wird
        System.out.println("Connecting to Server");                   // Info auf Konsole ausgeben

        try {
            Socket socket = new Socket("localhost", 9090);  // TCP-Verbindung zum Server aufbauen (localhost, Port 9090)

            BufferedReader bufferedReader = new BufferedReader(       // Eingabestrom zum Lesen vom Server
                    new InputStreamReader(socket.getInputStream())
            );

            System.out.println("Reading from Server");                // Hinweis, dass jetzt gelesen wird
            System.out.println("Server first answer: " + bufferedReader.readLine());  // Begrüßungsnachricht vom Server lesen

            BufferedWriter bufferedWriter = new BufferedWriter(       // Ausgabestrom zum Schreiben an den Server
                    new OutputStreamWriter(socket.getOutputStream())
            );

            System.out.println("Send command: " + command + " to Server");   // Senden vorbereiten
            bufferedWriter.write(command);                                   // Befehl schreiben
            bufferedWriter.newLine();                                        // WICHTIG: Server erwartet Zeilenende-Symbol
            bufferedWriter.flush();                                          // Daten direkt losschicken

            System.out.println("Executed Command by Server: " + bufferedReader.readLine());  // Antwort vom Server lesen und ausgeben
            System.out.println("End of connection");                         // Verbindung fertig

        } catch (IOException e) {
            e.printStackTrace();                                             // Fehlerausgabe bei Problemen
        }
    }
}