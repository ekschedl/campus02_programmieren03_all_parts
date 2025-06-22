package _FILE____IO;

import java.io.File;
import java.io.IOException;

public class _01___about_File_Information____F {
    public static void main(String[] args) {
        /*
        Uebung_1:
        Create a method, which has the parameter File
            The method should print the following information of a file on the console:
            - Does this file exist?
            - Name of the File
            - Parent Directory of the File
            - Path to this File
            - Is this a directory?
            - Is this a file?
            - Is this file readable?
            - Is this File writeable
            - File Size
            - ...
         */

        File file = new File("/Users/kaaatkina/CAMPUS02_2025/Programmieren_3/src/Uebungen_und_Notizen");
        readFileInformation(file);


    }

    public static void readFileInformation(File file) {
        System.out.println("Does this file exists? \t\t\t" + file.exists());
        System.out.println("The name of file is  \t\t\t" + file.getName());
        System.out.println("Parent Directory of this file   " + file.getParent());
        System.out.println("Path to this file \t\t\t\t" + file.getPath());
        System.out.println("The full path to this file \t\t" + file.getAbsolutePath());
        System.out.println("Is this a Directory? \t\t\t" + file.isDirectory());
        System.out.println("Is this a File? \t\t\t\t" + file.isFile());
        System.out.println("Is this a hidden file \t\t\t" + file.isHidden());
        System.out.println("Is this File readable ? \t\t" + file.canRead());
        System.out.println("Is this File writable ? \t\t" + file.canWrite());
        System.out.println("File Size: \t\t\t\t\t\t" + file.length());

// --------deutsch
        System.out.println("🔍 Existiert die Datei? \t\t\t\t" + file.exists());
        System.out.println("📛 Dateiname: \t\t\t\t\t\t" + file.getName());
        System.out.println("📁 Übergeordneter Ordner: \t\t\t" + file.getParent());
        System.out.println("🧭 Pfad zur Datei: \t\t\t\t\t" + file.getPath());
        System.out.println("🛣️ Absoluter Pfad: \t\t\t\t\t" + file.getAbsolutePath());
        System.out.println("📂 Ist ein Verzeichnis? \t\t\t" + file.isDirectory());
        System.out.println("📄 Ist eine Datei? \t\t\t\t\t" + file.isFile());
        System.out.println("🙈 Ist versteckt? \t\t\t\t\t" + file.isHidden());
        System.out.println("🔓 Lesbar? \t\t\t\t\t\t\t" + file.canRead());
        System.out.println("✍️  Schreibbar? \t\t\t\t\t\t" + file.canWrite());
        System.out.println("📏 Dateigröße (in Bytes): \t\t\t" + file.length());



    }
    // ----------------- extra ---------------

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
    public static void temporaereDateiErstellen() throws IOException, IOException {
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


