package dsa.list;

public class LinkedListExample2 {
    public static void main(String[] args) {
        // Sample usage of the doubly linked
        // list and traversal functions
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;

        System.out.println("Forward Traversal:");
        LinkedListDouble.forwardTraversal(head);

        System.out.println("Backward Traversal:");
        LinkedListDouble.backwardTraversal(third);
        System.out.println("Length of doubly linked list: "
                + LinkedListDouble.FindLength(head));
    }
}
