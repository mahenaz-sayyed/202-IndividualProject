package cmpe202_individual;

import static org.junit.Assert.*;

import org.junit.Test;

public class checkFactoryMethod {

	@Test
	public void test() {
		
		CardFactoryMethod chk = new CardFactoryMethod();
		Cred_card cd = chk.getCard("Visa");
		assertNotSame(cd, new Visa());
		//Because they are two different objects
	}
}
