//Hans Tang Food Truck lab

import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;
import java.math.*;
import java.text.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.PrintStream;


public class FoodTruck{

      public static void main(String[] args){


        try{
          // Creating text files for the menu and prices
          File menufile  = new File("menu.txt");
          File pricefile = new File("prices.txt");

          double SALES_TAX = 0.0625; // Definiing Sales tax

          // Creating scanners
          Scanner menusc   = new Scanner(menufile); // For scanning the menu
          Scanner pricesc  = new Scanner(pricefile); // for scanning the prices
          Scanner namesc   = new Scanner(System.in); // for scanning the input for name
          Scanner amountsc = new Scanner(System.in); // for scanning the amount of the items

          DecimalFormat curform = new DecimalFormat("$#.00"); // Formatter for currency

          DateTimeFormatter dtf1  = DateTimeFormatter.ofPattern("M/d/yyyy"); // Format for date
          DateTimeFormatter dtf2  = DateTimeFormatter.ofPattern("HH:mm:ss"); // format for time
          DateTimeFormatter dtf3  = DateTimeFormatter.ofPattern("M"); // format for just the month         <--- These lines
          DateTimeFormatter dtf4  = DateTimeFormatter.ofPattern("d"); // format for just the day                will help build
          DateTimeFormatter dtf5  = DateTimeFormatter.ofPattern("HH"); // format for just the hour              the invoice number
          DateTimeFormatter dtf6  = DateTimeFormatter.ofPattern("mm"); // format for just the minutes      <--- later

          LocalDateTime localtime = LocalDateTime.now(); // The local time and date

          // Creating strings for time with the previous formats
          String date   = dtf1.format(localtime);
          String time   = dtf2.format(localtime);
          String month  = dtf3.format(localtime);
          String day    = dtf4.format(localtime);
          String hour   = dtf5.format(localtime);
          String minute = dtf6.format(localtime);


          String[] menu   = new String[3]; // Array for menu
          double[] prices = new double[3]; // Array for prices
          int[] amount    = new int[3];    // Array for amounts entered
          double[] totals = new double[3]; // Array for the totals of each item


          System.out.println("\nWelcome to the CS food truck!");

          System.out.print("\nPlease enter your name: "); // Asking user for their name
          String name = namesc.nextLine();                // Using our name scanner to define the input to variable name

          System.out.println("\nEnter the quantity of each item"); // Asking user for the amount of each item they'd like
          System.out.println("================================");


          // Building the array for menu items
          int counter1 = 0;
          while(menusc.hasNext()){
            menu[counter1] = menusc.nextLine();
            counter1 ++;
          } // end menu array build

          // Building the array for menu prices
          int counter2 = 0;
          while(pricesc.hasNext()){
            prices[counter2] = pricesc.nextDouble();
            counter2 ++;
          } // end prices array build


          // Printing the menu array and prices array, and putting the amount entered for each item into its own array
          int x;
          for( x = 0; x < menu.length; x++){
            System.out.print(menu[x] + " - "+ curform.format(prices[x]) + ": ");
            amount[x] = amountsc.nextInt();
          } // end for loop


        // Defining a few variables for a counter and holding price values
        int y;
        double j;
        double k;
        for(y = 0; y < prices.length; y++){
            j = prices[y];
            k = amount[y];
            totals[y] = j * k;  // Putting the total of each item into its own array
        }

        double subtot = 0;
        for(y = 0; y < totals.length; y++){
          subtot = subtot + totals[y]; // Getting the subtotal using our total of each item array
        }

        double tax       = subtot * SALES_TAX; // Using our sales tax global variable to define the tax for this transaction
        double taxedtot  = subtot + tax;    // Our final, taxed, total


        // Building invoice number
        int index  = name.indexOf(' ');         // Finding the space in the name
        char init1 = name.charAt(0);           // getting the first intial of the first name
        char init2 = name.charAt(1);          // getting the second initial of the first name
        char init3 = name.charAt(index + 1); // getting the first inital of the last name
        char init4 = name.charAt(index +2); // getting the second initial of the last name

        String inits = "" + init1 + init2 + init3 + init4; // Putting all the initials together into a string
        inits = inits.toUpperCase();                      // Converting the added initials into uppercase

        // Gathering unicode values for initials
        int unic1 = init1;
        int unic2 = init3;
        int unic3 = unic1 + unic2; // adding the unicode values

        int preid = unic3 * name.length(); // mulitiplying unic3 by the length of the name entered

        String invoice = inits + preid + month + day + hour + minute; // Finally concatenating all the values for the final invoice number


        // For loop for controlling output to console and to the invoice text file
        for(int z = 0; z != 2; z ++){
          // If the for loop has gone through once and printed to the console it will now print the same thing to a text file named the invoice number.txt
          if (z > 0) {
            PrintStream fileOut = new PrintStream(invoice + ".txt"); // Creating a new printstream for the invoice text file
            System.setOut(fileOut);                                 // Changing the output for system
        }
        System.out.println("\nInvoice Number:\t\t" + invoice);
        System.out.printf("\nDate:\t\t\t%s", date);
        System.out.printf("\nTime:\t\t\t%s", time);
        System.out.println("\n\nItem\t\t\tQuantitity\tPrice\tTotal");
        System.out.println("\n========================================================");
          for(y = 0; y < totals.length; y++){
            System.out.printf("\n%-30s", menu[y]);
            System.out.printf("%-10s", amount[y]);
            System.out.printf("%-10s", curform.format(prices[y]));
            System.out.printf("%-10s\n", curform.format(totals[y]));
        }
        System.out.println("\n========================================================");
        System.out.printf("\nSubtotal %48s\n\n", curform.format(subtot));
        System.out.printf("6.25%% sales tax %40s\n\n", curform.format(tax));
        System.out.printf("Total %51s", curform.format(taxedtot));
        }

        // Closing the scanners
        menusc.close();
        pricesc.close();
        namesc.close();
        amountsc.close();

        }// end try
    catch(IOException e){
    }// end catch
  }// end main
} // end class
