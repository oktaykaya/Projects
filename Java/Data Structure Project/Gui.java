import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;

public class Gui {

	private JFrame frame;
	private JTextField txtInsertionSizedays;
	private Main main;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		this.main = new Main();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Final Project");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);

		// PANEL LAYOUT
		CardLayout cl = new CardLayout(0, 0);
		panel.setLayout(cl);

		// MAIN MENU
		JPanel mainMenu = new JPanel();
		panel.add(mainMenu, "mainMenu");
		mainMenu.setLayout(new GridLayout(0, 1, 10, 10));
		JButton btnInsert = new JButton("Insert New Dataset");
		mainMenu.add(btnInsert);
		JButton btnList = new JButton("List All Datasets");
		mainMenu.add(btnList);

		// INSERT MENU
		JPanel insertMenu = new JPanel();
		panel.add(insertMenu, "insertMenu");

		// LIST MENU
		JPanel listMenu = new JPanel();
		panel.add(listMenu, "listMenu");

		// DATASET PANEL
		JPanel datasetMenu = new JPanel();
		panel.add(datasetMenu, "datasetMenu");
		GridBagLayout gbl_datasetMenu = new GridBagLayout();
		gbl_datasetMenu.columnWidths = new int[] { 0, 0 };
		gbl_datasetMenu.rowHeights = new int[] { 0, 0 };
		gbl_datasetMenu.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_datasetMenu.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		datasetMenu.setLayout(gbl_datasetMenu);

