package maven;

import org.jfree.ui.RefineryUtilities;
import java.io.*;

public class HistogramGenerator {
	
	static int[][] freq = new int[11][2];
	
    public static void main(String[] args) throws Exception {
	   
    	String path = args[0];    
        HistogramGenerator hg = new HistogramGenerator();
        hg.fileReader(path);
        
        PieChart_AWT demo = new PieChart_AWT( "Grades' Chart" );  
        demo.setSize( 560 , 367 );    
        RefineryUtilities.centerFrameOnScreen( demo );    
        demo.setVisible( true );
    }

    public int[][] fileReader(String path) throws Exception {
	    
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

}