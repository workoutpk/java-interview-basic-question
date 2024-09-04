package interview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintEvenOddNumbers {

        public static void main(String[] args) {
                ExecutorService executorService = Executors.newFixedThreadPool(2);

                // Create two threads
                Thread evenThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                                for (int i = 2; i <= 10; i += 2) {
                                        System.out.println(i);
                                }
                        }
                });
                Thread oddThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                                for (int i = 1; i <= 10; i += 2) {
                                        System.out.println(i);
                                }
                        }
                });

                // Start the two threads
                executorService.submit(evenThread);
                executorService.submit(oddThread);

                // Shutdown the executor service
                executorService.shutdown();
        }


}

