package thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureChainingExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // First task: Fetch user data (returns String)
        CompletableFuture<String> fetchUserData = CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching user data...");
            // Simulate delay
            sleep(1000);
            return "User: John Doe";
        });

        // Second task: Process fetched user data (returns String)
        CompletableFuture<String> processUserData = fetchUserData.thenApply(userData -> {
            System.out.println("Processing data for: " + userData);
            // Simulate delay
            sleep(1000);
            return userData + " (Processed)";
        });

        // Third task: Notify completion (doesn't return anything)
        CompletableFuture<Void> notifyCompletion = processUserData.thenAccept(processedData -> {
            System.out.println("Notifying completion for: " + processedData);
            // Simulate delay
            sleep(500);
        });

        // Blocking main thread until the entire chain of tasks completes
        notifyCompletion.get();

        System.out.println("All tasks completed.");
    }

    // Helper method to simulate delay
    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

