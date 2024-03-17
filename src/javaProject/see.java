package javaProject;
import java.sql.*;

class seeing{
	String url = "jdbc:mysql://localhost:3306/java";
	String uname = "root" ;
	private final String password = "*someswar";
	void seeStudent() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,password);		
		Statement st = con.createStatement();
		String query1 = "select * from student";
		ResultSet rs = st.executeQuery(query1);
		String data;
		System.out.println("Students are : ");
		while(rs.next()){
			  data = rs.getString(1)+" : "+rs.getString(2)+" : "+rs.getString(3);
			  System.out.println(data);
		  }
		st.close();
		con.close();
	}
	
    void seeInstructions() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,password);
		Statement st = con.createStatement();
		System.out.println("          Instructions are :-        ");
		String query = "select * from instructions ";
		ResultSet rs = st.executeQuery(query);
		String data;
		 while(rs.next()) {
		  data = rs.getInt(1)+" : "+rs.getString(2);
		  System.out.println(data); 
		  }
		 
		st.close();
		con.close();
	}
    
    void seeTest() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,password);
		Statement st = con.createStatement();
		System.out.println("          Questions are :-        ");
		String query = "select * from Questions ";
		ResultSet rs = st.executeQuery(query);
		String data;
			
		  while(rs.next()) {
		  data = rs.getInt(1)+" : "+rs.getString(2);
		  System.out.println(data); 
		  }
		 
		st.close();
		con.close();

	}
}
public class see {

	public static void main(String[] args) {

	}

}

