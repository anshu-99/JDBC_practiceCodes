import java.sql.*;
public class JdbcQuery {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url= "jdbc:mysql://localhost:3306/StudentData";
		String user="root";
		String pass="anshu";
		String query ="SELECT std.UID,std.name,std.cgpa "
	             + "FROM Student AS std "
	             + "JOIN FeeStatus AS fs "
	             + "ON std.UID = fs.UID "
	             + "WHERE std.cgpa > 8.50";
		
		Connection conn=DriverManager.getConnection(url,user,pass);
		Statement st= conn.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+") "+rs.getString(2)+":"+rs.getFloat(3));
		}
	}

}
