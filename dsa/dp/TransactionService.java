package dsa.dp;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransactionService {
    public void processTransaction(String userId, double amount) {
        try {
            // Set the user context for this thread
            UserContext.setUser(userId);

            // Log transaction with user context
            System.out.println("Processing transaction for user: " + UserContext.getUser());
            System.out.println("Amount: " + amount);

            // Simulate some processing
            Thread.sleep(1000);

            // More logging with user context
            System.out.println("Transaction completed for user: " + UserContext.getUser());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Always clean up ThreadLocal
            UserContext.clear();
        }



    }
}
