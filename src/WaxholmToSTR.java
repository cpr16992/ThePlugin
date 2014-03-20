

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WaxholmToSTR {
	private static ArrayList<Structure> WaxholmTags = new ArrayList<Structure>();

	public static void main(String argv[]) {

		try {

			File fXmlFile = new File("C:\\Users\\cporras\\Desktop\\Atlases\\Atlas Waxholm\\CLabels.atlas (1).xml");
			/* The line above is to be substituted by the path of the file containing the atlas
			 * In case of an update, change the path by the one containing the latest version of
			 * the atlas ontology.
			 */
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Area");
			for (int u = 0; u < nList.getLength(); u++)
			{
				Node mNode = nList.item(u);
				FillFields(mNode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrintNames();
		System.out.println(WaxholmTags.size());
		//showKinder();
	}
	public static void FillFields(Node nNode) {
		Structure tag = new Structure(null, null);
		Element eElement = (Element) nNode;
		//Falta la ID, que no sé muy bien como resolver. Quizás sería buena idea poner una ID autoincremental
		//(consultar ASAP)
		tag.setName((eElement.getAttribute("name")));
		Element gElement = 	(Element) eElement.getElementsByTagName("color").item(0);
		tag.setColorR((gElement.getAttribute("r")));
		tag.setColorB((gElement.getAttribute("b")));
		tag.setColorG((gElement.getAttribute("g")));
		WaxholmTags.add(tag);
		/*for (Structure str : WaxholmTags) {
			if (tag.isChild(str)) {
				str.addChild(tag);
			}
		}*/
	}

	public static void PrintNames() {
		for (Structure str : WaxholmTags) {
			System.out.println(str.getName());
		}
	}
	public static void SortKinder(Structure parent){
		for (Structure kind : WaxholmTags)
		{
			if (kind.isChild(parent)) {
				WaxholmTags.add(kind);
				SortKinder(kind);
			}
		}
	}
	public static void PrintNames (Structure str) {
		System.out.println(str.getName());
	}
	public static String[] getTags(){
		String[] WaxholmTagName = new String[WaxholmTags.size()];
		for (int i = 0; i < WaxholmTags.size(); i++)
		{
			WaxholmTagName[i] = WaxholmTags.get(i).getName();
		}
		return WaxholmTagName;
	}
	public static void showKinder (){
		Structure root = WaxholmTags.get(0);
		List<Structure> lista = root.getChildren();
			for (Structure kind: lista)
			{
				System.out.println(kind.getName());
			};
	}

}
