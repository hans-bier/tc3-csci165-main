import java.text.DecimalFormat;

public class CountyResults2016 {
	
	//creating the needed instance variables
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
	
	
	public CountyResults2016() {} // our no argument constructor
	
	public CountyResults2016( // our overloaded constructor
		double demVotes,
		double gopVotes,
		double totalVotes,
		double percentDem,
		double percentGOP,
		double difference,
		double percentDifference,
		String StateAbbreviation,
		String county,
		int fips)
		{
		this.demVotes = demVotes;
		this.gopVotes = gopVotes;
		this.totalVotes = totalVotes;
		this.percentDem = percentDem;
		this.percentGOP = percentGOP;
		this.difference = difference;
		this.percentDifference = percentDifference;
		this.StateAbbreviation = StateAbbreviation;
		this.county = county;
		this.fips = fips;
	} // end CountyResults2016 constructor
	
	
	public double getTotalVotes() { // start getTotalVotes method
		return totalVotes;
	} // end getTotalVotes method
	
	
	public double getDemVotes() { // start getDemVotes method
		return demVotes;
	}// end getDemvotes method
	
	
	public double getGOPVotes() { // start getGOPVotes
		return gopVotes;
	}// end getGOPVotes method
	
	
	public double getDifference() { // start getDifference method
		return difference;
	}// end getDifference method
	
	
	public double getPercentDifference() { // start getPercentDifference method
		return percentDifference;
	}// end getPercentDifference method
	
	
	public String getState() { // start getState method
		return StateAbbreviation;
	}// end getState method
	
	
	public String getCounty() { // start getCounty method
		return county;
	}// end getCounty method
	
	
	@Override
	public String toString() {  //start overriden toString method
		
		DecimalFormat df = new DecimalFormat("#.##%");
		String formDemPerc = df.format(percentDem);
		String formGOPPerc = df.format(percentGOP);
		
		String current = "Democratic votes: " + demVotes + " | Republican votes: " + gopVotes 
						  + " | Total votes: " + totalVotes + "\nPercentage of Democratic votes: "
						  + formDemPerc + " | Percentage of Republican votes: " + formGOPPerc
						  + "\nTotal difference of parties: " + difference + " | Victory margin: "
						  + percentDifference + "%\nState: " + StateAbbreviation + " | County: "
						  + county + " | FIPS code: " + fips;
		
		return current;
	}// end toString method

	
}// end class

