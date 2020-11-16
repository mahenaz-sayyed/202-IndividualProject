package cmpe202_individual;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.*;
import java.math.BigDecimal;

import javax.xml.parsers.DocumentBuilder;  
import javax.xml.xpath.*; 
import org.w3c.dom.*;

public class ReadXml {

	public void ParseXml(String FileName, String OutFileName)
	{
		
		String brandCard = "";
		String[][] result = new String[500][500];
		int n=0;
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
		 brandCard = typeOfCard.createCardType(ccNumber, OutFileName);
			
		 result[n][0]=ccNumber;
		 result[n][1]=brandCard;
		 n++;
		}
		}  
		}  
			
		}   
		catch (Exception e)   
		{  
		e.printStackTrace();  
		}  
		
		
		
		DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
	     DocumentBuilder icBuilder;
	     try {
	            icBuilder = icFactory.newDocumentBuilder();
	            Document doc = icBuilder.newDocument();
	            Element mainRootElement = doc.createElementNS("https://crunchify.com/CrunchifyCreateXMLDOM", "Cards");
	            doc.appendChild(mainRootElement);
	 
	            for(int a = 0; a<n; a++) {
	            // append child elements to root element
	            mainRootElement.appendChild(getCompany(doc, result[a][0], result[a][1]));
	            }
	 
	            // output DOM XML to console 
	            Transformer transformer = TransformerFactory.newInstance().newTransformer();
	            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
	            DOMSource source = new DOMSource(doc);
	            StreamResult console = new StreamResult(System.out);
	            StreamResult file = new StreamResult(new File(OutFileName));
	          //  transformer.transform(source, console);
	            transformer.transform(source, file);
	 
	            
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
		
		}  
	
	private static Node getCompany(Document doc, String name, String age) {
        Element company = doc.createElement("row");
       
        company.appendChild(getCompanyElements(doc, company, "Name", name));
        company.appendChild(getCompanyElements(doc, company, "Type", age));
        
        return company;
    }
 
    
    private static Node getCompanyElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
		
	
	}


