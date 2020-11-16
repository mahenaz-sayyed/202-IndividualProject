package cmpe202_individual;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.*;
import java.math.BigDecimal;

import javax.xml.parsers.DocumentBuilder;  
import javax.xml.xpath.*; 
import org.w3c.dom.*;

public class ReadXml {

	public void ParseXml(String FileName, String OutFileName)
	{
		CardFactoryMethod thisCard = new CardFactoryMethod();
		try   
		{  
		 
		File file = new File(FileName);  
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
		
		DocumentBuilder db = dbf.newDocumentBuilder();  
		Document doc = db.parse(file);  
		doc.getDocumentElement().normalize();  
		
		NodeList nodeList = doc.getElementsByTagName("row");  
		
		for (int itr = 0; itr < nodeList.getLength(); itr++)   
		{  
		Node node = nodeList.item(itr);  
		
		if (node.getNodeType() == Node.ELEMENT_NODE)   
		{  
		Element eElement = (Element) node;  
	
		if(eElement.getElementsByTagName("CardNumber").item(0) != null) {
		String number = eElement.getElementsByTagName("CardNumber").item(0).getTextContent();  
		BigDecimal CNumber=new BigDecimal(number);
		String ccNumber=CNumber.toPlainString();

		determineTypeOfCard typeOfCard = new determineTypeOfCard();
		typeOfCard.createCardType(ccNumber, OutFileName);
		}
		}  
		}  
			
		}   
		catch (Exception e)   
		{  
		e.printStackTrace();  
		}  
		}  
		
	
	}


