//Hans Tang, Mehdi Nya Louhaichy

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;


public class Tickets{

    public static void main(String[] args){

        /*
            The following code steps you through the String processing
            and math neccessary to determine if a single ticket number is valid.
            Your job with this code is to:

            ~   Closely study the code. Reverse engineer it. Use the API for guidance
                to understand the classes and methods that are being used.
            ~   Add comments for each statement, describing in detail what the line is doing
                I want to know DETAILS, not generalizations. RESEARCH!
            ~   When you have completed that, add code to complete the following

                1) Using a Scanner, open the file: tickets.txt
                2) Using a while(hasNext) loop, read each ticket number
                3) Run the ticket number through the provided math and String processing
                4) If the ticket number is valid write it to a new file called: valid_tix.txt
                5) Ignore the invalid ticket numbers

            ~   Additional code must also be commented. But I am more interested in why you are doing
                something, not the details of how.

            Check your work: There are 101 valid ticket numbers among the 1000 provided ticket numbers
                             These people make mistakes!!!

            Submit only Java source code files. Also submit valid_tix.txt

        */

        /*
        String  ticket  = "123454";
       // The variable 'ticket' is being defined as data type string, and being assigned the value "123454"
        String  last = ticket.substring(ticket.length() - 1);
         // The variable 'last' is being defined as data type string, and is using the methods .subtring(), and .length() to remove the last digit.
        int     last_digit = Integer.valueOf(last);
         //The variable 'last_digit' is being defined as data type int, and is using Integer.valueOf(last) to redefine the last data type, which is a String, and turning into an int data type
        String  reduced_ticket = ticket.substring(0, ticket.length() - 1);
        // The variable 'reduced_ticket' is being defined as data type String, and is using the variable 'ticket' and method .substring() to define it as the reduced ticket number
        int     ticket_number = Integer.valueOf(reduced_ticket);
        // The variable 'ticket_number' is using the method .valueOf() on 'reduced_ticket' to change it's data type to int
        int     remainder = ticket_number % 7;
        // The variable 'remainder' is being defined as data type int, and is using math symbol '%' to find the remainder of ticket_number divided by 7
        boolean validity = remainder == last_digit;
        // The variable 'validity' is being defined as data type boolean, True when the variable 'remainder' is equal to the variable 'last_digit', false otherwise
        String  format = "Original Ticket #: %s\nLast Digit: %d\nReduced Ticket #: %d\nRemainder: %d\nValidity: %b\n";
        // The variable 'format' is being defined as data type String, and is structured for use with the method printf
        System.out.printf(format, ticket, last_digit, ticket_number, remainder, validity);
        // printing the String 'format' using printf to format the different variables
        */

        //Counter
        int counter = 0;

        // Using try to connect the 'tickets.txt' file
        try{

          // Creating file instance to connect file
          File text = new File("tickets.txt");

          // Creating scanner instance to connect the File object.
          Scanner fileScanner = new Scanner(text);

          // Creating file writer
          FileWriter fileWriter = new FileWriter("valid_tix.txt");

          while(fileScanner.hasNextLine()){
            //Applying logic from given code example to our variables
            String line           = fileScanner.nextLine();
            String last           = line.substring(line.length() - 1);
            int last_digit        = Integer.valueOf(last);
            String reduced_ticket = line.substring(0, line.length() -1);
            int ticket_number     = Integer.valueOf(reduced_ticket);
            int remainder         = ticket_number % 7;
            boolean validity      = remainder == last_digit;

            //If the boolean statement 'validity' is true, the ticket number will be added to the file 'valid_tix.txt'
            if(validity == true) {
              fileWriter.write(line+"\n");

            } // end of if statement

          } // end while loop

          // Closing scanner and writer
          fileScanner.close();
          fileWriter.close();

        } // end try

   catch(IOException e) {

    } // end catch
  }// end main
}// end class
