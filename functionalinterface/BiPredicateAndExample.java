package functionalinterface;

import java.util.function.BiPredicate;

public class BiPredicateAndExample {
    public static void main(String[] args) {
        //Supports logical operations like and(), or(), and negate()
        // Check if both integers are positive
        BiPredicate<Integer, Integer> bothPositive = (a, b) -> a > 0 && b > 0;

        // Check if the sum of two integers is greater than 100
        BiPredicate<Integer, Integer> sumGreaterThanHundred = (a, b) -> (a + b) > 100;

        // Combine both conditions with "and"
        BiPredicate<Integer, Integer> bothPositiveAndSumGreaterThanHundred = bothPositive.and(sumGreaterThanHundred);

        System.out.println(bothPositiveAndSumGreaterThanHundred.test(60, 50));  // Output: true
        System.out.println(bothPositiveAndSumGreaterThanHundred.test(-10, 150)); // Output: false
    }
}
