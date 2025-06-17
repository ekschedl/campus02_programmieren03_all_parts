import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // readFileInformation("/Users/kaaatkina/CAMPUS02_2025/FUCHS/Programmieren3/test.txt");

        File theDir = new File("eins/zwei/drei/vier/five");
        if (!theDir.exists()) {
            boolean antwort = theDir.mkdirs();
            System.out.println("Wurde das Verzeichnis erstellt: " + antwort);
            System.out.println("-- Ordners erstellt --");
        } else {
            System.out.println("-- Ordner nicht erstellt, bereits existieren --");

        }



    }



    }



//System.lineSeparator();