package _NETZWERK___.HerrFuchs_ServerVerbinden;

public class WorkerThread implements Runnable {

    private volatile boolean running = true; // erlaubt sicheres Stoppen von außen

    public void stopThread() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            System.out.println("Ich bin ein Thread und laufe im Hintergrund!");

            try {
                Thread.sleep(3000); // 3 Sekunden warten
            } catch (InterruptedException e) {
                System.out.println("Thread wurde unterbrochen.");
                Thread.currentThread().interrupt(); // guter Stil: Interrupt-Flag wieder setzen
                break;
            }
        }

        System.out.println("Hintergrundthread wurde gestoppt.");
    }
}