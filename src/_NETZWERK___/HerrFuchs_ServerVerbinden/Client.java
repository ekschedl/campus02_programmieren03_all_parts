package _NETZWERK___.HerrFuchs_ServerVerbinden;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Client{
    public static void main(String[] args) throws IOException {
        // Aufgabe 1)
        // verbinden zu bernhardfuchs.at und "Hallo von NAME"
        // an den Serverschreiben.

        // Aufgabe 2)
        // alle Nachrichten vom Server anzeigen
        // Aufgabe 3) Inputs von Konsole an server senden
        Socket socket = new Socket("bernhardfuchs.at", 40061);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        out.write("Hallo von Katja Sch" + System.lineSeparator());

        WorkerThread wt = new WorkerThread();
        Thread backgroundThread = new Thread(wt);
        backgroundThread.start();
        

        out.flush();
        String line;
        Scanner scanner = new Scanner(System.in);


        while ((line = in.readLine()) != null) // Alle Textnachrichten anzeigen
        {
            System.out.println(line);
            if (System.in.available() > 0) {
                out.write("Katja: "); //mein Name
                out.write(scanner.nextLine()); //Text von Konsole
                out.write(System.lineSeparator()); // Newline / Enter
                out.flush();
            }
        }
    }
}
