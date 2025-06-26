package _THREADS___;

public class ThreadStartTwice extends Thread {

    @Override
    public void run() {
        System.out.println("running...");
    }

    public static void main(String[] args) {
        ThreadStartTwice t1 = new ThreadStartTwice();

        t1.start(); // Startet den Thread korrekt, ruft run() im neuen Thread auf

        t1.start(); // ❌ Fehler! Ein Thread darf nur EINMAL gestartet werden
    }
}