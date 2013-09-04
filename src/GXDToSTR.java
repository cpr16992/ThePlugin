



import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GXDToSTR {
	//private static ArrayList<Structure> tags = new ArrayList<Structure>();
	private static ArrayList<Structure> tagswithoutlevel = new ArrayList<Structure>();

	public static void main(String argv[]) {

		try {

			File fXmlFile = new File("C:\\Users\\carlos\\Desktop\\GXD_filtered.xml");
			/* The line above is to be substituted by the path of the file containing the atlas
			 * In case of an update, change the path by the one csontaining the latest version of
			 * the atlas ontology.
			 */
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("ROW");
			for (int temp = 0; temp < nList.getLength(); temp++)
			{
				Node nNode = nList.item(temp);
				/*Structure struct =*/ FillFields(nNode);
			}
			/*for (int i = 0; i < tagswithoutlevel.size(); i++){
				String ActualParentKey = tagswithoutlevel.get(i).getParentKey();
				for(int counter = i; counter < tagswithoutlevel.size(); counter++)
				{
					if(tagswithoutlevel.get(counter).isChild(ActualParentKey))
					{
						tagswithoutlevel.get(i).addChild(tagswithoutlevel.get(counter));
					}
				//PrintNames(str);
				}
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrintNames();
	}
	public static void FillFields(Node nNode) {
		Structure tag = new Structure();
		Element eElement = (Element) nNode;
		tag.setStructureKey((eElement.getElementsByTagName("_Structure_key").item(0).getTextContent()));
		tag.setParentKey((eElement.getElementsByTagName("_Parent_key").item(0).getTextContent()));
		tag.setStructureNameKey((eElement.getElementsByTagName("_StructureName_key").item(0).getTextContent()));
		tag.setStageKey((eElement.getElementsByTagName("_Stage_key").item(0).getTextContent()));
		tag.setEdinburghKey((eElement.getElementsByTagName("edinburghKey").item(0).getTextContent()));
		tag.setName((eElement.getElementsByTagName("printName").item(0).getTextContent()));
		tag.setTreeDepth((eElement.getElementsByTagName("treeDepth").item(0).getTextContent()));
		tag.setPrintStop((eElement.getElementsByTagName("printStop").item(0).getTextContent()));
		tag.setTopoSort((eElement.getElementsByTagName("topoSort").item(0).getTextContent()));
		tagswithoutlevel.add(tag);
		for (Structure str: tagswithoutlevel)
		{
			if (tag.isChild(str.getStructureKey()))
			{
				str.addChild(tag);
			}
		}
	}
	public static void PrintNames () {
		for (Structure str:tagswithoutlevel)
		{
			System.out.println(str.getName());
		}
	}
}