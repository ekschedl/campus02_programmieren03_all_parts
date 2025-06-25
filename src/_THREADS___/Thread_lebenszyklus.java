package _THREADS___;

public class Thread_lebenszyklus implements Runnable {

    @Override
    public void run() {
        System.out.println("➡️ Thread ist RUNNING");

        try {
            System.out.println("⏸️ Thread schläft 2 Sekunden (WAITING)");
            Thread.sleep(2000);  // künstliches Warten
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("✅ Thread ist fertig (TERMINATED)");
    }

    public static void main(String[] args) {
        System.out.println("🆕 Thread wird erstellt (NEW)");

        Thread t = new Thread(new Thread_lebenszyklus());  // Zustand NEW

        System.out.println("▶️ Thread wird gestartet (RUNNABLE)");
        t.start();  // Zustand RUNNABLE → JVM entscheidet, wann run() kommt

        System.out.println("📢 Hauptprogramm läuft unabhängig weiter");
    }
}

/*Thread_lebenszyklus
* Ablauf wenn du das startest:

✅ Thread t = new Thread(...) → NEW
✅ t.start() → RUNNABLE
✅ JVM ruft run() irgendwann auf → RUNNING
✅ Thread.sleep() → WAITING
✅ Nach dem Sleep → läuft weiter → dann TERMINATED*/