package _FILE____IO;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class _00___BinaerDatei_sammlung____und_etwas_kodierung__B_K {
    public static void main(String[] args) {
        try {
            // Anwendung für Methode 5 – zufällige Bytes schreiben
            zufallsBytesSchreiben("random_bytes.bin");

            // Anwendung für Methode 1 – Binärdatei als Zeichen ausgeben
            binaerDateiLesenUndAlsZeichenAusgeben("random_bytes.bin");

            // Anwendung für Methode 2 – Datei kopieren
            dateiByteweiseKopieren("random_bytes.bin", "kopie_bytes.bin");

            // Anwendung für Methode 3 – Dateien vergleichen
            binaerDateienVergleichen("random_bytes.bin", "kopie_bytes.bin");

            // Anwendung für Methode 4 – Hexdump
            hexDumpAusgeben("random_bytes.bin");

            // Anwendung für Methode 6 – Häufigkeit eines Bytes zählen
            byteHaeufigkeitZaehlen("random_bytes.bin", (byte) 0x41); // zählt z. B. 'A'

            // Anwendung für Methode 8 – Text zu Binär
            textZuBinaerKonvertieren("original.txt", "output.bin");

            // Anwendung für Methode 7 – Binär zu Text (zurückwandeln)
            binaerZuTextKonvertieren("output.bin", "zurueck.txt");

        } catch (IOException e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }

    // 1 – Lies eine Binärdatei und gib deren Inhalt als Zeichen aus
    public static void binaerDateiLesenUndAlsZeichenAusgeben(String pfad) throws IOException {
        FileInputStream fis = new FileInputStream(pfad);
        int byteWert;
        while ((byteWert = fis.read()) != -1) {
            System.out.print((char) byteWert);
        }
        fis.close();
    }

    // 2 – Kopiere eine Datei byteweise
    public static void dateiByteweiseKopieren(String quelle, String ziel) throws IOException {
        FileInputStream fis = new FileInputStream(quelle);
        FileOutputStream fos = new FileOutputStream(ziel);
        int b;
        while ((b = fis.read()) != -1) {
            fos.write(b);
        }
        fis.close();
        fos.close();
    }

    // 3 – Vergleiche zwei Binärdateien byteweise
    public static void binaerDateienVergleichen(String pfad1, String pfad2) throws IOException {
        FileInputStream f1 = new FileInputStream(pfad1);
        FileInputStream f2 = new FileInputStream(pfad2);
        int b1, b2;
        int position = 0;
        while ((b1 = f1.read()) != -1 && (b2 = f2.read()) != -1) {
            if (b1 != b2) {
                System.out.println("Unterschied bei Byte " + position);
                f1.close();
                f2.close();
                return;
            }
            position++;
        }
        if (f1.read() != -1 || f2.read() != -1) {
            System.out.println("Dateien haben unterschiedliche Länge.");
        } else {
            System.out.println("Dateien sind identisch.");
        }
        f1.close();
        f2.close();
    }

    // 4 – Gib Binärdatei als Hexdump aus
    public static void hexDumpAusgeben(String pfad) throws IOException {
        FileInputStream fis = new FileInputStream(pfad);
        int b;
        int count = 0;
        while ((b = fis.read()) != -1) {
            System.out.printf("%02X ", b);
            count++;
            if (count % 16 == 0) System.out.println();
        }
        fis.close();
    }

    // 5 – Schreibe 100 zufällige Bytes in eine Datei
    public static void zufallsBytesSchreiben(String pfad) throws IOException {
        FileOutputStream fos = new FileOutputStream(pfad);
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            fos.write(rand.nextInt(256));
        }
        fos.close();
    }

    // 6 – Zähle, wie oft ein bestimmtes Byte in einer Datei vorkommt
    public static void byteHaeufigkeitZaehlen(String pfad, byte zielByte) throws IOException {
        FileInputStream fis = new FileInputStream(pfad);
        int count = 0;
        int b;
        while ((b = fis.read()) != -1) {
            if ((byte) b == zielByte) count++;
        }
        fis.close();
        System.out.println("Byte " + String.format("0x%02X", zielByte) + " kommt " + count + "-mal vor.");
    }

    // 7 – Binär zu Text: Konvertiere Datei in Text und speichere sie
    public static void binaerZuTextKonvertieren(String quelle, String ziel) throws IOException {
        FileInputStream fis = new FileInputStream(quelle);
        PrintWriter writer = new PrintWriter(new FileWriter(ziel));
        int b;
        while ((b = fis.read()) != -1) {
            writer.print((char) b);
        }
        fis.close();
        writer.close();

        // Anwendung für Methode 7:
        // (public static void main(String[] args) {
        //    try {
        //        // Konvertiere die Binärdatei "output.bin" zurück in eine Textdatei "zurueck.txt"
        //        binaerZuTextKonvertieren("output.bin", "zurueck.txt");
        //        System.out.println("Binärdatei erfolgreich in Text konvertiert.");
        //    } catch (IOException e) {
        //        System.out.println("Fehler: " + e.getMessage());
        //    }
        // })
    }

    // 8 – Text zu Binär: Konvertiere Textdatei in Binärdatei
    public static void textZuBinaerKonvertieren(String quelle, String ziel) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(quelle));
        FileOutputStream fos = new FileOutputStream(ziel);

        int c;
        while ((c = bufferedReader.read()) != -1) {
            fos.write(c); // speichert jedes Zeichen als Byte
        }

        bufferedReader.close();
        fos.close();

        // Anwendung für Methode 8:
        // Tipp zur Prüfung:
        // Lege eine Datei namens original.txt in deinem Projektordner ab, z.B. mit Inhalt: Hallo Katja!\nDies ist ein Test.
        // public static void main(String[] args) {
        //     try {
        //         // Beispiel: Konvertiere eine Textdatei ("original.txt") in eine Binärdatei ("output.bin")
        //         textZuBinaerKonvertieren("original.txt", "output.bin");
        //         System.out.println("Text erfolgreich in Binärdatei gespeichert.");
        //     } catch (IOException e) {
        //         System.out.println("Fehler: " + e.getMessage());
        //     }
        // }
    }

    // Speichert UTF-8-Text als Binär
    public static void schreibeUTF8AlsBinaer(String quelle, String ziel) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(quelle), StandardCharsets.UTF_8));
        OutputStream os = new FileOutputStream(ziel);
        int c;
        while ((c = reader.read()) != -1) {
            os.write(c);
        }
        reader.close();
        os.close();
    }

    public static void konvertiereTextdateiMitAndererKodierung(String quelle, String ziel,
                                                               Charset quellCharset, Charset zielCharset) throws IOException {
        // Reader mit ursprünglicher Kodierung
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(quelle), quellCharset));

        // Writer mit gewünschter ZIEL-Kodierung
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ziel), zielCharset));

        String line;
        while ((line = reader.readLine()) != null) {
            writer.write(line);
            writer.newLine(); // Zeilenumbruch systemabhängig
        }

        reader.close();
        writer.close();
    }
    //Anwendung in main:
    // public static void main(String[] args) {
    //    try {
    //        // Konvertiere Datei von UTF-8 nach ISO-8859-1
    //        konvertiereTextdateiMitAndererKodierung("utf8_input.txt", "iso_output.txt",
    //                StandardCharsets.UTF_8, StandardCharsets.ISO_8859_1);
    //        System.out.println("Konvertierung erfolgreich.");
    //    } catch (IOException e) {
    //        System.out.println("Fehler bei Konvertierung: " + e.getMessage());
    //    }
    //}
    //du kannst die gleiche Methode auch verwenden, um von ISO-8859-1 nach UTF-8 zu konvertieren!
    //
}