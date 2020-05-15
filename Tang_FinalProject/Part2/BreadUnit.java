import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

class BreadUnit {

	
	@Test
	void modify() {
		HashMap<String, xyPoint> pointRef = new HashMap<>();
		HashMap<xyPoint, Items>  itemMap  = new HashMap<>();
		
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				pointRef.put(new xyPoint(x,y).toString(), new xyPoint(x,y));
			}
		}
		
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				itemMap.put(pointRef.get(x+","+y), null);
			}
		}
		
		Bread b = new Bread(new xyPoint(3,5), 10);
		Hobbit h = new Hobbit(new xyPoint(3,5), 100, 2, 10, 0, 0);
		b.modify(h, itemMap);
		assertEquals(h.hunger, 0);
	}
	
	@Test 
	void spawn() {
		HashMap<String, xyPoint> pointRef = new HashMap<>();
		HashMap<xyPoint, Items>  itemMap  = new HashMap<>();
		
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				pointRef.put(new xyPoint(x,y).toString(), new xyPoint(x,y));
			}
		}
		
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				itemMap.put(pointRef.get(x+","+y), null);
			}
		}
		
		int counter = 1;
		
		Bread b = new Bread(new xyPoint(3,3), 10);
		b.spawn(itemMap, pointRef);
		
		for(int x = 0; x <= 10; x++) {
			for(int y = 0; y <= 10; y++) {
				xyPoint p = new xyPoint(x,y);
				if(itemMap.get(p) instanceof Bread) {
					counter++;
				}
			}
		}
		
		assertEquals(counter, 2);
		
	}

	
}
