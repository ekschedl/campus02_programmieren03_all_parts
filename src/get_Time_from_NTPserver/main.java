package get_Time_from_NTPserver;  //version me

import java.io.InputStream;
import java.net.Socket;
import java.util.Date;

public class main {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("time-a-g.nist.gov", 37);
            InputStream input = socket.getInputStream();

            byte[] bytes = new byte[4];
            input.read(bytes);

            // Zeit seit 1900 in Sekunden (als unsigned int)
            long secondsSince1900 = ((bytes[0] & 0xFFL) << 24) |
                    ((bytes[1] & 0xFFL) << 16) |
                    ((bytes[2] & 0xFFL) << 8) |
                    (bytes[3] & 0xFFL);

            // Zeitverschiebung zur UNIX-Zeit (ab 1970)
            long secondsSince1970 = secondsSince1900 - 2208988800L;

            // In Millisekunden umwandeln und ausgeben
            Date date = new Date(secondsSince1970 * 1000);
            System.out.println("Zeit vom Server via Port 37: " + date);

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



/*
package get_Time_from_NTPserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class main {
    public static void main(String[] args) {
        try {
            // Port 13: Daytime Protocol (liefert Zeit als Text)
            Socket timeSocket = new Socket("time.nist.gov", 13);
            BufferedReader timeIn = new BufferedReader(
                    new InputStreamReader(timeSocket.getInputStream())
            );

            String line;
            while ((line = timeIn.readLine()) != null) {
                System.out.println("Zeit vom Server via Port 13: " + line);
            }

            timeIn.close();
            timeSocket.close();
        } catch (IOException e) {
            System.out.println("Fehler beim Verbinden mit dem Zeitserver:");
            e.printStackTrace();
        }
    }
}
*/
