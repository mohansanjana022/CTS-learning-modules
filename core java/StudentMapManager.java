import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentMapManager {
    public static void main(String[] args) {
        Map<Integer, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Add student entries (type '0' as ID to stop):");

        while (true) {
            System.out.print("Enter student ID (integer): ");
            int id;
            try {
                id = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID. Please enter a valid integer.");
                continue;
            }

            if (id == 0) break;

            System.out.print("Enter student name: ");
            String name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Name cannot be empty. Try again.");
                continue;
            }

            studentMap.put(id, name);
            System.out.println("Entry added.\n");
        }

        System.out.print("\nEnter an ID to retrieve the student name: ");
        try {
            int searchId = Integer.parseInt(scanner.nextLine().trim());
            String studentName = studentMap.get(searchId);

            if (studentName != null) {
                System.out.println("Student with ID " + searchId + ": " + studentName);
            } else {
                System.out.println("No student found with ID " + searchId);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Expected an integer ID.");
        }

        scanner.close();
    }
}
