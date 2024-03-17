package javaProject;
import java.sql.*;
import java.util.*;

public class questionInterface{
	String url = "jdbc:mysql://localhost:3306/java";
	String uname = "root" ;
	private final String password = "*someswar";
	
	public void cloneaddQuestion(String question,String optionA,String optionB,String optionC,String optionD,String correctOption) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,password);
		
		Statement st = con.createStatement();
		String query = "insert into questions(question,option_A,option_B,option_C,option_D,answer) values('"+question+"','"+optionA+"','"+optionB+"','"+optionC+"','"+optionD+"','"+correctOption+"')";
		st.executeUpdate(query);				
		
		st.close();
		con.close();
	}
	
	int input() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		return n;
		
	}
	void updateQuestion() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,password);		
		Statement st = con.createStatement();
		seeing s = new seeing();
		s.seeTest();
		Scanner sc = new Scanner(System.in);
		int num = input();
		System.out.print("Question : ");
		String question = sc.nextLine();
		System.out.print("option a : ");
		String optionA = sc.nextLine();
		System.out.print("option b : ");
		String optionB = sc.nextLine();
		System.out.print("option c : ");
		String optionC = sc.nextLine();
		System.out.print("option d : ");
		String optionD = sc.nextLine();
		System.out.print("Enter correct option from above  : ");
		String correctOption = sc.nextLine();
		String query = "update questions set question = '"+question+"',option_A = '"+optionA+"',option_B = '"+optionB+"',option_C = '"+optionC+"',option_D = '"+optionD+"',answer = '"+correctOption+"' where sNo = '"+num+"'";
		st.executeLargeUpdate(query);				
		
		st.close();
		con.close();
		s.seeTest();
	}
	
	void deleteQuestion() throws Exception {
		Scanner sc = new Scanner(System.in);
		seeing s = new seeing();
		s.seeTest();
		System.out.println("Enter sNo of the Question");
		String  num = sc.nextLine();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,password);		
		Statement st = con.createStatement();
		
		String query = "delete from questions where sNo = '"+num+"' ";
		st.executeUpdate(query);
		
		st.close();
		con.close();
		
		s.seeTest();
	}
	
	void searchQuestion() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter sNo of the Question");
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


	public static void main(String[] args) throws Exception {
		questionInterface qi = new questionInterface();		
		qi.updateQuestion();

	}

}
