class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class AgeValidator {
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Invalid age: Must be 18 or older.");
        } else {
            System.out.println("Access granted. Age is valid.");
        }
    }

    public static void main(String[] args) {
        int userAge = 16;

        try {
            checkAge(userAge);
        } catch (InvalidAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}

