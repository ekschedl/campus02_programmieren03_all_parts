package _NETZWERK___.localServer_Client_mit_HintergrundThread;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainClientOhneHintergrundNachrichten___chat_speichern_einzeln {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 9090);
            System.out.println("Verbunden mit Server");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Scanner scanner = new Scanner(System.in);

            // Dateiname generieren - Jede Session bekommt eigene Datei
            String zeit = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String dateiname = "/Users/kaaatkina/CAMPUS02_2025/Programmieren_3/src/_NETZWERK___/localServer_Client_mit_HintergrundThread/chat_protokoll_" + zeit + ".txt";

            BufferedWriter protokoll = new BufferedWriter(new FileWriter(dateiname));

            // Begrüßung schicken
            out.write("Hallo vom Client");
            out.newLine();
            out.flush();

            // Extra Thread für Konsolen-Eingabe → blockiert Hauptprogramm nicht
            Thread eingabeThread = new Thread(() -> {
                try {
                    while (true) {
                        String eingabe = scanner.nextLine();
                        out.write(eingabe);
                        out.newLine();
                        out.flush();

                        protokoll.write("Ich: " + eingabe);
                        protokoll.newLine();
                        protokoll.flush();
                    }
                } catch (IOException e) {
                    System.out.println("Eingabe-Thread beendet.");
                }
            });
            eingabeThread.start();

            // Haupt-Thread liest Nachrichten vom Server
            String empfangen;
            while ((empfangen = in.readLine()) != null) {
                System.out.println("Vom Server: " + empfangen);
                protokoll.write("Server: " + empfangen);
                protokoll.newLine();
                protokoll.flush();
            }

            protokoll.write("--- Chat beendet ---");
            protokoll.newLine();
            protokoll.close();
            socket.close();
            System.out.println("Verbindung geschlossen, Chat gespeichert in: " + dateiname);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}