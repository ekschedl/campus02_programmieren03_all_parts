package _FILE____;

import java.io.File;

public class _00___basics_____ {
    public static void main(String[] args) {

// Datei in einem bestimmten Ordner speichern willst
        File myDatei1 = new File("/Users/kaaatkina/CAMPUS02_2025/Programmieren_3/ausgabe/noten_semester.txt");

    // Du kannst natürlich auch einen relativen Pfad nehmen, z. B.:
        File myDatei2 = new File("ausgabe/noten_semester.txt");

// Ordner im Code erstellen (falls nicht vorhanden):
        File ordner = new File("/Users/kaaatkina/CAMPUS02_2025/Programmieren_3/ausgabe");
        if (!ordner.exists()) {
            ordner.mkdirs(); // erstellt Ordner inkl. aller Zwischenordner
        }
    }
}
