import java.sql.*;
public class JdbcBasicQuery1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mysql://localhost:3306/StudentData";
		String user ="root";
		String pass="anshu";
		String query = "SELECT std.UID,std.name,std.cgpa,fs.FeeStatus "
	             + "FROM Student AS std "
	             + "JOIN FeeStatus AS fs "
	             + "ON std.UID = fs.UID "
	             + "WHERE fs.FeeStatus = 'Unpaid'";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,pass);
		Statement st= con.createStatement();
		ResultSet rs= st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getString(4));
		}
		st.close();
		con.close();
	}

}
