package javaProject;
import CSV.*;
import java.util.*;
import java.lang.*;

class adminInterface{
	public void select() throws Exception {
    	int i;
    	 Switching sw = new Switching();
		Scanner Sc = new Scanner(System.in);		
		boolean c = true;
		while(c){
			System.out.println("1.Students \t 2.Instructions \t 3.Questions \t 4.LogOut");
		    i = Sc.nextInt();
		    switch(i){
		    case 1: sw.switchstudent();
		    	    break;
		    case 2: sw.switchInstruction();
		    	    break;
		    case 3: sw.switchQuestion();
    	            break;
		    case 4: c = false;break;
		    default:System.out.println("Enter only below mentioned choice :");break;
		  }
		}		
  }    
}

class students{
    public void db_student() throws Exception {
    	logging lg = new logging();adminInterface ai = new adminInterface();ai.select();
    }
}
 
public class Main{
	public static void main(String[] args) throws Exception {
	    int i;
		Scanner Sc = new Scanner(System.in);
		boolean c = true;
		logging lg = new logging();
		while(c){
			System.out.println("1.Admin \t 2.Student \t 3.Back Menu");
		    i = Sc.nextInt();
		    switch(i){
		    case 1:	lg.adminLogin();
		    	    break;
		    case 2: lg.studentLogin();
		    	    break;
		    case 3: c = false;break;
		    default:System.out.println("Enter only below mentioned choice :");break;
		  }
		}
		Sc.close();
		
	}
}

