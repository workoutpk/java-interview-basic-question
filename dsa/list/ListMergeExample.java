package dsa.list;

import java.util.LinkedList;
import java.util.List;

public class ListMergeExample {
    public static void main(String[] args) {
        List<Integer> list1 = List.of(1,3,4,6,7,8,8,11);
        List<Integer> list2 = List.of(12,31,41,61,71,81,81,111);
        List<Integer> list3 = new LinkedList<>();

        list3.addAll(list1);
        list3.addAll(list2);
        System.out.println("Merge List is  :::: " + list3);
    }
}
