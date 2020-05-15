import java.util.HashMap;

public abstract class Items {
	
	xyPoint xy;

	
	Items(){}
	
	Items(xyPoint xy){
		this.xy = xy;
	}
	
	abstract void modify(Creature c, HashMap<xyPoint, Items>  itemMap);
	abstract void spawn(HashMap<xyPoint, Items>  itemMap, HashMap<String, xyPoint> pointRef);
	

}
