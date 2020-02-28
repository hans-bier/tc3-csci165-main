import java.lang.Math;


public class Temperature {

	public static enum Scale{C, F}; // an enum of the temperature scale, Celsius or  Fahrenheit
	public static float TEMP = 0;  // a temperature value
	
	
	private Scale scale = Scale.C;
	private float temp = TEMP;
	
	
	public float getTempC() { // starting build of getTempC method
		if(scale == Scale.F) {
			
			float degreesC = (5*(temp -32))/9; // getting temperature in Celsius
			
			degreesC = Math.round(degreesC * 10)/10f;
			
			return degreesC; // returning degrees in Celsius	
		} // end if statement
		
		else {
			return temp;
		} // end else
		
	} // end getTempC method
	
	
	public float getTempF() { // starting build of getTempF method
		if(scale == Scale.C) {
			
			float degreesF = (9*(temp)/5)+32; // getting temperature in Fahrenheit
			
			degreesF = Math.round(degreesF * 10)/10f;
			
			return degreesF; // returning degrees in Fahrenheit
		}// end if
		
		else {
			return temp;
		}// end else
		
	} // end getTempF method
	
	
	public void setTemp(float temp) { // starting build of setTemp method
		this.temp = temp; // setting the temp
	} // end setTemp method

	
	public void setScale(Scale scale) { // starting build of setScale method
		this.scale = scale; // setting the scale
	} // end setScale method
	
	
	public void setAll(float temp, Scale scale) { // starting build of setAll method
		setTemp(temp);   // setting the temp
		setScale(scale); // setting the scale 
	} // end setAll method
	
	
	public boolean equals(Temperature t) { // starting build of equals method
		
		if(scale == Scale.F) { // enters if the scale is in fahrenheit
			
			if(this.temp == t.getTempF()){ // comparing the current temperature, 'temp' to t in fahrenheit
				return true; // returning true
			} // end inner if 
			
		} // end outer if
		
		
		if(scale == Scale.C) { // enters if the scale is in celsius
			
			if(this.temp == t.getTempC()) { // comparing the current temperature, 'temp' to t in celsius
				return true; // returning true
			} // end inner if
			
		} // end outer if
		
		return false; // if neither if statement is entered, then false is returned
		
	} // end equal method
	
	
	public int compareTo(Temperature t) { // starting build of compareTo method
		
		if(scale == Scale.F) { // enters if the scale is in fahrenheit
			
			float fahr = t.getTempF(); // defining 'fahr' as t's temperature in fahrenheit
			
			if(this.temp > fahr) { // enters if current temperature 'temp' is greater than t's temperature
				return 1; // returns 1
			} // end if
			
			else if(this.temp < fahr) { // enters if current temperature 'temp' is less than t's temperature
				return -1; // returns -1
			} // end else if
			
			else if(this.temp == fahr) { // enters if the current temperature 'temp' is equal to t's temperature
				return 0; // returns 0
			}// end else if
			
		} //end if
		
		
		if(scale == Scale.C) { // enters if the scale is in celsius
			
			float cels = t.getTempC(); // defining 'cels' as t's temperature in celsius
			
			if(this.temp > cels) { // enters if current temperature 'temp' is greater than t's temperature
				return 1; // returns 1
			} // end if
			
			else if(this.temp < cels) { // enters if current temperature 'temp' is less than t's temperature
				return -1; // returns -1
			} // end else if
			
			else if(this.temp == cels) { // enters if the current temperature 'temp' is equal to t's temperature
				return 0; // returns 0
			}// end else if
		} // end if
		
		return 0;
		
	} // end compareTo method
	
	
	@Override
	public String toString() { //starting build of toString method
		
		String current = "The current temperature is: " + temp + (scale == Scale.F ? " F°" : " C°"); // Building the string
		
		return current; // returning the string
	} // end toString method
	
	
} // end class

