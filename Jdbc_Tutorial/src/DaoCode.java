import java.sql.*;
import java.util.Scanner;
public class DaoCode {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		AccessDao acd= new AccessDao();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name to get data");
		String name=sc.nextLine();
		acd.accessData(name);
	}

}
class AccessDao{
	
	public Data accessData(String name) throws Exception{
		
		Data d =new Data();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url= "jdbc:mysql://localhost:3306/StData";
		String user="root";
		String pass="anshu";
		String query = "select rollNum from StData where sname=?";
		
		Connection con = DriverManager.getConnection(url,user,pass);
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, name);
        ResultSet st=pst.executeQuery();
        st.next();
        System.out.println(st.getInt(1));
		
        con.close();
        st.close();
		return d;
	}
}

class Data{
	int rollNum;
	String name;
}