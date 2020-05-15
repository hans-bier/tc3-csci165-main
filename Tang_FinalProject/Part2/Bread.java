import java.util.HashMap;
import java.util.Random;

public class Bread extends Items {
	int hungerPoints;
	
	public Bread() {}
	
	public Bread(xyPoint p, int h) {
		this.xy = p;
		this.hungerPoints = h;
	}
	
	public Bread(Bread copy) {
		super(copy.xy);
		this.hungerPoints = copy.hungerPoints;
	}

	@Override
	void modify(Creature c, HashMap<xyPoint, Items> itemMap) {
		System.out.println("Okay)");
		if(c instanceof Hobbit) {
			if(c.hunger-hungerPoints < 0) {
				c.hunger = 0;
			}
			else{
				System.out.println(c.hunger);
				c.hunger = c.hunger - hungerPoints;
				System.out.println(c.hunger);
				itemMap.remove(xy);
			}
		}
	}
	
	@Override
	void spawn(HashMap<xyPoint, Items>  itemMap, HashMap<String, xyPoint> pointRef) {
		
		int sqrMap = (int) Math.sqrt(pointRef.size()) - 1;
		
		Random r = new Random();
		
		int x = r.nextInt(sqrMap);
		int y = r.nextInt(sqrMap);
		int hungerPoints = r.nextInt(10);
		
		xyPoint p = new xyPoint(x,y);
		
		Bread b = new Bread(p,hungerPoints);
				
		itemMap.put(pointRef.get(x+","+y), b);
		
		Simulator.itemSpawn.add(b);
	}

}
