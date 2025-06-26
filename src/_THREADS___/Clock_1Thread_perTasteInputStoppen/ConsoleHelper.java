package _THREADS___.Clock_1Thread_perTasteInputStoppen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleHelper {

    public static String readLine() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        try {
            return br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}