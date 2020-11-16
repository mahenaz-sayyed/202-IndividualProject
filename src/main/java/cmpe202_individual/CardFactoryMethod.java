package cmpe202_individual;

public class CardFactoryMethod {

	
		
		   //use getShape method to get object of type shape 
		   public Cred_card getCard(String cardType){
		      if(cardType == null){
		         return null;
		      }		
		      if(cardType.equalsIgnoreCase("Visa")){
		         return new Visa();
		         
		      } else if(cardType.equalsIgnoreCase("MasterCard")){
		         return new MasterCard();
		         
		      } else if(cardType.equalsIgnoreCase("Amex")){
			         return new AmericanExpress();
			         
		      } else if(cardType.equalsIgnoreCase("Discover")){
			         return new Discover();
			         
			      } 
		      
		      return null;
		   }
		
}
