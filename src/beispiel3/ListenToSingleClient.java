package beispiel3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ListenToSingleClient {

    public static void main(String[] args) throws IOException {

        System.out.println("Starte Server auf Port 9090...");

        ServerSocket serverSocket = new ServerSocket(9090);  // Server öffnet Port 9090
        Socket socket = serverSocket.accept();               // Wartet auf eingehenden Client

        System.out.println("Verbindung aufgebaut von " + socket.getInetAddress());

        // Output zum Client
        BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream())
        );
        bufferedWriter.write("HELLO");  // Begrüßung
        bufferedWriter.newLine();
        bufferedWriter.flush();

        // Input vom Client
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );

        String command;
        while ((command = bufferedReader.readLine()) != null) {
            System.out.println("Empfangenes Kommando: " + command);

            if ("TIME".equals(command)) {
                Calendar cal = GregorianCalendar.getInstance();
                bufferedWriter.write(cal.get(Calendar.HOUR_OF_DAY) + " : " +
                        cal.get(Calendar.MINUTE) + " : " + cal.get(Calendar.SECOND));
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } else if ("END__".equals(command)) {
                bufferedWriter.write("BYE");
                bufferedWriter.newLine();
                bufferedWriter.flush();
                break;
            } else {
                bufferedWriter.write("Unbekanntes Kommando");
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }

        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        serverSocket.close();

        System.out.println("Verbindung beendet.");
    }
}