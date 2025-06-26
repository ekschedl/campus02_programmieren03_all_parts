package _THREADS___.Threads_Basis_Dog_Sleep_Interrupt_Join;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main: Hello from '" +
                Thread.currentThread().getName() + "'");
        Dog dog1 = new Dog();

        Thread dogThread1 = new Thread(dog1);
        dogThread1.start();
        System.out.println("dogThread state: " + dogThread1.getState());
        Thread.sleep(3000);
        System.out.println("dogThread state: " + dogThread1.getState());
        dog1.requestShutdown();
        //oder
        //dogThread1.interrupt();
        dogThread1.join();
        System.out.println("dogThread state nach join: " + dogThread1.getState());
        System.out.println("Main: Main beendet sich.");
    }
}