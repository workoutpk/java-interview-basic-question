package interview;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class InterviewTest1 {
        public static void main(String[] args) {
                ExecutorService executorService = Executors.newFixedThreadPool(5);
                CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
                        try {
                                try {
                                        TimeUnit.SECONDS.sleep(1);
                                        System.out.println("Tread Details is"  + Thread.currentThread().getName());
                                } catch (InterruptedException e) {
                                        throw new RuntimeException(e);
                                }

                        }catch (Exception e){
                                throw new RuntimeException(e);
                        }

                   return "Hello world !";
                },executorService);
                executorService.shutdown();
        }
}
