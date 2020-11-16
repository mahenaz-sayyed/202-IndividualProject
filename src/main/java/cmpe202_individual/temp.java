import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class temp {

    public static void main(String[] args) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            //add elements to Document
            Element rootElement =
                doc.createElementNS("https://www.journaldev.com/employee", "Employees");
            //append root element to document
            doc.appendChild(rootElement);

            //append first child element to root element
            rootElement.appendChild(getEmployee(doc, "1", "Pankaj", "29", "Java Developer", "Male"));

            //append second child
            rootElement.appendChild(getEmployee(doc, "2", "Lisa", "35", "Manager", "Female"));

            //for output to file, console
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //for pretty print
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            //write to console or file
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("/Users/pankaj/emps.xml"));

            //write data
            transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("DONE");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static Node getEmployee(Document doc, String id, String name, String age, String role,
            String gender) {
        Element employee = doc.createElement("Employee");

        //set id attribute
        employee.setAttribute("id", id);

        //create name element
        employee.appendChild(getEmployeeElements(doc, employee, "name", name));

        //create age element
        employee.appendChild(getEmployeeElements(doc, employee, "age", age));

        //create role element
        employee.appendChild(getEmployeeElements(doc, employee, "role", role));

        //create gender element
        employee.appendChild(getEmployeeElements(doc, employee, "gender", gender));

        return employee;
    }


    //utility method to create text node
    private static Node getEmployeeElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

}















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

public void PrintFile(String a, String b) 
{
	String temp = "temp.csv"; 

		 StringBuilder str = new StringBuilder(); 
		 str.append(a + "," + "Visa");
		 saveRec(str, temp);
	
	   
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

