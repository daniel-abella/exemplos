import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String _name;
	private List<Rental> _rentals = new ArrayList<Rental>();
	
	public Customer(String _name) {
		this._name = _name;
	}
	
	public void addRental(Rental arg) {
		_rentals.add(arg);
	}
	
	public String getName() {
		return _name;
	}
	
	public String statement() {
		String result = "Rental Record for " + getName() + "\n";
		for (Rental each : _rentals) {
			
			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
		}
		
		// add footer lines
		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRentalPoints()) +
		" frequent renter points";
		return result;
	}
	
	public int getTotalFrequentRentalPoints() {
		int result = 0;
		for (Rental each : _rentals) {			
			result += each.getFrequentRenterPoints();
		}
		return result;
	}
	
	public double getTotalCharge() {
		double result = 0d;
		for (Rental each : _rentals) {
			result += each.getCharge();
		}
		return result;
	}
	
	public String htmlStatement() {
		String result = "<h1>Rentals for <em>" + getName() + "</em></h1><p>\n";
		for (Rental each : _rentals) {
			result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<br>\n";
		}
		
		// add footer lines
		result += "<p>You owe <em>" + String.valueOf(getTotalCharge()) + "</em><p>\n";
		result += "On this rental you earned <em>" + String.valueOf(getTotalFrequentRentalPoints()) + "</em> frequent renter points<p>";
		return result;
	}
}
