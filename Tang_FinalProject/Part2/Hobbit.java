import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class Hobbit extends Creature {

	public ArrayList<Items> inventory;
	public xyPoint holder = new xyPoint();
	
	
	Hobbit(){}
	
	Hobbit(xyPoint p, int h, int s, int hu, int a, int d) {
		super(p, h, s, hu, a, d);
	}
	
	Hobbit(Hobbit copy) {
		super(copy.xy, copy.health, copy.sight, copy.hunger, copy.age, copy.dmg);
		this.inventory = copy.inventory;
	}
	
	
	@Override
	void moveTo(HashMap<xyPoint, Creature> neighbors, HashMap<String, xyPoint> pointRef) {
		System.out.println("moveTo");
		int x1 = xy.getX();
		int y1 = xy.getY();
		int x2 = holder.getX();
		int y2 = holder.getY();
		
		int sqrMap = (int) Math.sqrt(neighbors.size()) - 1;
		
		
		if((x1 + 1) > sqrMap) {
			x1 = (((x1)%sqrMap));
		}
		else if((x1 - 1) < 0) {
			x1 = (((x1)%sqrMap)+(sqrMap+1));
		}
		
		if((y1 + 1) > sqrMap) {
			y1 = (((y1)%sqrMap));
		}
		else if((y1 - 1) < 0) {
			y1 = (((y1)%sqrMap)+(sqrMap+1));
		}
		
		
		if(x1 < x2 && y1 == y2) {
			if(!(neighbors.get(pointRef.get((x1+1)+","+y2)) instanceof Creature)) {
				neighbors.put(pointRef.get(x1+","+y1), null);
				xy.setX(x1+1);
				neighbors.put(pointRef.get((x1+1)+","+y1), this);
			}
			else {
				moveRand(neighbors, pointRef);
			}
		}
	
		else if(x1 > x2 && y1 == y2) {
			if(!(neighbors.get(pointRef.get((x1-1)+","+y1)) instanceof Creature)) {
				neighbors.put(pointRef.get(x1+","+y1), null);
				xy.setX(x1-1);
				neighbors.put(pointRef.get((x1-1)+","+y1), this);
			}
			else {
				moveRand(neighbors, pointRef);
			}
		}
			
		else if(x1 == x2 && y1 < y2) {
			if(!(neighbors.get(pointRef.get(x1+","+(y1+1))) instanceof Creature)) {
				neighbors.put(pointRef.get(x1+","+y1), null);
				xy.setY(y1+1);
				neighbors.put(pointRef.get((x1)+","+(y1+1)), this);
			}
			else {
				moveRand(neighbors, pointRef);
			}
		}
	
		else if(x1 == x2 && y1 > y2) {
			if(!(neighbors.get(pointRef.get(x1+","+(y1-1))) instanceof Creature)) {
				neighbors.put(pointRef.get(x1+","+y1), null);
				xy.setY(y1-1);
				neighbors.put(pointRef.get(x1+","+(y1-1)), this);
			}
			else {
				moveRand(neighbors, pointRef);
			}
		}
			
		else if(x1 < x2 && y1 < y2) {
			if(!(neighbors.get(pointRef.get((x1+1)+","+(y1+1))) instanceof Creature)) {
				neighbors.put(pointRef.get(x1+","+y1), null);
				xy.setXY((x1+1), (y1+1));
				neighbors.put(pointRef.get((x1+1)+","+(y1+1)), this);
			}
			else {
				moveRand(neighbors, pointRef);
			}
		}
			
		else if(x1 < x2 && y1 > y2) {
			if(!(neighbors.get(pointRef.get((x1+1)+","+(y1-1))) instanceof Creature)) {
				neighbors.put(pointRef.get(x1+","+y1), null);
				xy.setXY((x1+1), (y1-1));
				neighbors.put(pointRef.get((x1+1)+","+(y1-1)), this);
			}
			else {
				moveRand(neighbors, pointRef);
			}
		}
			
		else if(x1 > x2 && y1 > y2) {
			if(!(neighbors.get(pointRef.get((x1-1)+","+(y1-1))) instanceof Creature)) {
				neighbors.put(pointRef.get(x1+","+y1), null);
				xy.setXY((x1-1), (y1-1));
				neighbors.put(pointRef.get((x1-1)+","+(y1-1)), this);
			}
			else {
				moveRand(neighbors, pointRef);
			}
		}
			
		else if(x1 > x2 && y1 < y2) {
			if(!(neighbors.get(pointRef.get((x1-1)+","+(y1+1))) instanceof Creature)) {
				neighbors.put(pointRef.get(x1+","+y1), null);
				xy.setXY((x1-1), (y1+1));
				neighbors.put(pointRef.get((x1-1)+","+(y1+1)), this);
			}
			else {
				moveRand(neighbors, pointRef);
			}
		}
		

	}
	
	@Override
	void moveFrom(HashMap<xyPoint, Creature> neighbors, HashMap<String, xyPoint> pointRef) {
		System.out.println("moveFrom");
		int x1 = xy.getX();
		int y1 = xy.getY();
		int x2 = holder.getX();
		int y2 = holder.getY();
		
		int sqrMap = (int) Math.sqrt(neighbors.size()) - 1;
		
	
		if((x1+1) <= sqrMap && (x1-1) >= 0 && (y1+1) <= sqrMap && (y1-1) >= 0) {
			if(x1 > x2 && y1 == y2) {
				if(!(neighbors.get(pointRef.get((x1+1)+","+y2)) instanceof Creature)) {
					neighbors.put(pointRef.get(x1+","+y1), null);
					xy.setX(x1+1);
					neighbors.put(pointRef.get((x1+1)+","+y1), this);
				}
				else {
					moveRand(neighbors, pointRef);
				}
			}
		
			if(x1 < x2 && y1 == y2) {
				if(!(neighbors.get(pointRef.get((x1-1)+","+y1)) instanceof Creature)) {
					neighbors.put(pointRef.get(x1+","+y1), null);
					xy.setX(x1-1);
					neighbors.put(pointRef.get((x1-1)+","+y1), this);
				}
				else {
					moveRand(neighbors, pointRef);
				}
			}
				
			if(x1 == x2 && y1 > y2) {
				if(!(neighbors.get(pointRef.get(x1+","+(y1+1))) instanceof Creature)) {
					neighbors.put(pointRef.get(x1+","+y1), null);
					xy.setY(y1+1);
					neighbors.put(pointRef.get((x1)+","+(y1+1)), this);
				}
				else {
					moveRand(neighbors, pointRef);
				}
			}
		
			if(x1 == x2 && y1 < y2) {
				if(!(neighbors.get(pointRef.get(x1+","+(y1-1))) instanceof Creature)) {
					neighbors.put(pointRef.get(x1+","+y1), null);
					xy.setY(y1-1);
					neighbors.put(pointRef.get(x1+","+(y1-1)), this);
				}
				else {
					moveRand(neighbors, pointRef);
				}
			}
				
			if(x1 > x2 && y1 > y2) {
				if(!(neighbors.get(pointRef.get((x1+1)+","+(y1+1))) instanceof Creature)) {
					neighbors.put(pointRef.get(x1+","+y1), null);
					xy.setXY((x1+1), (y1+1));
					neighbors.put(pointRef.get((x1+1)+","+(y1+1)), this);
				}
				else {
					moveRand(neighbors, pointRef);
				}
			}
				
			if(x1 < x2 && y1 < y2) {
				if(!(neighbors.get(pointRef.get((x1-1)+","+(y1-1))) instanceof Creature)) {
					neighbors.put(pointRef.get(x1+","+y1), null);
					xy.setXY((x1-1), (y1-1));
					neighbors.put(pointRef.get((x1-1)+","+(y1-1)), this);
				}
				else {
					moveRand(neighbors, pointRef);
				}
			}
				
			if(x1 > x2 && y1 < y2) {
				if(!(neighbors.get(pointRef.get((x1+1)+","+(y1-1))) instanceof Creature)) {
					neighbors.put(pointRef.get(x1+","+y1), null);
					xy.setXY((x1+1), (y1-1));
					neighbors.put(pointRef.get((x1+1)+","+(y1-1)), this);
				}
				else {
					moveRand(neighbors, pointRef);
				}
			}
				
			if(x1 < x2 && y1 > y2) {
				if(!(neighbors.get(pointRef.get((x1-1)+","+(y1+1))) instanceof Creature)) {
					neighbors.put(pointRef.get(x1+","+y1), null);
					xy.setXY((x1-1), (y1+1));
					neighbors.put(pointRef.get((x1-1)+","+(y1+1)), this);
				}
				else {
					moveRand(neighbors, pointRef);
				}
			}	
		}
		else if((x1+1) > sqrMap || (x1-1) < 0 || (y1+1) > sqrMap || (y1-1) < 0) {
			int x12 = x1;
			int y12 = y1;
					
			
			if((x12 + 1) > sqrMap) {
				x1 = (((x1+1)%sqrMap)-1);
			}
			else if((x12 - 1) < 0) {
				x1 = (((x1-1)%sqrMap)+(sqrMap+1));
			}		
			if((y12 + 1) > sqrMap) {
				y1 = (((y1+1)%sqrMap)-1);
			}
			else if((y12 - 1) < 0) {
				y1 = (((y1-1)%sqrMap)+(sqrMap+1));
			}
				        
			if(x12 > x2 && y12 == y2) {
				if(!(neighbors.get(pointRef.get(x1+","+y2)) instanceof Creature)) {
					neighbors.put(pointRef.get(x12+","+y12), null);
					xy.setX(x1);
					neighbors.put(pointRef.get(x1+","+y1), this);
				}
				else {
					moveRand(neighbors, pointRef);
				}
			}
				
			if(x12 < x2 && y12 == y2) {
				if(!(neighbors.get(pointRef.get(x1+","+y1)) instanceof Creature)) {
					neighbors.put(pointRef.get(x12+","+y12), null);
					xy.setX(x1);
					neighbors.put(pointRef.get(x1+","+y1), this);
				}
				else {
					moveRand(neighbors, pointRef);
				}
			}
				
			if(x12 == x2 && y12 > y2) {
				if(!(neighbors.get(pointRef.get(x1+","+y1)) instanceof Creature)) {
					neighbors.put(pointRef.get(x12+","+y12), null);
					xy.setY(y1);
					neighbors.put(pointRef.get(x1+","+(y1)), this);
				}
				else {
					moveRand(neighbors, pointRef);
				}
			}
				
			if(x12 == x2 && y12 < y2) {
				if(!(neighbors.get(pointRef.get(x1+","+(y1))) instanceof Creature)) {
					neighbors.put(pointRef.get(x12+","+y12), null);
					xy.setY(y1);
					neighbors.put(pointRef.get(x1+","+(y1)), this);
				}
				else {
					moveRand(neighbors, pointRef);
				}
			}
				
			if(x12 > x2 && y12 > y2) {
				if(!(neighbors.get(pointRef.get((x1+1)+","+(y1))) instanceof Creature)) {
					neighbors.put(pointRef.get(x12+","+y12), null);
					xy.setXY((x1), (y1));
					neighbors.put(pointRef.get((x1)+","+(y1)), this);
				}
				else {
					moveRand(neighbors, pointRef);
				}
			}
				
			if(x12 < x2 && y12 < y2) {
				if(!(neighbors.get(pointRef.get((x1)+","+(y1))) instanceof Creature)) {
					neighbors.put(pointRef.get(x12+","+y12), null);
					xy.setXY((x1), (y1));
					neighbors.put(pointRef.get((x1-1)+","+(y1-1)), this);
				}
				else {
					moveRand(neighbors, pointRef);
				}
			}
				
			if(x12 > x2 && y12 < y2) {
				if(!(neighbors.get(pointRef.get((x1)+","+(y1))) instanceof Creature)) {
					neighbors.put(pointRef.get(x12+","+y12), null);
					xy.setXY((x1), (y1));
					neighbors.put(pointRef.get((x1)+","+(y1)), this);
				}
				else {
					moveRand(neighbors, pointRef);
				}
			}
				
			if(x12 < x2 && y12 > y2) {
				if(!(neighbors.get(pointRef.get((x1)+","+(y1))) instanceof Creature)) {
					neighbors.put(pointRef.get(x12+","+y12), null);
					xy.setXY((x1), (y1));
					neighbors.put(pointRef.get((x1)+","+(y1)), this);
				}
				else {
					moveRand(neighbors, pointRef);
				}
			}
		}
		

	}
	
	@Override
	void moveRand(HashMap<xyPoint, Creature> neighbors, HashMap<String, xyPoint> pointRef) {
		System.out.println("moveRand");
		int sqrMap = (int) Math.sqrt(neighbors.size()) - 1;
		
		Random r1 = new Random();
		
		int x1  = xy.getX();
		int y1  = xy.getY();

		int xMax = (x1+1);
		int xMin = (x1-1);
		int yMax = (y1+1);
		int yMin = (y1-1);
		
		if((xMax) > sqrMap) {
			xMax = (((xMax)%sqrMap)-1);

		}
		else if((xMin) < 0) {
			xMin = (((xMin)%sqrMap)+(sqrMap+1));
		}
		if((yMax) > sqrMap) {
			yMax = (((yMax)%sqrMap)-1);
		}
		else if((yMin) < 0) {
			yMin = (((yMin)%sqrMap)+(sqrMap+1));
		}
		if(xMax < 0)
		{
			xMax =0;
		}
		if(xMin < 0)
		{
			xMin =0;
		}
		if(yMax < 0)
		{
			yMax =0;
		}
		if(yMin < 0)
		{
			yMin =0;
		}
		int[] xChoice = {xMin, xMax};
		int[] yChoice = {yMin, yMax};
		
		int x2 = xChoice[r1.nextInt(2)];
		int y2 = yChoice[r1.nextInt(2)];

		
		if(!(neighbors.get(pointRef.get(x2+","+y2)) instanceof Creature)) {
			neighbors.put(pointRef.get(x1+","+y1), null);
			xy.setXY(x2, y2);
			neighbors.put(pointRef.get(x2+","+y2), this);
		}
	}

	@Override
	void attack(Creature c) {		
		c.health = c.health - dmg;
	}

	@Override
	void replicate(HashMap<xyPoint, Creature> neighbors, HashMap<String, xyPoint> pointRef) {
		System.out.println("replicate");
		stay();
		int x = holder.getX();
		int y = holder.getY();
		
		Hobbit h = new Hobbit(this);
		h.age = 0;
		neighbors.put(pointRef.get(x+","+y), h);
		
		Simulator.birth.add(h);
		
		age = 0;
	}

	@Override
	void stay() {
		System.out.println("stay");
		hunger = hunger++;
	}

	@Override
	void chooseAction(HashMap<xyPoint, Creature> neighbors, HashMap<String, xyPoint> pointRef) {
		System.out.println("chooseAction");
		int[][] nbd;
		ArrayList<xyPoint> points  = new ArrayList<>();
		ArrayList<xyPoint> nazguls = new ArrayList<>();
		ArrayList<xyPoint> hobbits = new ArrayList<>();
		
		int sqrMap = (int) Math.sqrt(neighbors.size()) - 1;
		int nbdSqr = (sight*2)+1;
		int x;
		int y;
		
		holder = null;
		
		nbd = new int[nbdSqr][nbdSqr];
				
		for(x = (xy.getX() - sight); x < (xy.getX() - sight) + nbd.length; x++) {
			for(y = (xy.getY() - sight); y < (xy.getY() - sight) + nbd[0].length; y++) {
				if((x >= 0 && x <= sqrMap) && (y >= 0 && y<= sqrMap)) {
					xyPoint p = pointRef.get(x+","+y);
					
					points.add(p);
					
					if(neighbors.get(p) instanceof Nazgul) {
						nazguls.add(p);
					}
					if(neighbors.get(p) instanceof Hobbit) {
						hobbits.add(p);
					}
				}
			}
		}
		points.remove(xy);
		hobbits.remove(xy);
		
		
		if(nazguls.size() > 0) {
			double min = xy.getDistance(nazguls.get(0));
			double minCheck =min;
			holder = nazguls.get(0);
			for(xyPoint p : nazguls) {
				minCheck = xy.getDistance(p);
				if(minCheck < min) {
					holder = p;
					min = minCheck;
				}	
			}
			moveFrom(neighbors, pointRef);
			nazguls.clear();
		}
		if(age >= 10) {
			for(xyPoint p : points) {
				if(neighbors.get(p) == null) {
					holder = p;
					replicate(neighbors, pointRef);
					points.clear();
					break;
				}
			}
		}
		if(hobbits.size() > 0) {
			Random r1 = new Random();
			int ind = r1.nextInt(hobbits.size());
			
			holder = hobbits.get(ind);
			moveTo(neighbors, pointRef);
			hobbits.clear();
		}
		else {
			moveRand(neighbors, pointRef);
		}
		
	}
		

	@Override
	Color color() {		
		if(this.health > (health/2)) return Color.green.darker();
		
		else return Color.red;
	}
	
}