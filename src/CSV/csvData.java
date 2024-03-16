package CSV;
import javaProject.*;

import java.io.*;
import java.util.*;  

public class csvData {
	public String[] uploadStudent() throws Exception {
		String line = ""; 
		String[] values = null;
		String splitBy = ",";  
		try    
		{  
		BufferedReader br = new BufferedReader(new FileReader("studentUploadCSV.csv"));  
		while ((line = br.readLine()) != null)   {  
		  values = line.split(splitBy);   
		  studentInterface cs = new studentInterface();
		  cs.cloneaddStudent(values[0],values[1],values[2],values[3]);		  
		}  
		}   
		catch (IOException e)   
		{  
		e.printStackTrace();  
		}
		return values;  
		}  
	
	public String[] uploadInstruction() throws Exception {
		String line = ""; 
		String[] values = null;
		String splitBy = ",";  
		try    
		{  
		BufferedReader br = new BufferedReader(new FileReader("InstructionCSV.csv"));  
		while ((line = br.readLine()) != null)   
		{  
		  values = line.split(splitBy);   
		  instructionInterface ii = new instructionInterface();
		  ii.clonegiveInstructions(values[0]);
		  
		}  
		}   
		catch (IOException e)   
		{  
		e.printStackTrace();  
		}
		return values;  
		} 
	
	public String[] uploadQuestion() throws Exception {
		String line = ""; 
		String[] values = null;
		String splitBy = ",";  
		try    
		{  
		BufferedReader br = new BufferedReader(new FileReader("questionCSV.csv"));  
		while ((line = br.readLine()) != null)   
		{  
		  values = line.split(splitBy);   
		  questionInterface ii = new questionInterface();
		  ii.cloneaddQuestion(values[0],values[1],values[2],values[3],values[4],values[5]);
		  
		}  
		}   
		catch (IOException e)   
		{  
		e.printStackTrace();  
		}
		return values;  
		}

	public static void main(String[] args) throws Exception {
		csvData cd = new csvData();
		//cd.uploadInstruction();
		
	}

}
