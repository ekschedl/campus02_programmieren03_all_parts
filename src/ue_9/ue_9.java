package ue_9;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ue_9 {

    public static void main(String[] args) throws IOException {

        System.out.println("UE 9: write to file");

        File file = new File("test.txt");
        FileWriter fw = new FileWriter(file, true); //append true damit es  dazugeschrieben wird, nicht überschreibt
        PrintWriter pw = new PrintWriter(fw);
        pw.println("Erste Zeile ");
        pw.println("Zweite Zeile ");
        for (int i = 0; i < 10; i++) {
            pw.println("Erste Zeile " + i);
        }
        pw.flush();
        pw.close();

    }
}
