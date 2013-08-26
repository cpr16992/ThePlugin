import ij.IJ;
import ij.gui.GenericDialog;
import ij.plugin.frame.PlugInFrame;

import java.awt.Checkbox;
import java.util.Vector;

public class Atlas_Selector extends PlugInFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Atlas_Selector() {
		super("FrameDemo");
	}
	@SuppressWarnings("unchecked")
	public void run(String arg){
		GenericDialog gd1 = new GenericDialog("Atlas selection");
		String[] atlases = {"Allen", "Toronto"};
		boolean[] defaultvalues = {false, false};
		gd1.addMessage("Please select an atlas:");
		gd1.addCheckboxGroup(2, 1, atlases, defaultvalues);
		gd1.showDialog();
		if (gd1.wasCanceled()) {
			IJ.error("PlugIn canceled!");
			return;
		}
		Vector<Checkbox> vect = gd1.getCheckboxes();
		boolean uno = vect.get(0).getState();
		boolean dos = vect.get(1).getState();
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
			if (uno)
			{
				if (dos)
				{

				}
				else
				{

				}
			}
			else if (dos)
			{

			}

		}
		else if (result1.equals("Gene"))
		{
			GenericDialog gd4 = new GenericDialog("Gene Query");
			String queries[] = {"Individual expression", "Coexpression"};
			gd4.addMessage("Please select a query:");
			gd4.addRadioButtonGroup(null, queries, 2, 1, "Individual expression");
			gd4.showDialog();
			String result2 = gd4.getNextRadioButton();
			if (result2.equals(null))
			{
				illegalQuery();
			}
			else if (result2.equals("Individual expression"))
			{
			}
			else if (result2.equals("Coexpression"))
			{
			}

		}
	}


	private void illegalQuery() {
		GenericDialog gd = new GenericDialog("Error");
		gd.addMessage("Error. Illegal query.");
		gd.showDialog();
	}

}


