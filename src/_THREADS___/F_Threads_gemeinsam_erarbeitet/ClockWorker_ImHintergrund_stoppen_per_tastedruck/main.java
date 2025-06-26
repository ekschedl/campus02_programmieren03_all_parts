package _THREADS___.F_Threads_gemeinsam_erarbeitet.ClockWorker_ImHintergrund_stoppen_per_tastedruck;/*
Schreiben Sie eine Konsolenanwendung mit einem Hintergrund-Thread,
welcher im Sekundentakt die aktuelle Uhrzeit ausgibt Aktuelle Uhrzeit:
    Date d = new Date();
    System.out.println(d.toString())
Per Tastendruck / Eingabe eines Zeichens soll die Anwendung (und der Thread „höflich“)
gestoppt werden können.
 */

public class main {
    public static void main(String[] args) {

        ClockWorker w1 = new ClockWorker();
        ClockWorker w2 = new ClockWorker();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w2);

        t1.start();
        t2.start();

        System.out.println("Drücken Sie eine Taste bzw. Eingabe um zu stoppen ...");
        if (ConsoleHelper.readLine() != null) {
            w1.requestShutDown();
        }


        try {
            t1.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Fertig!");
    }
}
