import java.text.DecimalFormat;
import java.time.Year;

public class Account {
	private String accountID;
	private Customer customer;
	private Date dateCreated;
	private double balance       = 0.0;
	private double creditLimit   = 0.0;
	private double discountLevel;
	
	
	Account(){} // no argument constructor
	
	
	Account(Customer customer, Date date){ // start Account overloaded constructor
		this.customer    = customer;
		this.dateCreated = new Date(date);
		this.setAccountID();
	} // end overloaded constructor
	
	
	Account(Customer customer, Date date, // start Account overloaded constructor
			double balance, double creditLimit)
			{
		this.customer      = customer;
		this.dateCreated = new Date(date);
		this.setBalance(balance);
		setCreditLimit(creditLimit);
		this.setDiscount();
		this.setAccountID();
	} // end overloaded constructor
	
	
	public Account(Account copy){ // copy constructor
		this.accountID     = copy.accountID;
		this.customer      = new Customer(copy.customer);
		this.dateCreated   = new Date(copy.dateCreated);
		this.balance       = copy.balance;
		this.creditLimit   = copy.creditLimit;
		this.discountLevel = copy.discountLevel;
	} // end copy constructor
	
	
	public Customer getCustomer() { // start getCustomer method
		return new Customer(customer);
	} // end getCustomer method
	
	
	public double getBalance() { // start getBalance method
		return balance;
	} // end getBalance method
	
	
	public double getCreditLimit() { // start getCreditLimit method
		return creditLimit;
	} // end getCreditLimit method
	
	public double getDiscount() { // start getDiscount method
		return discountLevel;
	} // end getDiscount method
	
	
	public void setAccountID() { // start setAccountID
		DecimalFormat df = new DecimalFormat("00");
		
		String id = customer.getName(); // getting the customers name
		
		id = id.replaceAll("[AaEeIiOoUu]", "").toUpperCase().replaceAll(" ", ""); // Exterminating all vowels, converting
																			      // upper case and removing spaces.
		int day   = dateCreated.getDay();   // getting the day
		int month = dateCreated.getMonth(); // getting the month
		int year  = dateCreated.getYear();  // getting the year
		
		String date = df.format(month) + df.format(day) +  year; // formatting the date into the format mmddyyyy
		
		int check_digit = 0; // instantiating a check digit
		
		// calculating the check digit
		for(int i = 0; i < id.length(); i++) {
			check_digit = check_digit + (int) id.charAt(i);
		} // end for
		
		check_digit = check_digit % id.length();
		
		id = id + date + check_digit; // defining the final account id
		
		this.accountID = id;
	} // end setAccountID
	
	
	public void setBalance(double balance) { // start setBalance method
		
		if(balance >= 0) { // entered if the balance is non negative
			this.balance = balance;
		} // end if
		
		else { // if the balance is negative it is set to zero
			this.balance = 0.0;
		} // end else
		
	} // end setBalance method
	
	
	public void setCreditLimit(double credLim) { // start setCreditLimit method
		
		double bala200 =  2 * this.balance; // finding 200% of the balance
		
		if(credLim >= 0) { // entered if the credit limit is non negative
			
			if(credLim <= bala200) { // entered if the credit limit is less than 200% of the balance
				this.creditLimit = credLim;
			} // end inner if
			else {
				this.creditLimit = bala200;
			} // end else
		} // end outer if

		else {
			this.creditLimit = 0.0;
		} // end else
		
	} // end setCreditLimit method
	
	public void setDiscount() { // start setDiscount method
		
		
		double discount = 0.02;
		int year1 = this.dateCreated.getYear();
		int year2 = Year.now().getValue();
		
		discount = discount * (year2 - year1);
		//discount = discount * 100;
		
		this.discountLevel = discount;
	} // end setDiscount method
	
	
	public String toString() { // start toString method
		
		DecimalFormat df1 = new DecimalFormat("$#.00");
		DecimalFormat df2 = new DecimalFormat("#");
		
		return "Account Number: " + accountID + "\n" + customer.toString() + "\nAccount created on: " + dateCreated + 
			   "\nBalance: " + df1.format(balance) + "\nCredit Limit: " + df1.format(creditLimit) + 
			   "\nCustomer Discount: " + df2.format(discountLevel*100) + "%";
	} // end toString method
	
	
	public boolean equals(Account otherAccount) { // start equals method
		return this.accountID == otherAccount.accountID    		 &&
			   this.customer.equals(otherAccount.customer) 		 &&
			   this.dateCreated.equals(otherAccount.dateCreated) &&
			   this.balance == otherAccount.balance 			 &&
			   this.creditLimit == otherAccount.creditLimit      &&
			   this.discountLevel == otherAccount.discountLevel;
	} // end equals method
	
	
	public int compareTo(Account otherAccount) { // start compareTo method
		return this.accountID.compareTo(otherAccount.accountID);
	} // end compareTo method
	
	
}// end class
