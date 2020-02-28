import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;


public class ElectionUnit {
	
	ArrayList<CountyResults2016> results = new ArrayList<CountyResults2016>();
	
	
	//======================================================\\
	//=All expected values were found using Excel functions=\\
	//======================================================\\
	
	
	@Test
	void findLargestMargin() {
		ElectionDriver.fillList();
		
		assertEquals(ElectionDriver.findLargestMargin(), ElectionDriver.results.get(2718));
		
		assertEquals(ElectionDriver.findLargestMargin("NY"), ElectionDriver.results.get(1982));
		
		assertEquals(ElectionDriver.findLargestMargin("CA"), ElectionDriver.results.get(223));
		
		assertEquals(ElectionDriver.findLargestMargin("CO"), ElectionDriver.results.get(275));
	}
	
	
	@Test
	void getStateTotals() {
		ElectionDriver.fillList();
		
		String[] states = ElectionDriver.getStateTotals();
		
		String one = "State: MI Total Democratic Votes: 2268193.0 Total Republican Votes: 2279805.0\n" + 
				"Margin of Victory 18.82% Winning Party: Republican party";
		
		String two = "State: NV Total Democratic Votes: 537753.0 Total Republican Votes: 511319.0\n" + 
				"Margin of Victory 6.99% Winning Party: Democratic party";
		
		String three = "State: UT Total Democratic Votes: 274188.0 Total Republican Votes: 452086.0\n" + 
				"Margin of Victory 12.66% Winning Party: Republican party";
		
		
		assertEquals(states[22], one);
		
		assertEquals(states[33], two);
		
		assertEquals(states[44], three);
	}	
}
