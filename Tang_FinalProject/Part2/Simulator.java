import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Random;

class Simulator extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JFrame window = new JFrame();
	Timer timer = new Timer(100, this);
	
	private int gridLen = 50;
	private int gridWid = 50;
	
	private  HashMap<String, xyPoint>   pointRef    = new HashMap<>();
	private  HashMap<xyPoint, Creature> creatureMap = new HashMap<>();
	private HashMap<xyPoint, Items>  itemMap        = new HashMap<>();
	
	public static ArrayList<Items>    item       = new ArrayList<>();
	public static ArrayList<Items>    itemSpawn  = new ArrayList<>();
	public static ArrayList<Creature> birth      = new ArrayList<>();
	public static ArrayList<Creature> life       = new ArrayList<>();
	public static ArrayList<Creature> death      = new ArrayList<>();
	
	
	public Simulator() {
		initUI();
		worldSeeder();
		timer.start();
		
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		simLogic();
		repaint();
		
	}
	
	 void initUI() {
		 window.add(this);
	     window.setTitle("Hooboots");
	     window.setSize(515,540);
	     window.setLocationRelativeTo(null);
	     window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     window.setVisible(true);
	   }
		 
	 @Override
	 public void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 doDrawing(g);
	 }
	 
	 void doDrawing(Graphics g) {
		for(Creature c : life) {
			g.setColor(c.color());
			g.fillRect(c.xy.tenScaleX(), c.xy.tenScaleY(), 10, 10);
		}
	 }
		 
	 public void worldSeeder() {
		 for(int x = 0; x < gridLen; x++) {
			 for(int y = 0; y < gridWid; y++) {
				 pointRef.put(new xyPoint(x,y).toString(), new xyPoint(x,y));
			 }
		 }
		
		 for(int x = 0; x < gridLen; x++) {
			 for(int y = 0; y < gridWid; y++) {
				 creatureMap.put(pointRef.get(x+","+y), null);
			 }
		 }
		 
		 for(int x = 0; x < gridLen; x++) {
			 for(int y = 0; y < gridWid; y++) {
				 itemMap.put(pointRef.get(x+","+y), null);
			 }
		 }
		 
		 Hobbit h  = new Hobbit(new xyPoint(1,7), 100, 2, 1, 0, 0);
		 Hobbit h2 = new Hobbit(new xyPoint(8,9), 100, 2, 1, 0, 0);
		 Hobbit h3 = new Hobbit(new xyPoint(10,13), 100, 2, 1, 0, 0);
		 
		 Nazgul n  = new Nazgul(new xyPoint(3,7), 75, 4, 1, 0, 2);
		 Nazgul n2 = new Nazgul(new xyPoint(10,14), 75, 4, 1, 0, 2);
		 Nazgul n3 = new Nazgul(new xyPoint(30,30), 75, 4, 1, 0, 2);
		 
		 creatureMap.put(h.xy, h);
		 creatureMap.put(h2.xy, h2);
		 creatureMap.put(h3.xy, h3);
		 
		 creatureMap.put(n.xy, n);
		 creatureMap.put(n2.xy, n2);
		 creatureMap.put(n3.xy, n3);
		 
		 life.add(h);
		 life.add(h2);
		 life.add(h3);
		 
		 life.add(n);
		 life.add(n2);
		 life.add(n3);
		 
		 for(int j = 0; j < gridLen; j++) {		
			Random r = new Random();
			
			int x = r.nextInt(gridLen);
			int y = r.nextInt(gridLen);
			int hungerPoints = r.nextInt(10);
			
			xyPoint p = new xyPoint(x,y);
			Bread   b = new Bread(p, hungerPoints);
					
			itemMap.put(pointRef.get(x+","+y), b);
			item.add(b);
		}
	}
	
		 
	 
	 
	 public void simLogic() {
		
		for(int x = 0; x < gridLen; x++) {
			for(int y = 0; y < gridWid; y++) {
			 	creatureMap.put(pointRef.get(x+","+y), null);
			}
		 }
		
		for(Creature c : life) {
		 	creatureMap.put(c.xy, c);
		}
		
		for(Creature c : life) {
			c.chooseAction(creatureMap, pointRef);
			c.age = c.age + 1;
			c.hunger = c.hunger + 1;
			
			for(Items i : item) {
				if(i.xy.equals(c.xy)) {
					i.modify(c, itemMap);
					i.spawn(itemMap, pointRef);
				}
			}
			if(c.hunger > 25) {
				c.health = c.health - 1;
			}
			if(c.health <= 0) {
				death.add(c);
			}
		}
		for(Creature c : death) {
			life.remove(c);
			creatureMap.remove(c.xy);
		}
		death.clear();
		
		for(Creature c : birth) {
			life.add(c);
		}
		birth.clear();
	 } 
	
	 
	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> {
			Simulator ex = new Simulator();
			ex.setVisible(true);
		});
		
	}
}

