package dsa.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamExample {
    public static void main(String[] args) {
        // Create a list of numbers
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        System.out.println("Original List: " + numbers);

        // Process using parallel stream
        List<Integer> squaredNumbers = numbers.parallelStream()
                .map(num -> {
                    System.out.println("Processing " + num + " in thread: " + Thread.currentThread().getName());
                    return num * num;
                })
                .collect(Collectors.toList());

        System.out.println("Squared Numbers: " + squaredNumbers);
    }
}
