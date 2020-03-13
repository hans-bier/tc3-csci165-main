import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CompoDriver {
	
	public static Customer[] customers = new Customer[1000];
	public static Product[] products   = new Product[1000];
	public static Account[] accounts   = new Account[1000];
	public static Invoice[] invoices   = new Invoice[1000];
	
	public static void fillCustomers() { //start fillCustomer method
		
		String fileName = "customers.txt"; // defining variable for the file name
		
		try{
    		File data  = new File(fileName); // referencing our file 
    		Scanner sc = new Scanner(data); // creating a scanner for file 
    		
    		String line;      // a variable for parsing line's of info from file
    		String firstName; // a variable for customers first name
    		String lastName;  // a variable for customers last name
    		String email; 	  // a variable for customers email
    		String street; 	  // a variable for the customers street
    		int zip; 		  // a variable for the customers zip
    		
    		int counter = 0; // a counter variable  
    		
    		// a while loop for parsing information from our customers.txt
    		// file and populating our 'customers' array
    		while(sc.hasNextLine()) {
    			
    			street = " ";
    			
    			line = sc.nextLine();
    			
    			String[] fields = line.split("\t|\\s", 4);
    			String[] fields2 = fields[3].split("\t");
    			
    			for(int i = 0; i < fields2.length-1; i++) {
    				street = street + fields2[i] + " ";
    			}
    			
    			firstName = fields[0];
    			lastName = fields[1];
    			email = fields[2];
    			zip = Integer.valueOf(fields2[fields2.length-1]);
    			
    			Address address = new Address(street, zip);
    			Customer customer = new Customer(firstName, lastName, email, address);
    			
    			customers[counter] = customer;
    			
    			counter++;
    			
    		}// end while 

    		sc.close(); // closing scanner
    
    	} // end try
    	catch(IOException ioe) {
    		System.out.println(ioe.getMessage());
    	}// end catch
	
	} // end fillCustomers method
	
	
	public static void fillProducts() { //start fillProducts method
		
		String fileName = "products.txt"; // defining a variable for the file name
		
			try{
	    		File data  = new File(fileName); // referencing our file 
	    		Scanner sc = new Scanner(data); // creating a scanner for file 
	    		
	    		String line; 		// a variable for parsing line's of info from file
	    		String name; 		// a variable for the products name
	    		String description; // a variable for the products description
	    		String sku; 		// a variable for the products sky
	    		
	    		double price; // a variable for the products price	    		
	    		
	    		int counter = 0; // a counter variable 
	    		
	    		// a while loop that will parse information from the
	    		// products.txt file and populate our 'products' array
	    		while(sc.hasNextLine()) {
	    			
	    			line = sc.nextLine();
	    
	    			String[] fields = line.split("\t");
	    			
	    			name = fields[0];
	    			description = fields[1];
	    			price = Double.valueOf(fields[2]);
	    			sku = fields[3];
	    			
	    			Product prod = new Product(name, description, price, sku);
	    			
	    			products[counter] = prod;
	    			
	    			counter ++;
	    		}// end while 
	
	    		sc.close(); // closing scanner
	    
	    	} // end try
	    	catch(IOException ioe) {
	    		System.out.println(ioe.getMessage());
	    	}// end catch
			
	} // end fillProducts method
	
	
	public static void fillAccounts() { // start fillAccounts method
		
		Random randy = new Random(); // creating a random randy
		
		int day;   // instantiating a variable for day
		int month; // instantiating a variable for month
		int year;  // instantiating a variable for year
		
		double balance; // instantiating a variable for balance
		double credLim; // instantiating a variable for credit limit
		
		//for loop that populates our 'customers' array
		for(int i = 0; i < 1000; i++) { 
			
			Customer cust = customers[i];
			
			day   = randy.nextInt(31) + 1;
			month = randy.nextInt(12) + 1;
			year  = 2005 + randy.nextInt(15) + 1;
			Date date = new Date(month, day, year);
			
			balance = randy.nextInt(69000) + 1;
			credLim = balance / 10;
			
			Account account = new Account(cust, date, balance, credLim);
			
			accounts[i] = account;
			
		} // end for loop
		
	} // end fillAccounts method
	
	
	public static void fillInvoices() { //start fillInvoices method
		
		Random randy = new Random(); // creating a random randy
		
		int day;   // instantiating a variable for day 
		int month; // instantiating a variable for month
		int year;  // instantiating a variable for year
		
		int inv_Num; // instantiating a variable for invoice number
		
		// for loop that populates our 'invoices' array
		for(int i = 0; i < 1000; i++) {
			
			ArrayList<Product> prods = new ArrayList<Product>();
			
			inv_Num = randy.nextInt(101010);
			
			Account account = accounts[randy.nextInt(1000)];
			
			day   = randy.nextInt(31) + 1;
			month = randy.nextInt(12) + 1;
			year  = 2005 + randy.nextInt(15) + 1; 
			Date date  = new Date(month, day, year);
			
			for(int k = 0; k < 20; k++) {
				prods.add(products[randy.nextInt(1000)]);
			} // end for
			
			Invoice invoice = new Invoice(inv_Num, account, date, prods);
			
			invoices[i] = invoice;
	
		} // end for
		
	} // end fillInvoices method
	
	
	public static void selectionSort(Invoice[] list) { // start selectionSort method
		
		int index = 0; // an index for the minimum value
	
		//nested for loops that will use selection sorting
		//to sort an array of type Invoice
		for(int i = 0; i < list.length; i++) {
			index = i;
			for(int j = i+1; j < list.length; j++) {
				if(list[j].compareTo(list[index]) == -1) {
					index = j;
				} // end if
			} // end inner for
			Invoice minInv = list[index];
			list[index]    = list[i];
			list[i]        = minInv;
		} // end outer for
		
	} // end selectionSort
	
  
	public static void main(String[] args) {
		
		 /*       Part 1 of lab
		  
		ArrayList<Product> list = new ArrayList<Product>();
		
		Date date = new Date(2, 7, 2001);
		Address add = new Address("105 FieldStone Ln", 14850);
		Customer cus = new Customer("Hans", "Tang", "hansmbierkamper@gmail.com", add);
		Account acc = new Account(cus, date, 1500, 3500);
		Product pro = new Product("Raw nut", "Rawest nuts in the weast", 69.69, "004XJOLZQR");
		list.add(pro);
		Invoice inv = new Invoice(666, acc, date, list);
		Invoice inv2 = inv;
		
		System.out.println(inv.toString());
		System.out.println(inv.equals(inv2));
		*/
		
		// part 2 of lab
		
		fillCustomers(); // creating 1000 customers
		fillProducts(); // creating 1000 products
		fillAccounts(); // creating 1000 accounts
		fillInvoices(); // creating 1000 invoices	
		selectionSort(invoices); // selection sorting our 'invoices' array
	
	
		Scanner sc = new Scanner(System.in); // making a scanner
		
		for(int j = 0; j < invoices.length; j ++) {       // for loop for printing 'invoices' array
			
			System.out.println("Press enter to print invoice"); // you'll have to press enter to print a new array
			
			try {
			sc.nextLine(); // you're gonna have to press enter to make it to the next print
			
			System.out.println(invoices[j].toString()); // printing an invoice
			
			} // end try
	    	catch(Exception e) {    		
	    	}// end catch
		} // end for
		
		sc.close(); // closing the scanner
	
	} // end main
} // end class
