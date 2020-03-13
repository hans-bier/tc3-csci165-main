
public class Customer {
	private String firstName;
	private String lastName;
	private String email;
	private Address address;
	
	Customer(){} // no argument constructor
	
	
	Customer(String firstName, String lastName, // start overloaded Customer constructor
			String email, Address address)
			{
		this.firstName = firstName;
		this.lastName  = lastName;
		this.address   = new Address(address);
		this.setEmail(email);
	} // end Customer constructor
		
	
	Customer(String firstName, String lastName){ // overloaded Customer constructor
		this.firstName = firstName;
		this.lastName  = lastName;
	} // end Customer constructor
	
	
	public Customer(Customer copy){ // copy constructor
		this.firstName = copy.firstName;
		this.lastName  = copy.lastName;
		this.email     = copy.email;
		this.address   = new Address(copy.address);
	} // end copy constructor
	
	
	public void setName(String firstName, String lastName) { //start setName method
		this.firstName = firstName;
		this.lastName  = lastName;
	} // end setName method
	
	
	public void setEmail(String email) { // start setEmail method	
		
		int x = email.indexOf("@");     // finding index of the "@" in the email 
		int y = email.lastIndexOf("."); // finding the last index of "." in the email
		
		int count = 0; // counter variable
		
		String z; // instantiating a string variable for a substring found below
		
		for(int j = 0; j < email.length(); j++) { // making sure there is one '@' character and
			if(email.charAt(j) == '@') {  		  // only one '@' character in the string
				count++;
			} // end if
		} // end for
		
		if(count == 1) { // Entered if there is one and only one '@' character in the email
			
			if(x < y) { // entered if the '@' character is before the '.' character
				
				z = email.substring(y,email.length());   // getting that substring I was talking about
				
				if(z.length() == 3 || z.length() == 4) { //Makes sure the top level domain is only 2 or 3 characters 
					this.email = email;					 // after the '.' character
				}// end inner if
			} // end inner if
			
			// if domain restrictions not met the email will not be put on file
			else {  
				this.email = "none on file";
			} // end else
		} // end outer if
		
		// if domain restrictions not met the email will not be put on file
		else { 
			this.email = "none on file";
		} // end else
		
	} // end setEmail method
	
	
	public String getName() { // start getName method
		return this.firstName + " " + this.lastName;
	} // end getName method
	
	
	public String getEmail() { // start getEmail method
		return email;
	} // end getEmail method
	
	
	public boolean equals(Customer otherCust) { // start equals method
		return this.firstName.equals(otherCust.firstName) &&
			   this.lastName.equals(otherCust.lastName)   &&
			   this.email.equals(otherCust.email)         &&
			   this.address.equals(otherCust.address);
	} // end equals method
	
	
	public String toString() { // start toString method
		return "Name: " + firstName + " " + lastName + "\nEmail: " + email + "\nAddress: " + address.toString();
	} // end to String method
	

} // end class



