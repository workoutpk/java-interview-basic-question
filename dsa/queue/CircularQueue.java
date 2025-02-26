package dsa.queue;

public class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Constructor to initialize the circular queue
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Method to add an element to the queue (Enqueue)
    public void enqueue(int item) {
        // Check if queue is full
        if (isFull()) {
            throw new IllegalStateException("Queue is full. Cannot add more elements.");
        }

        // If queue was empty, set front to 0
        if (isEmpty()) {
            front = 0;
        }

        // Move rear and wrap around if needed
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
    }

    // Method to remove an element from the queue (Dequeue)
    public int dequeue() {
        // Check if queue is empty
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. Cannot remove elements.");
        }

        // Get the element to return
        int removedItem = queue[front];

        // If last element is being removed
        if (size == 1) {
            front = -1;
            rear = -1;
        } else {
            // Move front and wrap around if needed
            front = (front + 1) % capacity;
        }

        // Decrease size
        size--;

        return removedItem;
    }

    // Method to peek at the front element without removing
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. No elements to peek.");
        }
        return queue[front];
    }

    // Method to get the current size of the queue
    public int getSize() {
        return size;
    }

    // Method to print the queue contents
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue: ");
        int count = 0;
        int index = front;

        while (count < size) {
            System.out.print(queue[index] + " ");
            index = (index + 1) % capacity;
            count++;
        }
        System.out.println();
    }

    // Main method to demonstrate circular queue functionality
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);

        // Enqueue elements
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50);

        // Print the queue
        cq.printQueue();

        // Dequeue some elements
        System.out.println("Dequeued: " + cq.dequeue());
        System.out.println("Dequeued: " + cq.dequeue());

        // Print queue after dequeue
        cq.printQueue();

        // Enqueue more elements to show circular nature
        cq.enqueue(60);
        cq.enqueue(70);

        // Print final queue
        cq.printQueue();

        // Peek at front element
        System.out.println("Front element: " + cq.peek());
        System.out.println("Current size: " + cq.getSize());
    }
}
