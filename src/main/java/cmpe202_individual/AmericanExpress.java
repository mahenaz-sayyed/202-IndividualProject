package cmpe202_individual;

public class AmericanExpress implements Cred_card {

public boolean check_card_number() {
		
		return true;
	}

	public void PrintFile(String a, String b) 
	{
		StringBuilder str = new StringBuilder(); 
		 str.append(a + "," + "Amex");
		 System.out.println(str);

}

}
