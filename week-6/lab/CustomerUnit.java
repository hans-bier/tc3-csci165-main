import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerUnit {

	@Test
	void setEmail() {
		
		Address add   = new Address("105 FieldStone Ln", 14850);
		Customer cust = new Customer("Hans", "Tang", "hansmbierkamper@gmail.com", add);
		
		cust.setEmail("ganggang@@gang.org");
		assertEquals(cust.getEmail(), "none on file");
		
		cust.setEmail("breadwinner@bakery.yeasty");
		assertEquals(cust.getEmail(), "none on file");
		
		cust.setEmail("OmmeletesRock.com@chs");
		assertEquals(cust.getEmail(), "none on file");
		
		cust.setEmail("ThisEmailDoesntHaveAnAt.yee");
		assertEquals(cust.getEmail(), "none on file");
		
		
		cust.setEmail("SickKickFlipBro@TonyHawksProSkater2.gov");
		assertEquals(cust.getEmail(), "SickKickFlipBro@TonyHawksProSkater2.gov");
		
		cust.setEmail("LoamShredder333@whistler.com");
		assertEquals(cust.getEmail(), "LoamShredder333@whistler.com");
		
		cust.setEmail("GundamRX78@shibuya.jp.co");
		assertEquals(cust.getEmail(), "GundamRX78@shibuya.jp.co");
	}	

}
