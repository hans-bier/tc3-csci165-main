public class Cylinder extends MyCircle {
	private double height;
	
	
	Cylinder() { // start constructor
		super();
		height = 1.0;
	} // end constructor 
	
	
	Cylinder(double height) { // start overloaded constructor
		super();
		this.height = height;
	} // end overloaded constructor
	
	
	Cylinder(double radius, double height) { // start overloaded constructor
		super(radius);
		this.height = height;
	} // end overloaded constructor
	
	
	Cylinder(MyPoint center, double radius, double height) { // start overloaded constructor
		super(center, radius);
		this.height = height;
	} // end overloaded constructor
	
	
	public double getHeight() { // start getHeight method
		return height;
	} // end getHeight constructor
	
	
	public double getVolume() { // start getVolume method
		return getArea() * height;
	} // end getVolume method
	
	
	@Override
	public String toString() { // start toString method
		return "Cylinder[" + super.toString() + ", height=" + height + "]";
	} // end toString method
	
	
	@Override
	public boolean equals(Object obj) { // start equals method
		// identity check
		if(this == obj) return true;
				
		// null check
		if(obj == null) return false;
				
		// origin check
		if(getClass() != obj.getClass()) return false;
				
		Cylinder other = (Cylinder) obj; // down cast
		
		if(!super.equals(other)) return false;

		if(this.height != other.height) return false; 
			
		return true;
	} // end equals method
	
} // end class
