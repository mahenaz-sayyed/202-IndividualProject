package cmpe202_individual;
import java.util.*;
import java.io.*;
import java.math.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.DocumentBuilder;  
import javax.xml.xpath.*; 
import org.w3c.dom.*;

public class Main {

public static void main(String[] args) throws Exception {
	
	String[][] cards = new String[500][500];	
	 JSONParser parser = new JSONParser();
 
		String line = "";  
		String splitBy = ",";  
		try   
		{  
			
			
		//parsing a CSV file into BufferedReader class constructor  
		CardFactoryMethod thisCard = new CardFactoryMethod();
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\mehna\\Desktop\\Sample.csv"));  
		br.readLine();
		Cred_card[] listOfall = new Cred_card[50];
		int cnt=0; 
		int i=0,j=0;
		
		while ((line = br.readLine()) != null)   //returns a Boolean value  
		{  
			cnt++;
			
			
			
			if(line.matches("[0-9].*"))
			{
					String[] customer = line.split(splitBy);    // use comma as separator  
					BigDecimal bigDecimal=new BigDecimal(customer[0]);
					String toStringBigDec=bigDecimal.toPlainString();
					System.out.println("Customer [Card=" + toStringBigDec + ", "
							+ "ExpirationDate=" + customer[1] + ", Name=" + customer[2] +"]");  
	
					if(toStringBigDec.length()<19 && toStringBigDec.length()>0) 
					{
						if((toStringBigDec.matches("5[1-5].*")) && (toStringBigDec.length()==16) )
						{
							 listOfall[cnt] = thisCard.getCard("MasterCard");
							
							listOfall[cnt].check_card_number();
							cards[i][0]=toStringBigDec; 
							cards[i][1]="MasterCard";
						}
						
						else if(((toStringBigDec.length()==15) || (toStringBigDec.length()==13)) && (toStringBigDec.matches("3.*")))
						{
							listOfall[cnt] = thisCard.getCard("Visa");
							
							listOfall[cnt].check_card_number();
						}
						
						else if((toStringBigDec.matches("3[4,7].*")) && (toStringBigDec.length()==15) )
						{
							System.out.println("AmericanExpress");
						}
					}
			}
		} 
		
		
		
		
		 JSONParser jsonParser = new JSONParser();
		 
		 FileReader reader = new FileReader("C:\\Users\\mehna\\eclipse-workspace\\Sample.json");
		
		 Object obj = jsonParser.parse(reader);
		 
		 JSONArray employeeList = (JSONArray) obj;
		 
     
 
         employeeList.forEach( emp -> 
         
         { 
        	 JSONObject x = (JSONObject) emp;

   	Long number = (Long)x.get("CardNumber");
 	String date = (String)x.get("ExpirationDate");
 	String name = (String)x.get("NameOfCardholder");
   	System.out.println(number);

         }	); 
         
        
		
		}   
		catch (IOException e)   
		{  
		e.printStackTrace();  
		}  
		} 


}
	




