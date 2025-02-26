package thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.concurrent.*;

public class ThreadStatesDemo {
    public static void main(String[] args) throws InterruptedException {
        // Create an ExecutorService with a fixed thread pool
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Create a task that will sleep for a while
        Runnable sleepingTask = () -> {
            Thread currentThread = Thread.currentThread();
            System.out.println(currentThread.getName() + " starting - State: " + currentThread.getState());
            try {
                Thread.sleep(2000); // TIMED_WAITING state
                System.out.println(currentThread.getName() + " waking up - State: " + currentThread.getState());
            } catch (InterruptedException e) {
                System.out.println(currentThread.getName() + " interrupted!");
            }
        };

        // Create a task with synchronization to demonstrate BLOCKED state
        Object lock = new Object();
        Runnable blockingTask = () -> {
            Thread currentThread = Thread.currentThread();
            System.out.println(currentThread.getName() + " trying to acquire lock - State: " + currentThread.getState());
            synchronized (lock) {
                System.out.println(currentThread.getName() + " acquired lock - State: " + currentThread.getState());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Submit tasks to ExecutorService
        System.out.println("Submitting tasks to ExecutorService...");
        Future<?> future1 = executor.submit(sleepingTask);
        Future<?> future2 = executor.submit(blockingTask);

        // CompletableFuture example
        System.out.println("\nDemonstrating CompletableFuture...");
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            Thread currentThread = Thread.currentThread();
            System.out.println(currentThread.getName() + " in CompletableFuture - State: " + currentThread.getState());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Task Complete";
        }, executor);

        // Add a callback to the CompletableFuture
        cf.thenAccept(result -> {
            Thread currentThread = Thread.currentThread();
            System.out.println(currentThread.getName() + " processing result: " + result +
                    " - State: " + currentThread.getState());
        });

        // Wait for completion
        try {
            future1.get(3, TimeUnit.SECONDS);
            future2.get(3, TimeUnit.SECONDS);
            cf.get(3, TimeUnit.SECONDS);
        } catch (ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }

        // Demonstrate thread state monitoring
        Thread monitoringThread = new Thread(() -> {
            ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
            ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
            System.out.println("\nCurrent thread states in the pool:");
            Arrays.stream(threadInfos)
                    .filter(info -> info.getThreadName().contains("pool"))
                    .forEach(info -> System.out.println(info.getThreadName() +
                            " - State: " + info.getThreadState()));
        });
        monitoringThread.start();
        monitoringThread.join();

        // Shutdown the executor
        executor.shutdown();
        if (executor.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("All tasks completed, executor shut down successfully");
        } else {
            System.out.println("Executor shutdown timed out");
        }
    }
}
