/**
 * An atomic data class to hold the quarterly values for our project. Each
 * quarter represents 3 months therefore this object can be called as an
 * aggregation of MonthlyDatacell values. It has quarterly demand value and
 * values for calculating the deseasonalized regression analysis of the quarters
 * and lastly the forecast value of the said regression analysis.
 */
public class QuarterlyDatacell {

	private double demand;
	private double quarterAvg;
	private double periodFactor;
	private double deseasonalizedRegressionForecast;

	public QuarterlyDatacell(double demand) {
		this.demand = demand;
	}

	public double getDemand() {
		return demand;
	}

	public void setDemand(double demand) {
		this.demand = demand;
	}

	public double getQuarterAvg() {
		return quarterAvg;
	}

	public void setQuarterAvg(double quarterAvg) {
		this.quarterAvg = quarterAvg;
	}

	public double getPeriodFactor() {
		return periodFactor;
	}

	public void setPeriodFactor(double periodFactor) {
		this.periodFactor = periodFactor;
	}

	public double getDeseasonalDemand() {
		return (demand / 3.0) / periodFactor;
	}

	public double getDeseasonalizedRegressionForecast() {
		return deseasonalizedRegressionForecast;
	}

	public void setDeseasonalizedRegressionForecast(double deseasonalizedRegressionForecast) {
		this.deseasonalizedRegressionForecast = deseasonalizedRegressionForecast;
	}

}
