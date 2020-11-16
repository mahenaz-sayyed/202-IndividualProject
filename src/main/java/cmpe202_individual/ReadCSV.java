package cmpe202_individual;
import java.util.*;
import java.io.*;
import java.math.*;

public class ReadCSV {

	public void ParseCSV(String FileName, String OutFileName)
	{
		
		
		String line = "";  
		String splitBy = ",";  
		try   
		{  
		
		CardFactoryMethod thisCard = new CardFactoryMethod();
		BufferedReader br = new BufferedReader(new FileReader(FileName));  
		br.readLine();
		while ((line = br.readLine()) != null)   
		{  
			if(line.matches("[0-9].*")) 
			{
			
			String[] customer = line.split(splitBy);    // use comma as separator  
			BigDecimal bigDecimal=new BigDecimal(customer[0]);
			String ccNumber=bigDecimal.toPlainString();
			
			
			determineTypeOfCard typeOfCard = new determineTypeOfCard();
			typeOfCard.createCardType(ccNumber, OutFileName);
			
			}
		}
		
		}
		
		catch (IOException e)   
		{  
		e.printStackTrace();  
		}  
	}

}
