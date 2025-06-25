package at.campus02.pr3.network.beispiel4;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class ListenToMultipleClients {

    public static void main(String[] args) {
        List<Thread> clients = new ArrayList<>();

        System.out.println("Starte Server ...");

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(9090);
            serverSocket.setSoTimeout(30000); // 30 sek
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                Thread thread = new Thread(new CommunicationTask(socket)); // Worker Class -> Runnalbe implementation
                thread.start();
                clients.add(thread);
            } catch (SocketTimeoutException e) {
                System.out.println("Server TIMEOUT");
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (Thread t : clients) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("ENDE");
    }
}

