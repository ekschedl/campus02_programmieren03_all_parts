package ue_12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ue_12 {

    public static void main(String[] args) throws IOException {
        System.out.println("UE12: Read Binary from file");
        File file = new File("/Users/kaaatkina/CAMPUS02_2025/Programmieren_3/test2.txt");
        FileInputStream fis = new FileInputStream(file);
        int byteRead;
        while ((byteRead = fis.read()) != -1) {
            System.out.print(byteRead + " ");
        }

    }
}

