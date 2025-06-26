package _NETZWERK___.FUCHS_Test_pruefung_loesung_src;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/*
✅ Du verwendest new ServerSocket(9090); → das bedeutet, dieses Programm ist der Server.
✅ Der Server wartet auf eingehende Verbindungen: serverSocket.accept();
✅ Danach liest er Nachrichten vom Client und schickt sie wieder zurück → Echo-Server-Verhalten*/
public class MainLokalerEchoServer {
    public static void main(String[] args) {
        try {
            /*	•	Server öffnet ServerSocket zum Lauschen
                •	Client baut mit Socket Verbindung auf
                •	Server bekommt über accept() ebenfalls ein Socket für den einzelnen Client*/

            ServerSocket serverSocket = new ServerSocket(9090);
            System.out.println("Server läuft auf Port 9090, wartet auf Verbindungen...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client verbunden: " + clientSocket.getInetAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            String nachricht;
            while ((nachricht = in.readLine()) != null) {
                System.out.println("Empfangen vom Client: " + nachricht);

                // Nachricht zurück an Client senden
                out.write("Server sagt: " + nachricht);
                out.newLine();
                out.flush();
            }

            // Verbindungen schließen
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();

            System.out.println("Server beendet.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}