
public class RegularPrice extends Price {

	public int getPriceCode() {
		return Movie.REGULAR;
	}
	
	public double getCharge(int daysRented) {
		return daysRented > 2 ? 2.0 + (daysRented - 2) * 1.5 : 2.0;
	}
	
	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}

}
