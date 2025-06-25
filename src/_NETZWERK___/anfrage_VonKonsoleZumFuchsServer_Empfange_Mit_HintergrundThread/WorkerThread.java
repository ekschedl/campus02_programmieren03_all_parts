package _NETZWERK___.anfrage_VonKonsoleZumFuchsServer_Empfange_Mit_HintergrundThread;

import java.io.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class WorkerThread implements Runnable {
    BufferedWriter out;

    public WorkerThread(BufferedWriter out) {
        this.out = out;
    }

    @Override
    public void run() {
        while (Thread.currentThread().isInterrupted() == false) {
            String message = Thread.currentThread().getName() + ": Ich bin ein Hintergrundthread";

            // out.write(message); // Message zum server schicken
            // out.write(System.lineSeparator());
            // out.flush();
            System.out.println(message); // Message auf Konsole schreiben

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

