package at.campus02.pr3.network.beispiel4;


import java.io.*;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CommunicationTask implements Runnable {

    private Socket socket;

    public CommunicationTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Client Port " + socket.getPort());
        System.out.println(Thread.currentThread().getName() + " wurde gestartet.");
        try {
            // Server-Antwort zum Kunden
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("HELLO");
            bufferedWriter.newLine();
            bufferedWriter.flush();

            // Einlesen von Input vom Client über Putty/Telnet/Java-Programm
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String command;
            while ((command = bufferedReader.readLine()) != null) {
                System.out.println(Thread.currentThread().getName() + " führt folgendes Kommando aus -> "
                        + command);
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
            System.out.println(Thread.currentThread().getName() + " wurde beendet.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
