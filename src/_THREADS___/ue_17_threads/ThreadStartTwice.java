package _THREADS___.ue_17_threads;

public class ThreadStartTwice extends Thread {

    @Override
    public void run() {

        System.out.println("hallo, ich bin in dem Thread this name  '"+
                Thread.currentThread().getName() + "'");

    }

    public static void main(String[] args) {
        ThreadStartTwice t1=new ThreadStartTwice();
        ThreadStartTwice t2=new ThreadStartTwice();
        t1.start(); //startet run()
        t2.start(); //startet run() // wenn gestorben-kann nicht wiedergerufen werden


        System.out.println(" hallo, ich bin in dem Thread this name  '"+
                Thread.currentThread().getName() + "'");
    }
}
