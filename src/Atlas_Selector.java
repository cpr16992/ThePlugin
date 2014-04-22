import java.util.ArrayList;

import ij.IJ;
import ij.gui.GenericDialog;
import ij.plugin.frame.PlugInFrame;

public class Atlas_Selector extends PlugInFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Structure> query;


	public Atlas_Selector() {
		super("FrameDemo");
	}
	public void run(String arg){
		GenericDialog gd2 = new GenericDialog("Checkout selection");
		String options[] = {"Anatomy", "Gene"};
		gd2.addMessage("Please select the query type:");
		gd2.addRadioButtonGroup(null, options, 2, 1, "Anatomy");
		gd2.showDialog();
		if (gd2.wasCanceled()) {
			IJ.error("PlugIn canceled!");
			return;
		}
		String result1 = gd2.getNextRadioButton();
		if (result1.equals(null))
		{
			illegalQuery();
		}
		else if (result1.equals("Anatomy"))
		{
			windowAnatomy widow = new windowAnatomy();
			while (!widow.wasperformed){
				query = widow.getResults();
			}
			query = widow.getResults();
			widow.dispose();
		}
		else if (result1.equals("Gene"))
		{
			
		}
	}


	private void illegalQuery() {
		GenericDialog gd = new GenericDialog("Error");
		gd.addMessage("Error. Illegal query.");
		gd.showDialog();
	}
	
}


