package _NETZWERK___.testpruefung_loesung_src;

import java.io.*;
import java.net.Socket;

public class Main {
/*
✅ Du sendest Texte zum Server → landen auf Konsole & im Logfile
✅ Du empfängst Texte vom Server → landen auf Konsole & im Logfile
✅ Extra-Thread beobachtet im Hintergrund die Logdatei
✅ Mit “ende” brichst du alles sauber ab*/

    public static void main(String[] args) throws IOException, InterruptedException {
        //Verbindet dein Client-Programm zu bernhardfuchs.at auf Port 4006
//        Socket chatSocket = new Socket(
//                "bernhardfuchs.at", 40061);
        Socket chatSocket = new Socket("localhost", 9090);  // Verbindung zum Server aufbauen

        //Reader user input .Zum Einlesen von Text, den ich  auf der Konsole tippe.
        BufferedReader userInput = new BufferedReader(
                new InputStreamReader(System.in)
        );
        //Writer to chat. Zum Senden von Text über die Netzwerkverbindung an den Server
        PrintWriter chatOutput = new PrintWriter(
                new OutputStreamWriter(chatSocket.getOutputStream())
        );
        //Reader FROM chat.Zum Empfangen von Nachrichten, die vom Server ankommen
        BufferedReader chatInput = new BufferedReader(
                new InputStreamReader(chatSocket.getInputStream())
        );

        //Öffnet/erstellt eine Textdatei logfile.txt, dort wird ALLES protokolliert (gesendete & empfangene Daten).
        File logfile = new File("logfile.txt");
        FileWriter lofileWriter = new FileWriter(logfile);

        //ich übergebe dem Thread Objekt das logfoile im Comstructor
        //Startet einen extra Thread, der unabhängig im Hintergrund läuft.
        //Dieser MyFilesizeThread überprüft regelmäßig die Größe der Logdatei (steht in deiner anderen Klasse)
        Thread logfilesizeThread = new Thread(new _NETZWERK___.testpruefung_loesung_src.MyFilesizeThread(logfile));
        logfilesizeThread.start();

        while (true) {//Solange das Programm läuft, wiederholt sich Folgendes:
            //sind Daten vom USER verfügbar? -> Auf Konsole, in Logfile und zum globalen Chat schicken.
            String userInputString = "";
            while (userInput.ready()) {//Prüft, ob du was in die Konsole geschrieben hast.Wenn ja:
                userInputString = userInput.readLine(); //Text lesen

                //System.out.println("DEBUG: sende Text '" + userInputString
                //        + "' zu Chat...");
                chatOutput.println("---> DATEN GESENDET VON USER: " + userInputString);//Text zum Server schicken
                System.out.println("---> DATEN GESENDET VON USER: " + userInputString);//Text auf Konsole anzeigen

                //Text ins Logfile schreiben
                chatOutput.flush();
                lofileWriter.write("---> DATEN GESENDET VON USER: " + userInputString + "\n");
                lofileWriter.flush();
            }
            //Möchte der USER das ganze Programm beenden?
            //dieses if MUSS hier sein, damit wir aus der äußersten while()
            //schleife springen können.
            //Möglichkeit aus einem nested loop ganz hinaus zu springen:
            //(Hinweis: man muss dem außersten einfach einen Namen geben)
            //https://stackoverflow.com/questions/886955/how-do-i-break-out-of-nested-loops-in-java
            // Möglichkeit zum Beenden:
            if (userInputString.equalsIgnoreCase("ende")) {//Wenn man “ende” egal ob groß/klein geschrieben eintippt
                System.out.println("USER HAT ENDE EINGEGEBEN; BEENDE ALLES.");
                System.out.println("Beende logfilesizeThread...");
                logfilesizeThread.interrupt(); //Hintergrund-Thread wird mit logfilesizeThread.interrupt(); gestoppt
                System.out.println("ChatProgramm beendet sich.");
                //System.exit(0);
                break; // gehe aus der Hauptschleife
            }
            //sind Daten vom Chat verfügbar? -> auf Konsole schreiben
            //also Empfang von Nachrichten vom Server
//            if (chatInput.ready()) {//wenn ja:
//                System.out.println("<--- DATEN VON CHAT: " + chatInput.readLine());//Nachricht anzeigen
//                lofileWriter.write("<--- DATEN VON CHAT: " + chatInput.readLine()
//                        + "\n"); //Nachricht ins Logfile schreiben
//                lofileWriter.flush();
//            }

            if (chatInput.ready()) {//oben variante mit herrn fuchs, hier musste ich anpassen
                String serverAntwort = chatInput.readLine();
               // System.out.println("<--- DATEN VON CHAT: " + serverAntwort);
                lofileWriter.write("<--- DATEN VON CHAT: " + serverAntwort + "\n");
                lofileWriter.flush();
            }
            //Das Hauptprogramm pausiert 1 Sekunde, damit es den Prozessor nicht überlastet.
            Thread.sleep(1000);
        }
    }
}
