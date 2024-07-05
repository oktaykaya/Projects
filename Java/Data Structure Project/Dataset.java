import java.util.Comparator;

/**
 * Dataset is the class to hold together various inputs and calculations. This
 * class represents the 2 year period of data which is assuming each month is 30
 * days and each year is 360. This class also holds the calculation functions
 * for each analysis.
 */
public class Dataset {
	// necessary values for calculations
	private final double exponentialAlpha = 0.2;
	private final double doubleExponentialAlpha = 0.2;
	private final double doubleExponentialBeta = 0.2;
	private final double doubleExponentialS0 = 200;
	private final double doubleExponentialG0 = 50;

	// each of the comparators listed below are rules that describe how to compare
	// atomic data cells by given attribute values

	// compare monthly data cells by demand value
	public static Comparator<MonthlyDatacell> mdcDemandComparator = new Comparator<MonthlyDatacell>() {
		@Override
		public int compare(MonthlyDatacell arg0, MonthlyDatacell arg1) {
			return Double.valueOf(arg0.getDemand()).compareTo(Double.valueOf(arg1.getDemand()));
		}
	};

	// compare monthly data cells by exponential smoothing forecast value
	public static Comparator<MonthlyDatacell> mdcExpComparator = new Comparator<MonthlyDatacell>() {
		@Override
		public int compare(MonthlyDatacell arg0, MonthlyDatacell arg1) {
			return Double.valueOf(arg0.getExponentialSmoothingForecast())
					.compareTo(Double.valueOf(arg1.getExponentialSmoothingForecast()));
		}
	};

	// compare monthly data cells by double exponential smoothing forecast value
	public static Comparator<MonthlyDatacell> mdcDoubComparator = new Comparator<MonthlyDatacell>() {
		@Override
		public int compare(MonthlyDatacell arg0, MonthlyDatacell arg1) {
			return Double.valueOf(arg0.getDoubleExponentialSmoothingForecast())
					.compareTo(Double.valueOf(arg1.getDoubleExponentialSmoothingForecast()));
		}
	};

	// compare monthly data cells by regression analysis forecast value
	public static Comparator<MonthlyDatacell> mdcRegrComparator = new Comparator<MonthlyDatacell>() {
		@Override
		public int compare(MonthlyDatacell arg0, MonthlyDatacell arg1) {
			return Double.valueOf(arg0.getRegressionForecast()).compareTo(Double.valueOf(arg1.getRegressionForecast()));
		}
	};

	// compare quarterly data cells by demand value
	public static Comparator<QuarterlyDatacell> qdcDemandComparator = new Comparator<QuarterlyDatacell>() {
		@Override
		public int compare(QuarterlyDatacell arg0, QuarterlyDatacell arg1) {
			return Double.valueOf(arg0.getDemand()).compareTo(Double.valueOf(arg1.getDemand()));
		}
	};

	// compare quarterly data cells by deseasonalized regression analysis forecast
	// value
	public static Comparator<QuarterlyDatacell> qdcDesComparator = new Comparator<QuarterlyDatacell>() {
		@Override
		public int compare(QuarterlyDatacell arg0, QuarterlyDatacell arg1) {
			return Double.valueOf(arg0.getDeseasonalizedRegressionForecast())
					.compareTo(Double.valueOf(arg1.getDeseasonalizedRegressionForecast()));
		}
	};

	// compare two doubles
	public static Comparator<Double> doubleComparator = new Comparator<Double>() {
		@Override
		public int compare(Double arg0, Double arg1) {
			return arg0.compareTo(arg1);
		}
	};

	// the day amount of each given input, it must be between 0 and 720 while also a
	// divisor to 720 so each input chunks have equal amount without overflow. The
	// default value in GUI is 30 (which is a month)
	private int period;
	// List of doubles where this data set is constructed from, if period is 30
	// input is equal to monthly data, and if period is 120 input is equal to
	// quarterly data.
	private ListImpl<Double> input;
	// Inputs shared over months
	private ListImpl<MonthlyDatacell> monthlyData;
	// Inputs shared over quarters
	private ListImpl<QuarterlyDatacell> quarterlyData;

