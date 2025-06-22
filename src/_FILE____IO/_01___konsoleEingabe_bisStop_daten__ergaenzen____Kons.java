package _FILE____IO;

import java.io.*;

public class _01___konsoleEingabe_bisStop_daten__ergaenzen____Kons {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new FileWriter("daten/essen.txt", true)); // Append-Modus

        System.out.println("Was willst du noch hinzufügen? (STOP zum Beenden):");

        String zeile;
        while (!(zeile = reader.readLine()).equalsIgnoreCase("STOP")) {
            writer.println(zeile);
        }

        writer.close();
        reader.close();
        System.out.println("Daten wurden ergänzt.");
    }
}
