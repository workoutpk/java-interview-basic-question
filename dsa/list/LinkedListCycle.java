package dsa.list;

public class LinkedListCycle {
    public static boolean hasCycle(Node head) {
        if (head == null) return false;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move slow by one
            fast = fast.next.next;      // Move fast by two

            if (slow == fast) {         // If they meet, cycle is found
                return true;
            }
        }
        return false;                   // No cycle found
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head; // Creating a cycle for testing

        System.out.println(hasCycle(head) ? "The list is circular." : "The list is not circular.");
    }

}