		// GO TO INSERT
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panel, "insertMenu");
			}
		});

		/**
		 * DATASET MENU
		 */
		JButton btnBackFromDataset = new JButton("Back to Main");
		GridBagConstraints gbc_btnBackFromDataset = new GridBagConstraints();
		gbc_btnBackFromDataset.gridwidth = 2;
		gbc_btnBackFromDataset.fill = GridBagConstraints.BOTH;
		gbc_btnBackFromDataset.insets = new Insets(0, 0, 5, 5);
		gbc_btnBackFromDataset.gridx = 0;
		gbc_btnBackFromDataset.gridy = 0;
		datasetMenu.add(btnBackFromDataset, gbc_btnBackFromDataset);
		btnBackFromDataset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panel, "mainMenu");
			}
		});

		JPanel rightPanel = new JPanel();
		GridBagConstraints gbc_rightPanel = new GridBagConstraints();
		gbc_rightPanel.gridwidth = 2;
		gbc_rightPanel.fill = GridBagConstraints.BOTH;
		gbc_rightPanel.gridx = 0;
		gbc_rightPanel.gridy = 1;
		datasetMenu.add(rightPanel, gbc_rightPanel);
		rightPanel.setLayout(new GridLayout(1, 0, 0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		rightPanel.add(tabbedPane);

		JPanel inputly = new JPanel();
		tabbedPane.addTab("Inputs", null, inputly, null);
		inputly.setLayout(new BorderLayout(0, 0));
		JPanel inputFieldShower = new JPanel();
		JScrollPane jsp_2 = new JScrollPane(inputFieldShower, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		inputFieldShower.setLayout(new GridLayout(0, 6, 0, 0));
		inputly.add(jsp_2, BorderLayout.CENTER);

		JButton btnSaveChanges = new JButton("Save Changes");
		inputly.add(btnSaveChanges, BorderLayout.SOUTH);

		JPanel monthly = new JPanel();
		tabbedPane.addTab("Monthly", null, monthly, null);
		monthly.setLayout(new BorderLayout(0, 0));
		JPanel monthlyFieldShower = new JPanel();
		JScrollPane jsp_3 = new JScrollPane(monthlyFieldShower, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		monthlyFieldShower.setLayout(new GridLayout(2, 12, 0, 0));
		monthly.add(jsp_3, BorderLayout.CENTER);

		JPanel quarterly = new JPanel();
		tabbedPane.addTab("Quarterly", null, quarterly, null);
		quarterly.setLayout(new BorderLayout(0, 0));
		JPanel quarterlyFieldShower = new JPanel();
		JScrollPane jsp_4 = new JScrollPane(quarterlyFieldShower, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		quarterlyFieldShower.setLayout(new GridLayout(2, 12, 0, 0));
		quarterly.add(jsp_4, BorderLayout.CENTER);

		JPanel functions = new JPanel();
		tabbedPane.addTab("Functions", null, functions, null);
		functions.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel functButtons = new JPanel();
		functions.add(functButtons);
		functButtons.setLayout(new GridLayout(0, 1, 0, 0));

		JButton btnMaxForecast = new JButton("Max Forecasts");
		functButtons.add(btnMaxForecast);

		JButton btnMinForecast = new JButton("Min Forecasts");
		functButtons.add(btnMinForecast);

		JButton btnMse = new JButton("Mean Squared Error");
		functButtons.add(btnMse);

		JButton btnOrderForecast = new JButton("Order Forecasts");
		functButtons.add(btnOrderForecast);

		JButton btnMaxSales = new JButton("Max Sales");
		functButtons.add(btnMaxSales);

		JButton btnMinSales = new JButton("Min Sales");
		functButtons.add(btnMinSales);

		JButton btnReversePrint = new JButton("Print Reverse");
		functButtons.add(btnReversePrint);

		JPanel answer = new JPanel();
		functions.add(answer);
		answer.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel answerLabel = new JLabel("");
		answer.add(answerLabel);

		btnMaxForecast.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Double expMax = main.selectedDataset.getMonthlyData().getMax(Dataset.mdcExpComparator)
						.getExponentialSmoothingForecast();
				Double dblMax = main.selectedDataset.getMonthlyData().getMax(Dataset.mdcDoubComparator)
						.getDoubleExponentialSmoothingForecast();
				Double regMax = main.selectedDataset.getMonthlyData().getMax(Dataset.mdcRegrComparator)
						.getRegressionForecast();
				Double desMax = main.selectedDataset.getQuarterlyData().getMax(Dataset.qdcDesComparator)
						.getDeseasonalizedRegressionForecast();
				answerLabel.setText("<html><body>Exponential Smoothing: " + String.format("%.5f", expMax) + "<br>"
						+ "Double Exponential Smoothing: " + String.format("%.5f", dblMax) + "<br>"
						+ "Regression Analysis: " + String.format("%.5f", regMax) + "<br>"
						+ "Deseasonalized Regression Analysis: " + String.format("%.5f", desMax) + "<br>"
						+ "</body></html>");
			}
		});

		btnMinForecast.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Double expMax = main.selectedDataset.getMonthlyData().getMin(Dataset.mdcExpComparator)
						.getExponentialSmoothingForecast();
				Double dblMax = main.selectedDataset.getMonthlyData().getMin(Dataset.mdcDoubComparator)
						.getDoubleExponentialSmoothingForecast();
				Double regMax = main.selectedDataset.getMonthlyData().getMin(Dataset.mdcRegrComparator)
						.getRegressionForecast();
				Double desMax = main.selectedDataset.getQuarterlyData().getMin(Dataset.qdcDesComparator)
						.getDeseasonalizedRegressionForecast();
				answerLabel.setText("<html><body>Exponential Smoothing: " + String.format("%.5f", expMax) + "<br>"
						+ "Double Exponential Smoothing: " + String.format("%.5f", dblMax) + "<br>"
						+ "Regression Analysis: " + String.format("%.5f", regMax) + "<br>"
						+ "Deseasonalized Regression Analysis: " + String.format("%.5f", desMax) + "<br>"
						+ "</body></html>");
			}
		});

		btnMaxSales.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Double inMax = main.selectedDataset.getInput().getMax(Dataset.doubleComparator);
				Double monMax = main.selectedDataset.getMonthlyData().getMax(Dataset.mdcDemandComparator).getDemand();
				Double qMax = main.selectedDataset.getQuarterlyData().getMax(Dataset.qdcDemandComparator).getDemand();
				answerLabel.setText("<html><body>Input: " + String.format("%.5f", inMax) + "<br>" + "Monthly: "
						+ String.format("%.5f", monMax) + "<br>" + "Quarterly: " + String.format("%.5f", qMax) + "<br>"
						+ "</body></html>");
			}
		});

		btnMinSales.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Double inMax = main.selectedDataset.getInput().getMin(Dataset.doubleComparator);
				Double monMax = main.selectedDataset.getMonthlyData().getMin(Dataset.mdcDemandComparator).getDemand();
				Double qMax = main.selectedDataset.getQuarterlyData().getMin(Dataset.qdcDemandComparator).getDemand();
				answerLabel.setText("<html><body>Input: " + String.format("%.5f", inMax) + "<br>" + "Monthly: "
						+ String.format("%.5f", monMax) + "<br>" + "Quarterly: " + String.format("%.5f", qMax) + "<br>"
						+ "</body></html>");
			}
		});

		btnOrderForecast.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ListImpl<Double> exp = new ListImpl<Double>();
				ListImpl<Double> dbl = new ListImpl<Double>();
				ListImpl<Double> reg = new ListImpl<Double>();
				ListImpl<Double> des = new ListImpl<Double>();
				for (int i = 0; i < main.selectedDataset.getMonthlyData().size(); i++) {
					exp.insert(main.selectedDataset.getMonthlyData().get(i).getExponentialSmoothingForecast());
					dbl.insert(main.selectedDataset.getMonthlyData().get(i).getDoubleExponentialSmoothingForecast());
					reg.insert(main.selectedDataset.getMonthlyData().get(i).getRegressionForecast());
				}

				for (int i = 0; i < main.selectedDataset.getQuarterlyData().size(); i++) {
					des.insert(main.selectedDataset.getQuarterlyData().get(i).getDeseasonalizedRegressionForecast());
				}
				ListImpl<Double> expSorted = new ListImpl<Double>();
				ListImpl<Double> dblSorted = new ListImpl<Double>();
				ListImpl<Double> regSorted = new ListImpl<Double>();
				ListImpl<Double> desSorted = new ListImpl<Double>();
				while (exp.size() > 0) {
					Double max = exp.getMax(Dataset.doubleComparator);
					expSorted.insert(max);
					exp.removeAt(exp.findIndex(max));
				}
				while (dbl.size() > 0) {
					Double max = dbl.getMax(Dataset.doubleComparator);
					dblSorted.insert(max);
					dbl.removeAt(dbl.findIndex(max));
				}
				while (reg.size() > 0) {
					Double max = reg.getMax(Dataset.doubleComparator);
					regSorted.insert(max);
					reg.removeAt(reg.findIndex(max));
				}
				while (des.size() > 0) {
					Double max = des.getMax(Dataset.doubleComparator);
					desSorted.insert(max);
					des.removeAt(des.findIndex(max));
				}
				StringBuilder sb = new StringBuilder();
				sb.append("<html><body>Exponential Smoothing -> ");
				for (int i = 0; i < expSorted.size(); i++) {
					sb.append(String.format("%.5f", expSorted.get(i)) + "  ");
				}
				sb.append("<br><br>");
				sb.append("Double Exponential Smoothing -> ");
				for (int i = 0; i < dblSorted.size(); i++) {
					sb.append(String.format("%.5f", dblSorted.get(i)) + "  ");
				}
				sb.append("<br><br>");
				sb.append("Regression Analysis -> ");
				for (int i = 0; i < regSorted.size(); i++) {
					sb.append(String.format("%.5f", regSorted.get(i)) + "  ");
				}
				sb.append("<br><br>");
				sb.append("Exponential Smoothing -> ");
				for (int i = 0; i < desSorted.size(); i++) {
					sb.append(String.format("%.5f", desSorted.get(i)) + "  ");
				}
				sb.append("<br>");
				sb.append("</body></html>");
				answerLabel.setText(sb.toString());
			}
		});
		
		btnMse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				double expErr = 0.0;
				double dblErr = 0.0;
				double regErr = 0.0;
				double desErr = 0.0;
				for (int i=0; i<main.selectedDataset.getMonthlyData().size(); i++) {
					double dem = main.selectedDataset.getMonthlyData().get(i).getDemand();
					double frc = main.selectedDataset.getMonthlyData().get(i).getExponentialSmoothingForecast();
					expErr += (dem - frc) * (dem - frc);
					frc = main.selectedDataset.getMonthlyData().get(i).getDoubleExponentialSmoothingForecast();
					dblErr += (dem - frc) * (dem - frc);
					frc = main.selectedDataset.getMonthlyData().get(i).getRegressionForecast();
					regErr += (dem - frc) * (dem - frc);
				}
				expErr = expErr / 24.0;
				dblErr = dblErr / 24.0;
				regErr = regErr / 24.0;
				for (int i=0; i<main.selectedDataset.getQuarterlyData().size(); i++) {
					double dem = main.selectedDataset.getQuarterlyData().get(i).getDemand() / 3.0;
					double frc = main.selectedDataset.getQuarterlyData().get(i).getDeseasonalizedRegressionForecast();
					desErr += (dem - frc) * (dem - frc);
				}
				desErr = desErr / 8.0;
				StringBuilder sb = new StringBuilder();
				sb.append("<html><body>Exponential Smoothing -> ");
				sb.append(String.format("%.5f", expErr));
				sb.append("<br><br>");
				sb.append("<html><body>Double Exponential Smoothing -> ");
				sb.append(String.format("%.5f", dblErr));

				sb.append("<br><br>");
				sb.append("<html><body>Regression Analysis -> ");
				sb.append(String.format("%.5f", regErr));
				sb.append("<br><br>");
				sb.append("<html><body>Exponential Smoothing -> ");
				sb.append(String.format("%.5f", desErr));
				sb.append("<br>");
				sb.append("</body></html>");
				answerLabel.setText(sb.toString());
			}
		});

		btnReversePrint.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				StringBuilder sb = new StringBuilder();
				sb.append("<html><body>");
				for (int i = main.selectedDataset.getInput().size() - 1; i > -1; i--) {
					sb.append("index #" + (i + 1) + " " + main.selectedDataset.getInput().get(i) + "<br>");
				}
				sb.append("</body></html>");
				answerLabel.setText(sb.toString());
			}
		});

		btnSaveChanges.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Component[] content = inputFieldShower.getComponents();
				boolean fail = false;
				for (Component c : content) {
					InputPanel ip = (InputPanel) c;
					boolean isNumeric = ip.textField.getText().length() > 0
							&& ip.textField.getText().chars().allMatch(Character::isDigit);
					if (!isNumeric) {
						ip.textField.setBackground(Color.RED);
						fail = true;
					} else {
						ip.textField.setBackground(Color.WHITE);
					}
				}
				if (!fail) {
					ListImpl<Double> inputs = new ListImpl<Double>();
					for (Component c : content) {
						InputPanel ip = (InputPanel) c;
						inputs.insert((double) Integer.parseInt(ip.textField.getText()));
					}
					main.selectedDataset.setInput(inputs);
					monthlyFieldShower.removeAll();
					for (int i = 0; i < main.selectedDataset.getMonthlyData().size(); i++) {
						monthlyFieldShower.add(new MonthPanel(i + 1, main.selectedDataset.getMonthlyData().get(i)));
					}
					quarterlyFieldShower.removeAll();
					for (int i = 0; i < main.selectedDataset.getQuarterlyData().size(); i++) {
						quarterlyFieldShower
								.add(new QuarterlyPanel(i + 1, main.selectedDataset.getQuarterlyData().get(i)));
					}

				}
			}
		});

		/**
		 * LIST MENU
		 */
		GridBagLayout gbl_listMenu = new GridBagLayout();
		gbl_listMenu.columnWidths = new int[] { 314, 0 };
		gbl_listMenu.rowHeights = new int[] { 0, 25, 0 };
		gbl_listMenu.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_listMenu.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		listMenu.setLayout(gbl_listMenu);

		JButton btnBackFromList = new JButton("Back to Main");
		GridBagConstraints gbc_btnBackFromList = new GridBagConstraints();
		gbc_btnBackFromList.insets = new Insets(0, 0, 5, 5);
		gbc_btnBackFromList.anchor = GridBagConstraints.NORTH;
		gbc_btnBackFromList.fill = GridBagConstraints.BOTH;
		gbc_btnBackFromList.gridx = 0;
		gbc_btnBackFromList.gridy = 0;
		listMenu.add(btnBackFromList, gbc_btnBackFromList);

		JPanel listFieldPanel = new JPanel();
		JScrollPane jsp_1 = new JScrollPane(listFieldPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		listFieldPanel.setLayout(new GridLayout(0, 1, 10, 10));
		GridBagConstraints gbc_jsp_1 = new GridBagConstraints();
		gbc_jsp_1.insets = new Insets(0, 0, 0, 5);
		gbc_jsp_1.fill = GridBagConstraints.BOTH;
		gbc_jsp_1.gridx = 0;
		gbc_jsp_1.gridy = 1;
		listMenu.add(jsp_1, gbc_jsp_1);
		// BACK TO MAIN
		btnBackFromList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panel, "mainMenu");
			}
		});

		// GO TO LIST
		btnList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				listFieldPanel.removeAll();
				listFieldPanel.revalidate();
				listFieldPanel.repaint();
				for (int i = 0; i < main.datasets.size(); i++) {
					DatasetPanel dsp = new DatasetPanel(i, main);
					dsp.btnDelete.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							main.datasets.removeAt(dsp.index);
							listFieldPanel.remove(dsp);
							Component[] comps = listFieldPanel.getComponents();
							for (Component c : comps) {
								if (((DatasetPanel) c).index > dsp.index) {
									((DatasetPanel) c).index--;
								}
							}
							listFieldPanel.revalidate();
							listFieldPanel.repaint();
						}
					});
					dsp.btnView.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							main.selectedDataset = main.datasets.get(dsp.index);
							cl.show(panel, "datasetMenu");
							inputFieldShower.removeAll();
							for (int i = 0; i < main.selectedDataset.getInput().size(); i++) {
								inputFieldShower
										.add(new InputPanel(i + 1, main.selectedDataset.getInput().get(i).intValue()));
							}
							monthlyFieldShower.removeAll();
							for (int i = 0; i < main.selectedDataset.getMonthlyData().size(); i++) {
								monthlyFieldShower
										.add(new MonthPanel(i + 1, main.selectedDataset.getMonthlyData().get(i)));
							}
							quarterlyFieldShower.removeAll();
							for (int i = 0; i < main.selectedDataset.getQuarterlyData().size(); i++) {
								quarterlyFieldShower
										.add(new QuarterlyPanel(i + 1, main.selectedDataset.getQuarterlyData().get(i)));
							}
						}
					});

					listFieldPanel.add(dsp);
				}
				cl.show(panel, "listMenu");
			}
		});

		/**
		 * INSERT MENU
		 */
		GridBagLayout gbl_insertMenu = new GridBagLayout();
		gbl_insertMenu.columnWidths = new int[] { 162, 150, 98, 150, 0 };
		gbl_insertMenu.rowHeights = new int[] { 25, 25, 25, 271, 25, 0 };
		gbl_insertMenu.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_insertMenu.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		insertMenu.setLayout(gbl_insertMenu);
		JButton btnBackFromInsert = new JButton("Back to Main");
		GridBagConstraints gbc_btnBackFromInsert = new GridBagConstraints();
		gbc_btnBackFromInsert.gridwidth = 4;
		gbc_btnBackFromInsert.anchor = GridBagConstraints.NORTH;
		gbc_btnBackFromInsert.insets = new Insets(0, 0, 5, 0);
		gbc_btnBackFromInsert.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBackFromInsert.gridx = 0;
		gbc_btnBackFromInsert.gridy = 0;
		insertMenu.add(btnBackFromInsert, gbc_btnBackFromInsert);
		// BACK TO MAIN
		btnBackFromInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panel, "mainMenu");
			}
		});

		JLabel lblNewLabel = new JLabel("Insertion Size (days)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		insertMenu.add(lblNewLabel, gbc_lblNewLabel);

		txtInsertionSizedays = new JTextField();
		txtInsertionSizedays.setText("30");
		txtInsertionSizedays.setToolTipText("Must be an integer value");
		txtInsertionSizedays.setColumns(10);
		GridBagConstraints gbc_txtInsertionSizedays = new GridBagConstraints();
		gbc_txtInsertionSizedays.gridwidth = 3;
		gbc_txtInsertionSizedays.fill = GridBagConstraints.BOTH;
		gbc_txtInsertionSizedays.insets = new Insets(0, 0, 5, 5);
		gbc_txtInsertionSizedays.gridx = 0;
		gbc_txtInsertionSizedays.gridy = 2;
		insertMenu.add(txtInsertionSizedays, gbc_txtInsertionSizedays);

		JButton btnInsertInit = new JButton("Initialize");
		GridBagConstraints gbc_btnInsertInit = new GridBagConstraints();
		gbc_btnInsertInit.anchor = GridBagConstraints.NORTH;
		gbc_btnInsertInit.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInsertInit.insets = new Insets(0, 0, 5, 0);
		gbc_btnInsertInit.gridx = 3;
		gbc_btnInsertInit.gridy = 2;
		insertMenu.add(btnInsertInit, gbc_btnInsertInit);

		JPanel insertFieldPanel = new JPanel();
		JScrollPane jsp = new JScrollPane(insertFieldPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		GridBagConstraints gbc_jsp = new GridBagConstraints();
		gbc_jsp.gridwidth = 4;
		gbc_jsp.insets = new Insets(0, 0, 5, 0);
		gbc_jsp.fill = GridBagConstraints.BOTH;
		gbc_jsp.gridx = 0;
		gbc_jsp.gridy = 3;
		insertFieldPanel.setLayout(new GridLayout(0, 6));
		insertMenu.add(jsp, gbc_jsp);

		JButton btnSaveInsert = new JButton("Insert Dataset");
		btnSaveInsert.setEnabled(false);
		GridBagConstraints gbc_btnSaveInsert = new GridBagConstraints();
		gbc_btnSaveInsert.anchor = GridBagConstraints.NORTH;
		gbc_btnSaveInsert.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSaveInsert.gridx = 3;
		gbc_btnSaveInsert.gridy = 4;
		insertMenu.add(btnSaveInsert, gbc_btnSaveInsert);

		btnSaveInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Component[] content = insertFieldPanel.getComponents();
				boolean fail = false;
				for (Component c : content) {
					InputPanel ip = (InputPanel) c;
					boolean isNumeric = ip.textField.getText().length() > 0
							&& ip.textField.getText().chars().allMatch(Character::isDigit);
					if (!isNumeric) {
						ip.textField.setBackground(Color.RED);
						fail = true;
					} else {
						ip.textField.setBackground(Color.WHITE);
					}
				}
				if (!fail) {
					ListImpl<Double> inputs = new ListImpl<Double>();
					for (Component c : content) {
						InputPanel ip = (InputPanel) c;
						inputs.insert((double) Integer.parseInt(ip.textField.getText()));
					}

					main.datasets.insert(new Dataset(Integer.parseInt(txtInsertionSizedays.getText()), inputs));
					insertFieldPanel.removeAll();
					insertFieldPanel.revalidate();
					insertFieldPanel.repaint();
					txtInsertionSizedays.setEditable(true);
					txtInsertionSizedays.setEnabled(true);
					btnSaveInsert.setEnabled(false);

				}
			}
		});

		btnInsertInit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String txtVal = txtInsertionSizedays.getText();
				boolean isNumeric = txtVal.length() > 0 && txtVal.chars().allMatch(Character::isDigit);
				boolean fail = false;
				int numVal = 30;
				if (isNumeric) {
					numVal = Integer.parseInt(txtVal);
					if (numVal > 0 && numVal < 720 && 720 % numVal == 0) {
						fail = false;
					} else {
						fail = true;
					}
				} else {
					fail = true;
				}
				if (fail) {
					txtInsertionSizedays.setBackground(Color.RED);
				} else {
					txtInsertionSizedays.setBackground(Color.WHITE);
					txtInsertionSizedays.setEditable(false);
					txtInsertionSizedays.setEnabled(false);
					btnSaveInsert.setEnabled(true);
					insertFieldPanel.removeAll();
					int count = 720 / numVal;
					for (int i = 0; i < count; i++) {
						insertFieldPanel.add(new InputPanel(i + 1));
					}
					insertFieldPanel.revalidate();
					insertFieldPanel.repaint();
				}
			}
		});

		cl.show(panel, "mainMenu");
	}
}
