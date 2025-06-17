package ue_13;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ue_13 {

    public static void main(String[] args) throws IOException {
        System.out.println("UE13: Read Binary from file + ANZAHL der eingelesenen Zeichnen");

        File file = new File("/Users/kaaatkina/CAMPUS02_2025/Programmieren_3/test2.txt");
        FileInputStream fis = new FileInputStream(file);
        System.out.println("1:"+"\t"+"DEZ CHAR");
        int byteRead;
        int count = 0;
        while ((byteRead = fis.read()) != -1) {
            System.out.println(count +":\t"+ byteRead + "\t" + (char)byteRead);
            count++;
        }
        System.out.println("\nCount: " + count);

    }
}

