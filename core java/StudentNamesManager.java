import java.util.ArrayList;
import java.util.Scanner;

public class StudentNamesManager {
    public static void main(String[] args) {
        ArrayList<String> studentNames = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student names (type 'done' to finish):");

        while (true) {
            System.out.print("Name: ");
            String name = scanner.nextLine().trim();

            if (name.equalsIgnoreCase("done")) {
                break;
            }

            if (!name.isEmpty()) {
                studentNames.add(name);
            } else {
                System.out.println("Empty input ignored. Please enter a valid name.");
            }
        }

        scanner.close();

        System.out.println("\nStudent names entered:");
        studentNames.forEach(System.out::println);
    }
}

