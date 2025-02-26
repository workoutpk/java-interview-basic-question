package array;

import java.util.Arrays;

public class ArrayEqualsExample {
    public static void main(String[] args) {
        // Define the two arrays
        int[] arr1 = {7, 8, 9, 10, 2, 5, 6};
        int[] arr4 = {7, 8, 9, 10, 2, 5, 6};

        // Check if the arrays are equal
        boolean areEqual = Arrays.equals(arr1, arr4);

        // Output the result
        if (areEqual) {
            System.out.println("The arrays are equal.");
        } else {
            System.out.println("The arrays are not equal.");
        }
    }
}
