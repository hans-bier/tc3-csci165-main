// Hans Tang Homework week 3
// KenSpeak™ problem 1

// importing java utility package scanner class
import java.util.Scanner;


public class kenspeakone{

      public static void main(String[] args){


      char[] encoder = {'*', 'B', 'E', 'A', '@', 'F', 'K', '%', 'R', 'M'}; // Array of kens language

      Scanner input = new Scanner(System.in); // Scanner for user input


      System.out.print("Please enter sequence of base 10 digits: "); // Asking user for their the number
      String num = input.nextLine(); // Defining the user input as a variable, num


      String speachofken = " "; // Starting the build of the encoded number


      // For loop for looping through the inputted number, converting it into ken speak, and adding it the final encoded string
      for(int y = 0; y < num.length() ; y++){

          char a = num.charAt(y); // Getting the char of a num at index 'y'

          int b  = Character.getNumericValue(a); // Converting char to its numeric value

          String place = Character.toString(encoder[b]); // Converting numberic value into ken speak

          speachofken  = speachofken + place; // Adding the converted numeric value into what will be the final string

      } // end for loop

      System.out.print(speachofken); // Pringthing the encoded number

    } // end main
} // end class
