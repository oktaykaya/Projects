/**
 * An atomic data class to hold the monthly values for our project. It has
 * monthly demand value, and the various monthly forecast's values.
 */
public class MonthlyDatacell {

	private double demand;
	private double exponentialSmoothingForecast;
	private double doubleExponentialSmoothingForecast;
	private double regressionForecast;

	public MonthlyDatacell(double demand) {
		this.demand = demand;
	}

	public double getDemand() {
		return demand;
	}

	public void setDemand(double demand) {
		this.demand = demand;
	}

	public double getExponentialSmoothingForecast() {
		return exponentialSmoothingForecast;
	}

	public void setExponentialSmoothingForecast(double exponentialSmoothingForecast) {
		this.exponentialSmoothingForecast = exponentialSmoothingForecast;
	}

	public double getDoubleExponentialSmoothingForecast() {
		return doubleExponentialSmoothingForecast;
	}

	public void setDoubleExponentialSmoothingForecast(double doubleExponentialSmoothingForecast) {
		this.doubleExponentialSmoothingForecast = doubleExponentialSmoothingForecast;
	}

	public double getRegressionForecast() {
		return regressionForecast;
	}

	public void setRegressionForecast(double regressionForecast) {
		this.regressionForecast = regressionForecast;
	}

}
