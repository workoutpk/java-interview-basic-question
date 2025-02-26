package dsa.stack;

public class StackExample1 {
    public static void main(String[] args) {
        Stack stack = new Stack(5); // Create a stack of size 5

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        // Try pushing another element to check for overflow
        stack.push(60);

        // Peek at the top element
        System.out.println("Top element: " + stack.peek());

        // Pop elements from the stack
        stack.pop();
        stack.pop();

        // Peek again after popping elements
        System.out.println("Top element after popping: " + stack.peek());

        // Pop all elements to check for underflow
        while (!stack.isEmpty()) {
            stack.pop();
        }

        // Try popping from an empty stack
        stack.pop();
    }
}
