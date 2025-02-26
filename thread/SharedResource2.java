package thread;

public class SharedResource2 {
    private boolean isDataReady = false;

    public synchronized void produceData() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " is producing data.");
        Thread.sleep(1000); // Simulate work
        isDataReady = true;
        System.out.println("Data produced, notifying consumers.");
        notifyAll(); // Wake up all waiting consumers
    }

    public synchronized void consumeData() throws InterruptedException {
        while (!isDataReady) {
            System.out.println(Thread.currentThread().getName() + " is waiting for data.");
            wait(); // Release lock and wait
        }
        System.out.println(Thread.currentThread().getName() + " consumed the data.");
        isDataReady = false; // Reset for next cycle
    }
}
