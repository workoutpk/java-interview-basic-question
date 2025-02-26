package dsa.stack;

class Stack {
    private int maxSize; // Maximum size of the stack
    private int[] stackArray; // Array to hold the stack elements
    private int top; // Index of the top element

    // Constructor to initialize the stack
    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1; // Stack is initially empty
    }

    // Method to push an element onto the stack
    public void push(int value) {
        if (top < maxSize - 1) { // Check if stack is not full
            stackArray[++top] = value; // Increment top and add value
            System.out.println("Pushed: " + value);
        } else {
            System.out.println("Stack is full. Cannot push " + value);
        }
    }

    // Method to pop an element from the stack
    public int pop() {
        if (top >= 0) { // Check if stack is not empty
            int value = stackArray[top--]; // Return top value and decrement top
            System.out.println("Popped: " + value);
            return value;
        } else {
            System.out.println("Stack is empty. Cannot pop.");
            return -1; // Return -1 if stack is empty
        }
    }

    // Method to peek at the top element without removing it
    public int peek() {
        if (top >= 0) { // Check if stack is not empty
            return stackArray[top]; // Return top value
        } else {
            System.out.println("Stack is empty. Cannot peek.");
            return -1; // Return -1 if stack is empty
        }
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1; // Return true if top is -1 (empty)
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return top == maxSize - 1; // Return true if top is at max size - 1 (full)
    }
}

// Main class to test the Stack implementation

