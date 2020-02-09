// Hans Tang Homework week 3
// KenSpeak™ problem 2


// importing the needed packages and classes
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class kenspeaktwo{

      public static void main(String[] args){

      try{

        char[] encoder = {'*', 'B', 'E', 'A', '@', 'F', 'K', '%', 'R', 'M'}; // Array of kens language

        File numbers = new File("numbers.txt"); // Connecting the file 'numbers.txt' to a File type variable numbers

        Scanner fileScanner = new Scanner(numbers); // Scanner for scanning through the File variable 'numbers'

        FileWriter fileWriter = new FileWriter("encodedNumbers.txt"); // A FileWriter for writing to our encoded numbers file


        // While loop for going through each line of the file 'numbers.txt', or our File variable 'numbers'
        while(fileScanner.hasNextLine()){

          String num = fileScanner.nextLine(); // Getting the number at each line of the 'numbers' variable and defining at String type

          String speachofken = " "; // Starting the build of the encoded number


          // For loop for looping through the inputted number, converting it into ken speak, and adding it the final encoded string
          for(int y = 0; y < num.length() ; y++){

              char a = num.charAt(y); // Getting the char of a num at index 'y'

              int b = Character.getNumericValue(a); // Converting char to its numeric value

              String place = Character.toString(encoder[b]); // Converting numberic value into ken speak

              speachofken = speachofken + place; // Adding the converted numeric value into what will be the final string
            } // end for loop

            fileWriter.write(speachofken+"\n"); // Writing our kenspeak converted number to our 'encodedNumbers.txt' file with our file writer

       } // end while loop

       // Closing scanner and filewriter
       fileScanner.close();
       fileWriter.close();

      }// end try

      catch(IOException e){

      }// end catch
    } // end main
} // end class
