package javaProject;
import java.sql.*;
import java.util.*;

/*abstract class login{
	abstract void adminLogin() throws Exception;
	abstract void studentLogin() throws Exception;
}*/
interface login{
	void adminLogin() throws Exception;
	void studentLogin() throws Exception ;
}

public class logging implements login{
	String url = "jdbc:mysql://localhost:3306/java";
	String uname = "root" ;
	private final String password = "*someswar";
	public void adminLogin() throws Exception{		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,password);
		Statement st = con.createStatement();
		//------------------------------------------
		String name,pass,query1;
		Scanner sc = new Scanner(System.in);
		System.out.print("name : ");
		name = sc.nextLine();
		System.out.print("password : ");
		pass = sc.nextLine();	
		//query1  = "select password from teacher where name = \"somu\" ";
		query1  = "select password from admin where user_name = '"+name+"' ";
		ResultSet rs = st.executeQuery(query1);
		rs.next();
		String data = rs.getString(1);
		
		if(pass.equals(data)){
			System.out.println("teacher successfully logged in");
			adminInterface ai = new adminInterface(); 
			 ai.select();
			
		}else{
			System.out.println("username or password is wrong");
		}
		st.close();
		con.close();
	}
	
	public void studentLogin() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,password);
		Statement st = con.createStatement();
		//------------------------------------------
		String id,pass,query1;
		Scanner sc = new Scanner(System.in);
		System.out.print("id : ");
		id = sc.nextLine();
		System.out.print("password : ");
		pass = sc.nextLine();	
		//query1  = "select password from teacher where name = \"somu\" ";
		query1  = "select password from student where id = '"+id+"' ";
		ResultSet rs = st.executeQuery(query1);
		rs.next();
		String data = rs.getString(1);
		
		if(pass.equals(data)){
			System.out.println("student successfully logged in");		
			int choice;
			boolean bool = true;
		//	while(bool) {
				System.out.println("");
				System.out.println("1. Attempt Quiz  \t  2. Logout");
				choice = sc.nextInt();
				switch(choice) {
				case 1: logging lg = new logging();lg.addMarks(id);//studentInterface si = new studentInterface();si.takeTest();
				break;
				case 2: st.close();bool=false;con.close();break;
				default:System.out.println("Enter correct choice");break;
				}
		//	}			
			//************************************************************************			
		}else{
			System.out.println("username or password is wrong");
		}
		st.close();
		con.close();
		
    }
	
	void addMarks(String id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,password);		
		Statement st = con.createStatement();
		studentInterface si = new studentInterface();
		float marks = si.takeTest();
		String query = "update student set marks = '"+marks+"' where id = '"+id+"' ";
		st.executeLargeUpdate(query);
		Class.forName("com.mysql.cj.jdbc.Driver");
		String query1 = "select id,user_name,marks from student where id = '"+id+"' ";
		ResultSet rs = st.executeQuery(query1);
		String data;
		while(rs.next()){
			  data = rs.getString(1)+" : "+rs.getString(2)+" : "+rs.getFloat(3);
			  System.out.println(data);
		  }
		st.close();
		con.close();
		
	}
	public static void main(String[] args) throws Exception {
		logging lg = new logging();
		//lg.adminLogin();
		lg.studentLogin();

	}

}