	public Dataset() {
		monthlyData = new ListImpl<MonthlyDatacell>();
		quarterlyData = new ListImpl<QuarterlyDatacell>();
		input = new ListImpl<Double>();
		period = 30;
	}

	public Dataset(int period, ListImpl<Double> input) {
		monthlyData = new ListImpl<MonthlyDatacell>();
		quarterlyData = new ListImpl<QuarterlyDatacell>();
		this.period = period;
		setInput(input);
	}

	// setter of input value if period is 30 just fills the monthly data from the
	// input otherwise if 30 is divisible by the period it groups up periods to
	// construct monthly data, if non of the statements apply it splits each period
	// day by day to find the daily demand value and fills months based on the
	// demand value, therefore with period values like 20, the month gets the first
	// 20 days from the first period and the last 10 days from the next period.
	public void setInput(ListImpl<Double> input) {
		monthlyData = new ListImpl<MonthlyDatacell>();
		quarterlyData = new ListImpl<QuarterlyDatacell>();
		this.input = input;
		if (period == 30) {
			fillMonthlyData(this.input);
		} else if (30 % period == 0) {
			int times = 30 / period;
			for (int i = 0; i < input.size(); i += times) {
				double total = 0.0;
				for (int j = 0; j < times; j++) {
					total += input.get(i + j);
				}
				monthlyData.insert(new MonthlyDatacell(total));
			}
			fillQuarterlyData();
		} else {
			int index = 0;
			int dayCounter = 0;
			for (int i = 0; i < 24; i++) {
				double totalDemand = 0.0;
				for (int j = 0; j < 30; j++) {
					totalDemand += input.get(index) / ((double) period);
					if (dayCounter == period - 1) {
						index++;
						dayCounter = 0;
					} else {
						dayCounter++;
					}
				}
				monthlyData.insert(new MonthlyDatacell(totalDemand));
			}
			fillQuarterlyData();
		}
	}

	public void fillMonthlyData(ListImpl<Double> input) {
		for (int i = 0; i < input.size(); i++) {
			monthlyData.insert(new MonthlyDatacell(input.get(i)));
		}
		fillQuarterlyData();
	}

	// calculates quarterly data based on the given monthly data, each quarter is 3
	// months therefore the function loops over monthly data 3 by 3 and finds out
	// the total demand and calculates that quarter's average demand.
	public void fillQuarterlyData() {
		for (int i = 0; i < monthlyData.size(); i += 3) {
			double total = monthlyData.get(i).getDemand() + monthlyData.get(i + 1).getDemand()
					+ monthlyData.get(i + 2).getDemand();
			quarterlyData.insert(new QuarterlyDatacell(total));
		}
		double total = 0.0;
		for (int i = 0; i < quarterlyData.size() / 2; i++) {
			double qTotal = quarterlyData.get(i).getDemand()
					+ quarterlyData.get(i + quarterlyData.size() / 2).getDemand();
			quarterlyData.get(i).setQuarterAvg(qTotal / 2.0);
			quarterlyData.get(i + quarterlyData.size() / 2).setQuarterAvg(qTotal / 2.0);
			total += qTotal;
		}
		total = total / quarterlyData.size();
		for (int i = 0; i < quarterlyData.size(); i++) {
			quarterlyData.get(i).setPeriodFactor(quarterlyData.get(i).getQuarterAvg() / total);
		}
		calculateAll();
	}

	// calculation of all the forecasting methods
	public void calculateAll() {
		calculateMonthlyForecasts();
		calculateQuarterlyForecasts();
	}

	// calculation of monthly forecasting methods
	public void calculateMonthlyForecasts() {
		exponentialSmoothing();
		doubleExponentialSmoothing();
		regressionalAnalysis();
	}

	// calculation of quarterly forecasting method (which there is only one of)
	public void calculateQuarterlyForecasts() {
		deseasonalizedRegressionAnalysis();
	}

