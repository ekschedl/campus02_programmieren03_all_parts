package _THREADS___.ue_18_threads_with_stop;

public class CounterTask implements Runnable{

    private Counter counter;

    public CounterTask(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            counter.increment();
            try {
                Thread.sleep(1000); // пауза 1 секунда
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread wurde unterbrochen");
            }
        }
    }
    }

