package file.ue12_read_text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("UE12: Read BINARY from file");

        File file = new File("C:\\Users\\b50394\\IdeaProjects\\PR3_local\\test\\test.txt");
        FileInputStream fis = new FileInputStream(file);
        int byteRead;
        while ((byteRead = fis.read()) != -1){
            System.out.print(byteRead + " ");
        }
    }
}
