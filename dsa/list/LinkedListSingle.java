package dsa.list;

public class LinkedListSingle {
    // Java Function to traverse and print the elements of the
    // in below function head is type of Node that consist of many number pair of (data,next);
    // Node - > Linked list
    public void traverseLinkedList(Node head){
        Node current  = head;
        while (current != null){
            System.out.println( current.data + " ");
            current = head.next;
        }
        System.out.println();
    }

    // Method to check if a key is present in the linked list
    public  boolean contains(Node head, int key){
        Node current = head;
        while (current != null){
            if(current.data == key){
                return true;
            }
            current = head.next;
        }
        return false;
    }

    public int size(Node head){
        int length = 0;
        Node current = head;
        while (current != null){
            length++;
            current = head.next;

        }
        return length;
    }

    // Java function to insert a new node at the beginning of the
    public Node insertAtBeginning(Node head, int value) {
        // Create a new node with the given value
        Node newNode = new Node(value);

        // Set the next pointer of the new node to the current
        // head
        newNode.next = head;

        // Move the head to point to the new node
        head = newNode;

        // Return the new head of the linked list
        return head;
    }


    // Function to insert a node at the end of the linked list
    public static Node insertAtEnd(Node head, int value)
    {
        // Create a new node with the given value
        Node newNode = new Node(value);

        // If the list is empty, make the new node the head
        if (head == null)
            return newNode;

        // Traverse the list until the last node is reached
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        // Link the new node to the current last node
        curr.next = newNode;

        return head;
    }

    public static Node insertPos(Node head, int pos, int data)
    {
        if (pos < 1) {
            System.out.println("Invalid position!");
            return head;
        }

        // Special case for inserting at the head
        if (pos == 1) {
            Node temp = new Node(data);
            temp.next = head;
            return temp;
        }

        // Traverse the list to find the node before the
        // insertion point
        Node prev = head;
        int count = 1;
        while (count < pos - 1 && prev != null) {
            prev = prev.next;
            count++;
        }

        // If position is greater than the number of nodes
        if (prev == null) {
            System.out.println("Invalid position!");
            return head;
        }

        // Insert the new node at the specified position
        Node temp = new Node(data);
        temp.next = prev.next;
        prev.next = temp;

        return head;
    }

    // Java Function to remove the first node
// of the linked list
    static Node removeFirstNode(Node head)
    {
        if (head == null)
            return null;

        // Move the head pointer to the next node
        Node temp = head;
        head = head.next;

        return head;
    }

    // Java Function to remove the last node of the linked list
    Node removeLastNode(Node head)
    {
        // If the list is empty, return null
        if (head == null)
            return null;

        // If the list has only one node, delete it and return
        // null
        if (head.next == null) {
            head = null;
            return null;
        }

        // Find the second last node
        Node second_last = head;
        while (second_last.next.next != null)
            second_last = second_last.next;

        // Remove the last node
        second_last.next = null;

        // Return the modified list
        return head;
    }

    // Java function to delete a node at a specific position
    public void deleteAtPosition(Node head, int position)
    {
        // If the list is empty or the position is invalid
        if (head == null || position < 1) {
            return;
        }

        // If the head needs to be deleted
        if (position == 1) {
            Node temp = head;
            head = head.next;
            temp = null;
            return;
        }

        // Traverse to the node before the position to be
        // deleted
        Node current = head;
        for (int i = 1; i < position - 1 && current != null;
             i++) {
            current = current.next;
        }

        // If the position is out of range
        if (current == null || current.next == null) {
            return;
        }

        // Store the node to be deleted
        Node temp = current.next;

        // Update the links to bypass the node to be deleted
        current.next = current.next.next;

        // Delete the node
        temp = null;
    }


}
