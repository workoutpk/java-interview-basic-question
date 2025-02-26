package dsa.list;


public class Node {
    int data; // Data stored in the node
    Node next; // Pointer to the next node
    Node prev; // Pointer to the previous node

    // Constructor to initialize the node with data
    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
