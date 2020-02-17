// Hans Tang homework week 4 problem set 1

import java.util.Scanner;
import java.io.File;
import java.io.IOException;


public class HWfour1{

      public static void main(String[] args) {

    	  int[] array = new int[1000]; // defining our integer array with 1000 indices

    	  fillArray(array); // calling fillArray method on our array

    	  int max = findMax(array); // calling findMax method on our array
    	  System.out.println("The maximum number in array is: " + max);

    	  int min = findMin(array); // calling finxMin method on our array
    	  System.out.println("\nThe minimum number in array is: " + min);

    	  int[] percent = percentChange(array); // calling percentChange on our array and
    	  										// defining it as the integer array percent


      }// end main



    public static void fillArray(int[] array) { // Starting the build of fillArray method

    	try{
    		File nums     = new File("number_list.txt"); // referencing our file
    		Scanner sc    = new Scanner(nums); // creating a scanner for file


    		// for loop for filling our array
    		for(int i = 0; i < array.length; i++) {

    			array[i] = Integer.parseInt(sc.nextLine());

    		} // end for loop

    		sc.close(); // closing scanner

    	} // end try

    	catch(IOException ioe) {
    		System.out.println(ioe.getMessage());
    		}// end catch

    	} // end fillArray method


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


    public static int[] percentChange(int[] array) { // starting build of percentChange method

    	int[] percArray = new int[500]; // new array to hold the percent changes

    	double percent_change = 0; // defining a variable to hold the value of a percent change


    	for(int z = 0; z < percArray.length; z++) { // for loop for adding percent values to percArray and
    												// and calculating the percent changes

    		percent_change = (array[z]-array[z+1])*100 / array[z+1]; // calculating the percent change

    		percArray[z] = (int)percent_change; // defining the index of the percent change

    	} // end for loop

    	return percArray; // returning the filled percArray

    } // end percentChange method


} // end class
