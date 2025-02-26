package dsa.array;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayIntersectionExample {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 3, 5, 6, 7};
        Set<Integer> integerSet = new HashSet<>();
        Set<Integer> finalSet = new HashSet<>();
        for (Integer num: arr1) {
            integerSet.add(num);
        }
        System.out.println(integerSet);
        for (Integer num: arr2) {
            if(!integerSet.contains(num)){
                finalSet.add(num);
            }

        }

        System.out.println(finalSet);
    }
}
