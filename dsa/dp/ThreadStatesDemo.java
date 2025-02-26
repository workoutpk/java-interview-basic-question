package dsa.dp;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadStatesDemo {
    // Resource class for demonstration
    static class SharedResource {
        private final Lock lock = new ReentrantLock();

        public void useResource() {
            lock.lock();
            try {
                // Simulate some work
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();

        // 1. NEW State
        System.out.println("\n1. Demonstrating NEW State");
        Thread newThread = new Thread(() -> {
            System.out.println("This thread will never run");
        });
        System.out.println("New thread state: " + newThread.getState());

        // 2. RUNNABLE State
        System.out.println("\n2. Demonstrating RUNNABLE State");
        Thread runnableThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                // CPU-intensive operation
//                Math.random() * Math.random();
            }
        });
        runnableThread.start();
        Thread.sleep(100); // Give thread time to start
        System.out.println("Runnable thread state: " + runnableThread.getState());
        runnableThread.interrupt();

        // 3. BLOCKED State
        System.out.println("\n3. Demonstrating BLOCKED State");
        Object lockObject = new Object();

        Thread blockingThread = new Thread(() -> {
            synchronized (lockObject) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread blockedThread = new Thread(() -> {
            synchronized (lockObject) {
                System.out.println("This will never be printed");
            }
        });

        blockingThread.start();
        Thread.sleep(100); // Ensure first thread gets the lock
        blockedThread.start();
        Thread.sleep(100); // Give second thread time to attempt lock acquisition

        System.out.println("Blocked thread state: " + blockedThread.getState());

        // 4. WAITING State
        System.out.println("\n4. Demonstrating WAITING State");
        Object waitObject = new Object();

        Thread waitingThread = new Thread(() -> {
            synchronized (waitObject) {
                try {
                    waitObject.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        waitingThread.start();
        Thread.sleep(100); // Give thread time to enter waiting state
        System.out.println("Waiting thread state: " + waitingThread.getState());
        waitingThread.interrupt();

        // 5. TIMED_WAITING State
        System.out.println("\n5. Demonstrating TIMED_WAITING State");
        Thread timedWaitingThread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        timedWaitingThread.start();
        Thread.sleep(4000);
        System.out.println("TIMED_WAITING thread state: " + timedWaitingThread.getState());

        // 6. TERMINATED State
        System.out.println("\n6. Demonstrating TERMINATED State");
        Thread terminatedThread = new Thread(() -> {
            // Do nothing
        });

        terminatedThread.start();
        Thread.sleep(100); // Give thread time to complete
        System.out.println("Terminated thread state: " + terminatedThread.getState());

    }
}
