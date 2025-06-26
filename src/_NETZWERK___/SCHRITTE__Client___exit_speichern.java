package _NETZWERK___;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class SCHRITTE__Client___exit_speichern {


        public static void main(String[] args) throws IOException {

            Socket socket = new Socket("localhost", 9090);
            System.out.println("Verbunden mit Server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Scanner scanner = new Scanner(System.in);

            // Begrüßung vom Server lesen
            System.out.println("Server sagt: " + in.readLine());

            String nachricht;
            while (true) {
                System.out.print("Nachricht an Server (exit zum Beenden): ");
                nachricht = scanner.nextLine();

                out.write(nachricht + "\n");
                out.flush();

                String antwort = in.readLine();
                System.out.println("Server antwortet: " + antwort);

                if (nachricht.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            in.close();
            out.close();
            socket.close();
            System.out.println("Verbindung beendet.");
        }
    }
