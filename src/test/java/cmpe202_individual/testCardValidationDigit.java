package cmpe202_individual;

import static org.junit.Assert.*;

import org.junit.Test;

public class testCardValidationDigit {

	@Test
	public void test() {
		MasterCard mCard= new MasterCard();
		Boolean result = mCard.check_card_number();
		Boolean res = true;
		assertEquals(result, res);
	}

}
