import java.sql.*;
import java.util.Scanner;

public class PreparedStmnt_1 {
    public static void enterName(String[] arr) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextLine();
        }
    }

    public static void enterUid(int[] arr) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }

    public static void main(String[] args) throws Exception {
        // Load MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Define connection details
        String url = "jdbc:mysql://localhost:3306/StudentData";
        String user = "root";
        String pass = "anshu";
        String query = "UPDATE Student SET name = ? WHERE uid = ?;";

        // Create arrays for names and uids
        String[] name = new String[5];
        int[] uid = new int[5];

        // Input names and uids
        System.out.println("Enter names to update:");
        enterName(name);
        System.out.println("Enter uids to update:");
        enterUid(uid);

        // Establish connection and prepare the statement
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement st = con.prepareStatement(query);

        // Update each name and uid in the database
        for (int i = 0; i < 5; i++) {
            st.setString(1, name[i]);
            st.setInt(2, uid[i]);
            int count = st.executeUpdate();
            System.out.println(count + " row(s) updated for uid: " + uid[i]);
        }

        // Close the resources
        st.close();
        con.close();
    }
}
