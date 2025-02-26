package dsa.list;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LinkedListExample1 {
    // Function to print the linked list
    public static void printList(Node head) {
        // Loop that runs till head is null
        while (head != null) {

            // Printing current node data
            System.out.print(" " + head.data);

            // Moving to the next node in the list
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Create a hard-coded linked list:
        // 2 -> 3 -> 4 -> 5 -> 6
        Node head = new Node(2);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(6);

        // Printing the above list
        System.out.print("Linked List:");
        printList(head);
    }
}
