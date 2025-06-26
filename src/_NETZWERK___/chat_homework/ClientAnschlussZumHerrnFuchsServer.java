package _NETZWERK___.chat_homework;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/*Was macht das ganze Programm?
	1.	Baut eine Verbindung zu einem Server auf
	2.	Fragt dich: Was willst du schicken?
	3.	Schickt deine Nachricht
	4.	Wartet auf Antwort
	5.	Zeigt dir Antwort
	6.	Schreibt alles (senden + empfangen) in eine Datei
	7.	Beendet sich, wenn ich ENDE schreibe,  aber selbst ZEile ENde kommt nicht  in die Datei mit chat */
public class ClientAnschlussZumHerrnFuchsServer {

    public static void main(String[] args) {
        System.out.println("... Verbindung wird aufgebaut");

        try (
                // Versuche eine Verbindung zu einem Server im Internet aufzubauen
                Socket socket = new Socket("bernhardfuchs.at", 40061);

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream())); //Lesegerät, mit dem ich Antworten vom Server lesen kann. (als Text)
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // Schreibgerät, mit dem ich dem Server Nachrichten schicken kann.
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter("/Users/kaaatkina/CAMPUS02_2025/Programmieren_3/src/chat_homework/chat_log2.txt", true)); // Datei für Speichern von Chat
                Scanner scanner = new Scanner(System.in) //Tastaturleser – der Computer fragt  Was möchtest du sagen? und liest, was ich tippe
        ) {
            // Mien LogWatcher (implements Runnable) zeigt alle 5 Sekunden, wie groß die Chat-Datei schon ist
            LogWatcher watcher = new LogWatcher("/Users/kaaatkina/CAMPUS02_2025/Programmieren_3/src/chat_homework/chat_log2.txt");
            Thread watcherThread = new Thread(watcher);
            watcherThread.start(); //Der Hintergrundthread watcherThread mit Task watcher startet

            // ServerListener starten – hört ständig auf neue Nachrichten vom Server
            ServerListener listener = new ServerListener(bufferedReader, fileWriter);
            Thread listenerThread = new Thread(listener);
            listenerThread.start();

            // Begrüßung anzeigen
            System.out.println("Juhu! Verbindung ist da, du kannst jetzt losschreiben");

            while (true) { // Endlosschleife – so ich kann immer wieder was schreiben, solange ich nicht end schreibe.
                System.out.print("Text zum Senden eingeben ---> : ");
                String nachricht = scanner.nextLine(); // // Ich tippe meine Nachricht ein und es wird in variable  Nachricht gespeicherrt


                // Wenn ENDE eingebe - wird das Programm beenden
                if (nachricht.equalsIgnoreCase("Ende")) {
                    listener.stopListening();     // Sag dem ServerListener, er soll aufhören zuzuhören
                    watcher.hoefflichStoppen();   // Sag dem LogWatcher, er soll aufhören mit der Größenanzeige
                    listenerThread.join();        // Warte, bis der ServerListener sauber beendet ist
                    watcherThread.join();         // Warte, bis der LogWatcher auch sauber gestoppt ist
                    break; // Beende die Schleife - Programmende
                }

                // Wenn es keine "Ende"-Nachricht war, dann → Nachricht an den Server senden
                bufferedWriter.write(nachricht);
                bufferedWriter.newLine();
                bufferedWriter.flush(); // Nachricht sofort wirklich losschicken

                System.out.println("von User gesendet: --> " + nachricht); // Info für mich in der Konsole

                // Nachricht zusätzlich in die Datei schreiben
                fileWriter.write("---> " + nachricht); // füge "Pfeil + Nachricht" zur Datei hinzu
                fileWriter.newLine();                  // mach einen Zeilenumbruch
                fileWriter.flush();                    // sage dem Computer: "Jetzt wirklich in die Datei schreiben!"


            }
            // Sobald die Schleife endet  zeige, dass alles fertig ist
            System.out.println("User hat ENDE eingegeben: ---> Verbindung wird geschlossen.");

        } catch (IOException | InterruptedException e) { // Falls irgendwo ein Fehler passiert
            e.printStackTrace();
        }
    }
}