package ue_10;

import java.io.*;

public class ue_10 {
    public static void main(String[] args) throws IOException {

        System.out.println("UE 10");

        // InputStreamReader und BufferedReader für die Eingabe von System.in
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inputStreamReader);

        String line = br.readLine();

//Öffne file <UE9

        File f = new File("test.txt");
        FileWriter fw = new FileWriter(f, true); //append true damit es  dazugeschrieben wird, nicht überschreibt
        PrintWriter pw = new PrintWriter(fw);
        while (!line.equalsIgnoreCase("STOP")) {
            System.out.println("read");
            line = br.readLine();

        }

        pw.flush();
        pw.close();

    }
}
