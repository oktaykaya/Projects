
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class QuarterlyPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2424023882995781032L;

	/**
	 * Create the panel.
	 * 
	 * @wbp.parser.constructor
	 */

	public QuarterlyPanel(int labelVal, QuarterlyDatacell qd) {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblMonth = new JLabel("Q #" + labelVal);
		lblMonth.setAlignmentY(Component.TOP_ALIGNMENT);
		add(lblMonth);

		JLabel lblDemand = new JLabel("Demand: " + String.format("%.5f", qd.getDemand()));
		add(lblDemand);

		JLabel lblForecasts = new JLabel("<html><body>Deseasonalized Regression</body></html>");
		add(lblForecasts);

		JLabel lbl = new JLabel(
				"<html><body>" + String.format("%.5f", qd.getDeseasonalizedRegressionForecast()) + "</body></html>");
		add(lbl);

	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(250, 50);
	}
}
