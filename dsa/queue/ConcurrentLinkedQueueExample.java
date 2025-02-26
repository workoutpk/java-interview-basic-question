package dsa.queue;

import java.lang.reflect.Type;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueExample {
    public static void main(String[] args) {
        //Type 1.
        Queue<String> queue1 = new ConcurrentLinkedQueue<>();
        queue1.offer("apple");
        queue1.offer("banana");
        queue1.offer("cherry");
        System.out.println(queue1.poll()); // Output: apple
        System.out.println(queue1.peek()); // Output: banana

        //Type 2.
        ConcurrentLinkedQueue<String> concurrentQueue = new ConcurrentLinkedQueue<>();

    }
}
