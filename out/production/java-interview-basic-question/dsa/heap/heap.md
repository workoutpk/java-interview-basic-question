# 1. Min-Heap Example (using PriorityQueue):
```java
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

```
## Output 
```properties
Min-Heap Elements:
5
10
15
20
30

```
# 2. Max-Heap Example (using PriorityQueue with a custom comparator):

```java
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

```

## Output
```properties
Max-Heap Elements:
30
20
15
10
5

```
### Explanation 
**Min-Heap**: The `PriorityQueue` class in Java implements a min-heap by default. When elements are added to it, they are automatically ordered such that the smallest element is at the root. By calling poll(), the smallest element is removed and printed.

**Max-Heap**: To implement a max-heap, the `PriorityQueue` is initialized with Collections.reverseOrder() to reverse the natural ordering, making it behave like a max-heap.