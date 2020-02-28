import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TempUnit {
	
	Temperature a = new Temperature();
	Temperature b = new Temperature();
	
	@Test
	void getTempC() {			
		assertEquals(a.getTempC(), 0);
	}
	
	@Test
	void getTempF() {
		assertEquals(a.getTempF(), 32);
	}
	
	@Test
	void setTemp() {
		a.setTemp(100);
		
		assertEquals(a.getTempC(), 100);
	}
	
	@Test
	void setScale() {
		a.setScale(Temperature.Scale.F);
		
		assertEquals(a.getTempF(), 0);
	}
	
	@Test
	void setAll() {
		a.setAll(0, Temperature.Scale.F);
		
		assertEquals(a.getTempF(), 0);
	}
	
	@Test
	void equals() {
		a.setAll(0, Temperature.Scale.C);
		b.setAll(32, Temperature.Scale.F);
		
		assertEquals(a.equals(b), true);
		
		
		a.setAll(-40, Temperature.Scale.C);
		b.setAll(-40, Temperature.Scale.F);
		
		assertEquals(a.equals(b), true);
		
		
		a.setAll(100, Temperature.Scale.C);
		b.setAll(212, Temperature.Scale.F);
		
		assertEquals(a.equals(b), true);
		
		
		a.setAll(333, Temperature.Scale.C);
		b.setAll(1, Temperature.Scale.F);
		
		assertEquals(a.equals(b), false);
	}
	
	@Test
	void compareTo() {
		// Testing equality
		a.setAll(100, Temperature.Scale.F);
		b.setAll(100, Temperature.Scale.F);
		
		assertEquals(a.compareTo(b), 0);
		
		// testing greater than
		a.setAll(100, Temperature.Scale.F);
		b.setAll(1, Temperature.Scale.F);
		
		assertEquals(a.compareTo(b), 1);
		
		// testing less than 
		a.setAll(1, Temperature.Scale.F);
		b.setAll(100, Temperature.Scale.F);
		
		assertEquals(a.compareTo(b), -1);
		
	}

	
	
}// end class
