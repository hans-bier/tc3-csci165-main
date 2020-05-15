import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class Nazgul extends Creature {

	public ArrayList<Items> inventory;
	public xyPoint holder = new xyPoint();
	
	Nazgul() {}

	Nazgul(xyPoint p, int h, int s, int hu, int a, int d) {
		super(p, h, s, hu, a, d);
	}
	
	Nazgul(Nazgul copy) {
		super(copy.xy, copy.health, copy.sight, copy.hunger, copy.age, copy.dmg);
		this.inventory = copy.inventory;
	}
	
	
	@Override
	void moveTo(HashMap<xyPoint, Creature> neighbors, HashMap<String, xyPoint> pointRef) {
		System.out.println("N moveTo");
		int x1 = xy.getX();
		int y1 = xy.getY();
		int x2 = holder.getX();
		int y2 = holder.getY();
		
		int sqrMap = (int) Math.sqrt(neighbors.size()) - 1;
			
		
		if((x1+1) <= sqrMap) {
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
		}
		if((x1-1) >= 0) {
			if(x1 > x2 && y1 == y2) {
				if(!(neighbors.get(pointRef.get((x1-1)+","+y1)) instanceof Creature)) {
					neighbors.put(pointRef.get(x1+","+y1), null);
					xy.setX(x1-1);
					neighbors.put(pointRef.get((x1-1)+","+y1), this);
				}
				else {
					moveRand(neighbors, pointRef);
				}
			}
		}
		if((y1+1) <= sqrMap) {
			if(x1 == x2 && y1 < y2) {
				if(!(neighbors.get(pointRef.get(x1+","+(y1+1))) instanceof Creature)) {
					neighbors.put(pointRef.get(x1+","+y1), null);
					xy.setY(y1+1);
					neighbors.put(pointRef.get((x1)+","+(y1+1)), this);
				}
				else {
					moveRand(neighbors, pointRef);
				}
			}
		}
		if((y1-1) >= 0) {
			if(x1 == x2 && y1 > y2) {
				if(!(neighbors.get(pointRef.get(x1+","+(y1-1))) instanceof Creature)) {
					neighbors.put(pointRef.get(x1+","+y1), null);
					xy.setY(y1-1);
					neighbors.put(pointRef.get(x1+","+(y1-1)), this);
				}
				else {
					moveRand(neighbors, pointRef);
				}
			}
		}
		if((x1+1) <= sqrMap && (y1+1) <= sqrMap) {
			if(x1 < x2 && y1 < y2) {
				if(!(neighbors.get(pointRef.get((x1+1)+","+(y1+1))) instanceof Creature)) {
					neighbors.put(pointRef.get(x1+","+y1), null);
					xy.setXY((x1+1), (y1+1));
					neighbors.put(pointRef.get((x1+1)+","+(y1+1)), this);
				}
				else {
					moveRand(neighbors, pointRef);
				}
			}
		}
		if((x1+1) <= sqrMap && (y1-1) >= 0) {
			if(x1 < x2 && y1 > y2) {
				if(!(neighbors.get(pointRef.get((x1+1)+","+(y1-1))) instanceof Creature)) {
					neighbors.put(pointRef.get(x1+","+y1), null);
					xy.setXY((x1+1), (y1-1));
					neighbors.put(pointRef.get((x1+1)+","+(y1-1)), this);
				}
				else {
					moveRand(neighbors, pointRef);
				}
			}
		}
		if((x1-1) >= 0 && (y1-1) >= 0) {
			if(x1 > x2 && y1 > y2) {
				if(!(neighbors.get(pointRef.get((x1-1)+","+(y1-1))) instanceof Creature)) {
					neighbors.put(pointRef.get(x1+","+y1), null);
					xy.setXY((x1-1), (y1-1));
					neighbors.put(pointRef.get((x1-1)+","+(y1-1)), this);
				}
				else {
					moveRand(neighbors, pointRef);
				}
			}
		}
		if((x1-1) >= 0 && (y1+1) <= sqrMap) {
			if(x1 > x2 && y1 < y2) {
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
	}
	
	@Override
	void moveFrom(HashMap<xyPoint, Creature> neighbors, HashMap<String, xyPoint> pointRef) {
		System.out.println("N moveFrom");
		int x1 = xy.getX();
		int y1 = xy.getY();
		int x2 = holder.getX();
		int y2 = holder.getY();
		
		int sqrMap = (int) Math.sqrt(neighbors.size()) - 1;
	
		
		if((x1+1) <= sqrMap) {
			if(x1 > x2 && y1 == y2) {
				if((neighbors.get(pointRef.get((x1+1)+","+y2)) instanceof Creature)) {
					neighbors.put(pointRef.get(x1+","+y1), null);
					xy.setX(x1+1);
					neighbors.put(pointRef.get((x1+1)+","+y1), this);
				}
			}
		}
		if((x1-1) >= 0) {
			if(x1 < x2 && y1 == y2) {
				if(!(neighbors.get(pointRef.get((x1-1)+","+y1)) instanceof Creature)) {
					neighbors.put(pointRef.get(x1+","+y1), null);
					xy.setX(x1-1);
					neighbors.put(pointRef.get((x1-1)+","+y1), this);
				}
			}
		}
		if((y1+1) <= sqrMap) {
			if(x1 == x2 && y1 > y2) {
				if(!(neighbors.get(pointRef.get(x1+","+(y1+1))) instanceof Creature)) {
					neighbors.put(pointRef.get(x1+","+y1), null);
					xy.setY(y1+1);
					neighbors.put(pointRef.get((x1)+","+(y1+1)), this);
				}
			}
		}
		if((y1-1) >= 0) {
			if(x1 == x2 && y1 < y2) {
				if(!(neighbors.get(pointRef.get(x1+","+(y1-1))) instanceof Creature)) {
					neighbors.put(pointRef.get(x1+","+y1), null);
					xy.setY(y1-1);
					neighbors.put(pointRef.get(x1+","+(y1-1)), this);
				}
			}
		}
		if((x1+1) <= sqrMap && (y1+1) <= sqrMap) {
			if(x1 > x2 && y1 > y2) {
				if(!(neighbors.get(pointRef.get((x1+1)+","+(y1+1))) instanceof Creature)) {
					neighbors.put(pointRef.get(x1+","+y1), null);
					xy.setXY((x1+1), (y1+1));
					neighbors.put(pointRef.get((x1+1)+","+(y1+1)), this);
				}
			}
		}
		if((x1+1) <= sqrMap && (y1-1) >= 0 ) {
			if(x1 > x2 && y1 < y2) {
				if(!(neighbors.get(pointRef.get((x1+1)+","+(y1-1))) instanceof Creature)) {
					neighbors.put(pointRef.get(x1+","+y1), null);
					xy.setXY((x1+1), (y1-1));
					neighbors.put(pointRef.get((x1+1)+","+(y1-1)), this);
				}
			}
		}	
		if((x1-1) >= 0 && (y1-1) >= 0) {
			if(x1 < x2 && y1 < y2) {
				if(!(neighbors.get(pointRef.get((x1-1)+","+(y1-1))) instanceof Creature)) {
					neighbors.put(pointRef.get(x1+","+y1), null);
					xy.setXY((x1-1), (y1-1));
					neighbors.put(pointRef.get((x1-1)+","+(y1-1)), this);
				}
			}
		}
		if((x1-1) >= 0 && (y1+1) <= sqrMap) {
			if(x1 < x2 && y1 > y2) {
				if(!(neighbors.get(pointRef.get((x1-1)+","+(y1+1))) instanceof Creature)) {
					neighbors.put(pointRef.get(x1+","+y1), null);
					xy.setXY((x1-1), (y1+1));
					neighbors.put(pointRef.get((x1-1)+","+(y1+1)), this);
				}
			}
		}
	}
	
	@Override 
	void moveRand(HashMap<xyPoint, Creature> neighbors, HashMap<String, xyPoint> pointRef) {
		System.out.println("N moveRand");
		int sqrMap = (int) Math.sqrt(neighbors.size()) - 1;
		
		Random r1 = new Random();
		
		int x1  = xy.getX();
		int y1  = xy.getY();
		
		
		int xMax = (x1+1);
		int xMin = (x1-1);
		int yMax = (y1+1);
		int yMin = (y1-1);
		
		if((xMax) > sqrMap) {
			xMax = xMax-1;
		}
		else if((xMin) < 0) {
			xMin = xMin+1;
		}
		if((yMax) > sqrMap) {
			yMax = yMax-1;
		}
		else if((yMin) < 0) {
			yMin = yMin+1;
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
		System.out.println("N attack");
		hunger = hunger - dmg;
		c.health = c.health - dmg;
	}

	@Override
	void replicate(HashMap<xyPoint, Creature> neighbors, HashMap<String, xyPoint> pointRef) {
		System.out.println("N replicate");
		stay();
		int x = holder.getX();
		int y = holder.getY();
		
		Nazgul n = new Nazgul(this);
		n.age = 0;
		neighbors.put(pointRef.get(x+","+y), n);
		
		Simulator.birth.add(n);
		
		age = 0;
	}

	@Override
	void stay() {
		System.out.println("N stay");
		hunger = hunger++;
	}

	@Override
	void chooseAction(HashMap<xyPoint, Creature> neighbors, HashMap<String, xyPoint> pointRef) {
		System.out.println("N chooseAction");
		int[][] nbd;
		ArrayList<xyPoint> points  = new ArrayList<>();
		ArrayList<xyPoint> hobbits = new ArrayList<>();
		ArrayList<xyPoint> nazguls = new ArrayList<>();
		int sqrMap = (int) Math.sqrt(neighbors.size()) - 1;
		int nbdSqr = (sight*2)+1;
		int x;
		int y;
		
		double min = 0;
		double minCheck = 0;
		
		holder = null;

			
		nbd = new int[nbdSqr][nbdSqr];
		
		for(x = (xy.getX() - sight); x < (xy.getX() - sight) + nbd.length; x++) {
			for(y = (xy.getY() - sight); y < (xy.getY() - sight) + nbd[0].length; y++) {
				if((x >= 0 && x <= sqrMap) && (y >= 0 && y <=sqrMap)) {
					xyPoint p = pointRef.get(x+","+y);
					
					points.add(p);
					
					if(neighbors.get(p) instanceof Hobbit) {
						hobbits.add(p);
					}
					if(neighbors.get(p) instanceof Nazgul) {
						nazguls.add(p);
					}
				}
			}
		}
		
		points.remove(xy);
		nazguls.remove(xy);
		
		if(hobbits.size() > 0) {
			min = xy.getDistance(hobbits.get(0));
			minCheck = min;
			holder = hobbits.get(0);
			for(xyPoint p : hobbits) {
				minCheck = xy.getDistance(p);
				if(minCheck < min) {
					holder = p;
					min = minCheck;
				}
			}
			if(min <= 1) {
				attack(neighbors.get(holder));
				hobbits.clear();
			}
			else {
				moveTo(neighbors, pointRef);
				hobbits.clear();
			}
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
		if(nazguls.size() > 0) {
			Random r1 = new Random();
			int ind = r1.nextInt(nazguls.size());
	
			holder = nazguls.get(ind);
			
			moveTo(neighbors, pointRef);
			nazguls.clear();
		}
		else {
			moveRand(neighbors, pointRef);
		}
		
	}

	@Override
	Color color() {
		if(health > (health/2)) return Color.black;
		else return Color.gray.brighter(); 
	}
	
	

}
