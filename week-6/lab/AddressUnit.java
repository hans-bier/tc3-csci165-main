import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddressUnit {

	@Test
	void setZip() {
		Address add = new Address("123 Hairy Tooth Ln", 14850);
		
		assertEquals(add.getCity(), "Ithaca");
		assertEquals(add.getState(), "NY");
		
		add.setZip(55784);
		assertEquals(add.getCity(), "Swan River");
		assertEquals(add.getState(), "MN");
		
		add.setZip(88527);
		assertEquals(add.getCity(), "El Paso");
		assertEquals(add.getState(), "TX");
		
		add.setZip(99999999);
		assertEquals(add.getZip(), 0);
		assertEquals(add.getCity(), "DNE");
		assertEquals(add.getState(), "DNE");
		
		add.setZip(66666666);
		assertEquals(add.getZip(), 0);
		assertEquals(add.getCity(), "DNE");
		assertEquals(add.getState(), "DNE");
		
		add.setZip(987654);
		assertEquals(add.getZip(), 0);
		assertEquals(add.getCity(), "DNE");
		assertEquals(add.getState(), "DNE");
	}
	
}
