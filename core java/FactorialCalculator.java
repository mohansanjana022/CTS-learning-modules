import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");

        try {
            int num = Integer.parseInt(scanner.nextLine());

            if (num < 0) {
                System.out.println("Factorial is not defined for negative numbers.");
                return;
            }

            long factorial = 1;
            for (int i = 2; i <= num; i++) {
                factorial *= i;
            }

            System.out.println("Factorial of " + num + " is " + factorial);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter an integer.");
        }

        scanner.close();
    }
}

