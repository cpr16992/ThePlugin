

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
			String test = readFile(fileName);
			String[] arr = test.split("\t");
			System.out.println(arr[0]);
			for(int a = 0; a <= arr.length; a = a + 4)
			{
				Structure str = new Structure();
				str.setId(arr[a]);
				str.setColorHexTriplet(arr[a+1]);	
				str.setAcronym(arr[a+2]);
				str.setName(arr[a+3]);
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
		for (int i = 0; i <= MRMTags.size(); i++)
		{
			System.out.println(MRMTags.get(i).getName());
		}
	}

	 private String readFile( String file ) throws IOException {
		    BufferedReader reader = new BufferedReader( new FileReader (file));
		    String         line = null;
		    StringBuilder  stringBuilder = new StringBuilder();
		    String         ls = System.getProperty("line.separator");

		    while( ( line = reader.readLine() ) != null ) {
		        stringBuilder.append( line );
		        stringBuilder.append( ls );
		    }

		    return stringBuilder.toString();
		}
	 
	public static void main(String[] args){
		 MRMparser etiquetas = new MRMparser("C:\\Documents and Settings\\tfg-biig\\Desktop\\MRM.txt");
		 //etiquetas.printTags();
	}
}