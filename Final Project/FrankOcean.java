import java.awt.Color;
import java.util.Map;

public class FrankOcean extends Creature {
	
	int albums;
	
	FrankOcean(){}
	
	FrankOcean(xyPoint p , int h, int s, int a) {
		super(p, h, s);
		this.albums = a;
	}
	
	FrankOcean(FrankOcean copy) {
		super(copy.xy, copy.health, copy.sight);
		this.albums = copy.albums;
	}
	
	
	@Override
	void move() {
		System.out.println("Frank Ocean takes a step in his Nikes");
	}

	@Override
	void attack(Creature c) {
		System.out.println("Frank Ocean drops a fire track, burning the ears of all within his neighborhood!");
	}

	@Override
	Creature replicate() {
		System.out.println("Frank Ocean clones himself");
		FrankOcean f = new FrankOcean(this);
		return f;
	}

	@Override
	void stay() {
		System.out.println("Frank Ocean sits still, In My Room");
	}

	@Override
	void chooseAction(Map<xyPoint, Creature> neighbors) {
	}

	@Override
	Color color() {
		return null;
	}

}
