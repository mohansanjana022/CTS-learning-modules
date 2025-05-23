import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {
    private final String url = "jdbc:mysql://localhost:3306/school";
    private final String user = "root";
    private final String password = "";

    private Connection connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }

    public void insertStudent(String name, int age, String department) {
        String sql = "INSERT INTO students (name, age, department) VALUES (?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, department);
            pstmt.executeUpdate();
            System.out.println("✅ Student inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        getAllStudents();  // display all after insert
    }

    public void updateStudent(int id, String name, int age, String department) {
        String sql = "UPDATE students SET name = ?, age = ?, department = ? WHERE id = ?";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, department);
            pstmt.setInt(4, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Student updated successfully.");
            } else {
                System.out.println("⚠️ No student found with ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        getAllStudents();  // display all after update
    }

    public void getAllStudents() {
        String sql = "SELECT * FROM students";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\n--- Current Students in DB ---");
            System.out.printf("%-5s %-20s %-5s %-15s%n", "ID", "Name", "Age", "Department");
            System.out.println("--------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String dept = rs.getString("department");
                System.out.printf("%-5d %-20s %-5d %-15s%n", id, name, age, dept);
            }
            System.out.println("--------------------------------------------\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//  save as StudentApp.java
import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n===== Student Management =====");
            System.out.println("1. Insert Student");
            System.out.println("2. Update Student");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Clear buffer
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    System.out.print("Enter department: ");
                    String dept = scanner.nextLine();
                    dao.insertStudent(name, age, dept);
                    break;

                case 2:
                    System.out.print("Enter student ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    System.out.print("Enter new department: ");
                    String newDept = scanner.nextLine();
                    dao.updateStudent(id, newName, newAge, newDept);
                    break;

                case 3:
                    System.out.println("👋 Exiting...");
                    return;

                default:
                    System.out.println("❌ Invalid choice! Try again.");
            }
        }
    }
}

*/
  ===== Student Management =====
1. Insert Student
2. Update Student
3. Exit
Enter your choice: 1
Enter name: SANJU
Enter age: 19
Enter department: CSE
? Student inserted successfully.

--- Current Students in DB ---
ID    Name                 Age   Department     
--------------------------------------------
1     Alice                20    CSE            
2     Bob                  21    ECE            
3     Charlie              19    MECH           
4     ramaya               19    CSE            
5     sanjana              19    CSE            
6     dhanaa               19    CSE            
7     abi                  19    CSE            
8     SANJU                19    CSE            
--------------------------------------------



*/


