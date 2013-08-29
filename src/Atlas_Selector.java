import ij.IJ;
import ij.gui.GenericDialog;
import ij.plugin.frame.PlugInFrame;

import java.awt.Checkbox;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
					GenericDialog gd5 = new GenericDialog("Tags to be selected: ");
					//// ReadXMLFile.main(null);
					//// String[] AllenTagNames = ReadXMLFile.getTags();
					gd5.addMessage("Please select the tags you are interested for visualization");
					//// gd5.addChoice("Structures", AllenTagNames, "root");
					gd5.addStringField("", "root");
					Vector<?> sfs = gd5.getStringFields();
					TextField sf = (TextField)sfs.get(0);
					sf.addKeyListener(new KeyTypedManager());
					gd5.showDialog();
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

	
	class KeyTypedManager implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
			System.out.println("--> "+e.getKeyChar());
		}}
	
}


