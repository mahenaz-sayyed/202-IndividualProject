package cmpe202_individual;
import java.util.*;
import java.io.*;
import java.math.*;

public class ReadCSV {

	public void ParseCSV(String FileName, String OutFileName)
	{
		
		String brandCard = "";
		String line = "";  
		String splitBy = ","; 
		
		String[][] result = new String[500][500];
		int n=0;
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
			 brandCard = typeOfCard.createCardType(ccNumber, OutFileName);
			
			 result[n][0]=ccNumber;
			 result[n][1]=brandCard;

			 n++;
			
			}
		}
		
		}
		
		catch (IOException e)   
		{  
		e.printStackTrace();  
		}  
		StringBuilder headOfFile= new StringBuilder();
		headOfFile.append(("CardNumber , CardType"));
		saveRec(headOfFile, OutFileName);
		
		for(int a = 0; a<n; a++)
		{
			 StringBuilder str = new StringBuilder(); 
			 str.append(result[a][0] + " , " + result[a][1]);
			 saveRec(str, OutFileName);
		}
		
		
		
		
	}
	
	
	public static void saveRec(StringBuilder str, String filename)
	{
			try {
				FileWriter fw = new FileWriter(filename, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);
				pw.println(str);
				pw.flush();
				pw.close();
			}
			
			catch (Exception E) {
				System.out.println("Error caught");
			}
			}


}
