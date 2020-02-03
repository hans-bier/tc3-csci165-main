//Hans Tang Homework assign. Initials

// Importing util package for scanner class
import java.util.Scanner;


public class Initials{

    public static void main(String[] args){

    // Initating Scanner
    Scanner input = new Scanner(System.in);
    // Asking for input
    System.out.print("Please Enter your first and last name: ");
    // Defining the input as the variable name
    String name = input.nextLine();


    // Using charAt() method at the first index to retrieve the first name initial
    char first = name.charAt(0);
    // Finding the index of the space to find the last name inital
    int finder = name.indexOf(" ");
    // Using charAt() method at the index of the space + 1 to get the last name initial
    char last  = name.charAt(finder+1);

    // Printing the characters individually
    System.out.println(first);
    System.out.println(last);


    // Converting the chars to its unicode value
    int unifirst = first;
    int unilast  = last;

    // Printing the numeric values of the characters (Unicode value)
    System.out.println(unifirst);
    System.out.println(unilast);

    // Printing the sum of the numeric values
    System.out.println(unifirst+unilast);


    // Converting chars to strings
    String strfirst = String.valueOf(first);
    String strlast  = String.valueOf(last);

    // Concatenating the two new strings
    String nowkiss = strfirst + strlast;

    // Printing the characters concatenated as a String
    System.out.println(nowkiss);


  }
}
