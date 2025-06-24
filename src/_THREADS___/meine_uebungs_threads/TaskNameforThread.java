package _THREADS___.meine_uebungs_threads;

public class TaskNameforThread implements Runnable{
    @Override
    public void run() {
        for ( int i=1; i<=10; i++){
            System.out.println("Katja "+ i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
