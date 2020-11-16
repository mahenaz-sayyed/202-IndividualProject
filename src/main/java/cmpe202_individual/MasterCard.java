package cmpe202_individual;
import java.io.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class MasterCard implements Cred_card
{

	public boolean check_card_number() {
		
		//System.out.println("MC");
		
		return true;
	}
	
	public void PrintFile(String a, String b) 
	{
		String[] OutputName = b.split("\\."); 
		int lenOfName= OutputName.length;
		String typeFile= OutputName[lenOfName-1];
		
		
		
		if(typeFile.equalsIgnoreCase("csv")) 
		{

			 StringBuilder str = new StringBuilder(); 
			 str.append(a + "," + "MasterCard");
			 saveRec(str, b);
		}
		
		
		
		else if(typeFile.equalsIgnoreCase("xml")) 
		{
			 DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
		     DocumentBuilder icBuilder;
		     try {
		            icBuilder = icFactory.newDocumentBuilder();
		            Document doc = icBuilder.newDocument();
		            Element mainRootElement = doc.createElementNS("https://crunchify.com/CrunchifyCreateXMLDOM", "Cards");
		            doc.appendChild(mainRootElement);
		 
		            // append child elements to root element
		            mainRootElement.appendChild(getCompany(doc, a, "MasterCard"));
		           
		 
		            // output DOM XML to console 
		            Transformer transformer = TransformerFactory.newInstance().newTransformer();
		            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
		            DOMSource source = new DOMSource(doc);
		            StreamResult console = new StreamResult(System.out);
		            StreamResult file = new StreamResult(new File(b));
		            transformer.transform(source, console);
		            transformer.transform(source, file);
		 
		            
		 
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			 
		     
		     
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

