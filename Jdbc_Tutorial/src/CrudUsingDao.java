import java.sql.*;
import java.util.Scanner;

public class CrudUsingDao {

	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Crud crd = new Crud();

        System.out.println("Do you want to create a table? (yes/no)");
        String ans = sc.nextLine();

        if (ans.equalsIgnoreCase("yes")) {
            crd.create();
        } else {
            System.out.println("Okay!");
        }

        System.out.println("Add Data");
        System.out.println("Enter Name:");
        String name = sc.nextLine();

        System.out.println("Enter EID:");
        int EID = sc.nextInt();
        sc.nextLine(); // Clear the buffer after nextInt()

        crd.addData(name, EID);

        System.out.println("Enter EID number to see data:");
        int EmpID = sc.nextInt();
        sc.nextLine(); // Clear the buffer after nextInt()

        crd.readData(EmpID);

        System.out.println("Do you wanna update data? (yes/no)");
        String dcsn = sc.nextLine(); // Read user input correctly

        if (dcsn.equalsIgnoreCase("yes")) {
            System.out.println("Enter the employee number of the employee whose name you want to update:");
            int eid = sc.nextInt();
            sc.nextLine(); // Clear the buffer after nextInt()

            System.out.println("Enter the new name of the employee:");
            String empName = sc.nextLine(); // Read employee name

            crd.updateData(eid, empName);
        } else if (dcsn.equalsIgnoreCase("no")) {
            System.out.println("Operation cancelled.");
        } else {
            System.out.println("Invalid choice.");
        }

        sc.close(); // Close the scanner to free resources
    }
}

class Crud {

    private static final String URL = "jdbc:mysql://localhost:3306/EmpData";
    private static final String USER = "root";
    private static final String PASSWORD = "anshu";

    public void create() throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS empData (name VARCHAR(50), EID INT);";

        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement st = con.createStatement();

        int count = st.executeUpdate(query);

        if (count == 0) {
            System.out.println("Table created successfully or already exists.");
        } else {
            System.out.println("Table creation failed.");
        }

        // Close resources
        st.close();
        con.close();
    }

    public void addData(String name, int EID) throws SQLException {
        String query = "INSERT INTO empData VALUES (?, ?);";

        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement pst = con.prepareStatement(query);

        pst.setString(1, name);
        pst.setInt(2, EID);

        int rowsAffected = pst.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Data entered successfully.");
        } else {
            System.out.println("Data entry failed.");
        }

        // Close resources
        pst.close();
        con.close();
    }
    public void readData(int EID) throws Exception {
    	Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
    	String query="SELECT * from empData where EID=?;";
    	PreparedStatement st=con.prepareStatement(query);
    	st.setInt(1, EID);
    	ResultSet rst=st.executeQuery();
    	while(rst.next()) {
    		System.out.println(rst.getString(1)+":"+rst.getInt(2));
    	}
    	st.close();
    	con.close();
    }
    public void updateData(int eid,String name) throws Exception {
    	Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
    	String query="Update empData set name=? where EID=? ;";
    	PreparedStatement pst= con.prepareStatement(query);
    	pst.setString(1, name);
    	pst.setInt(2, eid);
    	
    	int count=pst.executeUpdate();
    	
    	System.out.println(count+" rows affected");
    	pst.close();
    	con.close();
    }
}

class RawData {
    String name;
    int EID;
}
