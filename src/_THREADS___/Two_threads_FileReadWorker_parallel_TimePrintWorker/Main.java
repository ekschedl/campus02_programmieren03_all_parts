package _THREADS___.Two_threads_FileReadWorker_parallel_TimePrintWorker;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TimePrintWorker worker = new TimePrintWorker("Zeit-Worker");

        Thread thread = new Thread(worker);
        thread.start();

        Thread.sleep(5000); // 5 Sekunden warten

        worker.stopWorker(); // Worker stoppen
    }
}
