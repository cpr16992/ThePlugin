

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MRMparser extends ArrayList<Structure>
{
	private static final long serialVersionUID = 1L;
	private static ArrayList<Structure> MRMTags = new ArrayList<Structure>();
	public MRMparser(String fileName)
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
		for (int i = 0; i < MRMTags.size(); i++)
		{
			System.out.println(MRMTags.get(i).getName());
		}
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
		 MRMparser etiquetas = new MRMparser("C:\\Documents and Settings\\tfg-biig\\Desktop\\MRM.txt");
		 etiquetas.printTags();
	}
}