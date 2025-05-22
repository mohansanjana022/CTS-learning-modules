import java.util.Scanner;
public class ArraySumAndAverage {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of elements: ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                return;
            }
            int n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Number of elements must be positive.");
                return;
            }
            int[] numbers = new int[n];
            int sum = 0;
            System.out.println("Enter " + n + " integers:");
            for (int i = 0; i < n; i++) {
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter an integer.");
                    return;
                }
                numbers[i] = scanner.nextInt();
                sum += numbers[i];
            }
            double average = (double) sum / n;
            System.out.println("Sum: " + sum);
            System.out.println("Average: " + average);
        }
    }
}

