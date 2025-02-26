package dsa.array;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayUnionExample {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 3, 5, 6, 7};
        int[] arr3 = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, arr3, 0, arr1.length);
        System.out.println(Arrays.toString(arr3));
        System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);
        System.out.println(Arrays.toString(arr3));
        Set<Integer> integerSet = new HashSet<>(arr3.length);
        for (Integer integer: arr3) {
            integerSet.add(integer);
        }
        System.out.println("Union of sorted array is :: " + integerSet);

    }
}
