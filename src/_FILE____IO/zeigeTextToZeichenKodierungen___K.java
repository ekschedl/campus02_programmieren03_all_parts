package _FILE____IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class zeigeTextToZeichenKodierungen___K {

    public static void main(String[] args) throws IOException {
        // Text analysieren
        zeigeZeichenKodierungen("hallo");

        System.out.println("\nAufgabe textAusDezimalWertenErstellen   -----");
        // Dezimalwerte in Text umwandeln und speichern
        textAusDezimalWertenErstellen("104 97 22 1 104"); //frei gewählt
    }

    // 🔍 Zeichen in verschiedene Kodierungen anzeigen
    public static void zeigeZeichenKodierungen(String text) throws UnsupportedEncodingException {
        System.out.println("🔡 Ursprünglicher Text: " + text);
        System.out.println("=".repeat(60));

        System.out.println("Dezimalwerte (ASCII / UTF-8):");
        for (char c : text.toCharArray()) {
            System.out.print((int) c + " ");
        }
        System.out.println("\n");

        System.out.println("Binärwerte (8-Bit):");
        for (char c : text.toCharArray()) {
            System.out.print(String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0') + " ");
        }
        System.out.println("\n");

        System.out.println("Hexadezimalwerte:");
        for (char c : text.toCharArray()) {
            System.out.print(String.format("%02X", (int) c) + " ");
        }
        System.out.println("\n");

        System.out.println("UTF-8 Bytefolge:");
        byte[] utf8Bytes = text.getBytes("UTF-8");
        for (byte b : utf8Bytes) {
            System.out.print((b & 0xFF) + " ");
        }
        System.out.println();
    }

    // 🔁 Aus Dezimalwerten Text rekonstruieren & speichern
    public static void textAusDezimalWertenErstellen(String eingabe) throws IOException {
        String[] teile = eingabe.trim().split("\\s+");
        byte[] bytes = new byte[teile.length];
        for (int i = 0; i < teile.length; i++) {
            bytes[i] = (byte) Integer.parseInt(teile[i]);
        }

        String text = new String(bytes, "UTF-8");
        System.out.println("✅ Wiederhergestellter Text: " + text);

        OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream("wiederhergestellt.txt"), "UTF-8");
        writer.write(text);
        writer.close();
        System.out.println("💾 Datei gespeichert als 'wiederhergestellt.txt'");
    }
}