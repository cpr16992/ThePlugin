

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AllenToSTR {
	private static ArrayList<Structure> AllenTags = new ArrayList<Structure>();

	public static void main(String argv[]) {

		try {

			File fXmlFile = new File("C:\\Users\\carlos\\git\\XML_fileproject\\XML_fileproject\\src\\ref.xml");
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
				FillFields(nNode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(AllenTags.size());
		//PrintNames();
		showKinder();
	}
	public static void FillFields(Node nNode) {
		Structure tag = new Structure();
		Element eElement = (Element) nNode;
		tag.setId((eElement.getElementsByTagName("id").item(0).getTextContent()));
		tag.setAtlasId((eElement.getElementsByTagName("atlas-id").item(0).getTextContent()));
		tag.setOntologyId((eElement.getElementsByTagName("ontology-id").item(0).getTextContent()));
		tag.setAcronym((eElement.getElementsByTagName("acronym").item(0).getTextContent()));
		tag.setName((eElement.getElementsByTagName("name").item(0).getTextContent()));
		tag.setColorHexTriplet((eElement.getElementsByTagName("color-hex-triplet").item(0).getTextContent()));
		tag.setGraphOrder((eElement.getElementsByTagName("graph-order").item(0).getTextContent()));
		tag.setStLevel((eElement.getElementsByTagName("st-level").item(0).getTextContent()));
		tag.setHemisphereId((eElement.getElementsByTagName("hemisphere-id").item(0).getTextContent()));
		tag.setParentStructureId((eElement.getElementsByTagName("parent-structure-id").item(0).getTextContent()));
		AllenTags.add(tag);
		for (Structure str : AllenTags) {
			if (tag.isChild(str)) {
				str.addChild(tag);
			}
		}
	}

	public static void PrintNames() {
		for (Structure str : AllenTags) {
			System.out.println(str.getName());
		}
	}
	public static void SortKinder(Structure parent){
		for (Structure kind : AllenTags)
		{
			if (kind.isChild(parent)) {
				AllenTags.add(kind);
				SortKinder(kind);
			}
		}
	}
	public static void PrintNames (Structure str) {
		System.out.println(str.getName());
	}
	public static String[] getTags(){
		String[] AllenTagName = new String[AllenTags.size()];
		for (int i = 0; i < AllenTags.size(); i++)
		{
			AllenTagName[i] = AllenTags.get(i).getName();
		}
		return AllenTagName;
	}
	public static void showKinder (){
		Structure root = AllenTags.get(0);
		List<Structure> lista = root.getChildren();
			for (Structure kind: lista)
			{
				System.out.println(kind.getName());
			};
	}

}
