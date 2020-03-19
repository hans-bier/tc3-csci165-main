public class MyPoint {
	
	private int x = 0;
	private int y = 0;
	
	
	MyPoint(){} // no argument constructor
	
	
	MyPoint(int x, int y){ // start constructor
		this.x = x;
		this.y = y;
	} // end MyPoint constructor
	
	
	MyPoint(MyPoint copy) { // start copy constructor
		this.x = copy.x;
		this.y = copy.y;
	} // end copy constructor
	
	
	public int getX() { // start getX method
		return x;
	} // end getX method
	
	
	public void setX(int x) { // start setX method
		this.x = x;
	} // end setX method
	
	
	public int getY() { // start getY method
		return y;
	} // end getY method
	
	
	public void setY(int y) { // start setY method
		this.y = y;
	} // end setY
	
	
	public int[] getXY() { // start getXY method
		int[] points = {this.x, this.y};
		return points;
	} // end getXY method
	
	
	public void setXY(int x, int y) { // start setXY method
		this.x = x;
		this.y = y;
	} // end setXY method
	
	
	public double distance(int x, int y) { // start distance method
		
		double dist = Math.sqrt( Math.pow((x - this.x), 2) + Math.pow((y - this.y), 2));
		
		return dist;
	} // end distance method
	
	
	public double distance(MyPoint another) { //start overloaded distance method
		double dist = Math.sqrt( Math.pow((another.x - this.x), 2) + Math.pow((another.y - this.y),2 ));
		
		return dist;		
	} // end distance method
	
	
	public double distance() { // start overloaded distance method
		double dist = Math.sqrt( Math.pow((0 - this.x), 2) + Math.pow((0 - this.y), 2));
		
		return dist;
	} // end distance method
	
	
	@Override
	public String toString() { // start toString method
		return "(" + x + ", " + y + ")";
	} // end toString method
	
	
	@Override
	public boolean equals(Object obj) { // start equals method
		//identity check
		if(this == obj)  return true;
		
		// null check
		if(obj == null)  return false;
		
		// origin check
		if(getClass() != obj.getClass()) return false;
	
		MyPoint other = (MyPoint) obj; // down cast
		
		if(this.x != other.x) return false;
		
		if(this.y != other.y) return false;
		
		return true;
	} // end equals method
	
	
} // end class
