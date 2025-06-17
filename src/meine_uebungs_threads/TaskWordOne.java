package meine_uebungs_threads;

import ue_17_threads.ThreadStartTwice;

public class TaskWordOne implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Word one");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread unterbrochen");
            }
        }
    }






}
