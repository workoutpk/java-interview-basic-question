package thread;

import java.util.concurrent.*;

public class ThreadExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Thread thread1 =  new MyThread();
        Thread thread2 = new MyThread();
        System.out.println("Current thread: " + Thread.currentThread().getName());

        thread1.start();  // Creates and starts a new thread
        thread2.run();    // Runs in the main thread
        System.out.println("After creation: " + thread1.getState());  // NEW


        System.out.println("After starting: " + thread2.getState());  // RUNNABLE
        // Wait for thread1 to finish
        try {
            //The join() method is used to wait for a thread to die (complete its execution). When you call join()
            // on a thread, it causes the currently running thread to pause its execution and wait until the thread being joined completes its task.
            thread1.join();
            System.out.println("Main thread waited for " + thread1.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("After completion: " + thread1.getState());  // TERMINATED


        // Ways to create thread in java
        // Usage
        Thread thread3 = new Thread(new MyRunnable());
        System.out.println("Thread has been started by Implementing the Runnable interface");
        //thread3.start();

        Thread thread4 = new Thread(new Runnable() {
            public void run() {
                System.out.println("Thread running");
            }
        });
        System.out.println("Thread has been started by Using an Anonymous Inner Class");
        //thread4.start();


        //Using Lambda Expressions (Java 8+)
        Thread thread5 = new Thread(() -> System.out.println("Thread running"));
        System.out.println("Thread has been started by Using Lambda Expressions (Java 8+)");
        //thread5.start();

        //thread.join();

        ExecutorService executor1 = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executor1.execute(() -> System.out.println("Task executed by " + Thread.currentThread().getName()));
        }
        executor1.shutdown();


        Callable<String> callable = () -> {
            Thread.sleep(1000);
            return "Thread result";
        };

        ExecutorService executor2 = Executors.newSingleThreadExecutor();
        Future<String> future1 = executor2.submit(callable);

        // Later, get the result
        String result1 = future1.get();
        System.out.println("Task executed by callable  " +result1);
        executor2.shutdown();


        Runnable task1 = () -> System.out.println("Runnable task");
        Thread thread = new Thread(task1);
        thread.start();

        Callable<String> task2 = () -> {
            return "Callable task";
        };
        ExecutorService executor3 = Executors.newSingleThreadExecutor();
        Future<String> future2 = executor3.submit(task2);
        String result2 = future2.get();
        System.out.println(result2);
        executor3.shutdownNow();
    }
}
