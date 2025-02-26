package dsa.queue;

import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.offer("banana");
        queue.offer("apple");
        queue.offer("cherry");
        System.out.println(queue.poll()); // Output: apple
        System.out.println(queue.poll()); // Output: banana

    }
}
