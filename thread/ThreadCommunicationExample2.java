package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCommunicationExample2 {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static boolean dataAvailable = false;

    public static void main(String[] args) {
        Thread producerThread = new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    // Produce data
                    System.out.println("Producing data...");
                    dataAvailable = true;
                    condition.signal();
                } finally {
                    lock.unlock();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumerThread = new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    while (!dataAvailable) {
                        condition.await();
                    }
                    // Consume data
                    System.out.println("Consuming data...");
                    dataAvailable = false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}