package _NETZWERK___.localServer_Client_mit_HintergrundThread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MainLokalerEchoServer {
    public static void main(String[] args) {
        try {
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