// Hans Tang Homework Assign. GMT

// Importing util package for scanner class
import java.util.Scanner;


public class GMT{

    public static void main(String[] args){

      // Initating scanner for input
      Scanner input = new Scanner(System.in);
      //Asking for the input
      System.out.print("Please enter the Time Zone Offset to GMT: ");
      // Defining the input as the offset
      int offset = input.nextInt();
      // Converting the offset to minutes first to try to keep the numbers down in size
      offset = offset * 60;
      // Converting the offset in minutes to the offset in milliseconds
      long offmili = offset * 60000;

      // Using division and modulus to section out each unit of time
      long totmil = System.currentTimeMillis() + offmili; // <-- Adding the offset to the total amount of milliseconds

      long totsec = totmil / 1000;

      long cursec = totsec % 60;

      long totmin = totsec / 60;

      long curmin = totmin % 60;

      long tothou = totmin / 60;

      long curhou = tothou % 24;


      // Printing the current time using printf
      System.out.printf("\nThe current time is: %d:%d:%d", curhou, curmin, cursec);

    }
  }
