package _NETZWERK___.localServer_Client_mit_HintergrundThread;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MainClientMitHintergrund {
    public static void main(String[] args) {

        try {
            // Verbindung zum lokalen Server aufbauen (Port muss gleich wie am Server sein)
            Socket socket = new Socket("localhost", 9090);
            System.out.println("Verbunden mit Server auf Port 9090");

            // Streams für Kommunikation vorbereiten
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Scanner scanner = new Scanner(System.in);

            // Hintergrund-Thread starten
            Thread background = new Thread(new WorkerThread(out));
            background.start();

            // Begrüßung senden
            out.write("Hallo vom Client");
            out.newLine();
            out.flush();

            // Empfangen und Konsoleingaben verarbeiten
            String empfangen;
            while ((empfangen = in.readLine()) != null) {
                System.out.println("Vom Server: " + empfangen);

                // Benutzer darf jederzeit Text eingeben und an Server schicken
                if (System.in.available() > 0) {
                    String eingabe = scanner.nextLine();
                    out.write(eingabe);
                    out.newLine();
                    out.flush();
                }
            }

            // Verbindung schließen
            socket.close();
            System.out.println("Verbindung beendet.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}