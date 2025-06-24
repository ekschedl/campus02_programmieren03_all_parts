package _THREADS___.ue_18_threads_with_stop;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TimePrinter taskTimePrint = new TimePrinter();
        Thread myThread = new Thread(taskTimePrint);
        myThread.start();


        Scanner sc = new Scanner(System.in);
        String userInput;


        while (true) {
            System.out.println("Gib 'q' ein, um die Zeit-Anzeige zu stoppen:");
            userInput = sc.nextLine();
            if (userInput.equalsIgnoreCase("q")) {
                taskTimePrint.stopRunning();
                break;
            } else if (userInput.equalsIgnoreCase("sonne")) {
                Thread myThread2 = new Thread(new SonneTask());
                myThread2.start();
            } else if (userInput.equalsIgnoreCase("regen")) {
                Thread myThread3 = new Thread(new RegenTask());
                myThread3.start();
            }else {
                System.out.println("Unbekannter Befehl.");
            }
        }
    }

}
