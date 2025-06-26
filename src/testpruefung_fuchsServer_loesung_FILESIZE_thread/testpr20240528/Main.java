package testpruefung_fuchsServer_loesung_FILESIZE_thread.testpr20240528;

import java.io.*;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket chatSocket = new Socket(
                "bernhardfuchs.at", 40064);
        //Reader user input
        BufferedReader userInput = new BufferedReader(
                new InputStreamReader(System.in)
        );
        //Writer to chat
        PrintWriter chatOutput = new PrintWriter(
                new OutputStreamWriter(chatSocket.getOutputStream())
        );
        //Reader FROM chat
        BufferedReader chatInput = new BufferedReader(
                new InputStreamReader(chatSocket.getInputStream())
        );
        File logfile = new File("logfile.txt");
        FileWriter lofileWriter = new FileWriter(logfile);

        //ich übergebe dem Thread Objekt das logfoile im Comstructor
        Thread logfilesizeThread = new Thread(new MyFilesizeThread(logfile));
        logfilesizeThread.start();

        while (true) {
            //sind Daten vom USER verfügbar? -> Auf Konsole, in Logfile und zum globalen Chat schicken.
            String userInputString = "";
            while (userInput.ready()) {
                userInputString = userInput.readLine();

                //System.out.println("DEBUG: sende Text '" + userInputString
                //        + "' zu Chat...");
                chatOutput.println("---> DATEN GESENDET VON USER: " + userInputString);
                System.out.println("---> DATEN GESENDET VON USER: " + userInputString);
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
            if (userInputString.equalsIgnoreCase("ende")) {
                System.out.println("USER HAT ENDE EINGEGEBEN; BEENDE ALLES.");
                System.out.println("Beende logfilesizeThread...");
                logfilesizeThread.interrupt();
                System.out.println("ChatProgramm beendet sich.");
                //System.exit(0);
                break; // gehe aus der Hauptschleife
            }
            //sind Daten vom Chat verfügbar? -> auf Konsole schreiben
            if (chatInput.ready()) {
                System.out.println("<--- DATEN VON CHAT: " + chatInput.readLine());
                lofileWriter.write("<--- DATEN VON CHAT: " + chatInput.readLine()
                        + "\n");
                lofileWriter.flush();
            }
            Thread.sleep(1000);
        }
    }
}
