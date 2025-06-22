package _FILE____IO.ue_15;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class ue_15_printstream {

    public static void main(String[] args) throws IOException {
        System.out.println("UE15");

        File file1 = new File("test15_printstream.txt");
        PrintStream printstream = new PrintStream(file1);
        String output1 = "Das ist ein Test üüüü";
        printstream.println(output1);

        printstream.flush();
        printstream.close();


    }
}
