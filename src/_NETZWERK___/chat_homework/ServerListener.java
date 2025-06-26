package _NETZWERK___.chat_homework;

import java.io.*;

public class ServerListener implements Runnable {
    private final BufferedReader reader;
    private final BufferedWriter fileWriter;
    private volatile boolean listening = true;

    public ServerListener(BufferedReader reader, BufferedWriter fileWriter) {
        this.reader = reader;
        this.fileWriter = fileWriter;
    }

    @Override
    public void run() {
        try {
            String line;
            while (listening && (line = reader.readLine()) != null) {
                System.out.println("<--- DATEN VOM CHAT: " + line);

                // Schreibe die empfangene Nachricht auch ins Logfile
                fileWriter.write("<--- " + line);
                fileWriter.newLine();
                fileWriter.flush();
            }
        } catch (IOException e) {
            System.out.println("Verbindung zum Server verloren oder geschlossen.");
        }
    }

    public void stopListening() {
        listening = false;
    }
}