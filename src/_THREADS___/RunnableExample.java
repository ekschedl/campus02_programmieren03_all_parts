package _THREADS___;

public class RunnableExample implements Runnable {

        public static void main(String[] args) {
            /*
             * Ein Thread ist ein Ausführungsstrang innerhalb eines Programms.
             * Die Java Virtual Machine (JVM) erlaubt es, dass ein Programm mehrere Threads gleichzeitig ausführt.
             *
             * Thread.currentThread(): Liefert eine Referenz auf das aktuell laufende Thread-Objekt.
             * .getName(): Gibt den Namen des Threads zurück.
             */

            System.out.println("Inside : " + Thread.currentThread().getName());
            // Zeigt an, welcher Thread gerade den Code ausführt (im Main-Thread)

            System.out.println("Creating Runnable ...");
            Runnable runnable = new RunnableExample();
            // Runnable-Objekt wird erstellt, Runnable definiert die Logik für den Thread

            System.out.println("Creating Thread ...");
            Thread thread = new Thread(runnable); // Neuer Thread wird erstellt, Status: NEU (noch nicht gestartet)

            // Optional könnte man hier den Namen des Threads setzen:
            // thread.setName("MeinNeuerThread");

            System.out.println(thread.getName()); // Gibt aktuellen Namen des Threads aus (Standardname, z. B. Thread-0)

            System.out.println("Starting Thread");
            thread.start();
            // Startet den neuen Thread, JVM ruft dann automatisch die run()-Methode auf
        }

        @Override
        public void run() {
            // Diese Methode wird ausgeführt, wenn der Thread gestartet wird
            System.out.println("Inside new Thread : " + Thread.currentThread().getName());
            // Zeigt an, welcher Thread die run()-Methode ausführt
        }
    }

/*
Main: Hello from 'main'
Dog: Hallo ich bin ein Dog und ein Thread gleichzeitig
dogThread state: RUNNABLE
Dog: Mein Thread Name: Thread-0
Dog: Ich arbeite gerade! Solange isRunning == true.
Dog: Ich arbeite gerade! Solange isRunning == true.
Dog: Ich arbeite gerade! Solange isRunning == true.
Dog: Ich arbeite gerade! Solange isRunning == true.
Dog: Ich arbeite gerade! Solange isRunning == true.
Dog: Ich arbeite gerade! Solange isRunning == true.
dogThread state: TIMED_WAITING
Request shutdown wurde von folgendem Thread ausgeführt:main
Dog: ich beende mich.
dogThread state nach join: TERMINATED
Main: Main beendet sich.

1️⃣ Startausgabe:
Main: Hello from 'main'
➡ Dein Hauptprogramm (main-Thread) startet und gibt diese Begrüßung aus.

2️⃣ Hund-Thread wird gestartet:
Dog: Hallo ich bin ein Dog und ein Thread gleichzeitig
➡ Die Dog-Klasse ist ein eigener Thread, der gerade parallel gestartet wurde.

dogThread state: RUNNABLE
➡ RUNNABLE bedeutet: Der Thread ist startbereit oder läuft bereits (genau in dem Moment ist er entweder aktiv oder wartet auf CPU-Zeit).

3️⃣ Arbeitsphase vom Dog-Thread:
Dog: Mein Thread Name: Thread-0
➡ Der Hund gibt seinen aktuellen Thread-Namen aus (standardmäßig von der JVM vergeben: Thread-0).

Dog: Ich arbeite gerade! Solange isRunning == true.
➡ Das wiederholt sich mehrmals → Der Thread führt Schleifen aus, solange das Steuerungsflag isRunning true ist.

4️⃣ Schlafphase:
dogThread state: TIMED_WAITING
➡ Dein Thread schläft kurz mit Thread.sleep() → deshalb wechselt der Zustand auf TIMED_WAITING.
TIMED_WAITING bedeutet: Der Thread pausiert für eine bestimmte Zeit (z. B. durch sleep() oder wait(timeout)).

5️⃣ Shutdown wird eingeleitet:
Request shutdown wurde von folgendem Thread ausgeführt: main
➡ Dein Hauptthread (main) setzt das Flag isRunning = false, signalisiert dem Hund also: Bitte aufhören.

6️⃣ Hund-Thread beendet sich sauber:
Dog: ich beende mich.
➡ Die Schleife erkennt isRunning == false und der Hund-Thread verlässt die Schleife und beendet sich.

7️⃣ Join und finaler Zustand:
dogThread state nach join: TERMINATED
➡ join() wurde benutzt, das heißt: Der Hauptthread wartet, bis der Hund-Thread fertig ist. Danach hat der Hund den Zustand TERMINATED → der Thread ist sauber beendet.

8️⃣ Hauptthread beendet sich:
Main: Main beendet sich.
➡ Auch dein Hauptthread ist jetzt fertig.

🟢 Zusammenfassung der Zustände:

✅ RUNNABLE → Thread aktiv oder startbereit
✅ TIMED_WAITING → Thread pausiert (z.bB. durch sleep())
✅ TERMINATED → Thread sauber beendet
*/