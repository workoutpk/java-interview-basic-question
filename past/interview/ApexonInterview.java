package past.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApexonInterview {
    public static void main(String[] args) {
        Integer[] s = {1,4,5,6,7,8,9};
        System.out.println("Original Array ::: "+Arrays.toString(s));
        List<Integer> list1 = Arrays.asList(1,4,5,6,7,8,9);
        List<Integer> list2 = list1.stream().filter(i -> i != list1.indexOf(i) + 1).toList();
        System.out.println("Non Index Array :: " + list2);
        int[][] array = {
                {1, 1},
                {3, 2},
                {5, 3},
                {4, 1},
                {2, 3},
                {1, 4}
        };
        // Print the array
        int m = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

    }
}
