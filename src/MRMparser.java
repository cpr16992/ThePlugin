

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class MRMparser extends ArrayList<Structure>
{
	/** Reads tags from a .txt file and stores them in a Hashtable
	 * @param fileName the path and name of the file containing tags
	 */
	private static final long serialVersionUID = 1L;
	private static ArrayList<Structure> MRMTags = new ArrayList<Structure>();
	private int num;
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
			Scanner file = new Scanner(new File(fileName));
			while (file.hasNextLine())
			{
				Structure str = new Structure();
				num = file.nextInt();
				str.setId(String.valueOf(num));
				String colour = file.nextLine();
				str.setColorHexTriplet(colour);	
				String Acron = file.nextLine();
				str.setAcronym(Acron);
				String tag = file.nextLine();
				str.setName(tag);
				MRMTags.add(str);
			}
			file.close();
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
		for (int i = 0; i <= MRMTags.size(); i++)
		{
			System.out.println(MRMTags.get(i).getId());
			System.out.println(MRMTags.get(i).getColorHexTriplet());
			System.out.println(MRMTags.get(i).getAcronym());
			System.out.println(MRMTags.get(i).getName());
		}
	}

	public static void main(String[] args){
		 MRMparser etiquetas = new MRMparser("C:\\Documents and Settings\\tfg-biig\\Desktop\\MRM.txt");
		 etiquetas.printTags();
	}
}