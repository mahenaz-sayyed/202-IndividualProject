package cmpe202_individual;

public class determineTypeOfCard {
	
	public String createCardType(String cardNumber, String OutFileName ) {

	CardFactoryMethod thisCard = new CardFactoryMethod();
	String brand = "";
	
	if(cardNumber.length()<19 && cardNumber.length()>0) 
		{
			if((cardNumber.matches("5[1-5].*")) && (cardNumber.length()==16) )
			{
				Cred_card masterCard = thisCard.getCard("MasterCard");
				brand="MasterCard";
				
				masterCard.check_card_number();
		
				
			}
			
			else if((cardNumber.matches("3[4,7].*")) && (cardNumber.length()==15) )
			{
              
				Cred_card amex= thisCard.getCard("Amex");
				
				amex.check_card_number();
				
				brand="Amex";
			}
			else if(((cardNumber.length()==15) || (cardNumber.length()==13)) && (cardNumber.matches("3.*")))
			{
				Cred_card visa= thisCard.getCard("Visa");
				
				visa.check_card_number();
				
				brand="Visa";
			}
			
			
			
			else if((cardNumber.matches("6011.*")) && (cardNumber.length()==16) )
			{
                
				Cred_card discover= thisCard.getCard("Discover");
				
				discover.check_card_number();
				
				brand="Discover";
			}
			
			else {
				System.out.println("unidentified");
				brand="Unidentified Card";
			}
		
		}
	else {
		System.out.println("Invalid Card");
		brand="Error card number";
	}
	return brand;
	
	}
}
