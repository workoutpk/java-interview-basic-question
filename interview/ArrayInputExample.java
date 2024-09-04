package interview;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class ArrayInputExample {
        public static void main(String[] args) {
                Scanner  scanner= new Scanner(System.in);
                // Prompt the user to enter the number of numbers.
                System.out.print("Enter the number of numbers: ");
                int numberOfNumbers = scanner.nextInt();

                // Create an array to store the numbers.
                int[] numbers = new int[numberOfNumbers];

                // Prompt the user to enter the numbers.
                for (int i = 0; i < numberOfNumbers; i++) {
                        System.out.print("Enter number " + i + ": ");
                        numbers[i] = scanner.nextInt();
                }

                // Print the numbers.
                for (int number : numbers) {
                        System.out.println(number);
                }


        }
}
