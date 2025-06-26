package P_R_O_B_E_pruefung_PR3_von_2023;

import java.io.*;

//Erstellen Sie eine Main Klasse mit einer main-Funktion.
//• Die main-funktion hat folgenden Ablauf:
//o Öffnen einer neuen Datei „hallo.txt“
//o Schreiben Sie folgende Binärzahl in die Datei: 43 (Dezimal), in Hex: 0x2B.
//o Dieses Zeichen soll 20-mal in die Datei geschrieben werden

public class Main_BinaerFile {

    public static void main(String[] args) {


        File file = new File("hello.txt");

        // Versuch Datei zu erstellen
        try {
            // Datei erstellen (nur beim ersten Mal)
            if (file.createNewFile()) {
                System.out.println("Das Doc wurde erstellt. Name: " + file.getName());
            } else {
                System.out.println(file.getName() + " existiert bereit");
            }

        } catch (SecurityException e) {
            // Wird geworfen, wenn das Programm keine Berechtigung hat, Datei zu erstellen
            System.out.println("Keine Berechtigung, Datei zu erstellen.");
            e.printStackTrace();
            return;
        } catch (IOException e) {
            // Allgemeiner Fehler beim Erstellen der Datei (z.B. ungültiger Pfad, gesperrtes Medium)
            System.out.println(" Fehler beim Erstellen der Datei.");
            e.printStackTrace();
            return; // Wenn Datei nicht erstellt werden kann, macht Schreiben keinen Sinn
        }

        // Versuch Binärdaten in die Datei zu schreiben
        try {
            // Schreiben in die Datei mit FileOutputStream (fos wird verwendet für binäres Schreiben)
            FileOutputStream fos = new FileOutputStream(file);

            // Binärzahl (Hex: 0x2B = Dezimal 43) vorbereiten
            byte forInsert = 0x2B; //Hexadezimalzahl (gleich 43 in Dezimal)

            for (int i = 0; i < 20; i++) {
                fos.write(forInsert); // schreibt 0x2B
            }

            fos.close(); //wichtig! Datei schließen
            System.out.println("20-mal 0x2B wurden erfolgreich in die Datei geschrieben");

        } catch (FileNotFoundException e) {
            //  Tritt auf, wenn Datei nicht gefunden wird oder nicht geöffnet werden kann
            System.out.println("Datei konnte nicht zum Schreiben geöffnet werden.");
            e.printStackTrace();
        } catch (SecurityException e) {
            //  Wird geworfen, wenn das Programm keine Schreibrechte auf die Datei hat
            System.out.println(" Keine Berechtigung zum Schreiben in die Datei.");
            e.printStackTrace();
        } catch (IOException e) {
            //  Allgemeiner Schreibfehler (z.B. bei Schreibfehler auf der Festplatte)
            System.out.println("Fehler beim Schreiben in die Datei.");
            e.printStackTrace();
        }
    }
}

//public static void main(String[] args) {
//    //Erstellen Sie eine Main Klasse mit einer main-Funktion.
//    //• Die main-funktion hat folgenden Ablauf:
//    //o Öffnen einer neuen Datei „hallo.txt“
//    //o Schreiben Sie folgende Binärzahl in die Datei: 43 (Dezimal), in
//    //Hex: 0x2B.
//    //o Dieses Zeichen soll 20-mal in die Datei geschrieben werden
//
//
//    File file =new File("hello.txt");
//
//    // Versuch Datei zu erstellen
//    try {
//        // Datei erstellen (nur beim ersten Mal)
//        if(file.createNewFile()){
//            System.out.println("Das Doc wurde erstellt. Name: " + file.getName());
//        }
//        else {
//            System.out.println(file.getName() + " existiert bereit");
//        }
//
//    } catch (IOException e) {
//        System.out.println(" Fehler beim Erstellen der Datei.");
//        e.printStackTrace();
//        return; // Wenn Datei nicht erstellt werden kann, macht Schreiben keinen Sinn
//    }
//
//
//    // Versuch Binärdaten in die Datei zu schreiben
//    try {
//        // Schreiben in die Datei mit FileOutputStream (fos wird verwendet für binäres Schreiben)
//        FileOutputStream fos=new FileOutputStream(file);
//
//        // Binärzahl (Hex: 0x2B = Dezimal 43) vorbereiten
//        byte forInsert = 0x2B; //Hexadezimalzahl (gleich 43 in Dezimal)
//
//
//
//        for (int i=0; i<20; i++ ){
//            fos.write(forInsert); // schreibt 0x2B
//        }
//
//
//        fos.close(); //wichtig! Datei schliessen
//        System.out.println("20-mal 0x2B wurden erfolgreich in die Datei geschrieben");
//
//    } catch (IOException e) {
//        System.out.println("Fehler beim Schreiben in die Datei.");
//        e.printStackTrace();
//    }
//
//
//
//}