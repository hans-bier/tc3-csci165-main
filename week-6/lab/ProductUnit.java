import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductUnit {

	@Test
	void setSku() {
		Product prod = new Product("Reverse Plunger", "if you know, you know", 23, "001UOSNBRI");
		
		assertEquals(prod.getSku(), "001UOSNBRI");
		
		prod.setSku("002OKOKOKO");
		assertEquals(prod.getSku(), "002OKOKOKO");
		
		prod.setSku("003DIBBADO");
		assertEquals(prod.getSku(), "003DIBBADO");
		
		prod.setSku("004DODIBBA");
		assertEquals(prod.getSku(), "004DODIBBA");
		
		prod.setSku("110OKOKOKO");
		assertEquals(prod.getSku(), "110OKOKOKO");
		
		prod.setSku("333INVALID");
		assertEquals(prod.getSku(), "INVALID");
		
		prod.setSku("123OKOKOKO");
		assertEquals(prod.getSku(), "INVALID");
		
		prod.setSku("110NOT10CHARACTERS");
		assertEquals(prod.getSku(), "INVALID");
		
		prod.setSku("lolyoucompileyourcode?nerd");
		assertEquals(prod.getSku(), "INVALID");
		
		prod.setSku("lolword");
		assertEquals(prod.getSku(), "INVALID");
	}

	@Test
	void setPrice() {
		Product prod = new Product("Reverse Plunger", "if you know, you know", 23, "004UOSNBRI");
		
		assertEquals(prod.getPrice(), 23);
		
		prod.setPrice(12.34);
		assertEquals(prod.getPrice(), 12.34);
		
		prod.setPrice(3000);
		assertEquals(prod.getPrice(), 3000);
		
		prod.setPrice(-3000);
		assertEquals(prod.getPrice(), 0);
		
		prod.setPrice(-12.34);
		assertEquals(prod.getPrice(), 0);
		
		prod.setPrice(-23);
		assertEquals(prod.getPrice(), 0);
	}
	
}
