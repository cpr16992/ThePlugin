

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MRMtoSTR extends ArrayList<Structure>
{
	private static final long serialVersionUID = 1L;
	private static ArrayList<Structure> MRMTags = new ArrayList<Structure>();
	public MRMtoSTR(String fileName)
	{
		/*
		 * protected String id;
    	 * protected String acronym;
    	 * protected String name;
    	 * protected String colorHexTriplet;
		 * 
		 */
		try
		{
			ArrayList<String> test = readFile(fileName);
			for (String s : test) {
				String [] arr = s.split("\t");				
				Structure str = new Structure();
				str.setId(arr[0]);
				str.setColorHexTriplet(arr[1]);
				str.setAcronym(arr[2]);
				str.setName(arr[3]);
				MRMTags.add(str);
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}

	}
	/** Prints the list of tags in screen
	 */
	 public void printTags()
	{
		int i = 0;
		for (i = 0; i < MRMTags.size(); i++)
		{
			System.out.println(MRMTags.get(i).getName());
		}
		System.out.println(i);
	}

	private ArrayList<String> readFile(String file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		ArrayList<String> lines = new ArrayList<String>();

		while ((line = reader.readLine()) != null) {
			lines.add(line);
		}
		reader.close();

		return lines;
	}
	 
	public static void main(String[] args){
		 MRMtoSTR etiquetas = new MRMtoSTR("C:\\Users\\cporras\\Desktop\\Atlases\\Atlas LONI MRM\\Atlas LONI MRM\\MRM.txt");
		 etiquetas.printTags();
	}
}