import java.awt.Color;
import java.util.Map;

public class Giraffe extends Creature {
	
	int neckLength;
	
	Giraffe(){}
	
	Giraffe(xyPoint p, int h, int s, int nl) {
		super(p, h, (int) Math.floor((s + nl)/2));
		this.neckLength = nl;
	}
	
	Giraffe(Giraffe copy) {
		super(copy.xy, copy.health, copy.sight);
		this.neckLength = copy.neckLength;
	}

	
	@Override
	void move() {
		System.out.println("Giraffe has lumbered away");
	}

	@Override
	void attack(Creature c) {
		System.out.println("The giraffe used neck slap!");
	}

	@Override
	Creature replicate() {
		Giraffe g = new Giraffe(this);
		System.out.println("Giraffe has cloned himself using advanced giraffe tech");
		return g;
	}

	@Override
	void stay() {
		System.out.println("The giraffe sits still..");
	}

	@Override
	void chooseAction(Map<xyPoint, Creature> neighbors) {
	}

	@Override
	Color color() {
		return null;
	}
}
