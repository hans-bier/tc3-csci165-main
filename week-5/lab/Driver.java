
public class Driver {

	public static void main(String[] args) {
		
		Temperature a = new Temperature(); // creating new class variable a
		Temperature b = new Temperature(); // creating new class variable b
	
		
		a.setAll(52.2f, Temperature.Scale.F); // using setAll method on variable a
		
		// using the seperate setTemp and setScale methods on variable b
		b.setTemp(11.2f);              
		b.setScale(Temperature.Scale.C);
		
		
		System.out.println(a.toString()); // printing the toString() method
		
		
		if(a.equals(b)) { // entered if temperature a is equal to temperatue b
			System.out.println("\n" + a.getTempF() + " F° is equal to " + b.getTempC() + "C°"); 
		} // end if
	
		
		a.setAll(32, Temperature.Scale.F); // using setAll method on variable a
		b.setAll(0, Temperature.Scale.C);  // using setAlll method on variable b
		
		if(a.compareTo(b) == 0) { // entered if compareTo method returns 0, which means the temps are equal
			System.out.println("\nTemperature a: " + a.getTempF() + "F°, is equal to Temperature b: " + b.getTempC() + "C°");
		} // end if
		
		
	}// end main
} // end class
