package dsa.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeapExample {
    public static void main(String[] args) {
        // Create a max-heap using PriorityQueue and Collections.reverseOrder() comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Insert elements into the heap
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(15);
        maxHeap.add(5);
        maxHeap.add(30);
        // Print and remove elements from the max-heap
        System.out.println("Max-Heap Elements:");
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll()); // Removes and prints the largest element
        }
    }
}
