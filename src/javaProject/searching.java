package javaProject;
import java.sql.*;
import java.util.*;

public class searching {
	String url = "jdbc:mysql://localhost:3306/java";
	String uname = "root" ;
	private String password = "*someswar";
	void searchStudent() throws Exception{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter id of the Student");
		String id = sc.nextLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,password);		
		Statement st = con.createStatement();
		
		String query = "select * from student where id = '"+id+"' ";
		ResultSet rs = st.executeQuery(query);
		String data;
		System.out.println("Student : ");
		while(rs.next()){
			  data = rs.getString(1)+" : "+rs.getString(2)+" : "+rs.getString(3);
			  System.out.println(data);
		  }
		
		st.close();
		con.close();
				
	}
	
	void studentString() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name of the Student");
		String name = sc.nextLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,password);		
		Statement st = con.createStatement();
	    String query = "select * from student where user_name = '"+name+"' ";
		ResultSet rs = st.executeQuery(query);
		String data;
		System.out.println("Student : ");
		while(rs.next()){
			  data = rs.getString(1)+" : "+rs.getString(2)+" : "+rs.getString(3);
			  System.out.println(data);
		  }
		
		st.close();
		con.close();
	}
	void studentString(String Name) throws Exception {
		Scanner sc = new Scanner(System.in);
		String name = Name;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,password);		
		Statement st = con.createStatement();
	    String query = "select * from student where user_name = '"+name+"' ";
		ResultSet rs = st.executeQuery(query);
		String data;
		while(rs.next()){
			  data = rs.getString(1)+" : "+rs.getString(2)+" : "+rs.getString(3);
			  System.out.println(data);
		  }
		
		st.close();
		con.close();
	}
	
	void onlyStudentName() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name of the Student");
		String name = sc.nextLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,password);		
		Statement st = con.createStatement();
		String query = "select user_name from student where user_name like '%"+name+"%' ";
		ResultSet rs = st.executeQuery(query);
		String data;
		System.out.println("Student : ");
		while(rs.next()){
			  data = rs.getString(1);
			  System.out.println(data);
			  
		  }
		
		st.close();
		con.close();
	}
//---------------------------------------------------------------------------------------------------	
	
	void studentSubString() throws Exception {
		searching s = new searching();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name of the Student");
		String name = sc.nextLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,password);		
		Statement st = con.createStatement();
	//  String query = "select * from student where user_name = '"+name+"' ";
		String query = "select user_name from student where user_name like '%"+name+"%' ";
		ResultSet rs = st.executeQuery(query);
		String data;
		System.out.println("Student : ");
		while(rs.next()){
			  data = rs.getString(1);
			  s.studentString(data);				  
		  }
		
		st.close();
		con.close();
	}
	
	void searchQuestion() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter sNo of the Student");
		String sNo = sc.nextLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,password);		
		Statement st = con.createStatement();
		
		String query = "select * from questions where sNo = '"+sNo+"' ";
		ResultSet rs = st.executeQuery(query);
		String data;
		System.out.println("Question : ");
		while(rs.next()){
			  data = rs.getString(1)+" : "+rs.getString(2);
			  System.out.println(data);
		  }
		
		st.close();
		con.close();
	}
	void questionString() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter question");
		String question = sc.nextLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,password);		
		Statement st = con.createStatement();
		
		String query = "select * from questions where question = '"+question+"' ";
		ResultSet rs = st.executeQuery(query);
		String data;
		System.out.println("Question : ");
		while(rs.next()){
			  data = rs.getString(1)+" : "+rs.getString(2);
			  System.out.println(data);
		  }
		
		st.close();
		con.close();
	}
	
	void questionSubString() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter question");
		String question = sc.nextLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,password);		
		Statement st = con.createStatement();
		String query = "select question from questions where question like '%"+question+"%' ";
		ResultSet rs = st.executeQuery(query);
		String data;
		System.out.println("Question : ");
		while(rs.next()){
			  data = rs.getString(1);
			  System.out.println(data);
		  }
		
		st.close();
		con.close();
	}
	
	void searchInstruction() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter sNo of the Instruction");
		String sNo = sc.nextLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,password);		
		Statement st = con.createStatement();
		
		String query = "select * from instructions where sNo = '"+sNo+"' ";
		ResultSet rs = st.executeQuery(query);
		String data;
		System.out.println("Instruction : ");
		while(rs.next()){
			  data = rs.getString(1)+" : "+rs.getString(2);
			  System.out.println(data);
		  }
		
		st.close();
		con.close();
	}
	
	void instructionString() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter question");
		String question = sc.nextLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,password);		
		Statement st = con.createStatement();
		
		String query = "select * from questions where question = '"+question+"' ";
		ResultSet rs = st.executeQuery(query);
		String data;
		System.out.println("Question : ");
		while(rs.next()){
			  data = rs.getString(1)+" : "+rs.getString(2);
			  System.out.println(data);
		  }
		
		st.close();
		con.close();
	}
	
	void instructionSubString() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter instruction");
		String instruction = sc.nextLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,password);		
		Statement st = con.createStatement();
		String query = "select instruction from instructions where instruction like '%"+instruction+"%' ";
		ResultSet rs = st.executeQuery(query);
		String data;
		System.out.println("Instruction : ");
		while(rs.next()){
			  data = rs.getString(1);
			  System.out.println(data);
		  }
		
		st.close();
		con.close();
	}
	
    void marks() throws Exception {
    	Scanner sc = new Scanner(System.in);
		System.out.println("Marks greater than or equal to :");
		float limit = sc.nextFloat();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,password);		
		Statement st = con.createStatement();
		String query = "select id,user_name,marks from student where marks >= '"+limit+"' ";
		ResultSet rs = st.executeQuery(query);
		String data;
		while(rs.next()){
			  data = rs.getString(1)+" : "+rs.getString(2)+" : "+rs.getFloat(3);
			  System.out.println(data);
		  }
		st.close();
		con.close();
    }

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		searching s = new searching();
		//s.searchStudent();
		//s.searchQuestion();
		//s.searchInstruction();
		//s.studentString();
		//s.studentSubString();
		//s.questionString();
		//s.questionSubString();
		//s.instructionSubString();

	}

}

