package _THREADS___.F_Threads_gemeinsam_erarbeitet.CLOCK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println(Thread.currentThread().getName()+": Starting up.");
        Clock c = new Clock();
        Thread t = new Thread(c);
        t.start();
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String a = br.readLine();
        c.requestShutDown();
        System.out.println(Thread.currentThread().getName()+": reached end.");
    }
}
