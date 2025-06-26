package _NETZWERK___.server_mehrereClients_mit_Broadcast;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientSeite {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9090);
            System.out.println("Verbunden mit Server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Scanner scanner = new Scanner(System.in);

            // Begrüßung vom Server lesen
            System.out.println("Server sagt: " + in.readLine());

            while (true) {
                System.out.print("Nachricht an Server (exit zum Beenden): ");
                String nachricht = scanner.nextLine();

                out.write(nachricht + "\n");
                out.flush();

                String serverAntwort = in.readLine();
                System.out.println("Server antwortet: " + serverAntwort);

                if (nachricht.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            in.close();
            out.close();
            socket.close();
            System.out.println("Verbindung beendet.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
