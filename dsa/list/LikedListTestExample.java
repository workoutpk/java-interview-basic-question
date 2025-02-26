package dsa.list;

public class LikedListTestExample {
    static Node head;
    public void add(int data){

        Node newData = new Node(data);
        if(head == null){
            head = newData;
            return;
        }
        Node current = head;
        while (current.next != null){
            current = current.next; // added new node to head
        }
        current.next = newData; // assign new node in current pointer

    }
    // Method to reverse the linked list
    public void reverse() {

        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next; // Store next node in separate node that reference() of list node
            current.next = prev; // Reverse current node's pointer to separate node  that contains null value
            prev = current;      // Move pointers one position ahead
            current = next;
        }
        head = prev; // Update head to point to the new first element
    }

    public int size(){
        Node current = head;
        int i = 1;
        while (current.next != null){
            current = current.next;
            i++;
        }
        return i;
    }

    public void printList(){
        Node current = head;
        while (current != null){
            System.out.print(current.data + ", ");
            current = current.next ;
        }
    }

    public static Boolean contains(Node head, int value){
        Node current = head;
        while (current !=null){
            if(current.data == value){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 4, 5, 6, 7};

        LikedListTestExample list = new LikedListTestExample();

        System.out.println("Added Linked List:");
         //Adding elements from the array to the linked list
        for (int value : originalArray) {
            list.add(value);
        }
    ;
        list.printList();
        System.out.println();
        System.out.println("Reversed Linked List:");
        list.reverse();
        list.printList();
        System.out.println();
        System.out.println("Linked list size is  " + list.size());
        System.out.println("Linked list contains value 6 " + contains(head, 6));
    }


}
