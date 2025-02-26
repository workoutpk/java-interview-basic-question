package thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureParallelExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Task 1
        CompletableFuture<Void> task1 = CompletableFuture.runAsync(() -> {
            System.out.println("Task 1 started.");
            try {
                TimeUnit.SECONDS.sleep(2);  // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task 1 completed.");
        });

        // Task 2
        CompletableFuture<Void> task2 = CompletableFuture.runAsync(() -> {
            System.out.println("Task 2 started.");
            try {
                TimeUnit.SECONDS.sleep(1);  // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task 2 completed.");
        });

        // Task 3
        CompletableFuture<Void> task3 = CompletableFuture.runAsync(() -> {
            System.out.println("Task 3 started.");
            try {
                TimeUnit.SECONDS.sleep(3);  // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task 3 completed.");
        });

        // Run tasks in parallel and wait for all to complete
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2, task3);

        // Wait for all tasks to complete
        allTasks.get();

        System.out.println("All tasks completed.");
    }
}

