import java.util.ArrayList;

public class Simulator {

	public static void main(String[] args) {
				
		xyPoint p    = new xyPoint(0,0);
		
		Nazgul n     = new Nazgul(p, 25, 3);	
		Hobbit h     = new Hobbit(p, 15, 2);
		Giraffe g    = new Giraffe(p, 500, 4, 4);
		FrankOcean f = new FrankOcean(p, 55, 3, 3);
		
		ArrayList<Creature> creatures = new ArrayList<Creature>();
		creatures.add(n);
		creatures.add(h);
		creatures.add(g);
		creatures.add(f);
		
		for(Creature c : creatures) {
			c.move();
			c.attack(h);
			c.replicate();
			c.stay();
			System.out.println("\n");
		}
		
	}

}
