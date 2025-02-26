package functionalinterface;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateChaining {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> greaterThanFive = n -> n > 5;

        // Chaining predicates
        Predicate<Integer> isEvenAndGreaterThanFive = isEven.and(greaterThanFive);

        List<Integer> result = numbers.stream()
                .filter(isEvenAndGreaterThanFive)
                .collect(Collectors.toList());

        System.out.println("Even numbers greater than 5: " + result);
    }
}
