package self.test;

import java.util.*;

public class TestExample2 {
    public static void main(String[] args) {
        int[] a= {2,3,4,5};
        int[] b = {6,7,8,9 };
        List<Integer> list1= new LinkedList<>();
        for(int i = 0; i< a.length; i++){
            list1.add(a[i]);
            System.out.println(a[i]);
        }

        for(int i = 0; i< b.length; i++){
            list1.add(b[i]);
            System.out.println(a[i]);
        }

        List<Integer> sortedList = list1.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(sortedList);

        List<Integer> list2  = Arrays.asList(2, 5, 6, 7, 8);
        // Convert the list to an array using toArray()
        Integer[] array = list2.toArray(new Integer[list2.size()]);
        list1.addAll(list2);
        System.out.println("array :: " + array.toString());
        for (int element:array) {
            System.out.println(element);
        }
    }
}
