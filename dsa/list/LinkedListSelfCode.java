package dsa.list;

import java.util.List;

public class LinkedListSelfCode {
    Node head;
    int fg = 0;
    public  void add(int num){
        Node newData = new Node(num);
        if(head == null){
            head = newData;
            return;
        }
        Node current =  head;
        while (current.next != null){
            current = current.next;
        }
        current.next = newData;
    }

    public void reverse(){
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current.next != null){
            System.out.println(current.data);
            current.next = null;
        }
        current = current.next;
    }
    public static void printLinkedList(Node head){
        while (head.next != null){
            System.out.println(head.data);
            head = head.next;
        }
    }

    public void printList(){
        Node current = head;
        while (current != null){
            System.out.print(current.data + ", ");
            current = current.next ;
        }
    }
    public static void main(String[] args) {
        LinkedListSelfCode linkedListSelfCode =  new LinkedListSelfCode();
        List<Integer> integerList = List.of(2,3,4,5,6,7,8);
        for (Integer num: integerList) {
            linkedListSelfCode.add(num);
        }
        System.out.println("List in Natural Order ....");
        linkedListSelfCode.printList();
        System.out.println();
        System.out.println("List in Reverse Order ....");
        linkedListSelfCode.reverse();

    }
}
