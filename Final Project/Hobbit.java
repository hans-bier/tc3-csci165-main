import java.awt.Color;
import java.util.ArrayList;
import java.util.Map;

public class Hobbit extends Creature {

	ArrayList<hobbitItems> inventory;

	
	Hobbit(){}
	
	Hobbit(xyPoint p, int h, int s) {
		super(p, h, s);
	}
	
	Hobbit(Hobbit copy) {
		super(copy.xy, copy.health, copy.sight);
		this.inventory = copy.inventory;
	}
	
	
	@Override
	void move() {
		System.out.println("Thee Hobbit has moved");
	}

	@Override
	void attack(Creature c) {		
		System.out.println("Hobbit smackdown!");
	}

	@Override
	Creature replicate() {
		System.out.println("When one hobbit loves another hobbit...");
		Hobbit h = new Hobbit(this);
		return h;
	}

	@Override
	void stay() {
		System.out.println("Hobbit stays");
	}

	@Override
	void chooseAction(Map<xyPoint, Creature> neighbors) {
	}

	@Override
	Color color() {
		return null;
	}
	
	
	
}
