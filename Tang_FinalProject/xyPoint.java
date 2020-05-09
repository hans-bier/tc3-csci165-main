
public class xyPoint {
	int x;
	int y;
		
		
	xyPoint(){}
		
	xyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
		
	xyPoint(xyPoint copy) { 
		this.x = copy.x;
		this.y = copy.y;
	} 
		
		
	int getX() {
		return x;
	} 
				
	void setX(int x) { 
		this.x = x;
	}		
		
	int getY() { 
		return y;
	} 
		
	void setY(int y) { 
		this.y = y;
	} 		
		
	int[] getXY() { 
		int[] points = {this.x, this.y};
		return points;
	} 
		
		
	void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
