package javaProject;
import CSV.*;

import java.sql.*;
import java.util.*;
public class instructionInterface{
	String url = "jdbc:mysql://localhost:3306/java";
	String uname = "root" ;
	private final String password = "*someswar";
	
	public void clonegiveInstructions(String instruction) throws Exception {
		seeing s = new seeing();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,password);
		
		Statement st = con.createStatement();
		String query = "insert into instructions(instruction) values('"+instruction+"')";
		st.executeUpdate(query);
		s.seeInstructions();	
		st.close();
		con.close();
	}
	
	int instructionNum() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter instruction Number to update");
		int num = sc.nextInt();
		return num;
		
	}
	
	void updateInstruction() throws Exception {
		seeing s = new seeing();
		s.seeInstructions();		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,password);
		
		Statement st = con.createStatement();
		Scanner sc = new Scanner(System.in);
		int num = instructionNum();
		System.out.print("Instruction : ");
		String instrcution = sc.nextLine();
		String query = "update instructions set instruction = '"+instrcution+"' where sNo = '"+num+"'";
		st.executeLargeUpdate(query);				
		
		st.close();
		con.close();
		s.seeInstructions();
	}
	
	void deleteInstruction() throws Exception {
		Scanner sc = new Scanner(System.in);
		seeing s = new seeing();
		s.seeInstructions();
		System.out.println("Enter sNo of the instruction");
		String  num = sc.nextLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,password);		
		Statement st = con.createStatement();
		
		String query = "delete from instructions where sNo = '"+num+"' ";
		st.executeUpdate(query);
		
		st.close();
		con.close();
		
		s.seeInstructions();
	}

	public static void main(String[] args) throws Exception {
		instructionInterface ii = new instructionInterface();
		csvData cd = new csvData();
		//cd.uploadInstruction();
		//ii.updateInstruction();
		ii.deleteInstruction();
	}

}
