package _FILE____IO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TextInZahlenUndZurueck_______K {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // 🔸 Eingabe eines Textes
        System.out.print("Gib einen Text ein: ");
        String text = scanner.nextLine();

        // 🔹 Zeige alle Kodierungen
        zeigeKodierungen(text);

        // 🔹 Speichere in UTF-16 Datei
        speichereAlsUTF16(text, "ausgabe/utf16_text.txt");

        // 🔹 Lies wieder aus UTF-16 Datei
        String gelesen = liesUTF16("ausgabe/utf16_text.txt");
        System.out.println("📖 Gelesen aus UTF-16 Datei: " + gelesen);

        // 🔸 ASCII-Zahlen zurückkonvertieren
        System.out.println("\nGib ASCII-Zahlen ein (z. B. 72 97 108 108 111):");
        String zahlenEingabe = scanner.nextLine();
        konvertiereZahlenZuTextUndSpeichere(zahlenEingabe, "ausgabe/wiederhergestellt.txt");
    }

    // 🔹 Text → ASCII / Binär / Hex / UTF-8 anzeigen
    public static void zeigeKodierungen(String text) throws UnsupportedEncodingException {
        System.out.println("\n🔡 Ursprünglicher Text: " + text);
        System.out.println("=".repeat(60));

        System.out.println("Dezimal (ASCII):");
        for (char c : text.toCharArray()) {
            System.out.print((int) c + " ");
        }
        System.out.println("\n");

        System.out.println("Binär (8 Bit):");
        for (char c : text.toCharArray()) {
            System.out.print(String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0') + " ");
        }
        System.out.println("\n");

        System.out.println("Hexadezimal:");
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

    // 🔹 ASCII-Zahlen → Text zurück + speichern
    public static void konvertiereZahlenZuTextUndSpeichere(String eingabe, String dateipfad) throws IOException {
        String[] teile = eingabe.trim().split("\\s+");
        byte[] bytes = new byte[teile.length];
        for (int i = 0; i < teile.length; i++) {
            try {
                bytes[i] = (byte) Integer.parseInt(teile[i]);
            } catch (NumberFormatException e) {
                System.out.println("❌ Ungültige Zahl: " + teile[i]);
                return;
            }
        }

        String text = new String(bytes, "UTF-8");
        System.out.println("✅ Wiederhergestellter Text: " + text);

        File file = new File(dateipfad);
        file.getParentFile().mkdirs(); // Ordner automatisch erstellen
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
        writer.write(text);
        writer.close();
        System.out.println("💾 Datei gespeichert: " + dateipfad);
    }

    // 🔹 Text → UTF-16 Datei speichern
    public static void speichereAlsUTF16(String text, String pfad) throws IOException {
        File file = new File(pfad);
        file.getParentFile().mkdirs();
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_16);
        writer.write(text);
        writer.close();
        System.out.println("✅ UTF-16 gespeichert in: " + pfad);
    }

    // 🔹 UTF-16 Datei lesen
    public static String liesUTF16(String pfad) throws IOException {
        InputStreamReader reader = new InputStreamReader(new FileInputStream(pfad), StandardCharsets.UTF_16);
        BufferedReader br = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append(System.lineSeparator());
        }
        br.close();
        return sb.toString().trim();
    }
}
