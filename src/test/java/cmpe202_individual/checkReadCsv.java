package cmpe202_individual;

import static org.junit.Assert.*;

import org.junit.Test;

public class checkReadCsv {

	@Test
	public void test() {
		ReadCSV readcsv = new ReadCSV();
		readcsv.ParseCSV("C:\\Users\\mehna\\Desktop\\Sample.csv", "C:\\Users\\mehna\\Desktop\\Out.csv");
		
	}

}
