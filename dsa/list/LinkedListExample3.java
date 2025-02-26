package dsa.list;

public class LinkedListExample3 {
    public static void main(String[] args) {
        // Create a hardcoded doubly linked list:
        // 1 <-> 2 <-> 3
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;

        // Print the original list
        System.out.println("Original Linked List: ");
        LinkedListDouble.printList(head);

        // Insert a new node with data 4 at the end
        System.out.println(
                "Inserting Node with data 4 at the end: ");
        int data = 4;
        head = LinkedListDouble.insertEnd(head, data);

        // Print the updated list
        LinkedListDouble.printList(head);

        // Insert new node with data 3 at position 3
        System.out.print("Inserting Node with data 4 at position 5: ");
        int pos = 5;
        head = LinkedListDouble.insertAtPosition(head, pos, data);

        // Print the updated list
        LinkedListDouble.printList(head);



        System.out.print("After Deletion at the end: ");
        head = LinkedListDouble.delLast(head);

        LinkedListDouble.printList(head);


    }
}
