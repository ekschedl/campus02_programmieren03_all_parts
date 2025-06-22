package _FILE____IO;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

//🔹 Files (aus java.nio.file)
//	•	Klasse: java.nio.file.Files
//	•	Art: Sammlung von statischen Methoden
//	•	Funktionen:
//	•	Moderne Dateiverarbeitung (ab Java 7)
//	•	Inhalt lesen/schreiben/kopieren/verschieben/löschen
//	•	Unterstützt Path statt File
public class FILES_MethodenDemo {
    public static void main(String[] args) throws IOException {
        Path pfad = Path.of("beispiel.txt");
        Path ziel = Path.of("kopie.txt");
        Path ordner = Path.of("mein_ordner");

        // Datei schreiben
        Files.writeString(pfad, "Hallo Katja!", StandardCharsets.UTF_8);

        // Datei lesen
        String inhalt = Files.readString(pfad);
        System.out.println("Inhalt: " + inhalt);

        // Zeilenweise lesen/schreiben
        List<String> zeilen = Files.readAllLines(pfad);
        Files.write(Path.of("zeilen_kopie.txt"), zeilen);

        // Datei kopieren
        Files.copy(pfad, ziel, StandardCopyOption.REPLACE_EXISTING);

        // Datei verschieben
        Files.move(ziel, Path.of("verschoben.txt"), StandardCopyOption.REPLACE_EXISTING);

        // Datei löschen
        Files.deleteIfExists(Path.of("verschoben.txt"));

        // Datei-Existenz prüfen
        if (Files.exists(pfad)) {
            System.out.println("Datei existiert!");
        }

        // Dateigröße und Änderungszeit
        System.out.println("Größe: " + Files.size(pfad) + " Bytes");
        System.out.println("Letzte Änderung: " + Files.getLastModifiedTime(pfad));

        // Temporäre Datei
        Path tmpDatei = Files.createTempFile("katja_temp_", ".txt");
        Files.writeString(tmpDatei, "Temporaer gespeichert");

        // Ordner erstellen
        if (!Files.exists(ordner)) Files.createDirectory(ordner);

        // Inhalte eines Ordners auflisten
        Files.list(Path.of(".")).forEach(System.out::println);

        // Rekursiv alle Dateien durchlaufen
        Files.walk(Path.of(".")).filter(Files::isRegularFile).forEach(System.out::println);
    }
}
