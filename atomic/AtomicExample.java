package atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    private static int nonAtomicCounter = 0;
    private static AtomicInteger atomicCounter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable nonAtomicTask = () -> {
            for (int i = 0; i < 1000; i++) {
                nonAtomicCounter++; // Non-atomic operation
            }
        };

        Runnable atomicTask = () -> {
            for (int i = 0; i < 1000; i++) {
                atomicCounter.incrementAndGet(); // Atomic operation
            }
        };

        Thread t1 = new Thread(nonAtomicTask);
        Thread t2 = new Thread(nonAtomicTask);
        Thread t3 = new Thread(atomicTask);
        Thread t4 = new Thread(atomicTask);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("Non-atomic counter: " + nonAtomicCounter);
        System.out.println("Atomic counter: " + atomicCounter.get());

    }
}
