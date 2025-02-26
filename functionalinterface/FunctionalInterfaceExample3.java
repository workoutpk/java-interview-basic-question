package functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceExample3 {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(3,5,6,8);
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        Consumer<String> printer = System.out::println;
        names.forEach(printer);

        Function<String, Integer> lengthCalculator = (str) -> str.length();
        Function<String, Integer> lengthCalculatorRef = String::length;
        lengthCalculatorRef.apply("Hello");

        Supplier<String> greetingSupplier = () -> "Hello, world!";
        String greeting = greetingSupplier.get();
        System.out.println(greeting); // Output: Hello, world!

        Predicate<Integer> isEven = (number) -> number % 2 == 0;
        boolean isNumberEven = isEven.test(4);
        System.out.println(isNumberEven); // Output: true

    }
}
