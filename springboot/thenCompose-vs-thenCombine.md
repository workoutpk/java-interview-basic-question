In Java's `CompletableFuture`, `thenCombine()` and `thenCompose()` are both methods for combining or chaining asynchronous tasks, but they serve different purposes and work differently:

### 1. **`thenCombine()`**

- **Purpose**: Combines the results of two independent `CompletableFuture` instances.
- **Usage**: Used when you have two separate tasks and want to perform some operation after both have completed.
- **Functionality**: Takes another `CompletableFuture` and a `BiFunction` to combine their results.
- **Return Value**: Returns a new `CompletableFuture` with the combined result of both futures.

- **Example**:
  Suppose we want to fetch two values asynchronously (say from two different APIs) and then add them together.

  ```java
  CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 20);
  CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 30);

  CompletableFuture<Integer> result = future1.thenCombine(future2, (a, b) -> a + b);
  
  result.thenAccept(sum -> System.out.println("Sum: " + sum)); // Output: Sum: 50
  ```

### 2. **`thenCompose()`**

- **Purpose**: Chains two dependent asynchronous tasks, where the second task depends on the result of the first.
- **Usage**: Used when the result of one `CompletableFuture` is needed to initiate another.
- **Functionality**: Takes a `Function` that returns a new `CompletableFuture` based on the result of the previous one.
- **Return Value**: Returns a `CompletableFuture` that represents the result of the entire chain of operations.

- **Example**:
  Suppose we need to first fetch a user ID and then use that ID to fetch the user's details in another async task.

  ```java
  CompletableFuture<Integer> userIdFuture = CompletableFuture.supplyAsync(() -> 101);

  CompletableFuture<String> userDetailFuture = userIdFuture.thenCompose(userId ->
      CompletableFuture.supplyAsync(() -> "User details for ID " + userId));

  userDetailFuture.thenAccept(details -> System.out.println(details));
  // Output: User details for ID 101
  ```

### Summary Table

| Feature            | `thenCombine()`                                | `thenCompose()`                                    |
|--------------------|------------------------------------------------|----------------------------------------------------|
| **Use Case**       | Combine two independent futures                | Chain dependent futures (output of one is input for the next) |
| **Function Type**  | Takes `BiFunction` to combine both results     | Takes a `Function` that returns a new future       |
| **Return Value**   | New `CompletableFuture` with combined result   | New `CompletableFuture` representing chained tasks |
| **Example Use Case** | Adding two numbers from separate futures     | Fetching user details after getting a user ID      |

In short, use `thenCombine()` for parallel tasks that should be combined, and `thenCompose()` for sequential tasks where one depends on the other.