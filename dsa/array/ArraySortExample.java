package dsa.array;

import java.util.Arrays;

public class ArraySortExample {
    public static void main(String[] args) {
        // Initialize an unsorted array
        int[] numbers = {5, 3, 8, 1, 2, 7};

        // Print the original array
        System.out.println("Original Array: " + Arrays.toString(numbers));
        Arrays.parallelSort(numbers);
        System.out.println("Sorted Array : " + Arrays.toString(numbers));
    }
}
