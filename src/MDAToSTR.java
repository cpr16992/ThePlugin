

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MDAToSTR {
	private static ArrayList<Structure> MDATags = new ArrayList<Structure>();
	static Structure tag = new Structure();

	public static void main(String argv[]) {

		try {

			File fXmlFile = new File("C:\\Users\\cporras\\Desktop\\Atlases\\Atlas LONI MDA\\Atlas LONI MDA\\MDA.xml");
			/* The line above is to be substituted by the path of the file containing the atlas
			 * In case of an update, change the path by the one containing the latest version of
			 * the atlas ontology.
			 */
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("structure");
			for (int t = 0; t < nList.getLength(); t++) {
				Node nNode = nList.item(t);
				Element fElement = (Element) nNode;
				NodeList mList = fElement.getChildNodes();
				for (int u = 0; u < mList.getLength(); u++)
				{
					Node mNode = mList.item(u);
					FillFields(mNode, tag);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrintNames();
		//PrintChildren();
		System.out.println(MDATags.size());
	}
	public static void FillFields(Node nNode, Structure tag) {		
		Element eElement = (Element) nNode;
		tag.setId((eElement.getAttribute("id")));
		tag.setColorHexTriplet((eElement.getAttribute("color")));
		tag.setAcronym((eElement.getAttribute("abbreviation")));
		tag.setName((eElement.getAttribute("name")));
		if (eElement.hasChildNodes())
		{
			NodeList kList = eElement.getChildNodes();
			for (int u = 0; u < kList.getLength(); u++)
			{
				Structure tagchild = new Structure();
				Node mNode = kList.item(u);
				FillFields(mNode, tagchild);
				tag.addChild(tagchild);
			}
		}		
		MDATags.add(tag);

	}

	public static void PrintNames() {
		for (Structure str : MDATags) {
			System.out.println(str.getName());
		}
	}
	public static void PrintChildren() {
		for (int s = 0; s<MDATags.size(); s++)
		{
			List<Structure> Children = MDATags.get(s).getChildren();
			for (Structure str: Children)
			{
				System.out.println(str.getName());
			}
		}
	}
	public static void SortKinder(Structure parent){
		for (Structure kind : MDATags)
		{
			if (kind.isChild(parent)) {
				MDATags.add(kind);
				SortKinder(kind);
			}
		}
	}
	public static void PrintNames (Structure str) {
		System.out.println(str.getName());
	}
	public static String[] getTags(){
		String[] MDATagName = new String[MDATags.size()];
		for (int i = 0; i < MDATags.size(); i++)
		{
			MDATagName[i] = MDATags.get(i).getName();
		}
		return MDATagName;
	}
	public static void showKinder (){
		Structure root = MDATags.get(0);
		List<Structure> lista = root.getChildren();
		for (Structure kind: lista)
		{
			System.out.println(kind.getName());
		};
	}

}
