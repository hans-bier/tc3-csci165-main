
public class MyCircle {
	
	private MyPoint center = new MyPoint(0,0);
	private double radius = 1;
	
	MyCircle(){} // no argument constructor
	
	
	MyCircle(int x, int y, double radius){ // overloaded constructor
		center = new MyPoint(x,y);
		this.radius = radius;
	} // end overloaded constructor
	
	
	MyCircle(MyPoint center, double radius){ // overloaded MyCircle constructor
		this.center = new MyPoint(center);
		this.radius = radius;
	} // end overloaded Constructor
	
	
	MyCircle(double radius){ // overloaded constructor
		this.radius = radius;
	} // end overloaded constructor
	
	
	MyCircle(MyCircle copy) { // start copy constructor
		this.center = new MyPoint(copy.center);
		this.radius = copy.radius;
	} // end copy constructor
	
	public double getRadius() { // start getRadius method
		return radius;
	} // end getRadius method
	
	
	public void setRadius(double radius) { // start setRadius method
		this.radius = radius;
	} // end setRadius method
	
	
	public MyPoint getCenter() { // start getCenter method
		return new MyPoint(center);
	} // end getCenter method
	
	
	public void setCenter(MyPoint center) { // start setCenter method
		this.center = center;
	} // end setCenter method
	
	
	public int getCenterX() { // start getCenterX method
		return center.getX();
	} // end getCenterX method
	
	
	public void setCenterX(int x) { // start setCenterX method
		center.setX(x);
	} // end setCenterX method
	
	
	public int getCenterY() { // start getCenterY
		return center.getY();
	} // end getCenterY method
	
	
	public void setCenterY(int y) { // start setCenterY method
		center.setY(y);
	} // end setCenterY method
	
	
	public int[] getCenterXY() { // start getCenterXY method
		int[] points = {center.getX(), center.getY()};
		return points;
	} // end getCenterXY method
	
	
	public void setCenterXY(int x, int y) { // start setCenterXY method
		center.setXY(x, y);
	} // end setCenterXY
	
	
	public double getArea() { // start getArea method
		double area = Math.PI * Math.pow(radius, 2);
		
		return area;
	} // end getArea method
	
	
	public double getCircumference() { // start getCircumference method
		double circum = 2 * Math.PI * radius;
		
		return circum;
	} // end getCircumference method
	
	
	public double distance(MyCircle another) { // start distance method
		double dist = this.center.distance(another.getCenter());
		
		return dist;
	} // end distance method
	
	@Override
	public String toString() { // start toString method
		return "Circle[radius=" + radius + ", center=" + center.toString() + "]";
	}
	
	
	@Override
	public boolean equals(Object obj) { // start equals method
		// identity check
		if(this == obj) return true;
		
		// null check
		if(obj == null) return false;
		
		// origin check
		if(getClass() != obj.getClass()) return false;
		
		MyCircle other = (MyCircle) obj; // down cast
		
		if(!this.center.equals(other.center)) return false;
		
		if(this.radius != other.radius) return false;
		
		return true;
		
	} // end equals method

	
} // end class
