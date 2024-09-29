
import java.sql.*;
public class JdbcCode {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/StudentData";
		String user= "root";
		String pass="anshu";
		String query="select * from Student where Course='Master of Business Administration' ";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,pass);
		Statement st = con.createStatement();
		ResultSet rs= st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDouble(4)+" "+rs.getDouble(5));
		}
		st.close();
		con.close();

	}

}

