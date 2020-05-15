import java.awt.Color;
import java.util.HashMap;


public abstract class Creature {
	
	xyPoint xy;
	int startHealth;
	int health;
	int sight;
	int hunger;
	int age;
	int dmg;

	
	Creature(){}
	
	Creature(xyPoint xy, int h, int s, int hu, int a, int d) {
		this.xy = new xyPoint(xy);
		this.startHealth = h;
		this.health = h;
		this.sight  = s;
		this.hunger = hu;
		this.age 	= a;
		this.dmg  	= d;
	}
	
	Creature(Creature copy) {
		this.xy.setXY(copy.xy.getX(), copy.xy.getY());
		this.startHealth = copy.startHealth;
		this.health = copy.health;
		this.sight  = copy.sight;
		this.hunger = copy.hunger;
		this.age  	= copy.age;
		this.dmg    = copy.dmg;
	}
	
	
	abstract void moveTo(HashMap<xyPoint, Creature> neighbors, HashMap<String, xyPoint> pointRef);
	
	abstract void moveFrom(HashMap<xyPoint, Creature> neighbors, HashMap<String, xyPoint> pointRef);
	
	abstract void moveRand(HashMap<xyPoint, Creature> neighbors, HashMap<String, xyPoint> pointRef);
	
	abstract void attack(Creature c);
	
	abstract void replicate(HashMap<xyPoint, Creature> neighbors, HashMap<String, xyPoint> pointRef);
	
	abstract void stay();
	
	abstract void chooseAction(HashMap<xyPoint, Creature> neighbors, HashMap<String, xyPoint> pointRef);
	
	abstract Color color();
	

}
