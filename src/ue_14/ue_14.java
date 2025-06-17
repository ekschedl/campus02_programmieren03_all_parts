package ue_14;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ue_14 {

    public static void main(String[] args) throws IOException {
        System.out.println("UE14: write Binary single chars");

        // Создание нового файла
        File file = new File("test4.txt");
        file.createNewFile();

        // Запись данных в файл
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        String outputText = "Hello World";
        char[] charArray = outputText.toCharArray();
        for (char c : charArray) {
            fileOutputStream.write(c);  // Запись символов как байтов
        }
        fileOutputStream.flush();
        fileOutputStream.close();

        // Чтение данных из файла и вывод на консоль
        FileInputStream fileInputStream = new FileInputStream(file);
        int byteRead;
        while ((byteRead = fileInputStream.read()) != -1) {
            // Преобразуем байт обратно в символ и выводим
            System.out.print((char) byteRead);
        }
        fileInputStream.close();
    }
}