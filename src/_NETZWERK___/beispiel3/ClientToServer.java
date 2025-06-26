package _NETZWERK___.beispiel3;

import java.io.*;
import java.net.Socket;

public class ClientToServer {

    public static void main(String[] args) {
        String command = "TIME";
        System.out.println("Connecting to Server");
        try {
            Socket socket = new Socket("localhost", 9090); // localhost -aktueller Computer
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Reading from Server___");
            System.out.println("Server first answer: __" + bufferedReader.readLine());
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("Send command:__ " + command + " __to Server");
            bufferedWriter.write(command);
            bufferedWriter.newLine(); // important!
            bufferedWriter.flush();
            System.out.println("Executed Command by Server:__ " + bufferedReader.readLine());
            System.out.println("End of connection__");
            bufferedWriter.write("END__");
            bufferedWriter.newLine(); //important
            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
