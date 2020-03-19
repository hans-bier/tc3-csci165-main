public class Driver7 {
	public static void main(String[] args) {
		
		MyPoint[] points = new MyPoint[10]; // array for 10 points
		
		// for loop that fills the points array
		for(int x = 0; x < points.length; x++) {
			MyPoint point = new MyPoint(x+1, x+1);
			
			points[x] = point; 
		} // end for
		
		System.out.println("====Points====");
		
		// for loop for printing each point in points
		for(int x = 0; x < points.length; x++) {
			System.out.println(points[x].toString());
		} // end for
	
		// print statement for formatting
		System.out.print("\n");
		
		
		MyCircle[] circles = new MyCircle[10]; // array for 10 circles
		
		// for loop that fills the circles array
		for(int x = 0; x < circles.length; x++) {
			MyCircle circle = new MyCircle(points[x], x+1);
			
			circles[x] = circle;
		} // end for 
		
		
		// instantiating cylinders using the various constructors
		Cylinder c1 = new Cylinder(1);
		Cylinder c2 = new Cylinder(2, 2);
		Cylinder c3 = new Cylinder(points[3], 3, 3);
		
		// using MyCircle methods on the cylinder objects
		c1.setRadius(2);
		c2.setCenter(points[2]);
		c3.getArea();
		
		
		MyCircle[] newCircles = new MyCircle[10]; // new array for MyCircles type
		
		// for loop that fills newCircles array
		for(int x = 0; x < newCircles.length; x++) {
			if(x<5) {
				newCircles[x] = circles[x];
			} // end if
			
			if(x>=5) {
				Cylinder cylinder = new Cylinder(circles[x].getCenter(), x+1, x+1);
				newCircles[x] = cylinder;
			} // end if
		} // end for
		
		System.out.println("====Circles and Cylinders====");
		// for loop that prints newCircles array objects
		for(int x = 0; x < newCircles.length; x++) {
			System.out.println(newCircles[x].toString());
		} // end for
		
		// print statement for formatting
		System.out.print("\n");
		
		
		Object[] objects = new Object[12]; // array for 9 objects
		
		// for loop for filling objects array
		for(int x = 0; x < objects.length; x++) {
			if(x<3) {
				objects[x] = points[x];
			} // end if
			
			if(x>=3 && x<6) {
				objects[x] = circles[x];
			} // end if
			
			if(x>=6 && x<9) {
				objects[x] = newCircles[x];
			} // end if
			
			if(x>=9) {
				Date d = new Date(x+1, x+1, 2000 + x);
				objects[x] = d;
			} // end if
		} // end for
		
		System.out.println("====Points, Circless, Cylinders and Dates====");
		
		// for loop for printing objects array
		for(int x = 0; x < objects.length; x++) {
			System.out.println(objects[x].toString());
		} // end for
		
	
	} // end main
} // end class
