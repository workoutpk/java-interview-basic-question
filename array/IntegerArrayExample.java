package array;

import java.util.ArrayList;

public class IntegerArrayExample {
    public static void main(String[] args) {
        // Array of primitive ints
        int[] intArray = {1, 2, 3, 4, 5};

        // Array of Integer objects
        Integer[] integerArray = {1, 2, null, 4, 5};
        // Accessing elements
        System.out.println("Primitive int array:");
        for (int i : intArray) {
            System.out.print(i + " "); // Outputs: 1 2 3 4 5
        }

        System.out.println("\n\nInteger array:");
        for (Integer i : integerArray) {
            System.out.print(i + " "); // Outputs: 1 2 null 4 5
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(5); // Autoboxing from int to Integer
        int num = list.get(0); // Unboxing from Integer to int
    }
}
