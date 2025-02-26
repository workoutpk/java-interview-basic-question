package thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadWithCompletableExample {
    //Key Features:
    //
    //Asynchronous Completion: CompletableFuture allows you to perform asynchronous operations without blocking the current thread.
    //Chaining Operations: You can chain multiple operations together using methods like thenApply, thenCompose, thenAccept, etc., to create complex asynchronous workflows.
    //Completion Handling: You can handle the completion of a CompletableFuture using methods like get(), join(), and complete().
    //Exception Handling: CompletableFuture provides methods for handling exceptions that may occur during asynchronous operations.
    //Common Use Cases:
    //
    //Parallel Processing: CompletableFuture can be used to perform tasks in parallel, improving performance.
    //Asynchronous I/O: It can be used for asynchronous I/O operations, such as reading from files or making network requests.
    //Reactive Programming: CompletableFuture can be used to implement reactive programming patterns.
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "Hello, world!";
        }, executorService);

        future.thenAccept(System.out::println);
        executorService.shutdownNow();
    }
}
