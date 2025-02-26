package dsa.list;

public class LinkedListDouble {
    // Function to traverse the doubly linked list
    // in forward direction
    static void forwardTraversal(Node head) {

        // Start traversal from the head of the list
        Node curr = head;

        // Continue until the current node is
        // null (end of the list)
        while (curr != null) {

            // Output data of the current node
            System.out.print(curr.data + " ");

            // Move to the next node
            curr = curr.next;
        }

        // Print newline after traversal
        System.out.println();
    }

    // Function to traverse the doubly linked list
    //in backward direction
    static void backwardTraversal(Node tail) {

        // Start traversal from the tail of the list
        Node curr = tail;

        // Continue until the current node is
        // null (end of the list)
        while (curr != null) {

            // Output data of the current node
            System.out.print(curr.data + " ");

            // Move to the previous node
            curr = curr.prev;
        }

        // Print newline after traversal
        System.out.println();
    }


    // Function to find the length of
    // a doubly linked list
    static int FindLength(Node head) {
        int count = 0;
        for (Node cur = head; cur != null; cur = cur.next)
            count++;
        return count;
    }

    // Insert a node at the beginning
    static Node insertBegin(Node head, int data) {

        // Create a new node
        Node new_node = new Node(data);

        // Make next of it as head
        new_node.next = head;

        // Set previous of head as new node
        if (head != null) {
            head.prev = new_node;
        }

        // Return new node as new head
        return new_node;
    }

    // Function to insert a new node at the end of the
    // doubly linked list
    public static Node insertEnd(Node head, int newData) {

        // Create a new node
        Node newNode = new Node(newData);

        // If the linked list is empty, set the new node as
        // the head
        if (head == null) {
            head = newNode;
        }
        else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }

            // Set the next of last node to the new node
            curr.next = newNode;

            // Set the prev of new node to the last node
            newNode.prev = curr;
        }

        return head;
    }


    // Function to insert a new node at a given position
    public static Node insertAtPosition(Node head, int pos, int new_data) {
        // Create a new node
        Node new_node = new Node(new_data);

        // Insertion at the beginning
        if (pos == 1) {
            new_node.next = head;

            // If the linked list is not empty, set
            //the prev of head to new node
            if (head != null) {
                head.prev = new_node;
            }

            // Set the new node as the head of linked list
            head = new_node;
            return head;
        }

        Node curr = head;

        // Traverse the list to find the node before
        //the insertion point
        for (int i = 1; i < pos - 1 && curr != null; ++i) {
            curr = curr.next;
        }

        // If the position is out of bounds
        if (curr == null) {
            System.out.println("Position is out of bounds.");
            return head;
        }

        // Set the prev of new node to curr
        new_node.prev = curr;

        // Set the next of new node to next of curr
        new_node.next = curr.next;

        // Update the next of current node to new node
        curr.next = new_node;

        // If the new node is not the last node, update
        //prev of next node to new node
        if (new_node.next != null) {
            new_node.next.prev = new_node;
        }

        // Return the head of the doubly linked list
        return head;
    }

    // Function to delete the first node (head) of the list
    // and return the second node as the new head
    public static Node delHead(Node head) {
        // If empty, return null
        if (head == null) {
            return null;
        }

        // Store in temp for deletion later
        Node temp = head;

        // Move head to the next node
        head = head.next;

        // Set prev of the new head
        if (head != null) {
            head.prev = null;
        }

        // Return new head
        return head;
    }


    // Function to delete the last node of the
    //doubly linked list
    public static Node delLast(Node head) {

        // Corner cases
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }

        // Traverse to the last node
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        // Update the previous node's next pointer
        if (curr.prev != null) {
            curr.prev.next = null;
        }

        // Return the updated head
        return head;
    }


    // Function to delete a node at a
    //specific position in the doubly linked list
    public static Node delPos(Node head, int pos) {

        // If the list is empty
        if (head == null) {
            return head;
        }

        Node curr = head;

        // Traverse to the node at the given position
        for (int i = 1; curr != null && i < pos; ++i) {
            curr = curr.next;
        }

        // If the position is out of range
        if (curr == null) {
            return head;
        }

        // Update the previous node's next pointer
        if (curr.prev != null) {
            curr.prev.next = curr.next;
        }

        // Update the next node's prev pointer
        if (curr.next != null) {
            curr.next.prev = curr.prev;
        }

        // If the node to be deleted is the head node
        if (head == curr) {
            head = curr.next;
        }

        // Return the updated head
        return head;
    }

    // Print the doubly linked list
    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
