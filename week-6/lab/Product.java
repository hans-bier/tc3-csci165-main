import java.text.DecimalFormat;

public class Product {
	
	private String name;
	private String description;
	private double price;
	private String sku;
	 
	
	Product(){} // no argument constructor
	
	
	Product(String name, String description, // start Product overloaded constructor
			double price, String sku){
		this.name = name;
		this.description = description;
		this.price = price;
		setSku(sku);
	} // end overloaded constructor
	
	
	Product(String sku){ // start overloaded constructor
		setSku(sku);
	} // end overloaded constructor
	
	
	public double getPrice() { // start getPrice method
		return price;
	} // end getPrice method

	
	public String getName() { // start getName method
		return name;
	} // end getName
	
	public String getSku() { // start getSku method
		return sku;
	}
	
	
	public void setSku(String sku) { // start setSku method
		
		String[] skuStarters = {"001", "002", "003", "004", "110"}; // an array of valid sku starters
		
		String skuStart = sku.substring(0, 3); // determining the sku-to-be=set's starter characters
		
		int check = 0; // instantiating a checker variable
		
		for(int i = 0; i < skuStarters.length; i++) {
			if(skuStart.equals(skuStarters[i])){ // entered if the sku-to-be-set's starter is valid
				check = 1; 
				break;
			} // end if
			
			else {
				check = -1;
			} // end else
		} // end for loop	
		
		if(sku.length() == 10 && check == 1) { // entered if the sku-to-be-set's meets domain restrictions
			this.sku = sku;
		} // end if
		
		else if(sku.length() != 10 || check == -1 ) { // entered if the sku-to-be-set is invalid
			this.name = "Invalid Product";
			this.description = "This is invalid!"; 
			this.price = 0.0;
			this.sku = "INVALID";
		} // end if else
	
	} // end setSku method
	
	
	public void setName(String name) { // start setName method
		this.name = name;
	} // end setName method
	
	
	public void setPrice(double price) { // start setPrice
		
		if(price >= 0) { // entered if the price is non negative
			this.price = price;
		} // end if
		
		else { // if the price is negative it is set to 0
			this.price = 0.0;
		} // end else
		
	} // end setPrice method
	
	
	public boolean equals(Product otherProduct) { // start equals method
		return  this.name.equals(otherProduct.name) 			  &&
			    this.description.equals(otherProduct.description) && 
			    this.price == otherProduct.price   				  &&
			    this.sku.equals(otherProduct.sku);
	} // end equals method
	

	public String toString() { // start toString method
		DecimalFormat df = new DecimalFormat("$#.00");
		
		return name + "\n -" + description + "\nItem price: " + df.format(price) + "\nSKU number: " + sku;
	} // end toString method
	
	
} // end class
