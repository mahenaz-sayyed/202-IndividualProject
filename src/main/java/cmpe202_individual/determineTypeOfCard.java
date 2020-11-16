package cmpe202_individual;

public class determineTypeOfCard {
	
	public void createCardType(String cardNumber, String OutFileName ) {

	CardFactoryMethod thisCard = new CardFactoryMethod();
	
	
	if(cardNumber.length()<19 && cardNumber.length()>0) 
		{
			if((cardNumber.matches("5[1-5].*")) && (cardNumber.length()==16) )
			{
				Cred_card masterCard = thisCard.getCard("MasterCard");
				
				masterCard.check_card_number();
				masterCard.PrintFile(cardNumber, OutFileName);
				
			}
			
			else if((cardNumber.matches("3[4,7].*")) && (cardNumber.length()==15) )
			{
              
				Cred_card amex= thisCard.getCard("Amex");
				
				amex.check_card_number();
				amex.PrintFile(cardNumber, OutFileName);
			}
			else if(((cardNumber.length()==15) || (cardNumber.length()==13)) && (cardNumber.matches("3.*")))
			{
				Cred_card visa= thisCard.getCard("Visa");
				
				visa.check_card_number();
				visa.PrintFile(cardNumber, OutFileName);
			}
			
			
			
			else if((cardNumber.matches("6011.*")) && (cardNumber.length()==16) )
			{
                
				Cred_card discover= thisCard.getCard("Discover");
				
				discover.check_card_number();
				discover.PrintFile(cardNumber, OutFileName);
			}
			
			else {
				System.out.println("unidentified");
			}
		
		}
	else {
		System.out.println("Invalid Card");
	}
	}
}
