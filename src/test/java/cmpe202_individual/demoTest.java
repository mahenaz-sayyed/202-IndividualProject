package cmpe202_individual;

import static org.junit.Assert.*;

import org.junit.Test;

public class demoTest {

	@Test
	public void test() {
		determineTypeOfCard CheckCard = new determineTypeOfCard();
		String OutPut = CheckCard.createCardType("5410000000000000","abc");
		assertEquals("MasterCard", OutPut);
	}

}
