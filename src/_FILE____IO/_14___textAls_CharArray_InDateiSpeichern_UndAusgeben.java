package _FILE____IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _14___textAls_CharArray_InDateiSpeichern_UndAusgeben {

    public static void main(String[] args) throws IOException {
        System.out.println("UE14: Schreibe binär einzelne Zeichen");

        // 🔹 Datei erstellen (falls sie noch nicht existiert)
        File file = new File("text_ue14.txt");
        file.createNewFile(); // erzeugt eine neue leere Datei, wenn sie noch nicht vorhanden ist

        // 🔹 Text, der geschrieben werden soll
        //	•	"Ü" (Unicode-Wert 220) wird zu einem einzelnen Byte 11011100 geschrieben.
        //	•	Dieses Byte kann beim Lesen nicht korrekt als Ü interpretiert werden – also erscheint z.bB. ‹ oder ein anderes Zeichen.
        String outputText = "Hello World, Übung 14 \nWas ist passiert?\n" +
                "\n" +
                "Du hast mit FileOutputStream.write(char) direkt Zeichen (z. B. \"Übung\") als einzelne Bytes geschrieben. Dabei wird nur das niedrigste Byte jedes Zeichens gespeichert – was bei Sonderzeichen wie Ü nicht ausreicht, weil sie mehrere Bytes brauchen (z. B. in UTF-8)";

        // 🔹 Schreiben der Zeichen als Binärdaten (Byte für Byte)
        FileOutputStream fileOutputStream = new FileOutputStream(file); // Datei zum Schreiben öffnen
        char[] charArray = outputText.toCharArray(); // Zeichenkette in einzelne Zeichen aufteilen

        for (char c : charArray) {
            fileOutputStream.write(c); // jedes Zeichen wird in ein Byte umgewandelt und geschrieben
        }

        fileOutputStream.flush(); // sicherstellen, dass alle Daten in Datei geschrieben werden
        fileOutputStream.close(); // Stream schließen (Datei freigeben)

        // 🔹 Datei wieder lesen und auf Konsole ausgeben
        FileInputStream fileInputStream = new FileInputStream(file); // Datei zum Lesen öffnen
        int byteRead;

        while ((byteRead = fileInputStream.read()) != -1) {
            // Byte wieder in Zeichen umwandeln und ausgeben
            System.out.print((char) byteRead);
        }

        fileInputStream.close(); // Lesestream schließen
    }
}

//package _FILE____IO;   oben ist das Problem dass Ünichr korrekt in txt angezeigt wird; hier list die lösung:
//Was diese Klasse macht:
//        •	Speichert "Übung 14" in UTF-8
//        •	Liest sie wieder ein – korrekt inkl. Ü
//	•	Verwendet OutputStreamWriter und InputStreamReader für richtige Zeichenkodierung
////
//import java.io.*;
//
//public class Ue14_UebungMitUTF8WriterReader {
//
//    public static void main(String[] args) {
//        String dateiname = "ue14_utf8.txt";
//        String text = "Übung 14";
//
//        // 📤 Text in Datei schreiben (UTF-8)
//        try {
//            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(dateiname), "UTF-8");
//            writer.write(text);
//            writer.close();
//            System.out.println("✅ Text gespeichert in Datei: " + dateiname);
//        } catch (IOException e) {
//            System.out.println("❌ Fehler beim Schreiben: " + e.getMessage());
//        }
//
//        // 📥 Text aus Datei lesen (UTF-8)
//        try {
//            InputStreamReader reader = new InputStreamReader(new FileInputStream(dateiname), "UTF-8");
//            int zeichen;
//            System.out.print("📄 Gelesener Text: ");
//            while ((zeichen = reader.read()) != -1) {
//                System.out.print((char) zeichen); // Zeichen einzeln ausgeben
//            }
//            reader.close();
//        } catch (IOException e) {
//            System.out.println("❌ Fehler beim Lesen: " + e.getMessage());
//        }
//    }
//}