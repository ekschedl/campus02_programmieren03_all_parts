package ue_15;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ue_15_fileOutStream {
    public static void main(String[] args) throws IOException {
        System.out.println("UE15");
//        Schreiben Sie "das ist ein Test" in einFile,
//        nenutzen Sie dazu die Klasse PrintStream

// Создание нового файла
        File file = new File("test15_fileOutputStream.txt");
        file.createNewFile();

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        String output = "Das ist ein Test";
        char[] array = output.toCharArray();
        for (char c : array) {
            fileOutputStream.write(c);
        }

//        for( int i=0;i< array.length;i++){
//            fileOutputStream.write(i);
//        }

        //hier ist die version von suchs in der Folie  für Sound
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}