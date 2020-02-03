//Hans Tang Homework Assign. Java Primitives

// Importing util package for scanner class
import java.util.Scanner;


public class Primitives {

    public static void main(String[] args) {

        //Start problem 1
        System.out.print("========================PROBLEM 1========================\n\n");

        // each of primitive data types
        byte byt_ex    = 88;

        short sho_ex   = 30000;

        int int_ex     = 200;

        long lon_ex    = 60000;

        float flo_ex   = 1.11f;

        double dou_ex  = 1.2345;

        boolean boo_ex = int_ex > byt_ex;

        char cha_ex1   = '$';

        char cha_ex2   = '3';

        // Type casting examples

        // Widening type cast
        int    x = 1;
        int    y = 2;
        double z = (double)x / y;

        // Narrowing type cast
        int  a = 12345678;
        byte b = (byte)a;

        // Printing each var value using printf
        System.out.printf("This is a byte: %d. This is a short: %d. This is an integer: %d. This is a long: %d.", byt_ex, sho_ex, int_ex, lon_ex);
        System.out.printf("\nThis is a float: %f. This is a double: %f. This is a boolean: %s.", flo_ex, dou_ex, boo_ex);
        System.out.printf("\nThis is a type of char: %s. This is another type of char: %s",  cha_ex1, cha_ex2);


        // Widening type cast print statements
        System.out.printf("\n\nThis is an integer x: %d. This is another integer y: %d.", x, y);
        System.out.printf("\nAnd this is two integers, x and y, turned into a double using a widening type case, and divided for the double z: %.1f", z);

        // Narrowing type cast print statements
        System.out.printf("\n\nThis is an integer a: %d.", a);
        System.out.printf("\nAnd this is an integer b, turned into a byte using a narrowing type cast: %d.", b);
        // End problem 1



        // Start problem 2
        System.out.print("\n\n========================PROBLEM 2========================\n\n");

        // Initiating scanner for input
        Scanner input1 = new Scanner(System.in);

        // Asking for input
        System.out.print("Enter an integer: ");
        int num1 = input1.nextInt();

        // Printing the square, cube, and fourth root of the given input using Math.pow() method
        System.out.print("\nSquare of " + num1 + ": " + (int)Math.pow(num1, 2) + "\nCube of " + num1
        + ": " + (int)Math.pow(num1, 3) + "\nFourth power of " + num1 + ": " + (int)Math.pow(num1, 4));
        // End problem 2



        // Start problem 3
        System.out.print("\n\n========================PROBLEM 3========================\n\n");

        // Defining MIN and MAX integers using MIN_VALUE and MAX_VALUE defined constants
        int MIN = Integer.MIN_VALUE;
        int MAX = Integer.MAX_VALUE;

        // Printing the variables MIN and MAX
        System.out.print("Minimum value for an int data type in Java: " + MIN +
        "\nMaximum value for an int data type in Java: " + MAX);
        // End problem 3



        // Start problem 4
        //oop
        // End problem 4



        // Start problem 5
        System.out.print("\n\n========================PROBLEM 5========================\n\n");

        //Initiating scanner for input for the diviend
        Scanner input2 = new Scanner(System.in);
        // Asking for input
        System.out.print("Enter an integer diviend: ");
        // Defining input2 as the variable num2
        int num2 = input2.nextInt();


        // Initiating scanner for input for the divisor
        Scanner input3 = new Scanner(System.in);
        // Asking for input
        System.out.print("\nEnter an integer divisor: ");
        // Defining variable num3 using the input
        int num3 = input3.nextInt();


        // Dividing our diviend and divisor using floor methods from Math class
        int flnum1 = (int)Math.floorDiv(num2, num3);
        int monum1 = (int)Math.floorMod(num2, num3);

        // Printing results from floor methods using printf
        System.out.print("Results from using floor methods.");
        System.out.printf("\nThe quotient of " + num2 + " divided by " + num3 + " is " + "%d.\nThe remainder is %d.", flnum1, monum1);


        // Dividing our diviend and divisor using the operators (/ and %)
        int flnum2 = num2 / num3;
        int monum2 = num2 % num3;

        // Printing results from the operators using printf
        System.out.print("\n\nResults from using operators.");
        System.out.printf("\nThe quotient of " + num2 + " divided by " + num3 + " is " + "%d.\nThe remainder is %d.", flnum2, monum2);
        // End problem 5

    }
}
