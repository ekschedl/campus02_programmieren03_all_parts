package _THREADS___.F_Threads_gemeinsam_erarbeitet.example01Person;

public class Person implements Runnable {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Ich bin Person " + name +
                    " und mein Thread heiszt '" +
                    Thread.currentThread().getName()+"'");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
