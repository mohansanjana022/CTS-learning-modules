import java.util.Scanner;
public class RecursiveFibonacci {

     public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a positive integer (n): ");
          
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                return;
            }
            int n = scanner.nextInt();
            if (n < 0) {
                System.out.println("Fibonacci is not defined for negative numbers.");
                return;
            }
            int result = fibonacci(n);
            System.out.println("Fibonacci number at position " + n + " is " + result);
        }
    }
}
