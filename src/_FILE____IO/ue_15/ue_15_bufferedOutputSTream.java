package _FILE____IO.ue_15;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ue_15_bufferedOutputSTream {

    public static void main(String[] args) throws IOException {
        File f=new File("test15_buffered.txt");
        FileOutputStream fos=new FileOutputStream(f);
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        bos.write("Das ist test  in UTF8 äaääaäa".getBytes(StandardCharsets.UTF_8));
        bos.flush();
        bos.close();
    }}
