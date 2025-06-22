package _FILE____IO;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class LiesDatei_Mit_Files_ReadAllLines___Files_Path_of {

        public static void main(String[] args) throws IOException {
            // Pfad zur Datei
            Path pfad = Path.of("ue_12_text_Byte_fuer_byte.txt");

            // Liest alle Zeilen der Datei in eine Liste
            List<String> zeilen = Files.readAllLines(pfad);

            // Gibt die Zeilen aus
            for (String zeile : zeilen) {
                System.out.println(zeile);
            }
        }
    }
