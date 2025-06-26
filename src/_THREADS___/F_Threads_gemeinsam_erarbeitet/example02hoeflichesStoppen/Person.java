package _THREADS___.F_Threads_gemeinsam_erarbeitet.example02hoeflichesStoppen;

public class Person implements Runnable {

    private String name;
    private boolean isRunning = true;

    public Person(String name) {
        this.name = name;
    }

    public void requestShutDown() {
        System.out.println("Thread " +
                " got shutdown Request");
        isRunning = false;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (isRunning == false) {
                break;
            }
            System.out.println("Ich bin Person " + name +
                    " und mein Thread heiszt '" +
                    Thread.currentThread().getName() + "'");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread().getName() + " is finished.");
    }
}
