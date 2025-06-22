package _FILE____IO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class _00___basics_____ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("\n\uD83D\uDCC1 Menü – Grundlagen zu Dateien und Streams");

            // Gruppe 1: Datei erstellen, lesen, schreiben, löschen
            System.out.println("-- Grundlagen Dateioperationen --");
            System.out.println(" 1. Datei im fixen Ordner erstellen (inkl. Pfad prüfen)");
            System.out.println(" 2. Text in Datei schreiben mit FileWriter");
            System.out.println(" 3. Text von Konsole lesen und in Datei schreiben");
            System.out.println(" 4. Datei zeilenweise lesen (BufferedReader)");
            System.out.println(" 5. Alle Dateien in einem Ordner auflisten");
            System.out.println(" 6. Datei umbenennen");
            System.out.println(" 7. Datei löschen");

            // Gruppe 2: Filtern, Anhängen, Zeit, Vergleichen
            System.out.println("-- Schreiben, Anhängen, Zeit --");
            System.out.println(" 8. Lieblingsessen speichern");
            System.out.println(" 9. Nur Zeilen mit bestimmtem Wort anzeigen");
            System.out.println("10. Zwei Dateien zeilenweise vergleichen");
            System.out.println("11. Neue Zeile ans Dateiende anhängen");
            System.out.println("12. Mit Zeitstempel in Datei schreiben");
            System.out.println("13. Tagebuch-Eintrag speichern");

            // Gruppe 3: Kodierung & Konvertierung
            System.out.println("-- Kodierung und Konvertierung --");
            System.out.println("14. UTF-8 Datei neu als ISO speichern");
            System.out.println("15. Nur Zeilen mit Zahlen anzeigen");
            System.out.println("16. Alle .txt Dateien umbenennen");
            System.out.println("17. Dateien mit 'test' löschen");
            System.out.println("18. Zeilen einer Datei zählen");
            System.out.println("19. Mini-Tagebuch: Pro Tag neue Datei erstellen");
            System.out.println("20. Textdatei von UTF-8 nach ISO konvertieren");
            System.out.println("21. Zeilen mit Zahlenwerten filtern");

            // Gruppe 4: Umbenennen & Löschen & Struktur
            System.out.println("-- Umbenennen und Struktur --");
            System.out.println("22. .txt Dateien mit Prefix archiv_ umbenennen");
            System.out.println("23. Dateien mit 'test' im Namen automatisch löschen");
            System.out.println("24. Interaktives Menüsystem zur Dateiverwaltung starten");
            System.out.println("25. Ordnerstruktur automatisch erstellen");
            System.out.println("26. Neue Datei in gegebenem Ordner erstellen");

            // Gruppe 5: Benutzerinteraktion und Lesemethoden
            System.out.println("-- Benutzer und Ausgabe --");
            System.out.println("27. Textzeilen per Scanner eingeben und speichern");
            System.out.println("28. Datei zeichenweise mit FileReader ausgeben");
            System.out.println("29. Ganze Datei mit Files.readAllLines() ausgeben");
            System.out.println("30. Verzeichnisinhalte rekursiv auflisten");

            // Gruppe 6: Objekt-Serialisierung und Binärzugriff
            System.out.println("-- Serialisierung und Binärdateien --");
            System.out.println("31. String-Objekt serialisieren");
            System.out.println("32. String-Objekt deserialisieren");
            System.out.println("33. ArrayList<String> serialisieren");
            System.out.println("34. Binärdatei lesen und Text anzeigen");
            System.out.println("35. Bytes in Bilddatei zählen");

            // Gruppe 7: Dateiattribute
            System.out.println("-- Datei-Attribute --");
            System.out.println("36. Letzte Änderungszeit anzeigen");
            System.out.println("37. Datei auf nur-lesbar setzen");
            System.out.println("38. Temporäre Datei erstellen");
            System.out.println("39. Prüfen ob Datei versteckt ist");
            System.out.println("40. Berechtigungen setzen (lesen/schreiben/ausführen)");

            System.out.println(" 0. ❎ Beenden");
            int wahl = scanner.nextInt();
            scanner.nextLine();

            switch (wahl) {
                case 1 -> erstelleOrdnerUndDatei();
                case 2 -> schreibeTextInDatei();
                case 3 -> leseVonKonsoleUndSpeichere();
                case 4 -> leseDateiUndZeigeAn();
                case 5 -> zeigeAlleDateienImOrdner();
                case 6 -> dateiUmbenennen();
                case 7 -> dateiLoeschen();
                case 8 -> lieblingsEssenSpeichern();
                case 9 -> zeilenMitWort();
                case 10 -> vergleicheDateien();
                case 11 -> zeileAnhängen();
                case 12 -> schreibeMitZeitstempel();
                case 13 -> tagebuchEintrag();
                case 14 -> utf8NachIso();
                case 15 -> zeilenMitZahl();
                case 16 -> txtDateienUmbenennen();
                case 17 -> dateienMitTestLoeschen();
                case 18 -> zeilenZaehlen();
                case 19 -> tagebuchEintragProDatumErstellen();
                case 20 -> textdateiVonUtf8NachIsoKonvertieren();
                case 21 -> nurZeilenMitZahlenwertenAnzeigen();
                case 22 -> txtDateienMitPrefixArchivUmbenennen();
                case 23 -> dateienMitTestImNamenAutomatischLoeschen();
                case 24 -> System.out.println("⚙️ Interaktives Dateiverwaltungsmenü ist noch in Arbeit...");
                case 25 -> ordnerstrukturAutomatischErstellen();
                case 26 -> neueDateiInOrdnerErstellen();
                case 27 -> textMitScannerEingebenUndSpeichern();
                case 28 -> dateiZeichenweiseMitFileReaderAusgeben();
                case 29 -> ganzeDateiMitFilesReadAllLinesAusgeben();
                case 30 -> verzeichnisRekursivAuflisten();
                case 31 -> stringObjekt_Serialisieren_MitObjectOutputStream();
                case 32 -> stringObjekt_Deserialisieren_MitObjectInputStream();
                case 33 -> arrayList_Serialisieren_MitObjectOutputStream();
                case 34 -> binärDatei_Einlesen_Und_InTextAusgeben();
                case 35 -> anzahlBytes_InBilddatei_Zaehlen_MitFileInputStream();
                case 36 -> zeigeLetzteAenderung(new File("ausgabe/noten_semester.txt"));
                case 37 -> dateiNurLesbarSetzen(new File("ausgabe/noten_semester.txt"));
                case 38 -> temporaereDateiErstellen();
                case 39 -> istDateiVersteckt(new File("ausgabe/noten_semester.txt"));
                case 40 -> dateiBerechtigungenAendern(new File("ausgabe/noten_semester.txt"));
                case 0 -> {
                    System.out.println("Programm beendet.");
                    return;
                }
                default -> System.out.println("Bitte wähle eine gültige Option aus dem erweiterten Menü!");
            }
        }
    }




    // 1 – Erstellt einen Ordner namens 'ausgabe' und darin eine Datei 'noten_semester.txt'
    public static void erstelleOrdnerUndDatei() {
        File ordner = new File("ausgabe");
        if (!ordner.exists()) ordner.mkdirs();
        File datei = new File("ausgabe/noten_semester.txt");
        try {
            if (datei.createNewFile())
                System.out.println("✅ Datei wurde erstellt: " + datei.getAbsolutePath());
            else
                System.out.println("ℹ️  Datei existiert bereits: " + datei.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("❌ Fehler beim Erstellen: " + e.getMessage());
        }
    }

    // 2 – Schreibt zwei Beispielzeilen in die Datei 'beispiel.txt'
    public static void schreibeTextInDatei() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("ausgabe/beispiel.txt"));
        pw.println("PR1: 1");
        pw.println("Englisch: 2");
        pw.close();
        System.out.println("✅ Text wurde geschrieben.");
    }

    // 3 – Liest Texteingaben von der Konsole und speichert sie in 'noten.txt' bis 'STOP' eingegeben wird
    public static void leseVonKonsoleUndSpeichere() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new FileWriter("ausgabe/noten.txt"));
        System.out.println("Bitte gib deine Noten ein. Mit STOP beenden:");
        String line;
        while (!(line = br.readLine()).equalsIgnoreCase("STOP")) {
            pw.println(line);
        }
        pw.close();
        br.close();
        System.out.println("✅ Alle Eingaben gespeichert.");
    }

    // 4 – Liest eine Datei namens 'noten.txt' zeilenweise und gibt sie auf der Konsole aus
    public static void leseDateiUndZeigeAn() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("ausgabe/noten.txt"));
        String zeile;
        while ((zeile = br.readLine()) != null) System.out.println(zeile);
        br.close();
    }

    // 5 – Listet alle Dateien im Ordner 'ausgabe' auf
    public static void zeigeAlleDateienImOrdner() {
        File ordner = new File("ausgabe");
        File[] dateien = ordner.listFiles();
        if (dateien != null) {
            for (File f : dateien) System.out.println(f.getName());
        } else System.out.println("Ordner existiert nicht oder enthält keine Dateien.");
    }


    // 6 – Bennennt eine Datei 'noten.txt' in 'umbenannt.txt' um
    public static void dateiUmbenennen() {
        File original = new File("ausgabe/noten.txt");
        File umbenannt = new File("ausgabe/umbenannt.txt");
        if (original.renameTo(umbenannt))
            System.out.println("✅ Datei umbenannt.");
        else
            System.out.println("❌ Umbenennen fehlgeschlagen.");
    }

    // 7 – Löscht die Datei 'umbenannt.txt' im Ordner 'ausgabe'
    public static void dateiLoeschen() {
        File datei = new File("ausgabe/umbenannt.txt");
        if (datei.delete())
            System.out.println("✅ Datei gelöscht.");
        else
            System.out.println("❌ Datei konnte nicht gelöscht werden.");
    }

    // 8 – Speichert eine Liste von Lieblingsessen in der Datei 'essen.txt'
    public static void lieblingsEssenSpeichern() throws IOException {
        List<String> essen = Arrays.asList("Pizza", "Sushi", "Salat");
        PrintWriter writer = new PrintWriter(new FileWriter("ausgabe/essen.txt"));
        for (String gericht : essen) writer.println(gericht);
        writer.close();
        System.out.println("✅ Lieblingsessen gespeichert.");
    }

    // 9 – Gibt nur die Zeilen aus 'text.txt' aus, die das Wort "Java" enthalten
    public static void zeilenMitWort() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("ausgabe/text.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains("Java")) System.out.println(line);
        }
        reader.close();
    }

    // 10 – Vergleicht zwei Dateien zeilenweise und gibt Unterschiede aus
    public static void vergleicheDateien() throws IOException {
        BufferedReader r1 = new BufferedReader(new FileReader("ausgabe/a.txt"));
        BufferedReader r2 = new BufferedReader(new FileReader("ausgabe/b.txt"));
        String l1, l2;
        while ((l1 = r1.readLine()) != null && (l2 = r2.readLine()) != null) {
            if (!l1.equals(l2)) System.out.println("Unterschied: " + l1 + " / " + l2);
        }
        r1.close();
        r2.close();
    }




    // 11 – Hängt eine neue Zeile an eine bestehende Datei 'text.txt' an
    public static void zeileAnhängen() throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter("ausgabe/text.txt", true));
        writer.println("Neue Zeile am Ende");
        writer.close();
    }

    // 12 – Schreibt eine Zeile mit Zeitstempel in die Datei 'log.txt'
    public static void schreibeMitZeitstempel() throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter("ausgabe/log.txt", true));
        writer.println(LocalDateTime.now() + ": Fehler aufgetreten");
        writer.close();
    }

    // 13 – Fügt dem Tagebuch-Eintrag für das aktuelle Datum eine Zeile hinzu
    public static void tagebuchEintrag() throws IOException {
        String dateiname = "ausgabe/tagebuch_" + LocalDate.now() + ".txt";
        PrintWriter writer = new PrintWriter(new FileWriter(dateiname, true));
        writer.println(LocalTime.now() + ": Heute gelernt...");
        writer.close();
    }

    // 14 – Konvertiert eine UTF-8-Datei in ISO-8859-1
    public static void utf8NachIso() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("ausgabe/utf8.txt"), "UTF-8"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("ausgabe/latin.txt"), "ISO-8859-1"));
        String line;
        while ((line = reader.readLine()) != null) {
            writer.write(line);
            writer.newLine();
        }
        reader.close();
        writer.close();
    }

    // 15 – Gibt nur Zeilen mit Zahlen aus einer Datei aus
    public static void zeilenMitZahl() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("ausgabe/daten.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.matches(".*\\d+.*")) System.out.println(line);
        }
        reader.close();
    }


    // 16 – Benennt alle .txt-Dateien im Ordner 'ausgabe' mit einem Prefix 'archiv_'
    public static void txtDateienUmbenennen() {
        File ordner = new File("ausgabe");
        File[] dateien = ordner.listFiles((dir, name) -> name.endsWith(".txt"));
        for (File f : dateien) {
            File neu = new File(f.getParent(), "archiv_" + f.getName());
            f.renameTo(neu);
        }
    }

    // 17 – Löscht alle Dateien im Ordner 'ausgabe', die das Wort 'test' im Namen haben
    public static void dateienMitTestLoeschen() {
        File ordner = new File("ausgabe");
        File[] dateien = ordner.listFiles((dir, name) -> name.contains("test"));
        for (File f : dateien) f.delete();
    }

    // 18 – Zählt und gibt die Anzahl der Zeilen in der Datei 'text.txt' aus
    public static void zeilenZaehlen() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("ausgabe/text.txt"));
        int zeilen = 0;
        while (reader.readLine() != null) zeilen++;
        reader.close();
        System.out.println("📊 Zeilenanzahl: " + zeilen);
    }

    // 19 – Mini-Tagebuch: Pro Tag wird eine neue Datei mit Zeitstempel erstellt
    public static void tagebuchEintragProDatumErstellen() throws IOException {
        String dateiname = "ausgabe/tagebuch_" + LocalDate.now() + ".txt";
        PrintWriter writer = new PrintWriter(new FileWriter(dateiname, true));
        writer.println(LocalTime.now() + " – Eintrag: Heute war ein produktiver Tag :)");
        writer.close();
        System.out.println("✅ Tagebuch-Eintrag gespeichert: " + dateiname);
    }

    // 20 – Konvertiert den Inhalt einer UTF-8-codierten Datei in ISO-8859-1 und speichert sie neu
    public static void textdateiVonUtf8NachIsoKonvertieren() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream("ausgabe/utf8_eingabe.txt"), "UTF-8"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("ausgabe/iso_ausgabe.txt"), "ISO-8859-1"));

        String zeile;
        while ((zeile = reader.readLine()) != null) {
            writer.write(zeile);
            writer.newLine();
        }
        reader.close();
        writer.close();
        System.out.println("🔄 Konvertierung abgeschlossen (UTF-8 ➝ ISO-8859-1)");
    }

    // 21 – Zeigt alle Zeilen aus der Datei, die mindestens eine Ziffer enthalten
    public static void nurZeilenMitZahlenwertenAnzeigen() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("ausgabe/daten_mit_zahlen.txt"));
        String zeile;
        System.out.println("🔢 Zeilen mit Zahlen:");
        while ((zeile = reader.readLine()) != null) {
            if (zeile.matches(".*\\d+.*")) System.out.println(zeile);
        }
        reader.close();
    }

    // 22 – Benennt alle .txt-Dateien im Ordner 'ausgabe' mit Prefix 'archiv_' um (detaillierte Variante)
    public static void txtDateienMitPrefixArchivUmbenennen() {
        File ordner = new File("ausgabe");
        File[] dateien = ordner.listFiles((dir, name) -> name.endsWith(".txt"));

        if (dateien != null) {
            for (File alteDatei : dateien) {
                File neueDatei = new File(alteDatei.getParent(), "archiv_" + alteDatei.getName());
                if (alteDatei.renameTo(neueDatei)) {
                    System.out.println("✅ Umbenannt: " + neueDatei.getName());
                } else {
                    System.out.println("❌ Fehler beim Umbenennen: " + alteDatei.getName());
                }
            }
        }
    }

    // 23 – Löscht alle Dateien mit 'test' im Dateinamen im Ordner 'ausgabe'
    public static void dateienMitTestImNamenAutomatischLoeschen() {
        File ordner = new File("ausgabe");
        File[] dateien = ordner.listFiles((dir, name) -> name.contains("test"));

        if (dateien != null) {
            for (File f : dateien) {
                if (f.delete()) {
                    System.out.println("🧹 Gelöscht: " + f.getName());
                } else {
                    System.out.println("⚠️ Nicht gelöscht: " + f.getName());
                }
            }
        }
    }


    // 25 – Erstellt automatisch eine verschachtelte Ordnerstruktur unterhalb von 'ausgabe'
    public static void ordnerstrukturAutomatischErstellen() {
        File ordner = new File("ausgabe/jahr2025/mai/uebungen");
        if (ordner.mkdirs()) {
            System.out.println("✅ Ordnerstruktur erstellt: " + ordner.getAbsolutePath());
        } else {
            System.out.println("⚠️ Ordner existiert bereits oder konnte nicht erstellt werden.");
        }
    }

    // 26 – Erstellt eine neue Datei in einem gegebenen Unterordner
    public static void neueDateiInOrdnerErstellen() throws IOException {
        File datei = new File("ausgabe/jahr2025/neu_dokument.txt");
        if (datei.createNewFile()) {
            System.out.println("✅ Neue Datei erstellt: " + datei.getAbsolutePath());
        } else {
            System.out.println("⚠️ Datei existiert bereits: " + datei.getAbsolutePath());
        }
    }

    // 27 – Lässt den Benutzer beliebig viele Zeilen eingeben und speichert diese in 'eingaben.txt'
    public static void textMitScannerEingebenUndSpeichern() throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(new FileWriter("ausgabe/eingaben.txt"));
        System.out.println("Gib Textzeilen ein (mit 'STOP' beenden):");
        String input;
        while (!(input = sc.nextLine()).equalsIgnoreCase("STOP")) {
            writer.println(input);
        }
        writer.close();
        System.out.println("✅ Eingaben gespeichert.");
    }

    // 28 – Gibt den Inhalt der Datei 'eingaben.txt' zeichenweise mit FileReader aus
    public static void dateiZeichenweiseMitFileReaderAusgeben() throws IOException {
        FileReader reader = new FileReader("ausgabe/eingaben.txt");
        int zeichen;
        System.out.println("🔠 Zeichenweise Ausgabe:");
        while ((zeichen = reader.read()) != -1) {
            System.out.print((char) zeichen);
        }
        reader.close();
    }

    // 29 – Liest den gesamten Inhalt einer Datei mit Files.readAllLines() und gibt ihn zeilenweise aus
    public static void ganzeDateiMitFilesReadAllLinesAusgeben() throws IOException {
        List<String> zeilen = Files.readAllLines(Path.of("ausgabe/eingaben.txt"));
        System.out.println("📋 Komplette Datei:");
        for (String z : zeilen) {
            System.out.println(z);
        }
    }

    // 30 – Listet rekursiv alle Dateien und Unterordner im Verzeichnis 'ausgabe' auf
    public static void verzeichnisRekursivAuflisten() {
        Path start = Path.of("ausgabe");
        try {
            Files.walk(start)
                    .forEach(p -> System.out.println(p.toAbsolutePath()));
        } catch (IOException e) {
            System.out.println("❌ Fehler beim Durchlaufen des Verzeichnisses: " + e.getMessage());
        }
    }

    // 🔹 31 – String-Objekt serialisieren mit ObjectOutputStream
    public static void stringObjekt_Serialisieren_MitObjectOutputStream() throws IOException {
        String text = "Hallo Welt aus Aufgabe 31";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ausgabe/objekt31.dat"));
        oos.writeObject(text);
        oos.close();
        System.out.println("✅ Objekt gespeichert: " + text);
    }

    // 🔹 32 – String-Objekt deserialisieren mit ObjectInputStream
    public static void stringObjekt_Deserialisieren_MitObjectInputStream() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ausgabe/objekt31.dat"));
        String gelesen = (String) ois.readObject();
        ois.close();
        System.out.println("📄 Gelesenes Objekt: " + gelesen);
    }

    // 🔹 33 – ArrayList<String> serialisieren mit ObjectOutputStream
    public static void arrayList_Serialisieren_MitObjectOutputStream() throws IOException {
        ArrayList<String> liste = new ArrayList<>(List.of("Pizza", "Sushi", "Pasta"));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ausgabe/liste33.dat"));
        oos.writeObject(liste);
        oos.close();
        System.out.println("✅ Liste gespeichert: " + liste);
    }

    // 🔹 34 – Binärdatei lesen und als Text ausgeben
    public static void binärDatei_Einlesen_Und_InTextAusgeben() throws IOException {
        FileInputStream fis = new FileInputStream("ausgabe/objekt31.dat");
        int byteWert;
        System.out.println("📥 Datei-Inhalt in Text:");
        while ((byteWert = fis.read()) != -1) {
            System.out.print((char) byteWert);
        }
        fis.close();
    }

    // 🔹 35 – Anzahl Bytes in Bilddatei zählen mit FileInputStream
    public static void anzahlBytes_InBilddatei_Zaehlen_MitFileInputStream() throws IOException {
        FileInputStream fis = new FileInputStream("ausgabe/bild.jpg");
        int count = 0;
        while (fis.read() != -1) count++;
        fis.close();
        System.out.println("🖼️ Bildgröße in Bytes: " + count);
    }
    // 36 – Gibt das letzte Änderungsdatum der Datei aus
    public static void zeigeLetzteAenderung(File file) {
        if (file.exists()) {
            System.out.println("🕒 Letzte Änderung: " + new java.util.Date(file.lastModified()));
        } else {
            System.out.println("⚠️ Datei existiert nicht.");
        }
    }

    // 37 – Setzt eine Datei auf nur-lesbar
    public static void dateiNurLesbarSetzen(File file) {
        if (file.exists()) {
            boolean erfolg = file.setReadOnly();
            System.out.println(erfolg ? "🔒 Datei ist jetzt nur-lesbar." : "❌ Setzen auf nur-lesbar fehlgeschlagen.");
        } else {
            System.out.println("⚠️ Datei nicht gefunden.");
        }
    }


    // 38 – Erstelle temporäre Datei
    public static void temporaereDateiErstellen() throws IOException {
        File temp = File.createTempFile("tempfile_", ".tmp");
        System.out.println("📁 Temporäre Datei erstellt: " + temp.getAbsolutePath());
        temp.deleteOnExit();
    }

    // 39 – Prüfe ob Datei versteckt ist
    public static void istDateiVersteckt(File file) {
        if (file.exists()) {
            System.out.println("🙈 Ist versteckt: " + file.isHidden());
        } else {
            System.out.println("⚠️ Datei existiert nicht.");
        }
    }

    // 40 – Ändere Dateiberechtigungen
    public static void dateiBerechtigungenAendern(File file) {
        if (file.exists()) {
            boolean gelesen = file.setReadable(true);
            boolean geschrieben = file.setWritable(true);
            boolean ausgefuehrt = file.setExecutable(true);
            System.out.println("🔧 Berechtigungen geändert: Lesen=" + gelesen + ", Schreiben=" + geschrieben + ", Ausführen=" + ausgefuehrt);
        } else {
            System.out.println("⚠️ Datei existiert nicht.");
        }
    }
}
