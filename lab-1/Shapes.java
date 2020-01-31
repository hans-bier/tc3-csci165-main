// Hans Tang Shape printing assignment

public class Shapes {

    public static void main(String[] args) {

        // Upside down half triangle shape
        for(int x = 1; x <= 5; x++) {
            for(int y = 5; y > x; y = y-1) {
                System.out.print("*");
            }
            System.out.println("*");
        }// End of upside down half triangle shape


        // Space for clearer output
        System.out.println();


        // 'O' Shape
        for(int i = 0; i <= 4; i++) {
            for(int j = 0; j <= 4; j++) {
                if(i == 0 || j == 0 || i == 4 || j == 4) {
                    System.out.print("*");
                  }
                  else{
                      System.out.print(" ");
                  }
                }
                System.out.println();
            }// end of O shape


          // Space for clearer ouput
          System.out.println();


          // Hourglass shape, couldn't figure out the loop for this one :(
          System.out.println("*****");
          System.out.println(" *** ");
          System.out.println(" ** ");
          System.out.println(" *** ");
          System.out.println("*****");

  }// end of main
}// end of class
