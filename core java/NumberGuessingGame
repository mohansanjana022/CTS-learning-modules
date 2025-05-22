import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int target = rand.nextInt(100) + 1;  // 1 to 100
        Scanner scanner = new Scanner(System.in);
        int guess = 0;

        System.out.println("Guess the number between 1 and 100!");

        while (guess != target) {
            System.out.print("Enter your guess: ");
            try {
                guess = Integer.parseInt(scanner.nextLine());

                if (guess < target) {
                    System.out.println("Too low!");
                } else if (guess > target) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! You guessed the number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }

        scanner.close();
    }
}
