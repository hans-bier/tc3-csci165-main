import java.awt.Color;
import java.util.ArrayList;
import java.util.Map;

public class Nazgul extends Creature {

	ArrayList<nazgulItems> inventory;
	
	
	Nazgul() {}

	Nazgul(xyPoint p, int h, int s) {
		super(p, h, s);
	}
	
	Nazgul(Nazgul copy) {
		super(copy.xy, copy.health, copy.sight);
		this.inventory = copy.inventory;
	}
	
	
	@Override
	void move() {
		System.out.println("a small step for Nazguls");
	}

	@Override
	void attack(Creature c) {
		System.out.println("Nazgul smash!");
	}

	@Override
	Creature replicate() {
		System.out.println("Nazgul('s) smash(ed)!");
		Nazgul n = new Nazgul(this);
		return n;
	}

	@Override
	void stay() {
		System.out.println("The Nazgul takes a knee");
	}

	@Override
	void chooseAction(Map<xyPoint, Creature> neighbors) {
	}

	@Override
	Color color() {
		return null;
	}

}
