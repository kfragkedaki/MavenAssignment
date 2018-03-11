package maven;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import java.io.*;

public class HistogramGenerator {

    public static void main(String[] args) throws Exception {
	   
    	//String path = args[0];
    	String path ="C:\\Users\\pavlos\\Desktop\\Σχολή\\Ζ εξάμηνο\\Τεχνολογίας λογισμικού\\Lab\\Maven\\grades.txt";
	    int[][] freq=fileReader(path);
	    generateChart(freq);
    }

    public static int[][] fileReader(String path) throws Exception {
	    	 
	    int[][] freq = new int[11][2];
	    
	    for (int i=0;i<=10;i++) {
	    	freq[i][0] = i;
	    	freq[i][1] = 0;
	    }
	    
	    try{
	    	File file = new File(path);
	    	BufferedReader br = new BufferedReader(new FileReader(file));
	    	 
		    String st;
		    while ((st = br.readLine()) != null ) {
		        int i = Integer.parseInt(st);
		        freq[i][1]++;
		    }
		    
	    } catch (IOException e) {
	    	System.out.println("File I/O error!");
	    }
	    return freq;	    	    
	}
    
    public static void generateChart(int[][] dataValues) {
		/*
		 * The XYSeriesCollection object is a set XYSeries series (dataset) that
		 * can be visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		/*
		 * The XYSeries that are loaded in the dataset. There might be many
		 * series in one dataset.
		 */
		XYSeries data = new XYSeries("random values");

		/*
		 * Populating the XYSeries data object from the input Integer array
		 * values.
		 */
		for (int i = 0; i < dataValues.length; i++) {
			data.add(i, dataValues[i][1]);
		}

		// add the series to the dataset
		dataset.addSeries(data);

		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Chart title", "x_axis title", "y_axis_title", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);

		/*
		 * Initialize a frame for visualizing the chart and attach the
		 * previously created chart.
		 */
		ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);
	}
	  
}
