package past.interview;

import java.util.concurrent.*;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        int numberOfThreads = 4;
        CyclicBarrier barrier = new CyclicBarrier(numberOfThreads, () -> System.out.println("All threads have finished"));

        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(() -> {
                try {
                    System.out.println("Thread " + Thread.currentThread().getName() + " started");
                    // Perform some task
                    barrier.await();
                    System.out.println("Thread " + Thread.currentThread().getName() + " finished");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
