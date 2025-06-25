package at.campus02.pr3.network.beispiel3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ListenToSingleClient {
    // start via CommandLine (cmd): telnet localhost 9090
    public static void main(String[] args) throws IOException {
        System.out.println("Warte auf eingehende Verbindungen - Verbinde mit telnet localhost 9090");
        // We are working on localhost !!! = Hostname
        // We have configured Port 9090 for our ServerSocket Port
        // Test the Server Implementation with Putty Application or Telnet Command (see Tutorial within Moodle)
        ServerSocket serverSocket = new ServerSocket(9090);
        Socket socket = serverSocket.accept(); // Listens for a connection to be made to this socket and accepts it. The method blocks until a connection is made.

        BufferedWriter bufferedWriter =
                new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("HELLO");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        BufferedReader bufferedReader
                = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String command;
        while ((command = bufferedReader.readLine()) != null) {
            System.out.println(command);

            if ("TIME".equals(command)) {
                Calendar cal = GregorianCalendar.getInstance();
                bufferedWriter.write(cal.get(Calendar.HOUR_OF_DAY) + " : " + cal.get(Calendar.MINUTE) + " : " + cal.get(Calendar.SECOND));
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } else if ("PORT".equals(command)) {
                bufferedWriter.write("PORT: " + socket.getLocalPort()); // -> 9090
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } else if ("END".equals(command)) {
                bufferedWriter.write("BYE");
                bufferedWriter.newLine();
                bufferedWriter.flush();
                break;
            } else {
                bufferedWriter.write("unknown command");
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }

        bufferedReader.close();
        bufferedWriter.close();
        System.out.println("Beendet.");
    }
}
