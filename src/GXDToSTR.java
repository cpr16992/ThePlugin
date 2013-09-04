
import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GXDToSTR {
	private static ArrayList<Structure> temp = new ArrayList<Structure>();
	private static ArrayList<Structure> GXDtags = new ArrayList<Structure>();

	public static void main(String argv[]) {

		try {

			File fXmlFile = new File(
					"C:\\Users\\carlos\\Desktop\\GXD_filtered.xml");
			/*
			 * The line above is to be substituted by the path of the file
			 * containing the atlas In case of an update, change the path by the
			 * one csontaining the latest version of the atlas ontology.
			 */
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("ROW");
			for (int t = 0; t < nList.getLength(); t++) {
				Node nNode = nList.item(t);
				FillFields(nNode);
			}
			for (Structure str : temp) // recorro la lista temporal
			{
				if (str.getId().equals("7005")) {
					Structure brain = str;
					GXDtags.add(brain); // añado el root que es brain a la lista
					// final
					SortKinder(brain);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrintNames();
		System.out.println(temp.size());
		System.out.println(GXDtags.size());
	}

	public static void FillFields(Node nNode) {
		Structure tag = new Structure();
		Element eElement = (Element) nNode;
		tag.setId((eElement.getElementsByTagName("_Structure_key")
				.item(0).getTextContent()));
		tag.setParentStructureId((eElement.getElementsByTagName("_Parent_key").item(0)
				.getTextContent()));
		tag.setStructureNameKey((eElement.getElementsByTagName(
				"_StructureName_key").item(0).getTextContent()));
		tag.setEdinburghKey((eElement.getElementsByTagName("edinburghKey")
				.item(0).getTextContent()));
		tag.setName((eElement.getElementsByTagName("printName").item(0)
				.getTextContent()));
		tag.setTreeDepth((eElement.getElementsByTagName("treeDepth").item(0)
				.getTextContent()));
		tag.setPrintStop((eElement.getElementsByTagName("printStop").item(0)
				.getTextContent()));
		tag.setTopoSort((eElement.getElementsByTagName("topoSort").item(0)
				.getTextContent()));
		temp.add(tag);
		for (Structure str : temp) {
			if (tag.isChild(str)) {
				str.addChild(tag);
			}
		}
	}

	public static void PrintNames() {
		for (Structure str : GXDtags) {
			System.out.println(str.getName());
		}
	}
	public static void SortKinder(Structure parent){
		for (Structure kind : temp)
		{
			if (kind.isChild(parent)) {
				GXDtags.add(kind);
				SortKinder(kind);
			}
		}
	}
}