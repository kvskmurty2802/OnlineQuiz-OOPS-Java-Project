package javaProject;
import CSV.*;
import java.util.Scanner;

public class Switching {	
	void switchstudent() throws Exception {
		seeing s = new seeing();
		csvData cd = new csvData();
		Switching sw = new Switching();
		studentInterface si = new studentInterface();
		Scanner sc = new Scanner(System.in);
		boolean condition = true;
		while(condition) {
			System.out.println("1.See Student \t 2.Add/Update Student  \t 3.Search Student \t 4.delete student \t 5.Back");
			int i = sc.nextInt();
			switch(i) {
			case 1:s.seeStudent();break;
			case 2:cd.uploadStudent();//si.addStudent();
			       break;
			case 3:sw.studentSearchVia();break;
			case 4:si.deleteStudent();
			case 5:condition = false;break;
			default :break;
		  }	
		
		}
	}
	
	void studentSearchVia() throws Exception {
		Scanner sc = new Scanner(System.in);
		studentInterface si = new studentInterface();
		searching s = new searching();
		boolean condition = true;
		while(condition) {
			System.out.println("1.search via id  \t  2.Search via Name String  \t  3.search via marks \t 4.Back");
			int i = sc.nextInt();
			switch(i) {
			case 1:s.searchStudent();break;
			case 2:s.studentSubString();break;
			case 3:s.marks();break;
			case 4:condition = false;break;
			default :break;
		 }	
		
		}
	}
	
	void switchInstruction() throws Exception {
		seeing se = new seeing();
		csvData cd = new csvData();
		searching s = new searching();
		instructionInterface ii = new instructionInterface();
		Scanner sc = new Scanner(System.in);
		boolean condition = true;
		while(condition) {
			System.out.println("1.See Instruction  \t  2.Add Instruction  \t  3.Search Instruction  \t  4.delete Instruction \t  5.Back");
			int i = sc.nextInt();
			switch(i) {
			case 1:se.seeInstructions();break;
			case 2:cd.uploadInstruction();break;
			case 3:s.searchInstruction();break;
			case 4:ii.deleteInstruction();
			case 5:condition = false;break;
			default :break;
		 }	
		
		}		
	}
	
	void switchQuestion() throws Exception {
		seeing se = new seeing();
		csvData cd = new csvData();
		adminInterface ai = new adminInterface();
		searching s = new searching();
		questionInterface qi = new questionInterface();
		Scanner sc = new Scanner(System.in);
		boolean condition = true;
		while(condition) {
			System.out.println("1.See Question  \t  2.Add Question  \t  3.Search Question  \t  4.Delete Question  \t  5.Back");
			int i = sc.nextInt();
			switch(i) {
			case 1:se.seeTest();break;
			case 2:cd.uploadQuestion();break;
			case 3:qi.searchQuestion();break;
			case 4:qi.deleteQuestion();
			case 5:condition = false;break;
			default :break;
		 }	
		
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Switching sw = new Switching();
		//sw.switchstudent();
		//sw.switchInstruction();
		//sw.switchQuestion();

	}

}
