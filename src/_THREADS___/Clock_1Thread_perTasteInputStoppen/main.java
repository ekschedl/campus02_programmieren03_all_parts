package _THREADS___.Clock_1Thread_perTasteInputStoppen;

/*
Schreiben Sie eine Konsolenanwendung mit einem Hintergrund-Thread,
welcher im Sekundentakt die aktuelle Uhrzeit ausgibt Aktuelle Uhrzeit:
    Date d = new Date();
    System.out.println(d.toString())
Per Tastendruck / Eingabe eines Zeichens soll die Anwendung (und der Thread „höflich“)
gestoppt werden können.
 */

public class main {
    public static void main(String[] args) {

        Worker w1 = new Worker();
        Thread t1 = new Thread(w1);
        t1.start();

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
