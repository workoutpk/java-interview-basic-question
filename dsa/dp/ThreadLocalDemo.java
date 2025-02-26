package dsa.dp;

public class ThreadLocalDemo {
    public static void main(String[] args) {
        TransactionService service = new TransactionService();

        // Create multiple threads processing transactions
        Thread thread1 = new Thread(() -> {
            service.processTransaction("user1", 100.0);
        });

        Thread thread2 = new Thread(() -> {
            service.processTransaction("user2", 200.0);
        });

        thread1.start();
        thread2.start();
    }
}
