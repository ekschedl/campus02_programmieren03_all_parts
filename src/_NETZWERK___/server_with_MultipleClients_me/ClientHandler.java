package _NETZWERK___.server_with_MultipleClients_me;

import java.io.*;
import java.net.Socket;
/*
✅ Mehrere Clients parallel
✅ Server bleibt aktiv
✅ exit trennt nur den jeweiligen Client
✅ Protokollierung der Chats*
 */
class ClientHandler implements Runnable {

    private Socket clientSocket;
    private BufferedWriter protokoll;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;

        try {
            // Logfile im Append-Modus öffnen
            protokoll = new BufferedWriter(new FileWriter("/Users/kaaatkina/CAMPUS02_2025/Programmieren_3/src/_NETZWERK___/server_with_MultipleClients_me/multiClients_chatlog.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            out.write("Hallo Client!\n");
            out.flush();

            String nachricht;
            while ((nachricht = in.readLine()) != null) {
                System.out.println("Empfangen von " + clientSocket.getInetAddress() + ": " + nachricht);
                protokoll.write("Client [" + clientSocket.getInetAddress() + "]: " + nachricht + "\n");
                protokoll.flush();

                if (nachricht.equalsIgnoreCase("exit")) {
                    out.write("Verbindung wird beendet.\n");
                    out.flush();
                    break;
                }

                out.write("Server sagt: " + nachricht + "\n");
                out.flush();
            }

            protokoll.close();
            in.close();
            out.close();
            clientSocket.close();
            System.out.println("Client " + clientSocket.getInetAddress() + " getrennt.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}