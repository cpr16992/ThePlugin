import ij.IJ;
import ij.ImagePlus;
import ij.ImageStack;
import ij.Prefs;
import ij.gui.GenericDialog;
import ij.io.Opener;
import ij.plugin.Duplicator;
import ij.plugin.ImageCalculator;
import ij.plugin.frame.PlugInFrame;
import ij.process.ImageProcessor;
import ij.process.ShortProcessor;
import ij.process.StackProcessor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Atlas_Selector extends PlugInFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private mapeo map = new mapeo();
	private MDAToSTR MDA = map.MDAlist;
	private aGEMtaglist aGEM = map.aGEMlist;
	private ArrayList<String> query = new ArrayList<String>();
	private ArrayList<Structure> queryaGEM = new ArrayList<Structure>();
	private ArrayList<Structure> querystr = new ArrayList<Structure>();
	private ArrayList<Gene> queryg = new ArrayList<Gene>();
	private String path = "C:\\Users\\cporras\\Desktop\\Atlases\\Atlas LONI MDA\\Atlas LONI MDA\\Data";
	private ImagePlus atlas;

	public Atlas_Selector() {
		super("FrameDemo");
	}
	@SuppressWarnings("unchecked")
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
			Opener opener = new Opener();  
			atlas = opener.openTiff(path, "MAP2006_t2avg.tif");
			atlas.show();
			for (String str: query){
				ArrayList<Structure> ofInterest = map.FindAllDownstreamCorrespondences(str);
				querystr.add(MDA.searchtag(str));
				querystr.addAll(MDA.getAllDescendants(str));
				queryaGEM.addAll(ofInterest);
			}
			makeMask(querystr);

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
			Opener opener = new Opener();  
			atlas = opener.openTiff(path, "MAP2006_t2avg.tif");
			atlas.show();
			for (String str: query){
				queryaGEM.addAll(aGEM.findstructuresbygene(str));
			}
			Set<Structure> querystrhs = new HashSet<Structure>();
			for (Structure struct: queryaGEM){
				querystrhs.addAll(map.FindInverseDownstreamCorrespondences(struct.getName()));
				querystrhs.add(map.FindInverseCorrespondence(struct.getName()));
			}
			querystr = (ArrayList<Structure>) querystrhs;
			makeMask(querystr);
		}
	}


	private void illegalQuery() {
		GenericDialog gd = new GenericDialog("Error");
		gd.addMessage("Error. Illegal query.");
		gd.showDialog();
	}

	

	private void makeMask(ArrayList<Structure> Structures){
		Opener opener = new Opener();  
		ImagePlus atlaslabels = opener.openTiff(path, "MDA2006label.tif");
		ImagePlus imp = new Duplicator().run(atlaslabels);
		ImageCalculator ic = new ImageCalculator();
		int threshold = Integer.parseInt(Structures.get(0).getId());
		IJ.setThreshold(imp, threshold, threshold +1);
		Prefs.blackBackground = false;
		IJ.run(imp, "Convert to Mask", "method=Default background=Default black");
		for (int i = 1; i < Structures.size(); i++){
			ImagePlus imp2 = new Duplicator().run(atlaslabels);
			threshold = Integer.parseInt(Structures.get(i).getId());
			IJ.setThreshold(imp2, threshold, threshold +1);
			Prefs.blackBackground = false;
			IJ.run(imp2, "Convert to Mask", "method=Default background=Default black");
			imp = ic.run("OR create stack", imp, imp2);
		}
		IJ.run(imp, "16-bit", "");
		imp.show();
		String title = imp.getTitle();
		ImagePlus result = new ImagePlus();
		String statement = "c2=[" + title + "] c4=MAP2006_t2avg.tif create keep";
		IJ.run(result, "Merge Channels...", statement);
		result.show();
		imp.hide();
		atlas.hide();
	}

}


