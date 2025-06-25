package _NETZWERK___.localServer_Client_mit_HintergrundThread;


import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainClientMitHintergrund___chat_speichern_einzeln_exit {

    public static void main(String[] args) {

        String dateiname = "";  // Muss global sein für später
        Thread hintergrund = null;

        try {
            Socket socket = new Socket("localhost", 9090);
            System.out.println("Verbunden mit Server");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Scanner scanner = new Scanner(System.in);

            // Dateiname generieren - Jede Session bekommt eigene Datei
            String zeit = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            dateiname = "/Users/kaaatkina/CAMPUS02_2025/Programmieren_3/src/_NETZWERK___/localServer_Client_mit_HintergrundThread/chat_protokoll_" + zeit + ".txt";
            BufferedWriter protokoll = new BufferedWriter(new FileWriter(dateiname));

            // Hintergrund-Thread starten
            hintergrund = new Thread(new WorkerThread(out));
            hintergrund.start();

            // Begrüßung schicken
            out.write("Hallo vom Client");
            out.newLine();
            out.flush();

            String empfangen;
            while ((empfangen = in.readLine()) != null) {
                System.out.println("Vom Server: " + empfangen);
                protokoll.write("Server: " + empfangen);
                protokoll.newLine();
                protokoll.flush();

                // Benutzer darf Text eingeben
                if (System.in.available() > 0) {
                    String eingabe = scanner.nextLine();

                    if (eingabe.equalsIgnoreCase("exit")) {
                        out.write(eingabe);
                        out.newLine();
                        out.flush();
                        hintergrund.interrupt();
                        System.out.println("Beende Chat...");
                        break;
                    }

                    out.write(eingabe);
                    out.newLine();
                    out.flush();

                    protokoll.write("Ich: " + eingabe);
                    protokoll.newLine();
                    protokoll.flush();
                }
            }

            protokoll.write("--- Chat beendet ---");
            protokoll.newLine();
            protokoll.flush();
            protokoll.close();
            socket.close();

        } catch (IOException e) {
            System.out.println("Verbindung unterbrochen.");
        } finally {
            System.out.println("Verbindung beendet, Chat gespeichert in: " + dateiname);
        }
    }
}