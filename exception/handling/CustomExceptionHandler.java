package exception.handling;

public class CustomExceptionHandler {
    public static void handleException(Exception e) {
        if (e instanceof InvalidAgeException) {
            System.out.println("InvalidAgeException occurred: " + e.getMessage());
            System.out.println("Please enter a valid age between 0 and 150.");
        } else if (e instanceof NumberFormatException) {
            System.out.println("NumberFormatException occurred: Invalid input format.");
            System.out.println("Please enter a valid integer for age.");
        } else {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
