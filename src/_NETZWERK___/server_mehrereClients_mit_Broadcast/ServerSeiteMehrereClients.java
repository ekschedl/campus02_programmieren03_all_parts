package _NETZWERK___.server_mehrereClients_mit_Broadcast;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerSeiteMehrereClients {

    // Liste für alle Client-Writer
    static List<BufferedWriter> alleClients = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("Server läuft, wartet auf Verbindungen...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Neuer Client verbunden: " + clientSocket.getInetAddress());

            // Thread pro Client starten
            new Thread(new ClientHandler(clientSocket)).start();
        }
    }
}
//	Kann dein Server mehrere Clients parallel annehmen? → ✅ Mit Threads gelöst.
//	•	Kannst du Nachrichten empfangen und zurückschicken? → ✅ Dein Server sendet an jeden Client eine Antwort.
//	•	Kannst du Logs speichern? → ✅ Machst du mit protokoll.write.
//	•	Muss der Server permanent laufen? → ✅ Hast du korrekt umgesetzt.
//	•	Braucht jeder Client ein neues Socket? → ✅ Auch das passt bei dir.
//
//Mein Tipp für die Prüfung:
//
//        ✔ Baue das so wie jetzt mit Threads.
//✔ Erkläre: „Jeder Client läuft in eigenem Thread, der Server bleibt offen für neue Clients.“
//        ✔ Zeige, dass du Logs speicherst.
//        ✔ Sag dazu: „Ich habe für die Tests nc genommen, es zeigt Nachrichten an, wenn ich was eintippe, das reicht für Demonstration.“

//⸻