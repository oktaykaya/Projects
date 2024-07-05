
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2424023882995781032L;
	public JTextField textField;
	public JLabel label;

	/**
	 * Create the panel.
	 */

	public InputPanel(int labelVal) {
		setLayout(null);

		label = new JLabel("Input #" + labelVal);
		label.setBounds(12, 12, 80, 20);
		add(label);

		textField = new JTextField();
		textField.setBounds(92, 12, 152, 20);
		textField.setColumns(10);
		add(textField);
	}
	
	public InputPanel(int labelVal, int val) {
		setLayout(null);

		label = new JLabel("Input #" + labelVal);
		label.setBounds(12, 12, 80, 20);
		add(label);

		textField = new JTextField();
		textField.setBounds(92, 12, 152, 20);
		textField.setColumns(10);
		add(textField);
		textField.setText(val+"");
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(250, 50);
	}

}
