package maven;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

 
public class PieChart_AWT extends ApplicationFrame {
   
   public PieChart_AWT( String title ) {
      super( title ); 
      setContentPane(createDemoPanel( ));
   }
   
   private static PieDataset createDataset() {
       DefaultPieDataset dataset = new DefaultPieDataset( );
       for (int i=0;i<=10;i++) {
       	dataset.setValue(String.valueOf(i), new Double (HistogramGenerator.freq[i][1] ) );
       } 
       return dataset; 
   } 
   
   private static JFreeChart createChart( PieDataset dataset ) {
       JFreeChart chart = ChartFactory.createPieChart(      
          "Datas' Pie Chart",   // chart title 
          dataset,          // data    
          true,             // include legend   
          true, 
          false);

       return chart;
    }
    
    public static JPanel createDemoPanel( ) {
       JFreeChart chart = createChart(createDataset());  
       return new ChartPanel( chart ); 
    }

}
