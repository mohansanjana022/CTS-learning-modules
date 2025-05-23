import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankTransaction {
    private final String url = "jdbc:mysql://localhost:3306/bankdb";
    private final String user = "root";
    private final String password = "";

    public void transferMoney(int fromAccount, int toAccount, double amount) {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

            // Start transaction
            conn.setAutoCommit(false);

            // Debit from sender
            PreparedStatement debitStmt = conn.prepareStatement(
                "UPDATE accounts SET balance = balance - ? WHERE account_id = ?"
            );
            debitStmt.setDouble(1, amount);
            debitStmt.setInt(2, fromAccount);
            int debitResult = debitStmt.executeUpdate();

            // Credit to receiver
            PreparedStatement creditStmt = conn.prepareStatement(
                "UPDATE accounts SET balance = balance + ? WHERE account_id = ?"
            );
            creditStmt.setDouble(1, amount);
            creditStmt.setInt(2, toAccount);
            int creditResult = creditStmt.executeUpdate();

            if (debitResult == 1 && creditResult == 1) {
                conn.commit();
                System.out.println("✅ Transfer successful.");
            } else {
                conn.rollback();
                System.out.println("❌ Transfer failed. Rolled back.");
            }

        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("❌ Exception occurred: " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.setAutoCommit(true);
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}

//MainApp.java as to be run for full transaction
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankTransaction bt = new BankTransaction();

        System.out.println("💸 Bank Transfer");
        System.out.print("Enter sender account ID: ");
        int from = scanner.nextInt();
        System.out.print("Enter receiver account ID: ");
        int to = scanner.nextInt();
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();

        bt.transferMoney(from, to, amount);
    }
}
//output

run:
? Bank Transfer
Enter sender account ID: 1
Enter receiver account ID: 2
Enter amount to transfer: 1999
? Transfer successful.
BUILD SUCCESSFUL (total time: 21 seconds)

