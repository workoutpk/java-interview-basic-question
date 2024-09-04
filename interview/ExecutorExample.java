package interview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {
        public static void main(String[] args) {
                ExecutorService executor = Executors.newFixedThreadPool(5);

                for (int i = 0; i < 10; i++) {
                        Runnable task = new Runnable() {
                                public void run() {
                                        System.out.println("Thread " + Thread.currentThread().getName() + " is running");
                                        try {
                                                TimeUnit.SECONDS.sleep(1);
                                        } catch (InterruptedException e) {
                                                e.printStackTrace();
                                        }
                                }
                        };

                        executor.submit(task);
                }

                executor.shutdown();
        }
        }

