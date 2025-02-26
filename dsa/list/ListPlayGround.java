package dsa.list;

import java.util.List;

public class ListPlayGround {
    static Node head;
    public static void addList(int data){
        Node newNode = new Node(data);
        if(head == null){
            head =newNode;
            return;
        }
        Node current  =  head;
        while (current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }

    static  void printList(){
        Node current = head;
        System.out.print("List Element :: ");
        while (current != null){
            System.out.print(current.data+ ", ");
            current = current.next;
        }
    }

    static void reverseList(){
        Node prev = null;
        Node current = head;
        Node next = null; //temp store
        while (current !=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        List<Integer> list1 = List.of(1,2,3,4,5,6,7,8,9);
        System.out.println("Before Reversed List :: ");
        list1.forEach(ListPlayGround::addList);
        printList();
        System.out.println();
        System.out.println("After Reversed List ::");
        reverseList();
        printList();

    }
}
