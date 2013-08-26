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
		boolean works = false;
		while (!works)
		{
			GenericDialog gd2 = new GenericDialog("Checkout selection");
			String options[] = {"Anatomy", "Gene"};
			gd2.addMessage("Please select the query type:");
			gd2.addCheckboxGroup(2, 1, options, defaultvalues);
			gd2.showDialog();
			if (gd2.wasCanceled()) {
				IJ.error("PlugIn canceled!");
				return;
			}
			Vector<Checkbox> vectr = gd2.getCheckboxes();
			boolean tres = vectr.get(0).getState();
			boolean cuatro = vectr.get(1).getState();
			if (cuatro && tres)
			{
				illegalQuery();
			}
			else if (tres)
			{
				works = true;
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
			else if (cuatro)
			{
				GenericDialog gd4 = new GenericDialog("Gene Query");
				String queries[] = {"Individual expression", "Coexpression"};
				gd4.addMessage("Please select a query:");
				gd4.addCheckboxGroup(2, 1, queries, defaultvalues);
				gd4.showDialog();
				Vector<Checkbox> vector = gd4.getCheckboxes();
				boolean cinco = vector.get(0).getState();
				boolean seis = vector.get(1).getState();
				if (cinco && seis)
				{
					illegalQuery();
				}
				else if (cinco)
				{
					works = true;
				}
				else if (seis)
				{
					works = true;
				}

			}
		}


	}
	private void illegalQuery() {
		GenericDialog gd = new GenericDialog("Error");
		gd.addMessage("Error. Illegal query.");
		gd.showDialog();
	}

}


