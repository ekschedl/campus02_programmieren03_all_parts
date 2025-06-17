package ue_18_threads_with_stop;

public class CounterMain {

    public static void main(String[] args) {
        Counter counter=new Counter();
        CounterTask task1=new CounterTask(counter);
        Thread thread1=new Thread(task1);
        thread1.start();

        CounterTask task2 = new CounterTask(counter);
        Thread thread2 = new Thread(task2);
        thread2.start();
    }
}
