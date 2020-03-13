import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Address {
		
	private String street;
	private String city;
	private String state;
	private int zip;
	
	private static ArrayList<Integer> zips  = new ArrayList<Integer>();
	private static ArrayList<String> cities = new ArrayList<String>();
	private static ArrayList<String> states = new ArrayList<String>();
	
	static {
		fillArrays(); // filling our ArrayLists
	}
	
	
	Address(){} // no argument constructor
	
	Address(String street, int zip) {  // start address overloaded constructor	
		this.street = street;
		this.setZip(zip);
	} // end Address constructor
	
	
	Address(Address copy) { // start copy constructor
		this.street = copy.street;
		this.city   = copy.city;
		this.state  = copy.state;
		this.zip    = copy.zip;
	} // end copy constructor
	
	
	public String getStreet() { // start getStreet method
		return street;
	}// end getStreet method
	
	
	public String getCity() { // start getCity method
		return city;
	}// end getCity method
	
	
	public String getState() { // start getState method
		return state;
	} // end getState method
	
	
	public int getZip() { // start getZip method
		return zip;
	}// end getZip method
	
	
	public void setStreet(String street){ // start setStreet method
		this.street = street;
	}// end setStreet method
	
	
	public void setZip(int zip) { // start setZip method
		
		int check = 0;
		
    	for(int x = 0; x < zips.size(); x++) {
    		if(zip == zips.get(x)) {
    			this.zip   = zip;
    			this.city  = cities.get(x).replaceAll("\"", "");
    			this.state = states.get(x);
    			check = -1;
    			break;
    		}// end if
    	}// end for
    	
    	if(check != -1) {
    		this.zip   = 0;
    		this.city  = "DNE";
    		this.state = "DNE";
    	}
	} // end setZip method
	
	
	public boolean equals(Address address) { // start equals method
		return this.street.equals(address.street) &&
			   this.city.equals(address.city)     &&
			   this.state.equals(address.state)   &&
			   this.zip == address.zip;			
	}// end equals method
	
	
	public String toString() { // start toString method
		return street + " " + city + " " + state + ", " + zip;
	}// end toString method
	
	
	public static void fillArrays() { // start fillArrays
		
		String fileName = "zip_code_database.csv";
		
		try{
    		File data  = new File(fileName); // referencing our file 
    		Scanner sc = new Scanner(data); // creating a scanner for file 
    		
    		String line = sc.nextLine(); // reading header, so it is ignored
    		
    		// defining variables for getting the index of needed fields
    		int indexZIP   = 0;
    		int indexCITY  = 3;
    		int indexSTATE;    // States index needs to be
    						   // found in the loop below
    		
    		
    		while(sc.hasNextLine()) {
    			
    			line = sc.nextLine();
    			String[] fields = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
    			indexSTATE = fields.length - 9; // Ta da !
    		
    			// adding the needed values to our three ArrayLists
    			zips.add(Integer.valueOf(fields[indexZIP]));
    			cities.add(fields[indexCITY]);
    			states.add(fields[indexSTATE]);
    			
    		}// end while

    		sc.close(); // closing scanner
    
    	} // end try
    	catch(IOException ioe) {
    		System.out.println(ioe.getMessage());
    		}// end catch	
	} // end fillArrays method

}// end class
