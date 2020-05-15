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
	
	double getDistance(xyPoint p) {
		double dist = Math.sqrt((Math.pow((x - p.x), 2) + (Math.pow((y-p.y), 2))));
		
		return dist;
	}
	 
	 int tenScaleX() {
			int scaled = (this.x)*10;
			return scaled;
		}
	 
	 int tenScaleY() {
		 int scaled = (this.y)*10;
		 return scaled;
	 }
	 
	 @Override
	 public String toString() {
		 return  x + "," + y;
	 }
	 
	 @Override
	 public int hashCode() {
		 return this.toString().hashCode();
	 }

	 @Override
	 public boolean equals(Object obj) {
		 if(this == obj)  return true;
		 
		 // null check
		 if(obj == null)  return false;
		 
		 // origin check
		 if(getClass() != obj.getClass()) return false;
		 	
		 xyPoint other = (xyPoint) obj; // down cast
		 
		 if(this.x != other.x) return false;
		 
		 if(this.y != other.y) return false;
		 
		 return true;
			
	 }

}
