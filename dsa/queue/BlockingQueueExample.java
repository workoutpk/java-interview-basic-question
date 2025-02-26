package dsa.queue;

import java.lang.reflect.Type;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) throws InterruptedException {
        //Type 1
        BlockingQueue<String> queue1 = new LinkedBlockingQueue<>();
        new Thread(() -> {
            try {
                queue1.put("apple");
                queue1.put("banana");
                queue1.put("cherry");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println(queue1.take()); // Output: apple
        System.out.println(queue1.take()); // Output: banana
        //Type 2
        BlockingQueue queue2 = new ArrayBlockingQueue(2);
        queue2.put("First");
        queue2.put("Second");

        System.out.println("Queue: " + queue2); // [First, Second]

        // Remove an element
        System.out.println("Polled: " + queue2.take()); // First
        System.out.println("Queue after polling: " + queue2); // [Second]


        //Type 3
        BlockingQueue<Object> queue3 = new PriorityBlockingQueue<>();
     }
}
