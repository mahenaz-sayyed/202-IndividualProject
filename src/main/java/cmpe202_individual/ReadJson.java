package cmpe202_individual;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class ReadJson {

	public void ParseJson(String FileName, String OutFileName) throws IOException, ParseException
	{
         JSONParser jsonParser = new JSONParser();
		 FileReader reader = new FileReader(FileName);
		 Object obj = jsonParser.parse(reader);
		 
		 JSONArray employeeList = (JSONArray) obj;
		 
		 CardFactoryMethod thisCard = new CardFactoryMethod();
		 
     employeeList.forEach( emp -> 
         
         { 
        	 
        	 JSONObject x = (JSONObject) emp;
             Long number = (Long)x.get("CardNumber");
             String ccNumber = String.valueOf(number);  
         	determineTypeOfCard typeOfCard = new determineTypeOfCard();
         	
			typeOfCard.createCardType(ccNumber, OutFileName);
 	
         }	
    		 			); 
         	
	}

}
