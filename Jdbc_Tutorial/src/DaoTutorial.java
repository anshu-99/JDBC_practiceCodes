import java.sql.*;
import java.util.*;
public class DaoTutorial {

	public static void main(String[] args)throws Exception  {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		StudentDAO dao=new StudentDAO();
		System.out.println("enter roll number to get data");
		int rollNumber= sc.nextInt();
		Student s1=dao.getStudent(rollNumber);
		System.out.println(s1.roll+" "+s1.sname);
	}

}

class StudentDAO{
	public Student getStudent(int rollNum) throws Exception {
		Student s= new Student();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url= "jdbc:mysql://localhost:3306/StData";
		String user="root";
		String pass="anshu";
		String query="Select * from StData where rollNum="+rollNum;
		Connection con = DriverManager.getConnection(url,user,pass);
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		rollNum=rs.getInt(1);
		String name=rs.getString(2);
		s.roll = rollNum;
		s.sname=name;
		return s;
	}
}

class Student{
	int roll;
	String sname;
}
