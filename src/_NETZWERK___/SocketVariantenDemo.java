package _NETZWERK___;


import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class SocketVariantenDemo {

    public static void main(String[] args) throws IOException {

        // 1️⃣ Leeres Socket, später verbinden
        Socket socket1 = new Socket();
        System.out.println("Socket 1: unverbunden erstellt");

        // 2️⃣ Sofortige Verbindung zu Domain + Port
        Socket socket2 = new Socket("www.wetter.at", 80);
        System.out.println("Socket 2: Verbunden mit www.wetter.at:80");

        // 3️⃣ Verbindung über IP-Adresse als Byte-Array
        byte[] remAdr = { (byte)173, (byte)194, 35, (byte)152 }; // IP-Adresse (z.B. Google)
        InetAddress remoteAddress = InetAddress.getByAddress(remAdr);
        Socket socket3 = new Socket(remoteAddress, 80);
        System.out.println("Socket 3: Verbunden mit " + remoteAddress.getHostAddress() + ":80");

        // 4️⃣ Verbindung inkl. eigener lokaler IP + Port
        byte[] locAdr = { 10, 124, 79, 0 }; // Lokale IP aus eigenem Netzbereich
        InetAddress localAddress = InetAddress.getByAddress(locAdr);
        Socket socket4 = new Socket(remoteAddress, 80, localAddress, 8000);
        System.out.println("Socket 4: Verbunden über lokale IP " + localAddress.getHostAddress() + " mit Remote " + remoteAddress.getHostAddress());

        // Am Ende alle schließen
        socket1.close();
        socket2.close();
        socket3.close();
        socket4.close();
    }
}
