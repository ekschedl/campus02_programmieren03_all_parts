package _NETZWERK___.anfrage_VonKonsoleZumFuchsServer_Empfange_Mit_HintergrundThread;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Aufgabe 1)
        // verbinden zu bernhardfuchs.at und "Hallo von NAME"
        // an den Serverschreiben.

        // Aufgabe 2)
        // alle Nachrichten vom Server anzeigen
        // Aufgabe 3) Inputs von Konsole an server senden
        // Aufgabe 4) Erstellem Sie einen WorkerThread der alle 2 Sek
        // seinen Namen und "Ich bin ein Hintergrundthread" ausgibt.


        //Connecting to Server
        Socket socket = new Socket("bernhardfuchs.at", 40064);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        //Starting Thread START
        Thread t1 = new Thread(new WorkerThread(out));
        t1.start();
        //Starting Thread FERTIG

        out.write("Hallo von Bernhard" + System.lineSeparator());
        out.flush();
        String line;
        Scanner scanner = new Scanner(System.in);

        while ((line = in.readLine()) != null) // Alle Textnachrichten anzeigen
        {
            System.out.println(line);
            if (System.in.available() > 0) {
                out.write("Bernhard: "); //mein Name
                out.write(scanner.nextLine()); //Text von Konsole
                out.write(System.lineSeparator()); // Newline / Enter
                out.flush();
            }
        }
    }
}