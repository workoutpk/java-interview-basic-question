package Optional;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        // Creating an Optional object wit a value
        Optional<String> optionalName = Optional.of("John Doe");

        // Accessing the value using getOrElse()
        String name = optionalName.orElse("Unknown");
        System.out.println("Name: " + name); // Output: Name: John Doe

        // Creating an Optional object with no value
        Optional<String> optionalEmpty = Optional.empty();

        // Handling empty Optional using ifPresent()
        optionalEmpty.ifPresent(value -> System.out.println("Value: " + value)); // No output

        // Using orElseGet() to provide a default value
        String defaultValue = optionalEmpty.orElseGet(() -> "Default Value");
        System.out.println("Default Value: " + defaultValue); // Output: Default Value

        // Using orElseThrow() to throw an exception
        try {
            String forcedValue = optionalEmpty.orElseThrow(() -> new RuntimeException("Value is required"));
        } catch (RuntimeException e) {
            System.out.println("Exception: " + e.getMessage()); // Output: Exception: Value is required
        }
    }
}
