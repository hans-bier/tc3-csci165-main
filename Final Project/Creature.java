import java.awt.Color;
import java.util.Map;

public abstract class Creature {
	xyPoint xy;
	int health;
	int sight;
	
	
	Creature(){}
	
	Creature(xyPoint xy, int h, int s) {
		this.xy = new xyPoint(xy);
		this.health = h;
		this.sight  = s;
	}
	
	Creature(Creature copy) {
		this.xy.setXY(copy.xy.getX(), copy.xy.getY());
		this.health = copy.health;
		this.sight = copy.sight;
	}
	
	
	abstract void move();
	
	abstract void attack(Creature c);
	
	abstract Creature replicate();
	
	abstract void stay();
	
	abstract void chooseAction(Map<xyPoint, Creature> neighbors);
	
	abstract Color color();
	
}
