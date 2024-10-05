import java.sql.*;
public class PreparedStmtnt {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/StudentData" ;
		String user="root";
		String pass="anshu";
		String name="Vyas";
		int uid=6;
		String query = "update Student "
				+ "set name=(?) "
				+ "where uid=(?);";
		
		Connection con=DriverManager.getConnection(url,user,pass);
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1,name);
		st.setInt(2, uid);
		int count=st.executeUpdate();
		
		System.out.println(count+" rows affected");
		
	}

}
