package cmpe202_individual;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class ReadJson {

	int n =0;
	String brandCard = "";
	@SuppressWarnings("unchecked")
	public void ParseJson(String FileName, String OutFileName) throws IOException, ParseException
	{
         JSONParser jsonParser = new JSONParser();
		 FileReader reader = new FileReader(FileName);
		 Object obj = jsonParser.parse(reader);
		 
		 
		
			
		
			String[][] result = new String[500][500];
			
		 
		 JSONArray employeeList = (JSONArray) obj;
		 
		 CardFactoryMethod thisCard = new CardFactoryMethod();
		 
     employeeList.forEach( emp -> 
         
         { 
        	 
        	 
        	 JSONObject x = (JSONObject) emp;
             Long number = (Long)x.get("CardNumber");
             String ccNumber = String.valueOf(number);  
         	determineTypeOfCard typeOfCard = new determineTypeOfCard();
         	
         	 brandCard = typeOfCard.createCardType(ccNumber, OutFileName);
 			
			 result[n][0]=ccNumber;
			 result[n][1]=brandCard;
			// System.out.println(result[n][1]);

			 n++;
 	
         }	
    		 			); 
     
     
     
     
     JSONArray array = new JSONArray();
     
     for (int a= 0; a< n; a++) {
    	 JSONObject jsonObject = new JSONObject();
     jsonObject.put("CardNumber", result[a][0]);
     jsonObject.put("CardType", result[a][1]);
    array.add(jsonObject);
    // System.out.println(array);
   
     }
     try {
        FileWriter file = new FileWriter(OutFileName);
        file.write(array.toJSONString());
        file.close();
     } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
     }
     
  }
    
         	
	}


