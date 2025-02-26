package dsa.list;

public class LinkedListExample4 {
    public static void main(String[] args) {
//        Node last = null;
//
//        // Insert a node into the empty list
//        last = LinkedListCircularSingle.insertInEmptyList(last, 1);
//
//        // Print the list
//        System.out.print("List after insertion: ");
//        LinkedListCircularSingle.printList(last);

        // Create circular linked list: 2, 3, 4
        Node first = new Node(2);
        first.next = new Node(3);
        first.next.next = new Node(4);
        Node last = first.next.next;
        last.next = first;

        System.out.print("Original list: ");
        LinkedListCircularSingle.printList(last);

        // Insert 5 at the beginning
        last = LinkedListCircularSingle.insertAtBeginning(last, 5);

        System.out.print(
                "List after inserting 5 at the beginning: ");
        LinkedListCircularSingle.printList(last);

        // Delete the last node
        last = LinkedListCircularSingle.deleteLastNode(last);
        System.out.print("List after deleting last node: ");
        LinkedListCircularSingle.printList(last);

        // Delete a specific node
        int key = 3;
        last = LinkedListCircularSingle.deleteSpecificNode(last, key);

        System.out.print("List after deleting node " + key
                + ": ");
        LinkedListCircularSingle.printList(last);


        // Delete the first node
        last = LinkedListCircularSingle.deleteFirstNode(last);

        System.out.print("List after deleting first node: ");
        LinkedListCircularSingle.printList(last);

    }
}
