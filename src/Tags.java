

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.io.File;

public class Tags extends Hashtable<Integer, String>
{
	/** Reads tags from a .txt file and stores them in a Hashtable
	 * @param fileName the path and name of the file containing tags
	 */
	private static final long serialVersionUID = 1L;
	private Hashtable<Integer, String> tags;
	private int num;
	public Tags(String fileName)
	{
		tags = new Hashtable<Integer, String>();
		try
		{
			Scanner file = new Scanner(new File(fileName));
			while (file.hasNextLine())
			{
				num = file.nextInt();
				String tag = file.nextLine();
				tags.put(num, tag);
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
		for (int i = 0; i <= num; i++)
		{
			if(tags.containsKey(i))
			{
				System.out.print(i);
				System.out.print("\t");
				System.out.println(tags.get(i));
			}
		}
	}

	// public static void main(String[] args){
	//	 Tags etiquetas = new Tags("C:/Users/carlos/Downloads/PFC/Atlas Toronto/etiquetas.txt");
	//	 ArrayList<Structure> StructuredTags = etiquetas.TagMapper();
	//	 etiquetas.printTags();
	// }
	 public ArrayList<Structure> TagMapper(){
		 ArrayList<Structure> ListOfTags = new ArrayList<Structure>();
		 for (int i = 0; i <= num; i++)
			{
				if(tags.containsKey(i))
				{
					Structure tagtoadd = new Structure();
					tagtoadd.setGrayLevel(Integer.toString(i));
					tagtoadd.setName(tags.get(i));
					ListOfTags.add(tagtoadd);
				}
			}
		 return ListOfTags;
	 }
}