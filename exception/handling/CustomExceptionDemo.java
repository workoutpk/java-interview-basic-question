package exception.handling;

import java.util.Scanner;

public class CustomExceptionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter your age (or 'q' to quit): ");
                String input = scanner.nextLine();

                if ("q".equalsIgnoreCase(input)) {
                    break;
                }

                int age = Integer.parseInt(input);
                AgeValidator.validateAge(age);
                System.out.println("Age is valid: " + age);
            } catch (Exception e) {
                CustomExceptionHandler.handleException(e);
            }
        }

        scanner.close();
        System.out.println("Program terminated.");
    }
}
