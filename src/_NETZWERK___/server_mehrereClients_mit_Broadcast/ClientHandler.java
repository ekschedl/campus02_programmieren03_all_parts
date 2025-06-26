package _NETZWERK___.server_mehrereClients_mit_Broadcast;

import java.io.*;
import java.net.Socket;

class ClientHandler implements Runnable {

    private Socket socket;
    private BufferedWriter out;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // Writer zur Liste hinzufügen
            ServerSeiteMehrereClients.alleClients.add(out);

            out.write("Willkommen im Chat!\n");
            out.flush();

            String nachricht;
            while ((nachricht = in.readLine()) != null) {
                System.out.println("Empfangen von " + socket.getInetAddress() + ": " + nachricht);

                // Nachricht an alle Clients senden
                broadcast("[" + socket.getInetAddress() + "]: " + nachricht);

                if (nachricht.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            // Aufräumen
            in.close();
            out.close();
            socket.close();
            ServerSeiteMehrereClients.alleClients.remove(out);
            System.out.println("Client " + socket.getInetAddress() + " getrennt.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void broadcast(String message) {
        synchronized (ServerSeiteMehrereClients.alleClients) {
            for (BufferedWriter writer : ServerSeiteMehrereClients.alleClients) {
                try {
                    writer.write(message + "\n");
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

