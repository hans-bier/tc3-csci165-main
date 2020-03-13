import java.text.DecimalFormat;
import java.util.ArrayList;

public class Invoice {
	
	private int invoiceNumber;
	private Account account;
	private double amount = 0.0;
	private Date orderDate;
	private ArrayList<Product> products = new ArrayList<Product>();
	
	
	Invoice(){} // no argument constructor
	
	
	Invoice(int inv_num, Account acct, // start Invoice overloaded constructor
			Date date, ArrayList<Product> products){
		this.invoiceNumber = inv_num;
		this.account   = new Account(acct);
		this.orderDate = new Date(date);
		this.products = products;
		this.setAmountDue();
	} // end overloaded constructor 
	
	
	public Account getAccount() { // start getAccount method
		return this.account;
	} // end getAccount method
	
	
	public double getAmount() { // start getAmount method
		return this.amount;
	} // end getAmount method
	
	
	public Date getDate() { // start getDate method
		return this.orderDate;
	} // end getDate method
	
	
	public void setDate(Date date) { // start setDate method
		this.orderDate = date;
	} // end setDate method
	
	
	public void setAmountDue() { // start setAmountDue method
		
		double amount = 0; // instantiating an amount due variable
		
		for(int i = 0; i < products.size(); i++) {       // for loop for summing to the total amount due
			amount = amount + products.get(i).getPrice();
		} // end for loop
		
		double discounted = amount - (amount * account.getDiscount());
		
		this.amount = discounted;
	} // end setAmountDue method
	
	
	public String toString() { // start toString method
		DecimalFormat df = new DecimalFormat("$#.00");
		
		String productStr = ""; // instantiating a string for the products
		
		for(int i = 0; i < products.size(); i++) { 				    // for loop that concatenates all of the				
			productStr = productStr + products.get(i) + "\n====\n"; // products into a nice "little" string
		}
		
		return "Invoice Number: " + invoiceNumber + "\n===Account info===\n" + account.toString() +
			   "\nTotal Due: " + df.format(amount) + "\nOrder date: " + orderDate.toString() +
			   "\n\n===Products ordered===\n" + productStr;
	} // end toString method
	
	
	public int compareTo(Invoice otherInvoice) { // start compareTo method
		if(this.amount < otherInvoice.amount) return -1;
        if(this.amount > otherInvoice.amount) return  1;
        
        									  return 0;
	} // end compareTo method
	
	
} // end class
