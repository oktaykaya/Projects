
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MonthPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2424023882995781032L;

	/**
	 * Create the panel.
	 * 
	 * @wbp.parser.constructor
	 */

	public MonthPanel(int labelVal, MonthlyDatacell md) {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblMonth = new JLabel("Month #" + labelVal);
		lblMonth.setAlignmentY(Component.TOP_ALIGNMENT);
		add(lblMonth);

		JLabel lblDemand = new JLabel("Demand: " + md.getDemand());
		add(lblDemand);

		JLabel lblForecasts = new JLabel(
				"<html><body>Exponential Smoothing<br><br>Double Exponential<br><br>Regression</body></html>");
		add(lblForecasts);

		JLabel lbl = new JLabel("<html><body>" + String.format("%.5f", md.getExponentialSmoothingForecast())
				+ "<br><br>" + String.format("%.5f", md.getDoubleExponentialSmoothingForecast()) + "<br><br>"
				+ String.format("%.5f", md.getRegressionForecast()) + "</body></html>");
		add(lbl);

	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(250, 50);
	}
}
