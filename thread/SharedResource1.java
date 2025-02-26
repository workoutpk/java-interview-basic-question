package thread;

class SharedResource {
    private int data;
    private boolean isProduced = false;

    // Method for the producer to produce data
    public synchronized void produce(int value) throws InterruptedException {
        // If data is already produced, wait for the consumer to consume it
        while (isProduced) {
            wait();
        }
        this.data = value;
        System.out.println("Produced: " + data);
        isProduced = true;
        notify(); // Notify the consumer that data has been produced
    }

    // Method for the consumer to consume data
    public synchronized void consume() throws InterruptedException {
        // If no data is produced, wait for the producer to produce it
        while (!isProduced) {
            wait();
        }
        System.out.println("Consumed: " + data);
        isProduced = false;
        notify(); // Notify the producer that data has been consumed
    }
}

class Producer implements Runnable {
    private SharedResource sharedResource;

    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                sharedResource.produce(i);
                Thread.sleep(500); // Simulating time to produce
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private SharedResource sharedResource;

    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                sharedResource.consume();
                Thread.sleep(1000); // Simulating time to consume
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//public class ThreadCommunicationExample {
//    public static void main(String[] args) {
//        SharedResource sharedResource = new SharedResource();
//
//        Producer producer = new Producer(sharedResource);
//        Consumer consumer = new Consumer(sharedResource);
//
//        Thread producerThread = new Thread(producer);
//        Thread consumerThread = new Thread(consumer);
//
//        producerThread.start();
//        consumerThread.start();
//    }
//}

