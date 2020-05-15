import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

class NazgulUnit {

	
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
		Nazgul n = new Nazgul(new xyPoint(5,5), 100, 2, 1, 0, 0);
		n.holder = pointRef.get(7+","+5);
		xyPoint testP = new xyPoint(6,5);
		n.moveTo(creatureMap, pointRef);
		assertEquals(n.xy, testP);
		creatureMap.remove(n.xy);
		
		// left
		n.xy  = new xyPoint(5,5);
		creatureMap.put(n.xy, n);
		n.holder = pointRef.get(3+","+5);
		testP = pointRef.get(4+","+5);
		n.moveTo(creatureMap, pointRef);
		assertEquals(n.xy, testP);
		creatureMap.remove(n.xy);
		
		// down
		n.xy  = new xyPoint(5,5);
		creatureMap.put(n.xy, n);
		n.holder = pointRef.get(5+","+7);
		testP = pointRef.get(5+","+6);
		n.moveTo(creatureMap, pointRef);
		assertEquals(n.xy, testP);
		creatureMap.remove(n.xy);
		
		// up
		n.xy  = new xyPoint(5,5);
		creatureMap.put(n.xy, n);
		n.holder = pointRef.get(5+","+3);
		testP = pointRef.get(5+","+4);
		n.moveTo(creatureMap, pointRef);
		assertEquals(n.xy, testP);
		creatureMap.remove(n.xy);
		
		
		// up left
		n.xy  = new xyPoint(5,5);
		creatureMap.put(n.xy, n);
		n.holder = pointRef.get(3+","+3);
		testP = pointRef.get(4+","+4);
		n.moveTo(creatureMap, pointRef);
		assertEquals(n.xy, testP);
		creatureMap.remove(n.xy);
		
		//up right
		n.xy  = new xyPoint(5,5);
		creatureMap.put(n.xy, n);
		n.holder = pointRef.get(7+","+3);
		testP = pointRef.get(6+","+4);
		n.moveTo(creatureMap, pointRef);
		assertEquals(n.xy, testP);
		creatureMap.remove(n.xy);
		
		// down left
		n.xy  = new xyPoint(5,5);
		creatureMap.put(n.xy, n);
		n.holder = pointRef.get(3+","+7);
		testP = pointRef.get(4+","+6);
		n.moveTo(creatureMap, pointRef);
		assertEquals(n.xy, testP);
		creatureMap.remove(n.xy);
		
		// down right
		n.xy  = new xyPoint(5,5);
		creatureMap.put(n.xy, n);
		n.holder = pointRef.get(7+","+7);
		testP = pointRef.get(6+","+6);
		n.moveTo(creatureMap, pointRef);
		assertEquals(n.xy, testP);
		creatureMap.remove(n.xy);
		
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
		
		Nazgul n = new Nazgul(new xyPoint(5,5), 100, 2, 1, 0, 0);
		
		ArrayList<xyPoint> points = new ArrayList<>();
	
		for(int x = (n.xy.getX()-1); x <= (n.xy.getX()+1); x ++) {
			for(int y = (n.xy.getY()-1); y <= (n.xy.getY()+1); y++) {
				points.add(new xyPoint(x,y));
			}
		}
		
		n.moveRand(creatureMap, pointRef);
		assertEquals(points.contains(n.xy), true);		
	}
	
	@Test
	void attack() {
		Nazgul n = new Nazgul(new xyPoint(5,5), 100, 2, 1, 0, 10);
		Hobbit h = new Hobbit(new xyPoint(4,5), 100, 2, 1, 0, 0);
		
		int check = 90;
		n.attack(h);
		
		assertEquals(h.health, check);
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
		
		Nazgul n = new Nazgul(new xyPoint(5,5), 100, 2, 0, 0, 0);
		n.holder = pointRef.get(4+","+5);
		n.replicate(creatureMap, pointRef);
		
		assertNotEquals(creatureMap.get(pointRef.get(4+","+5)), null);
	}
	
	@Test
	void stay() {
		Nazgul n = new Nazgul(new xyPoint(5,5), 100, 2, 1, 0, 0);
		int check = n.hunger + 1;		
		n.stay();
		
		assertEquals(n.hunger, check);
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
		Nazgul n = new Nazgul(new xyPoint(5,5), 100, 2, 1, 0, 10);
		Hobbit h = new Hobbit(new xyPoint(3,5), 100, 2, 1, 0, 0);
		
		creatureMap.put(n.xy, n);
		creatureMap.put(h.xy, h);
		
		//moveTo
		xyPoint testP = new xyPoint(4,5);
		n.chooseAction(creatureMap, pointRef);
		assertEquals(n.xy, testP);
		
		//attack
		n.chooseAction(creatureMap, pointRef);
		assertEquals(h.health, 90);
		
		//moveRand
		creatureMap.put(h.xy, null);
		testP = new xyPoint(n.xy);
		n.chooseAction(creatureMap, pointRef);
		assertNotEquals(n.xy, testP);
		
		//replicate
		int counter = 1;
		n.age = n.age + 10;
		n.chooseAction(creatureMap, pointRef);
		for(int x = (n.xy.getX()-1); x <= (n.xy.getX()+1); x ++) {
			for(int y = (n.xy.getY()-1); y <= (n.xy.getY()+1); y++) {
				xyPoint p = new xyPoint(x,y);
				if(creatureMap.get(p) instanceof Nazgul) {
					counter++;
				}
			}
		}		
		assertEquals(counter, 2);

	}
	@Test
	void color() {
		Nazgul n = new Nazgul(new xyPoint(5,5), 100, 2, 1, 0, 0);
		
		assertEquals(n.color().equals(Color.black), true);

		n.health = n.health - 50;
	
		assertEquals(n.color().equals(Color.gray.brighter()), true);
		
	}
	
}
