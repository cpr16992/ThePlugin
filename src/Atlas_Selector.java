import ij.IJ;
import ij.ImagePlus;
import ij.ImageStack;
import ij.Prefs;
import ij.gui.GenericDialog;
import ij.io.Opener;
import ij.plugin.frame.PlugInFrame;
import ij.process.ImageProcessor;
import ij.process.ShortProcessor;
import ij.process.StackProcessor;

import java.util.ArrayList;

public class Atlas_Selector extends PlugInFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private mapeo map = new mapeo();
	private MDAToSTR MDA = map.MDAlist;
	private aGEMtaglist aGEM = map.aGEMlist;
	private ArrayList<String> query = new ArrayList<String>();
	private ArrayList<Structure> querystr = new ArrayList<Structure>();
	private ArrayList<Gene> queryg = new ArrayList<Gene>();
	private String path = "C:\\Users\\cporras\\Desktop\\Atlases\\Atlas LONI MDA\\Atlas LONI MDA\\Data";


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
			showAtlas(path);
			for (String str: query){
				ArrayList<Structure> ofInterest = map.FindInverseDownstreamCorrespondences(str);
				querystr.addAll(ofInterest);
			}
			for (Structure struct: querystr){
				makeMask(struct);
			}

		}
		else if (result1.equals("Gene"))
		{
			windowGene widow = new windowGene();
			while (!widow.wasperformed){
				query = widow.getResults();
			}
			query = widow.getResults();
			widow.dispose();
			for (String str: query){
				queryg.add(aGEM.searchgene(str));
			}
			showAtlas(path);
		}
	}


	private void illegalQuery() {
		GenericDialog gd = new GenericDialog("Error");
		gd.addMessage("Error. Illegal query.");
		gd.showDialog();
	}
	
	private void showAtlas(String path){
		Opener opener = new Opener();  
		ImagePlus imp = opener.openTiff(path, "MAP2006_t2avg.tif");
		imp.show();
	}
	
	private void makeMask(Structure structure){
		Opener opener = new Opener();  
		ImagePlus atlaslabels = opener.openTiff(path, "MDA2006label.tif");
		int threshold = Integer.parseInt(structure.getId());
		IJ.setThreshold(atlaslabels, threshold, threshold +1);
		Prefs.blackBackground = false;
		IJ.run(atlaslabels, "Convert to Mask", "method=Default background=Default black");
		IJ.run(atlaslabels, "16-bit", "");
		atlaslabels.show();
		ImagePlus result = new ImagePlus();
		IJ.run(result, "Merge Channels...", "c2=MDA2006label.tif c4=MAP2006_t2avg.tif create keep");
		result.show();
	}
	
}


