package meine_uebungs_threads;

public class TaskWordTwo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Word two");
            try {
                Thread.sleep(1000);  // каждый раз после вывода будет пауза
            } catch (InterruptedException e) {
                System.out.println("Thread unterbrochen");
            }
        }
    }
}