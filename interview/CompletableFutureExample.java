package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {
        public static void main(String[] args) {
                ExecutorService executor = Executors.newFixedThreadPool(5);

                CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                        System.out.println("Thread " + Thread.currentThread().getName() + " is running");
                        try {
                                TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                        return "Hello world!";
                }, executor);

                future.thenAccept(result -> {
                        System.out.println("The result is " + result);
                });

                executor.shutdown();
        }

        public static class CangaraIntervewExample {
                public static void main(String[] args) {
                        List<Integer> list1 = Arrays.asList(4,3,7,5,6,2);
                        List<Integer> list2 = Arrays.asList(9,1,8,11,13);

                        List<Integer> list3 = new ArrayList<>();
                        list3.addAll(list1);
                        list3.addAll(list2);
                        List<Integer> list4 = list3.stream().distinct().sorted(Comparator.naturalOrder()).toList();
                        int  median =0;
                        if(list4.size()%2==0){
                                int a = list4.size()/2;
                                median= list4.get(a-1);
                        }else {
                                int a = list4.size()/2;

                                median= list4.get(a);
                        }
                        System.out.println(list4);
                        System.out.println("Size is :::  "+list4.size());
                        System.out.println("Index of  ::::::::::::;" +list4.get(5));
                        System.out.println("median is ::: "+ median );
                        List<Integer> list5 = Arrays.asList(1,2,3,5,6,7,8,9);
                        List<Integer> missingNumber = list5.stream()
                                .filter(number->list5.indexOf(number)+1 !=number).toList();
                        System.out.println("Missing Number "+missingNumber);
                        System.out.println("Index of "+list5.indexOf(5));

                }
        }
}
