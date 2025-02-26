package exception.handling;

public class AgeValidator {
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be negative");
        } else if (age > 150) {
            throw new InvalidAgeException("Age cannot be greater than 150");
        }
    }

}
