
/**
 * 
 * The main handling class, it holds a list of datasets and a selected dataset
 * attribute which is used when a person interacts with a dataset over the GUI.
 *
 */
public class Main {

	public ListImpl<Dataset> datasets;
	public Dataset selectedDataset;

	public Main() {
		// adding first dataset
		datasets = new ListImpl<Dataset>();
		ListImpl<Double> ds1 = new ListImpl<Double>();
		ds1.insert(300.0);
		ds1.insert(350.0);
		ds1.insert(330.0);
		ds1.insert(340.0);
		ds1.insert(390.0);
		ds1.insert(430.0);
		ds1.insert(480.0);
		ds1.insert(460.0);
		ds1.insert(490.0);
		ds1.insert(510.0);
		ds1.insert(550.0);
		ds1.insert(560.0);
		ds1.insert(550.0);
		ds1.insert(590.0);
		ds1.insert(600.0);
		ds1.insert(610.0);
		ds1.insert(630.0);
		ds1.insert(620.0);
		ds1.insert(680.0);
		ds1.insert(690.0);
		ds1.insert(710.0);
		ds1.insert(730.0);
		ds1.insert(740.0);
		ds1.insert(770.0);
		datasets.insert(new Dataset(30, ds1));
		// adding second dataset
		ListImpl<Double> ds2 = new ListImpl<Double>();
		ds2.insert(200.0);
		ds2.insert(300.0);
		ds2.insert(250.0);
		ds2.insert(600.0);
		ds2.insert(650.0);
		ds2.insert(670.0);
		ds2.insert(400.0);
		ds2.insert(440.0);
		ds2.insert(430.0);
		ds2.insert(900.0);
		ds2.insert(980.0);
		ds2.insert(990.0);
		ds2.insert(300.0);
		ds2.insert(370.0);
		ds2.insert(380.0);
		ds2.insert(710.0);
		ds2.insert(730.0);
		ds2.insert(790.0);
		ds2.insert(450.0);
		ds2.insert(480.0);
		ds2.insert(490.0);
		ds2.insert(930.0);
		ds2.insert(960.0);
		ds2.insert(980.0);
		datasets.insert(new Dataset(30, ds2));

	}

}
