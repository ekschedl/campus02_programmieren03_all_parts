package _NETZWERK___.localServer_Client_mit_HintergrundThread;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MainClientMitHintergrund___chat_speichern_OHNE_EndNotice {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9090);  // Verbindung zum Server aufbauen
            System.out.println("Verbunden mit Server auf Port 9090");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Scanner scanner = new Scanner(System.in);

            // Logdatei vorbereiten
            BufferedWriter logWriter = new BufferedWriter(new FileWriter("/Users/kaaatkina/CAMPUS02_2025/Programmieren_3/src/_NETZWERK___/anfrage_VonKonsoleZumServer_Empfange_Mit_HintergrundThread/_netzwerk___chatlog.txt", true)); // true = anhängen

            // Hintergrundthread starten
            Thread background = new Thread(new WorkerThread(out));
            background.start();

            // Begrüßung senden
            out.write("Hallo vom Client");
            out.newLine();
            out.flush();

            logWriter.write("Client verbunden und Begrüßung gesendet.");
            logWriter.newLine();
            logWriter.flush();

            String empfangen;
            while ((empfangen = in.readLine()) != null) {
                System.out.println("Vom Server: " + empfangen);
                logWriter.write("Server: " + empfangen);
                logWriter.newLine();
                logWriter.flush();

                // Prüfen auf Benutzereingabe
                if (System.in.available() > 0) {
                    String eingabe = scanner.nextLine();

                    // Wenn "exit", nur sauber schließen, keine Nachricht senden
                    if (eingabe.equalsIgnoreCase("exit")) {
                        logWriter.close();
                        out.close();
                        in.close();
                        socket.close();
                        System.out.println("Verbindung beendet, Chat gespeichert.");
                        break;
                    }

                    // Normale Nachricht senden
                    out.write(eingabe);
                    out.newLine();
                    out.flush();
                    logWriter.write("Ich: " + eingabe);
                    logWriter.newLine();
                    logWriter.flush();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}