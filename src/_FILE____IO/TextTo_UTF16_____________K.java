package _FILE____IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class TextTo_UTF16_____________K {
    public static void main(String[] args) throws IOException {
        String text = "Hallo Welt! ÄÖÜ €";

        // 💾 In Datei als UTF-16 speichern
        schreibeAlsUTF16(text);

        // 🔎 Bytes in UTF-16 anzeigen
        zeigeUTF16Bytes(text);
    }

    public static void schreibeAlsUTF16(String text) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream("utf16_text.txt"), "UTF-16");
        writer.write(text);
        writer.close();
        System.out.println("✅ UTF-16 Datei gespeichert: utf16_text.txt");
    }

    public static void zeigeUTF16Bytes(String text) throws UnsupportedEncodingException {
        System.out.println("\n🔢 UTF-16 Bytefolge:");
        byte[] bytes = text.getBytes("UTF-16");
        for (byte b : bytes) {
            System.out.print((b & 0xFF) + " ");
        }
        System.out.println();
    }
}
