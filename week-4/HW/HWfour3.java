import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HWfour3 {

	public static void main(String[] args) {
		
		int ROW    = 50; // defining the row length
		int COLUMN = 20; // defining the column length
		
		int[][] matrix = new int[ROW][COLUMN]; // creating a 2d array
		
		fillArray(matrix); // filling the 2d array
		
		System.out.print("Row 3 formatted into 5 columns is shown below:");	
		printRow(matrix, 3, 5); // calling the printRow method on 'matrix'
		
		int smallch = smallestChange(matrix); // calling the smallestChange method on 'matrix'
		System.out.println("\n\nThe row with smallest change in matrix is row: " + smallch);
 
	} // end main
	
	
	
	public static void fillArray(int[][] matrix) { // starting build of method fillArray
		
		try{
    		File nums     = new File("number_list.txt"); // referencing our file 
    		Scanner sc    = new Scanner(nums); // creating a scanner for file 

    		String line = " ";
    		// for loop for filling our array in column major order
    		for(int i = 0; i < matrix[0].length; i++) {						
    			for(int j = 0; j < matrix.length; j++) {
    				line = sc.nextLine();
    				matrix[j][i] = Integer.parseInt(line);
    				
    			} // end inner for loop
    			   			
    		} // end for outer loop
    		    		
    		sc.close(); // closing scanner
    	
    	} // end try
    	
    	catch(IOException ioe) {
    		System.out.println(ioe.getMessage());
    		}// end catch
    	
    	} // end fillArray method   	
	
	
	public static void printRow(int[][] matrix, int row, int num_cols) { // starting build of printRow method
		
		for(int i = 0; i < matrix[num_cols].length; i++) { // for loop for printing row in columns
				
				if(i % num_cols == 0) {	    // if statement to determine when
					System.out.print("\n"); // to break into a new line
				} // end if statement
			
			System.out.print(matrix[row][i] + " "); // printing the value of the matrix with space
													// for formatting
		} // end for loop
		
	} // end printRow method
		
		
	public static int smallestChange(int[][] matrix) { // starting build of smallestChange method
		
		int index = 0; // defining the variable index
		
		int max = findMax(matrix[0]); // defining the initial max variable
		int min = findMin(matrix[0]); // defining the initial min variable
		
		int change1 = 0; // defining the initial change1 variable
		int change2 = max - min; // defining the initial change2 variable
		
		for(int i = 0; i < matrix.length; i++) { // for loop for comparing change in rows	
			
			max = findMax(matrix[i]); // finding max of current row
			min = findMin(matrix[i]); // finding min of current row
			change1 = max - min;      // getting the change of the current row

			if(change1 < change2) { // comparing change of current row to change in previous row
				change2 = change1;  // changing to the smaller change
				index = i;			// redefining to the current index
			} // end if statement
			
		} // end for loop
		
	return index; // returning the row index of smallest change
	
	}// end smallestChange method

	
	public static int findMax(int[] array) { // starting build of findMax method
    	
		int max = array[0];  // defining the starting variable as the first number in our
							 // array to be compared and changed as needed in the loop below
		
		for(int x = 1; x < array.length; x++) {  // for loop for finding max num
			
			if(array[x] > max) {    				
				max = array[x];	
			} // end if statement
			
		} // end for loop
		
		return max; // returning largest number
		
	} // end findMax method
	

	public static int findMin(int[] array) { // starting build of findMin method
	
		int min = array[0]; // defining the starting variable as the first number in our
							// array to be compared and changed as needed in the loop below
		
		for(int x = 1; x < array.length; x++) { // for loop for finding min num
			
			if(array[x] < min) {    					
				min = array[x];
			}// end if statement
			
		} // end for loop
		
		return min; // returning the smallest number
		
	} // end findMin method
	
	
	
} // end class
