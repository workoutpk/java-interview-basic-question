package dsa.heap;

import java.util.PriorityQueue;

public class MinHeapExample {
    public static void main(String[] args) {
        // Create a min-heap using PriorityQueue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Insert elements into the heap
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(15);
        minHeap.add(5);
        minHeap.add(30);

        // Print and remove elements from the min-heap
        System.out.println("Min-Heap Elements:");
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll()); // Removes and prints the smallest element
        }
    }
}
