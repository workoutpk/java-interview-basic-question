package array;

import java.util.Arrays;
import java.util.Collections;

public class ArraySortExample {
    public static void main(String[] args) {
        int[] arr1 = {7,8,9,10,2,5,6};
        int[] arr4 = {7,8,9,10,2,5,6};
        int[] arr3 = {7,8,9,5,6, 11, 65,};
        Arrays.sort(arr1);
        System.out.println("After sorting of array :: " + Arrays.toString(arr1));
        Integer[] arr2 = Arrays.stream(arr1).boxed().toArray(Integer[] :: new);
        Arrays.sort(arr2, Collections.reverseOrder());
        System.out.println("After sorting of array :: " + Arrays.toString(arr2));

    }
}
