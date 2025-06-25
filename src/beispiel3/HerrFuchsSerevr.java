package beispiel3;

import java.io.*;
import java.net.Socket;

public class HerrFuchsSerevr {

    public static void main(String[] args) {
        String command = "hi from Katja"; // Der Befehl, der an den Server gesendet werden soll
        System.out.println("Connecting to Server"); // Infoausgabe: Verbindung wird aufgebaut

        try {
            // Verbindet sich mit dem Server unter der Adresse "bernhardfuchs.at" und dem Port 40061
            Socket socket = new Socket("bernhardfuchs.at", 40061); // localhost - aktueller Computer

            // Eingabestrom vom Server lesen (Antworten vom Server empfangen)
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            System.out.println("Reading from Server___"); // Infoausgabe
            // Liest die erste Zeile, die vom Server gesendet wird (z. B. Begrüßung)
            System.out.println("Server first answer: __" + bufferedReader.readLine());

            // Ausgabestrom zum Server schreiben (Nachrichten senden)
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())
            );

            System.out.println("Send command:__ " + command + " __to Server"); // Infoausgabe
            // Sendet den eigentlichen Befehl an den Server (z.B. "hi from Katja")
            bufferedWriter.write(command);
            bufferedWriter.newLine(); // wichtig: neue Zeile senden, damit der Server weiß, dass die Nachricht zu Ende ist
            bufferedWriter.flush(); // sorgt dafür, dass alles wirklich geschickt wird

            // Liest die Antwort des Servers auf den gesendeten Befehl
            System.out.println("Executed Command by Server:__ " + bufferedReader.readLine());

            System.out.println("End of connection__"); // Infoausgabe: Verbindung wird beendet

            // Sendet "END__" an den Server, um die Verbindung sauber zu schließen (Serverseitig definierte Beendigungsnachricht)
            bufferedWriter.write("END");
            bufferedWriter.newLine(); // wichtig: neue Zeile senden
            bufferedWriter.flush(); // schickt das tatsächlich raus

        } catch (IOException e) {
            // Fehlerbehandlung – falls Server nicht erreichbar oder Verbindungsfehler
            e.printStackTrace();
        }

    }
}