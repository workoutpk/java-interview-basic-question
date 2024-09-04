package interview;

import java.util.Scanner;

public class NegativeSumSubarrays {

        public static void main(String[] args) {
                // Create a Scanner object.
                Scanner scanner = new Scanner(System.in);

                // Prompt the user to enter the array size.
                System.out.print("Enter the array size: ");
                int size = scanner.nextInt();

                // Create an array to store the numbers.
                int[] arr = new int[size];

                // Prompt the user to enter the numbers.
                for (int i = 0; i < size; i++) {
                        System.out.print("Enter element " + i + ": ");
                        arr[i] = scanner.nextInt();
                }

                // Initialize the count of negative subarrays.
                int count = 0;

                // Iterate through the array.
                for (int i = 0; i < size; i++) {
                        int sum = 0;


                        for (int j = i; j < size; j++) {
                                sum += arr[j];

                                // If the sum is negative, increment the count.
                                if (sum < 0) {
                                        count++;
                                }
                        }
                }

                // Print the count of negative subarrays.
                System.out.println("The number of negative subarrays is: " + count);
        }
}

