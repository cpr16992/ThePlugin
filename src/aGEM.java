import java.util.ArrayList;



public class aGEM {
	public static void main (String[] args) {
		aGEMtaglist list = new aGEMtaglist();
		ArrayList<Gene> genes = list.searchgenesbystructure("substantia nigra");
		for (Gene g: genes){
			System.out.println(g.getStrength());
		}
	}
}