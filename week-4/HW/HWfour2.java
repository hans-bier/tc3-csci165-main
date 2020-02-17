//Hans Tang homework week four problem set 2

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HWfour2 {

	public static void main(String[] args) {
	
		int ROW    = 50; // defining the row length
		int COLUMN = 20; // defining the column length
		
		int[][] matrix = new int[ROW][COLUMN]; // creating a 2d array
		
		
		fillArray(matrix); // filling the 2d array 'matrix'
		
		int maxAll = findMax(matrix); // calling findMax on our 2d array 'matrix'
		System.out.println("The maximum number in matrix is: " + maxAll);
		
		int minAll = findMin(matrix); // calling findMin on our 2d array 'matrix'
		System.out.println("\nThe minimum number in matrix is: " + minAll);
		
		int maxRow = findMaxOfRow(matrix, 0); // calling findMaxOfRow of our 2d array 'matrix' in row 0
		System.out.println("\nThe maximum number in row 0 is: " + maxRow);
		
		int minRow = findMinOfRow(matrix, 0); // calling findMinOfRow of our 2d array 'matrix' in row 0
		System.out.println("\nThe minimum number in row 0 is: " + minRow);
		
		int maxCol = findMaxOfColumn(matrix, 0); // calling findMaxOfColumn on our 2d array 'matrix' in column 0
		System.out.println("\nThe maximum number in column 0 is: " + maxCol);
		
		int minCol = findMinOfColumn(matrix, 0); // calling findMinOfColumn on our 2d array 'matrix' in column 0
		System.out.println("\nThe minimum number in column 0 is: " + minCol);
	
		
	} // end main
	
	
	
	public static void fillArray(int[][] matrix) { // starting build of method fillArray
		
		try{
    		File nums     = new File("number_list.txt"); // referencing our file 
    		Scanner sc    = new Scanner(nums); // creating a scanner for file 

    		
    		String line = " ";
    		// for loop for filling our array in row major order
    		for(int i = 0; i < matrix.length; i++) {						
    			for(int j = 0; j < matrix[0].length; j++) {
    				line = sc.nextLine();
    				matrix[i][j] = Integer.parseInt(line);
    				
    			} // end inner for loop
    			   			
    		} // end for outer loop
    		    		
    		sc.close(); // closing scanner
    	
    	} // end try
    	
    	catch(IOException ioe) {
    		System.out.println(ioe.getMessage());
    		}// end catch
    	
    	} // end fillArray method   	
	
	
	public static int findMax(int[][] matrix) { // starting build of method findMax
		
		
		int max = matrix[0][0]; // defining the first number of our matrix to be 
								// compared and changed as needed in the loops below
		
		//outer and inner for loops for finding largest value
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				
				if(matrix[i][j] > max) {
					max = matrix[i][j];
				} // end if statement
				
			} // end inner for loop
		} // end outer for loop
		
		return max; // returning the maximum number
		
	} // end findMax method
	
	
	public static int findMin(int[][] matrix) { // starting build of method findMin
		
		int min = matrix[0][0]; // defining the first number of our matrix to be
								// compared and changed as needed in the loops below
		
		// outer and inner for loops for finding smallest value
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				
				if(matrix[i][j] < min) {
					min = matrix[i][j];
				} // end if statement
				
			} // end inner for loop		
		} // end outer for loop
		
		return min; // returning minimum number
		
	} // end findMin method
	
	
	public static int findMaxOfRow(int[][] matrix, int row) { // starting build of method findMaxOfRow
		
		int max = matrix[row][0]; // defining the first number the selected row of our matrix to be 
								  // compared and changed as needed in the loops below
		
		for(int i = 0; i < matrix[0].length; i++) { // for loop for finding max value of row
			
			if(matrix[row][i] > max) {
				max = matrix[row][i];
			} // end if statement
			
		} // end for loop
		
		return max; // returning largest value of row
		
	} // end findMaxOfRow method
	
	
	public static int findMinOfRow(int[][] matrix, int row) { // starting build of method findMinOfRow
		
		int min = matrix[row][0]; // defining the first number of the selected row of our matrix to be 
								  // compared and changed as needed in the loops below
		
		for(int i = 0; i < matrix[0].length; i++) { // for loop for finding minimum value of row
			
			if(matrix[row][i] < min) {
				min = matrix[row][i];
			} // end if statement
			
		} // end for loop
		
		return min; // returning smallest value of row
		
	} // end findMinOfRow method
		
	
	public static int findMaxOfColumn(int[][] matrix, int column) {
		
		int max = matrix[0][column]; // defining the first number of the selected column of our matrix to
									 // be compared and changed as needed in the loops below
		
		for(int i = 0; i < matrix.length; i++) {
			
			if(matrix[i][column] > max) {
				max = matrix[i][column];
			} // end if statement
			
		} // end for loop
		
		return max; // returning largest value of the column
		
	} // end findMaxOfColumn method
	
	
	public static int findMinOfColumn(int[][] matrix, int column) {
		
		int min = matrix[0][column]; // defining the first number of the selected column of our matrix to
									 // to be compared and changed as needed in the loops below
		
		for(int i = 0; i < matrix.length; i++) {
			
			if(matrix[i][column] < min) {
				min = matrix[i][column];
			} // end if statement
			
		} // end for loop
		
		return min; // returning the smallest value of the column
		
	} // end findMinOfColumn method
	
} // end class
