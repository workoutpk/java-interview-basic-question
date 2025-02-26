The `Future` and `CompletableFuture` classes in Java are both used for handling asynchronous computations, but they have key differences in functionality and usage:

### 1. **Basic Usage**

- **`Future`**:
    - Represents a single, asynchronous task with basic methods for checking if the task is complete, retrieving the result, or cancelling the task.
    - Lacks any way to provide callbacks or handle completion without blocking.

- **`CompletableFuture`**:
    - An extension of `Future` that provides a complete API for asynchronous programming in Java, including methods to chain tasks, combine multiple async computations, and handle exceptions.
    - Supports non-blocking ways of handling results, making it ideal for complex async workflows.

### 2. **Non-blocking Result Handling**

- **`Future`**:
    - To retrieve the result, you must call the `get()` method, which blocks until the computation is complete.
    - This makes `Future` impractical for cases where you need non-blocking result handling.

- **`CompletableFuture`**:
    - Allows for non-blocking operations using methods like `thenApply()`, `thenAccept()`, and `thenRun()` to specify actions after completion.
    - Supports `thenCompose()` and `thenCombine()` to combine multiple async tasks and handle results without blocking.

### 3. **Completing the Future Manually**

- **`Future`**:
    - Once a `Future` is created and submitted to an executor, it can’t be completed or changed by the user; only the executor can set its result.

- **`CompletableFuture`**:
    - Allows manual completion of the future by calling `complete()` or `completeExceptionally()`. This is useful for custom implementations of async workflows or handling exceptions manually.

### 4. **Combining Multiple Futures**

- **`Future`**:
    - Does not support combining or chaining multiple futures.
    - You would need additional logic to coordinate multiple tasks manually.

- **`CompletableFuture`**:
    - Provides powerful methods like `allOf()`, `anyOf()`, `thenCombine()`, and `thenCompose()` to combine multiple asynchronous computations, making it much more flexible for concurrent programming.

### 5. **Exception Handling**

- **`Future`**:
    - Has very limited exception handling; if an exception occurs during task execution, you can only catch it after calling `get()`.

- **`CompletableFuture`**:
    - Offers comprehensive exception handling with methods like `exceptionally()`, `handle()`, and `whenComplete()`, allowing you to catch and handle exceptions as part of the async workflow.

### Code Examples

#### Future Example

```java
import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(1000);
            return 42;
        });

        System.out.println("Is task done? " + future.isDone());
        System.out.println("Result: " + future.get()); // This blocks until the result is ready
        executor.shutdown();
    }
}
```

#### CompletableFuture Example

```java
import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(1000); } catch (InterruptedException e) { }
            return 42;
        });

        future.thenApply(result -> result * 2) // Chain a task to double the result
              .thenAccept(result -> System.out.println("Result: " + result)); // Print final result
    }
}
```

### Summary Table

| Feature                   | `Future`                              | `CompletableFuture`                                         |
|---------------------------|---------------------------------------|-------------------------------------------------------------|
| **Basic Async Handling**  | Yes, but limited                      | Yes, with extensive support                                 |
| **Blocking Result Access**| Requires `get()`, blocking            | Non-blocking with callbacks like `thenApply()`              |
| **Manual Completion**     | Not supported                         | Supported with `complete()`                                 |
| **Combining Multiple Tasks** | Not supported                      | Supported with methods like `allOf()`, `thenCombine()`      |
| **Exception Handling**    | Limited to try-catch with `get()`     | Extensive handling with `exceptionally()`, `handle()`       |

`CompletableFuture` is more advanced and flexible, ideal for complex async programming needs, while `Future` serves basic, single-task async scenarios.