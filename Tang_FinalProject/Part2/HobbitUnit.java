import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

class HobbitUnit {
	
	
	@Test
	void moveTo(){
		HashMap<String, xyPoint>   pointRef    = new HashMap<>();
		HashMap<xyPoint, Creature> creatureMap = new HashMap<>();
		
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				pointRef.put(new xyPoint(x,y).toString(), new xyPoint(x,y));
			}
		}
		
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				creatureMap.put(pointRef.get(x+","+y), null);
			}
		}
		// right
		Hobbit h = new Hobbit(new xyPoint(5,5), 100, 2, 1, 0, 0);
		h.holder = pointRef.get(7+","+5);
		xyPoint testP = new xyPoint(6,5);
		h.moveTo(creatureMap, pointRef);
		assertEquals(h.xy, testP);
		creatureMap.remove(h.xy);
		
		// left
		h.xy  = new xyPoint(5,5);
		creatureMap.put(h.xy, h);
		h.holder = pointRef.get(3+","+5);
		testP = pointRef.get(4+","+5);
		h.moveTo(creatureMap, pointRef);
		assertEquals(h.xy, testP);
		creatureMap.remove(h.xy);
		
		// down
		h.xy  = new xyPoint(5,5);
		creatureMap.put(h.xy, h);
		h.holder = pointRef.get(5+","+7);
		testP = pointRef.get(5+","+6);
		h.moveTo(creatureMap, pointRef);
		assertEquals(h.xy, testP);
		creatureMap.remove(h.xy);
		
		// up
		h.xy  = new xyPoint(5,5);
		creatureMap.put(h.xy, h);
		h.holder = pointRef.get(5+","+3);
		testP = pointRef.get(5+","+4);
		h.moveTo(creatureMap, pointRef);
		assertEquals(h.xy, testP);
		creatureMap.remove(h.xy);
		
		
		// up left
		h.xy  = new xyPoint(5,5);
		creatureMap.put(h.xy, h);
		h.holder = pointRef.get(3+","+3);
		testP = pointRef.get(4+","+4);
		h.moveTo(creatureMap, pointRef);
		assertEquals(h.xy, testP);
		creatureMap.remove(h.xy);
		
		//up right
		h.xy  = new xyPoint(5,5);
		creatureMap.put(h.xy, h);
		h.holder = pointRef.get(7+","+3);
		testP = pointRef.get(6+","+4);
		h.moveTo(creatureMap, pointRef);
		assertEquals(h.xy, testP);
		creatureMap.remove(h.xy);
		
		// down left
		h.xy  = new xyPoint(5,5);
		creatureMap.put(h.xy, h);
		h.holder = pointRef.get(3+","+7);
		testP = pointRef.get(4+","+6);
		h.moveTo(creatureMap, pointRef);
		assertEquals(h.xy, testP);
		creatureMap.remove(h.xy);
		
		// down right
		h.xy  = new xyPoint(5,5);
		creatureMap.put(h.xy, h);
		h.holder = pointRef.get(7+","+7);
		testP = pointRef.get(6+","+6);
		h.moveTo(creatureMap, pointRef);
		assertEquals(h.xy, testP);
		creatureMap.remove(h.xy);
		
	}
	
	@Test
	void moveFrom() {
		HashMap<String, xyPoint>   pointRef    = new HashMap<>();
		HashMap<xyPoint, Creature> creatureMap = new HashMap<>();
		
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				pointRef.put(new xyPoint(x,y).toString(), new xyPoint(x,y));
			}
		}
		
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				creatureMap.put(pointRef.get(x+","+y), null);
			}
		}
		
		// left
		Hobbit h = new Hobbit(new xyPoint(5,5), 100, 2, 1, 0, 0);
		h.holder = pointRef.get(7+","+5);
		xyPoint testP = new xyPoint(4,5);
		h.moveFrom(creatureMap, pointRef);
		assertEquals(h.xy, testP);
		creatureMap.remove(h.xy);
		
		// right
		h.xy  = new xyPoint(5,5);
		creatureMap.put(h.xy, h);
		h.holder = pointRef.get(3+","+5);
		testP = pointRef.get(6+","+5);
		h.moveFrom(creatureMap, pointRef);
		assertEquals(h.xy, testP);
		creatureMap.remove(h.xy);
		
		// up
		h.xy  = new xyPoint(5,5);
		creatureMap.put(h.xy, h);
		h.holder = pointRef.get(5+","+7);
		testP = pointRef.get(5+","+4);
		h.moveFrom(creatureMap, pointRef);
		assertEquals(h.xy, testP);
		creatureMap.remove(h.xy);
		
		// down
		h.xy  = new xyPoint(5,5);
		creatureMap.put(h.xy, h);
		h.holder = pointRef.get(5+","+3);
		testP = pointRef.get(5+","+6);
		h.moveFrom(creatureMap, pointRef);
		assertEquals(h.xy, testP);
		creatureMap.remove(h.xy);
		
		
		// down right
		h.xy  = new xyPoint(5,5);
		creatureMap.put(h.xy, h);
		h.holder = pointRef.get(3+","+3);
		testP = pointRef.get(6+","+6);
		h.moveFrom(creatureMap, pointRef);
		assertEquals(h.xy, testP);
		creatureMap.remove(h.xy);
		
		//down left
		h.xy  = new xyPoint(5,5);
		creatureMap.put(h.xy, h);
		h.holder = pointRef.get(7+","+3);
		testP = pointRef.get(4+","+6);
		h.moveFrom(creatureMap, pointRef);
		assertEquals(h.xy, testP);
		creatureMap.remove(h.xy);
		
		// up right
		h.xy  = new xyPoint(5,5);
		creatureMap.put(h.xy, h);
		h.holder = pointRef.get(3+","+7);
		testP = pointRef.get(6+","+4);
		h.moveFrom(creatureMap, pointRef);
		assertEquals(h.xy, testP);
		creatureMap.remove(h.xy);
		
		// up left
		h.xy  = new xyPoint(5,5);
		creatureMap.put(h.xy, h);
		h.holder = pointRef.get(7+","+7);
		testP = pointRef.get(4+","+4);
		h.moveFrom(creatureMap, pointRef);
		assertEquals(h.xy, testP);
		creatureMap.remove(h.xy);
		
	}
	
	@Test
	void moveRand() {
		HashMap<String, xyPoint>   pointRef    = new HashMap<>();
		HashMap<xyPoint, Creature> creatureMap = new HashMap<>();
		
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				pointRef.put(new xyPoint(x,y).toString(), new xyPoint(x,y));
			}
		}
		
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				creatureMap.put(pointRef.get(x+","+y), null);
			}
		}
		
		Hobbit h = new Hobbit(new xyPoint(5,5), 100, 2, 1, 0, 0);
		
		ArrayList<xyPoint> points = new ArrayList<>();
	
		for(int x = (h.xy.getX()-1); x <= (h.xy.getX()+1); x ++) {
			for(int y = (h.xy.getY()-1); y <= (h.xy.getY()+1); y++) {
				points.add(new xyPoint(x,y));
			}
		}
		
		h.moveRand(creatureMap, pointRef);
		assertEquals(points.contains(h.xy), true);		
	}
	
	@Test
	void replicate() {
		HashMap<String, xyPoint>   pointRef    = new HashMap<>();
		HashMap<xyPoint, Creature> creatureMap = new HashMap<>();
		
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				pointRef.put(new xyPoint(x,y).toString(), new xyPoint(x,y));
			}
		}
		
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				creatureMap.put(pointRef.get(x+","+y), null);
			}
		}
		
		Hobbit h = new Hobbit(new xyPoint(5,5), 100, 2, 0, 0, 0);
		h.holder = pointRef.get(4+","+5);
		h.replicate(creatureMap, pointRef);
		
		assertNotEquals(creatureMap.get(pointRef.get(4+","+5)), null);
	}
	
	@Test
	void stay() {		
		Hobbit h = new Hobbit(new xyPoint(5,5), 100, 2, 1, 0, 0);
		int check = h.hunger + 1;		
		h.stay();
		
		assertEquals(h.hunger, check);
	}
	
	@Test
	void chooseAction() {
		HashMap<String, xyPoint>   pointRef    = new HashMap<>();
		HashMap<xyPoint, Creature> creatureMap = new HashMap<>();
		
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				pointRef.put(new xyPoint(x,y).toString(), new xyPoint(x,y));
			}
		}
		
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				creatureMap.put(pointRef.get(x+","+y), null);
			}
		}
		
		Hobbit h = new Hobbit(new xyPoint(3,5), 100, 2, 1, 0, 0);
		Nazgul n = new Nazgul(new xyPoint(5,5), 100, 2, 1, 0, 0);
		
		creatureMap.put(h.xy, h);
		creatureMap.put(n.xy, n);
		
		//moveFrom
		xyPoint testP = new xyPoint(2,5);
		h.chooseAction(creatureMap, pointRef);
		assertEquals(h.xy, testP);
		
		//moveTo
		creatureMap.put(n.xy, null);
		Hobbit h2 = new Hobbit(new xyPoint(0,5), 100, 2, 1, 0, 0);
		creatureMap.put(h2.xy, h2);
		testP = new xyPoint(1,5);
		h.chooseAction(creatureMap, pointRef);
		assertEquals(h.xy, testP);
		
		//moveRand
		creatureMap.put(h2.xy, null);
		testP = new xyPoint(h.xy);
		h.chooseAction(creatureMap, pointRef);
		assertNotEquals(h.xy, testP);
		
		//replicate
		int counter = 1;
		h.age = h.age + 10;
		h.chooseAction(creatureMap, pointRef);
		for(int x = (h.xy.getX()-1); x <= (h.xy.getX()+1); x ++) {
			for(int y = (h.xy.getY()-1); y <= (h.xy.getY()+1); y++) {
				xyPoint p = new xyPoint(x,y);
				if(creatureMap.get(p) instanceof Hobbit) {
					counter++;
				}
			}
		}		
		assertEquals(counter, 2);

	}
	
	@Test
	void color() {
		Hobbit h = new Hobbit(new xyPoint(5,5), 100, 2, 1, 0, 0);
		assertEquals(h.color().equals(Color.green.darker()), true);

		h.health = h.health - 50;
		assertEquals(h.color().equals(Color.red), true);
		
	}
	

}
