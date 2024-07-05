import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class DatasetPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2424023882995781032L;
	private JTable table;
	public JButton btnDelete;
	public JButton btnView;
	public int index;
	/**
	 * Create the panel.
	 */

	public DatasetPanel(int index, Main main) {
		this.index = index;
		Dataset ds = main.datasets.get(index);
		String[] cols = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEPT", "OCT", "NOV", "DEC"};
		setLayout(new GridLayout(1, 0, 0, 0));
		
		table = new JTable(ds.toTableFormat(), cols);
		table.setBounds(12, 12, 600, 200);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		add(panel);
		
		btnView = new JButton("Detailed View");
		panel.add(btnView);
		
		btnDelete = new JButton("Delete Dataset");
		panel.add(btnDelete);
	}
	

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800, 200);
	}

}
