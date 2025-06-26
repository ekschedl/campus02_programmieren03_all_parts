package _THREADS___.Two_threads_FileReadWorker_parallel_TimePrintWorker;

public class MainMitZweiThreads {

    public static void main(String[] args) throws InterruptedException {

        TimePrintWorker timeWorker = new TimePrintWorker("Uhrzeit-Worker");
        Thread timeThread = new Thread(timeWorker);
        timeThread.start();

        FileReadWorker fileWorker = new FileReadWorker("Datei-Leser", "test.txt");
        Thread fileThread = new Thread(fileWorker);
        fileThread.start();

        fileThread.join(); // warten bis Datei fertig eingelesen

        System.out.println("Datei komplett eingelesen, stoppe TimePrintWorker...");
        timeWorker.stopWorker();

        timeThread.join();
        System.out.println("Alle Threads sind beendet.");
    }
}
//}
//✔️ Der FileReadWorker liest die Datei korrekt zeilenweise.
//✔️ Parallel gibt der TimePrintWorker regelmäßig die aktuelle Uhrzeit aus.
//✔️ Sobald die Datei komplett eingelesen ist, wird der TimePrintWorker sauber gestoppt.
//        ✔️ Alle Threads beenden sich kontrolliert.