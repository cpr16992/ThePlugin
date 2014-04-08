import java.util.ArrayList;

public class MDAexecutable {
	public static void main (String[] args) {
		mapeo map = new mapeo();
		//MDAToSTR MDA = new MDAToSTR();
		//MDA.showAllDescendants("brain");
		map.showinversedownstreamcorrespondences("brain");
		//for (Structure k: midbrain){
		//	System.out.println(k.getName());
		//}
		//MDAToSTR list = new MDAToSTR();
		//System.out.println(list.searchtag("midbrain").getId());
		//list.showAllDescendants("brainstem");
		//list.showAllAncestors("brain nucleus");
	}
}
