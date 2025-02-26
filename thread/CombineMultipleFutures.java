package thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CombineMultipleFutures {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Simulate fetching user details
        CompletableFuture<String> userDetailsFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching User Details...");
            sleep(1000);
            return "User: John Doe";
        });

        // Simulate fetching user orders
        CompletableFuture<String> userOrdersFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching User Orders...");
            sleep(1500);
            return "Orders: [Laptop, Phone]";
        });

        // Simulate fetching user payment history
        CompletableFuture<String> paymentHistoryFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching Payment History...");
            sleep(1200);
            return "Payment History: [Paid in Full]";
        });

        // Combine userDetailsFuture and userOrdersFuture
        CompletableFuture<String> combinedFuture1 = userDetailsFuture.thenCombine(userOrdersFuture, (userDetails, userOrders) -> {
            return userDetails + ", " + userOrders;
        });

        // Combine the result of combinedFuture1 with paymentHistoryFuture
        CompletableFuture<String> finalCombinedFuture = combinedFuture1.thenCombine(paymentHistoryFuture, (combinedResult, paymentHistory) -> {
            return combinedResult + ", " + paymentHistory;
        });

        // Get the final result
        String result = finalCombinedFuture.get();  // This will block until all tasks are completed
        System.out.println("Final Combined Result: " + result);
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

