package javaProject;

import java.sql.*;
import java.util.*;

import CSV.csvData;

public class studentInterface{
	String url = "jdbc:mysql://localhost:3306/java";
	String uname = "root" ;
	private final String password = "*someswar";	
	
	public void cloneaddStudent(String id,String name,String pass,String mark) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,password);
		
		Statement st = con.createStatement();
		//-----------------------------------------------------------------------------------
		String query3 = "select id from student";
		ResultSet rs1 = st.executeQuery(query3);
		String data1;
		boolean condition = false;
		while(rs1.next()){
			  data1 = rs1.getString(1);
			  if(data1.equals(id)) {
				  condition = true;
			  }
		  }
		if(condition) {
			String query4 = " update student set user_name = '"+name+"',password = '"+pass+"',marks = '"+mark+"' where id = '"+id+"' ";
			st.executeLargeUpdate(query4);
		}else {
			//-----------------------------------------------------------------------------------
			String query = "insert into student values('"+id+"','"+name+"','"+pass+"','"+mark+"')";
			st.executeUpdate(query);	
		}
		
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
	
	void deleteStudent() throws Exception {
		Scanner sc = new Scanner(System.in);
		seeing s = new seeing();
		s.seeStudent();
		System.out.println("Enter id of the Student");
		String id = sc.nextLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,password);		
		Statement st = con.createStatement();
		
		String query = "delete from student where id = '"+id+"' ";
		st.executeUpdate(query);
		
		st.close();
		con.close();
		
		s.seeStudent();
	}
	
	float takeTest() throws Exception{
			float marks=0,total = 0;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,password);
			Statement st = con.createStatement();
			System.out.println("                                ******************* quiz ********************* \n");
			String query = "select *  from questions ";
			ResultSet rs = st.executeQuery(query); 
			String data;
			 Scanner sc = new Scanner(System.in);
			  String choice,answer;
			  while(rs.next()) {
				 total = rs.getInt(1);
			  data = rs.getInt(1)+". "+rs.getString(2)+" \n a. "+rs.getString(3)+" \t b. "+rs.getString(4)+" \t c.  "+rs.getString(5)+" \t d.  "+rs.getString(6);
			  answer = rs.getString(7);
			  System.out.println(data);
			  choice = sc.nextLine();
			   if(choice.equals(answer)) {
				   marks++;
			   }else {
				   marks =(float) (marks - 0.25);
			   }
			  System.out.println(" ");
			  }
			  
			 System.out.println("Total Marks : "+marks);
			 System.out.println(" ");
			st.close();
			con.close();
			return marks;
		}


	public static void main(String[] args) throws Exception {
		studentInterface s = new studentInterface();
		csvData cd = new csvData();
		//cd.uploadStudent();
		//s.deleteStudent();
		
	}

}
