package dsa.list;

class NodeD {

    // To store the Value or data.
    int data;

    // Reference to the Previous Node
    Node prev;

    // Reference to the next Node
    Node next;

    // Constructor
    NodeD(int d) {
        data = d;
        prev = next = null;
    }
};

