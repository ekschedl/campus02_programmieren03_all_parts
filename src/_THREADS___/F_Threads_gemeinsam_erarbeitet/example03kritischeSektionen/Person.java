package _THREADS___.F_Threads_gemeinsam_erarbeitet.example03kritischeSektionen;

public class Person implements Runnable {

    private String name;
    private static Object lock = new Object(); //unser LOCK
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
        synchronized (lock) {
            for (int i = 0; i < 10; i++) {
                if (isRunning == false) {
                    break;
                }
                System.out.println("Ich bin Person " + name +
                        " und mein Thread heiszt '" +
                        Thread.currentThread().getName() + "'");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " is finished.");
    }
}
