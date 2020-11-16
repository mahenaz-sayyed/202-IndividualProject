package cmpe202_individual;
import java.util.*;

import org.json.simple.parser.ParseException;

import java.io.*;

public class Main_App {

	

public static void main(String[] args) throws IOException, ParseException 
 { 
	String One= args[0];
	String Two= args[1];

	
	

	String[] InputName = One.split("\\."); 
	int lenOfName= InputName.length;
	String FileType= InputName[lenOfName-1];
	

	
	if(FileType.equalsIgnoreCase("csv")) 
	{
		
		ReadCSV csvfile = new ReadCSV();
		csvfile.ParseCSV(One, Two);
	} 
	else if(FileType.equalsIgnoreCase("json")) 
	{
		
		ReadJson jsonfile = new ReadJson();
		jsonfile.ParseJson(One, Two);
	}
	
	else if(FileType.equalsIgnoreCase("xml")) 
	{
		
		ReadXml xmlfile = new ReadXml();
		xmlfile.ParseXml(One, Two);
	}
	
	else 
	{
		System.out.println("Invalid File type. Please provide csv, json or xml file.");
	}
	
	
}

}
