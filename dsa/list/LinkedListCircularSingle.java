package dsa.list;

public class LinkedListCircularSingle {
    // Function to insert a node into an empty
    // circular singly linked list
    static Node insertInEmptyList(Node last, int data) {
        if (last != null) return last;

        // Create a new node
        Node newNode = new Node(data);

        // Point newNode to itself
        newNode.next = newNode;

        // Update last to point to the new node
        last = newNode;
        return last;
    }

    // Function to print the list
    static void printList(Node last) {
        if (last == null) return;

        // Start from the head node
        Node head = last.next;
        while (true) {
            System.out.print(head.data + " ");
            head = head.next;
            if (head == last.next) break;
        }
        System.out.println();
    }

    // Function to insert a node at the beginning of the
    // circular linked list
    public static Node insertAtBeginning(Node last,
                                         int value){
        Node newNode = new Node(value);

        // If the list is empty, make the new node point to
        // itself and set it as last
        if (last == null) {
            newNode.next = newNode;
            return newNode;
        }

        // Insert the new node at the beginning
        newNode.next = last.next;
        last.next = newNode;

        return last;
    }

    // Function to insert a node at the end of a circular
    // linked list
    static Node insertEnd(Node tail, int value){
        Node newNode = new Node(value);
        if (tail == null) {
            // If the list is empty, initialize it with the
            // new node
            tail = newNode;
            newNode.next = newNode;
        }
        else {
            // Insert new node after the current tail and
            // update the tail pointer
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        return tail;
    }



    // Function to insert a node at a specific position in a
    // circular linked list
    static Node insertAtPosition(Node last, int data,
                                 int pos){
        if (last == null) {
            // If the list is empty
            if (pos != 1) {
                System.out.println("Invalid position!");
                return last;
            }
            // Create a new node and make it point to itself
            Node newNode = new Node(data);
            last = newNode;
            last.next = last;
            return last;
        }

        // Create a new node with the given data
        Node newNode = new Node(data);

        // curr will point to head initially
        Node curr = last.next;

        if (pos == 1) {
            // Insert at the beginning
            newNode.next = curr;
            last.next = newNode;
            return last;
        }

        // Traverse the list to find the insertion point
        for (int i = 1; i < pos - 1; ++i) {
            curr = curr.next;

            // If position is out of bounds
            if (curr == last.next) {
                System.out.println("Invalid position!");
                return last;
            }
        }

        // Insert the new node at the desired position
        newNode.next = curr.next;
        curr.next = newNode;

        // Update last if the new node is inserted at the
        // end
        if (curr == last)
            last = newNode;

        return last;
    }

    public static Node deleteFirstNode(Node last) {
        if (last == null) {
            // If the list is empty
            System.out.println("List is empty");
            return null;
        }

        Node head = last.next;

        if (head == last) {
            // If there is only one node in the list
            last = null;
        } else {
            // More than one node in the list
            last.next = head.next;
        }

        return last;
    }

    public static Node deleteSpecificNode(Node last,
                                          int key){
        if (last == null) {
            // If the list is empty
            System.out.println(
                    "List is empty, nothing to delete.");
            return null;
        }
        Node curr = last.next;
        Node prev = last;

        // If the node to be deleted is the only node in the
        // list
        if (curr == last && curr.data == key) {
            last = null;
            return last;
        }

        // If the node to be deleted is the first node
        if (curr.data == key) {
            last.next = curr.next;
            return last;
        }

        // Traverse the list to find the node to be deleted
        while (curr != last && curr.data != key) {
            prev = curr;
            curr = curr.next;
        }

        // If the node to be deleted is found
        if (curr.data == key) {
            prev.next = curr.next;
            if (curr == last) {
                last = prev;
            }
        }
        else {
            // If the node to be deleted is not found
            System.out.println("Node with data " + key
                    + " not found.");
        }
        return last;
    }


    public static Node deleteLastNode(Node last){
        if (last == null) {
            // If the list is empty
            System.out.println(
                    "List is empty, nothing to delete.");
            return null;
        }
        Node head = last.next;

        // If there is only one node in the list
        if (head == last) {
            last = null;
            return last;
        }
        // Traverse the list to find the second last node
        Node curr = head;
        while (curr.next != last) {
            curr = curr.next;
        }
        // Update the second last node's next pointer to
        // point to head
        curr.next = head;
        last = curr;

        return last;
    }
    // Function to search for a specific value
    // in the circular linked list
    static boolean search(Node last, int key) {
        if (last == null) {
            // If the list is empty
            return false;
        }

        Node head = last.next;
        Node curr = head;

        // Traverse the list to find the key
        while (curr != last) {
            if (curr.data == key) {
                // Key found
                return true;
            }
            curr = curr.next;
        }

        // Check the last node
        if (last.data == key) {
            // Key found
            return true;
        }
        // Key not found
        return false;
    }


    public static void main(String[] args) {
        // Create circular linked list: 2, 3, 4
        Node first = new Node(2);
        first.next = new Node(3);
        first.next.next = new Node(4);

        Node last = first.next.next;
        last.next = first;

        System.out.print("Original list: ");
        printList(last);

        // Search for a specific value
        int key = 3;
        boolean found = search(last, key);
        if (found) {
            System.out.println("Value " + key
                    + " found in the list.");
        } else {
            System.out.println("Value " + key +
                    " not found in the list.");
        }
    }
}
