package thread;

public class WaitNotifyExample {
    public static void main(String[] args) throws InterruptedException {
        SharedResource2 resource = new SharedResource2();

        Thread producer = new Thread(() -> {
            try {
                resource.produceData();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Producer");

        Thread consumer1 = new Thread(() -> {
            try {
                resource.consumeData();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Consumer-1");

        Thread consumer2 = new Thread(() -> {
            try {
                resource.consumeData();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Consumer-2");

        consumer1.start();
        consumer2.start();
        producer.start();

        consumer1.join();
        consumer2.join();
        producer.join();
        consumer1.interrupt();
        consumer2.interrupt();
        producer.interrupt();
    }
}
