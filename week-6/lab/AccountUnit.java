import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AccountUnit {

	@Test
	void setBalance() {
		Address add   = new Address("105 FieldStone Ln", 14850);
		Customer cust = new Customer("Hans", "Tang", "hansmbierkamper@gmail.com", add);
		Date date 	  = new Date(7, 7, 2007);
		
		double bala = 1000;
		double credLim = 2000;
		
		Account acc = new Account(cust, date, bala, credLim);
		
		assertEquals(acc.getBalance(), 1000);
		
		acc.setBalance(2000);
		assertEquals(acc.getBalance(), 2000);
		
		acc.setBalance(22.22);
		assertEquals(acc.getBalance(), 22.22);
	
		acc.setBalance(-1);
		assertEquals(acc.getBalance(), 0);
		
		acc.setBalance(-111);
		assertEquals(acc.getBalance(), 0);
		
		acc.setBalance(-33.33);
		assertEquals(acc.getBalance(), 0);
	}

	@Test 
	void setCreditLimit() {
		Address add   = new Address("105 FieldStone Ln", 14850);
		Customer cust = new Customer("Hans", "Tang", "hansmbierkamper@gmail.com", add);
		Date date 	  = new Date(7, 7, 2007);
		
		double bala = 1000;
		double credLim = 2000;
		
		Account acc = new Account(cust, date, bala, credLim);
		
		assertEquals(acc.getCreditLimit(), 2000);
		
		acc.setCreditLimit(100);
		assertEquals(acc.getCreditLimit(), 100);
		
		acc.setCreditLimit(10.01);
		assertEquals(acc.getCreditLimit(), 10.01);
		
		acc.setCreditLimit(3000);
		assertEquals(acc.getCreditLimit(), 2000);
		
		acc.setCreditLimit(9000);
		assertEquals(acc.getCreditLimit(), 2000);
		
		acc.setCreditLimit(-333);
		assertEquals(acc.getCreditLimit(), 0);
		
		acc.setCreditLimit(-42.31);
		assertEquals(acc.getCreditLimit(), 0);	
	}
	
	@Test
	void setDiscount() {
		Address add   = new Address("105 FieldStone Ln", 14850);
		Customer cust = new Customer("Hans", "Tang", "hansmbierkamper@gmail.com", add);
		Date date1 	  = new Date(7, 7, 2007);
		Date date2 	  = new Date(1, 1, 2000);
		Date date3 	  = new Date(10, 10, 2013);
		
		double bala = 1000;
		double credLim = 2000;
		
		Account acc1 = new Account(cust, date1, bala, credLim);
		Account acc2 = new Account(cust, date2, bala, credLim);
		Account acc3 = new Account(cust, date3, bala, credLim);
		
		assertEquals(acc1.getDiscount(), 0.26);
		assertEquals(acc2.getDiscount(), 0.4);
		assertEquals(acc3.getDiscount(), 0.14);	
	}
	
}
