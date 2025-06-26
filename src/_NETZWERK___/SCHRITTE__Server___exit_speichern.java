package _NETZWERK___;


import java.io.*;
import java.net.*;

    public class SCHRITTE__Server___exit_speichern {
        public static void main(String[] args) throws IOException {

            ServerSocket serverSocket = new ServerSocket(9090);
            System.out.println("Server läuft, wartet auf Verbindungen...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client verbunden: " + clientSocket.getInetAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            BufferedWriter protokoll = new BufferedWriter(new FileWriter("chatlog.txt", true)); // Logfile öffnen (append)

            out.write("Hallo Client!\n");
            out.flush();

            String nachricht;
            while ((nachricht = in.readLine()) != null) {
                System.out.println("Empfangen vom Client: " + nachricht);
                protokoll.write("Client: " + nachricht + "\n");
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
            serverSocket.close();
            System.out.println("Server beendet.");
        }
    }