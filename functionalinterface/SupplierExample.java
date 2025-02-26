package functionalinterface;

import java.util.function.Supplier;
import java.util.Random;

public class SupplierExample {
    public static void main(String[] args) {
        // Supplier that generates a random integer between 1 and 100
        Supplier<Integer> randomIntSupplier = () -> new Random().nextInt(100) + 1;

        // Supplier that returns a greeting message
        Supplier<String> greetingSupplier = () -> "Hello, World!";

        // Using the random integer supplier
        System.out.println("Random number: " + randomIntSupplier.get());
        System.out.println("Another random number: " + randomIntSupplier.get());

        // Using the greeting supplier
        System.out.println("Greeting: " + greetingSupplier.get());

        // Supplier that generates the current timestamp
        Supplier<Long> timestampSupplier = System::currentTimeMillis;
        System.out.println("Current timestamp: " + timestampSupplier.get());

        // Using a supplier in a method
        printRandomNumbers(randomIntSupplier, 5);
    }

    // Method that uses a Supplier to print n random numbers
    private static void printRandomNumbers(Supplier<Integer> supplier, int count) {
        System.out.println("Printing " + count + " random numbers:");
        for (int i = 0; i < count; i++) {
            System.out.println(supplier.get());
        }
    }
}