package _THREADS___.ue_17_threads;

public class RunnableExample implements Runnable{

    public static void main(String[] args) {
        System.out.println("creating ");


    }


    @Override
    public void run() {
        System.out.println("i am Thread" + Thread.currentThread().getName());
    }
}
