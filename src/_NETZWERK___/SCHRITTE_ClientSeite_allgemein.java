package _NETZWERK___;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

// CLIENT-SEITE SCHRITTWEISE



public class SCHRITTE_ClientSeite_allgemein {
    public static void main(String[] args) throws IOException {
        // Schritt 1: Verbindung aufbauen
        Socket socket = new Socket("localhost", 9090);
        System.out.println("Verbunden mit Server.");

        // Schritt 2: Reader und Writer vorbereiten
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner scanner = new Scanner(System.in);

        // Schritt 3: Begrüßung vom Server lesen
        System.out.println("Server sagt: " + in.readLine());

        // Schritt 4: Nachricht senden
        System.out.print("Nachricht an Server: ");
        String nachricht = scanner.nextLine();
        out.write(nachricht + "\n");
        out.flush();

        // Schritt 5: Antwort lesen
        System.out.println("Server antwortet: " + in.readLine());

        // Schritt 6: Aufräumen
        in.close();
        out.close();
        socket.close();
        System.out.println("Verbindung beendet.");
    }
}
