
import java.sql.*;
public class JdbcCreateTable {
	public static void main(String[] args) throws Exception {
		
//		load
		String url="jdbc:mysql:localhost:3306/StudentData";
		String user="root";
		String pass="anshu";
        String query = "CREATE TABLE FeeStatus ("
                + "UID INT PRIMARY KEY AUTO_INCREMENT, "
                + "FeeStatus CHAR(10))";
        
//        register
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection(url,user,pass); //create connection
		Statement st= con.createStatement(); //create Statement
		int rs = st.executeUpdate(query); // execute create table

		if(rs==0) {
			System.out.println("Table created successfully");
		}else {
			System.out.println("Table is not created successfully");
		}
		
//		insert data
		String[] feeStatus= {
	            "Paid", "Unpaid", "Unpaid", "Paid", "Paid", 
	            "Paid", "Unpaid", "Paid", "Paid", "Unpaid",
	            "Unpaid", "Paid", "Paid", "Paid", "Unpaid",
	            "Paid", "Paid", "Unpaid", "Unpaid", "Paid"
		};
		
		for(int i=0;i<20;i++) {
			String insertQuery = "INSERT INTO FeeStatus (FeeStatus) VALUES ('" + feeStatus[i] + "')";
			st.executeUpdate(insertQuery);
		}
		System.out.println("Data Inserted sucessfully");
		
//		run query
		
        String getData="Select * from FeeStatus";
		ResultSet rst = st.executeQuery(getData);
		
		while(rst.next()) {
			System.out.println(rst.getInt(1)+" "+rst.getString(2));
		}
		
		st.close();
		con.close();
	}

}