	// exponential smoothing forecast formula applied to each month
	private void exponentialSmoothing() {
		for (int i = 0; i < monthlyData.size(); i++) {
			if (i < 2) {
				monthlyData.get(i).setExponentialSmoothingForecast(monthlyData.get(0).getDemand());
			} else {
				double forecast = (exponentialAlpha * monthlyData.get(i - 1).getDemand())
						+ ((1.0 - exponentialAlpha) * monthlyData.get(i - 1).getExponentialSmoothingForecast());
				monthlyData.get(i).setExponentialSmoothingForecast(forecast);
			}
		}
	}

	// double exponential smoothing forecast formula applied to each month
	private void doubleExponentialSmoothing() {
		double si = doubleExponentialS0;
		double gi = doubleExponentialG0;
		for (int i = 0; i < monthlyData.size(); i++) {
			monthlyData.get(i).setDoubleExponentialSmoothingForecast(si + gi);
			if (i != monthlyData.size() - 1) {
				double tmp = (doubleExponentialAlpha * monthlyData.get(i).getDemand())
						+ ((1.0 - doubleExponentialAlpha) * monthlyData.get(i).getDoubleExponentialSmoothingForecast());
				gi = (doubleExponentialBeta * (tmp - si)) + ((1.0 - doubleExponentialBeta) * gi);
				si = tmp;
			}
		}
	}

	// regression analysis forecast formula applied to each month
	private void regressionalAnalysis() {
		double sumX = 0.0;
		double sumY = 0.0;
		double sumXY = 0.0;
		double sumX2 = 0.0;
		for (int i = 0; i < monthlyData.size(); i++) {
			double x = 1.0 + i;
			double y = monthlyData.get(i).getDemand();
			sumX += x;
			sumY += y;
			sumXY += x * y;
			sumX2 += x * x;
		}
		double b = (monthlyData.size() * sumXY - (sumX * sumY)) / (monthlyData.size() * sumX2 - (sumX * sumX));
		double a = (sumY / monthlyData.size()) - (b * sumX / monthlyData.size());
		for (int i = 0; i < monthlyData.size(); i++) {
			double forecast = a + (b * (1.0 + i));
			monthlyData.get(i).setRegressionForecast(forecast);
		}
	}

	// deseasonalized regression analysis forecast formula applied to each quarter
	private void deseasonalizedRegressionAnalysis() {
		double sumX = 0.0;
		double sumY = 0.0;
		double sumXY = 0.0;
		double sumX2 = 0.0;
		for (int i = 0; i < quarterlyData.size(); i++) {
			double x = 1.0 + i;
			double y = quarterlyData.get(i).getDeseasonalDemand();
			sumX += x;
			sumY += y;
			sumXY += x * y;
			sumX2 += x * x;
		}
		double b = (quarterlyData.size() * sumXY - (sumX * sumY)) / (quarterlyData.size() * sumX2 - (sumX * sumX));
		double a = (sumY / quarterlyData.size()) - (b * sumX / quarterlyData.size());

		for (int i = 0; i < quarterlyData.size(); i++) {
			double forecast = (a + (b * (1.0 + i))) * quarterlyData.get(i).getPeriodFactor();
			quarterlyData.get(i).setDeseasonalizedRegressionForecast(forecast);
		}
	}

	public ListImpl<MonthlyDatacell> getMonthlyData() {
		return monthlyData;
	}

	public void setMonthlyData(ListImpl<MonthlyDatacell> monthlyData) {
		this.monthlyData = monthlyData;
	}

	public ListImpl<QuarterlyDatacell> getQuarterlyData() {
		return quarterlyData;
	}

	public void setQuarterlyData(ListImpl<QuarterlyDatacell> quarterlyData) {
		this.quarterlyData = quarterlyData;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public ListImpl<Double> getInput() {
		return input;
	}

	// exporting format for GUI to use them inside tables
	public String[][] toTableFormat() {
		String[][] out = new String[2][12];
		for (int i = 0; i < 24; i++) {
			int j = i / 12;
			int k = i % 12;
			out[j][k] = String.format("%.2f", getMonthlyData().get(i).getDemand());
		}
		return out;
	}
}
