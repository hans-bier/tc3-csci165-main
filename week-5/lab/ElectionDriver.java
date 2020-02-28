import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;


public class ElectionDriver {
	
	public static String fileName = "2016_US_County_Level_Presidential_Results.csv"; // putting our file name into a variable
	public static ArrayList<CountyResults2016> results = new ArrayList<CountyResults2016>(); // instantiating our ArrayList
	
	public static void fillList() { // starting build of fillList method
		
		
		try{
    		File data     = new File(fileName); // referencing our file 
    		Scanner sc    = new Scanner(data); // creating a scanner for file 
    		
    		String line = sc.nextLine(); // reading header, so it is ignored
    		
    		// defining needed variables
    		double demVotes;
    		double gopVotes;
    		double totalVotes;
    		double percentDem;
    		double percentGOP;
    		double difference;
    		double percentDifference;
    		String StateAbbreviation;
    		String county;
    		int fips;
    		String fix1;
    		String fix2;
    		
    		//While loop for parsing and formatting values
    		while(sc.hasNextLine()) {
    			line = sc.nextLine();
    			String[] fields = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
    			
    			demVotes = Double.parseDouble(fields[1]);
    			gopVotes = Double.parseDouble(fields[2]);
    			totalVotes = Double.parseDouble(fields[3]);
    			percentDem = Double.parseDouble(fields[4]);
    			percentGOP = Double.parseDouble(fields[5]);
    			fix1 = fields[6].replaceAll(",", "");
    			fix1 = fix1.replaceAll("\"", "");
    			difference = Double.parseDouble(fix1);
    			fix2 = fields[7].replaceAll("%", "");
    		    percentDifference = Double.parseDouble(fix2);
    			StateAbbreviation = fields[8];
    			county = fields[9];
    			fips = Integer.parseInt(fields[10]);
    			
    			CountyResults2016 cr = new CountyResults2016(demVotes, gopVotes, totalVotes, percentDem, percentGOP, difference, 
    														percentDifference, StateAbbreviation, county, fips);
    			
    			results.add(cr); // adding the new CountyResults2016 to our results ArrayList
    		}// end while loop   		
    
    		sc.close(); // closing scanner
    
    	} // end try
    	catch(IOException ioe) {
    		System.out.println(ioe.getMessage());
    		}// end catch
		
	} // end fillList method
	
	
	public static CountyResults2016 findLargestMargin() { // starting build of findLargestMargin method
		
		// defining our variables for comparisons
		double larMar1 = results.get(0).getPercentDifference();
		double larMar2 = larMar1;
		
		
		CountyResults2016 largestMarginCounty = results.get(0);
		
		// for loop that compares the margins to find the largest victory margin
		for(int x = 1; x < results.size(); x++) {
			larMar1 = results.get(x).getPercentDifference();
			if(larMar1 > larMar2) {
				larMar2 = larMar1;
				largestMarginCounty = results.get(x);
			}// end if
		}// end for
		
		return largestMarginCounty; // returning the county's record that has the largest victory margin
		
	}// end findLargestMargin method
	
	
	public static CountyResults2016 findLargestMargin(String state) { // starting build of overloaded findLargestMargin method
		
		// defining our variables for comparisons
		double larMar1 = results.get(0).getPercentDifference();
		double larMar2 = larMar1;
		
		CountyResults2016 largestMarginCounty = results.get(0); 
		String new_state = results.get(0).getState();
		
		//for loop that compares the margins within the state passed to this method to find the largest victory margin
		for(int x = 1; x < results.size(); x++) {
			
			new_state = results.get(x).getState();
			
			if(state.equals(new_state)) {
				larMar1 = results.get(x).getPercentDifference();
				if(larMar1 > larMar2) {
					larMar2 = larMar1;
					largestMarginCounty = results.get(x);
				}// end if	
			}// end if
			
		} // end for
		
		return largestMarginCounty; // returning the county's record that has the largest victory margin within a state
		
	}// end findLargestMargin
	
	
	public static String[] getStateTotals() { // starting build of getStateTotals method
		
		String[] stateTotals = new String[51]; // creating our string array
		
		// instancing the needed variables for the for loop
		int stateNum    = 0;
		String stateStr = "";
		String state1   = results.get(0).getState();
		String state2   = state1;
		double totDem   = 0;
		double totGOP   = 0;
		double demPerc  = 0;
		double GOPPerc  = 0;
		double MarVic   = 0;
		String winner   = "";
		int counter     = 0;
		
		for(int x = 0; x < results.size()+50; x++) {
			
			state1 = results.get(counter).getState();
			
			if(state1.equals(state2)) {
				totDem = totDem + results.get(counter).getDemVotes();
				totGOP = totGOP + results.get(counter).getGOPVotes();
				
				demPerc = demPerc + (results.get(counter).getDemVotes()/results.get(counter).getTotalVotes());	
				GOPPerc = GOPPerc + (results.get(counter).getGOPVotes()/results.get(counter).getTotalVotes());
				
				counter++;
			}// end if
			
			if(state1.equals(state2) == false) {
				
				if(demPerc > GOPPerc) {
					MarVic = demPerc - GOPPerc;
				}// end if
				
				else {
					MarVic = GOPPerc - demPerc;
				}// end else
				
				if(totDem > totGOP) {
					winner = "Democratic party";
				}// end if
				
				else {
					winner ="Republican party";
				}// end else
				
				DecimalFormat df = new DecimalFormat("0.00");
				String strMarVic = df.format(MarVic) + "%";
				
				stateStr = "State: " + state2 + " | Total Democratic Votes: " + totDem + " | Total Republican Votes: " 
							+ totGOP + "\nMargin of Victory " + strMarVic + " | Winning Party: " + winner; 
	
				stateTotals[stateNum] = stateStr;
				
				stateNum ++;

				state2 = results.get(counter).getState();
				
				stateStr = "";
				totDem   = 0;
				totGOP   = 0;
				demPerc  = 0;
				GOPPerc  = 0;
				MarVic   = 0;
				winner   = "";
				
			}// end if
			
			if(x == results.size()+50-1) {
				
				if(demPerc > GOPPerc) {
					MarVic = demPerc - GOPPerc;
				}// end if
				
				else {
					MarVic = GOPPerc - demPerc;
				}// end else
				
				if(totDem > totGOP) {
					winner = "Democratic party";
				}// end if
				
				else {
					winner ="Republican party";
				}// end else
				
				DecimalFormat df = new DecimalFormat("0.00");
				String strMarVic = df.format(MarVic) + "%";
				
				stateStr = "State: " + state2 + " | Total Democratic Votes: " + totDem + " | Total Republican Votes: " 
						   + totGOP + "\nMargin of Victory " + strMarVic + " | Winning Party: " + winner; 
	
				stateTotals[stateNum] = stateStr;
			}// end if
			
		}// end for
	
		return stateTotals; // returning an array of strings that contain information about each state
		
	}// end getStateTotals

	
	public static void main(String[] args) {
		
		fillList(); // filling our results ArrayList
		
		String[] states = getStateTotals(); // getting all the states totals
		
		
		// printing the county record that has the largest victory margin within the entire country
		System.out.println("This county has the largest victory margin within the entire county!\n");
		System.out.println(findLargestMargin().toString()+"\n\n"); 
														
		// printing the county record that has the largest victory margin within New York
		System.out.println("This county has the largest victory margin within the state of New York!\n");
		System.out.println(findLargestMargin("NY").toString()+"\n\n");
		
		// printing total's of the state of New York
		System.out.println("This is a comprehensive look at the state of New York's records!\n");
		System.out.println(states[34]);
		
				
	}// end main
}// end class
