

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;

public class ReadXMLFile {
	private static ArrayList<Structure> tags = new ArrayList<Structure>();
	private static ArrayList<Structure> tagswithoutlevel = new ArrayList<Structure>();

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
			int temp = 0;
			Node nNode = nList.item(temp);
			Structure struct = FillFields(nNode);
			tags.add(struct);
			for (Structure str: tags){
				PrintNames(str);
			}
			for (Structure str: tagswithoutlevel){
				PrintNames(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Structure FillFields(Node nNode) {
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
		NodeList children = eElement.getElementsByTagName("children");
		if (children.getLength() >= 1)
		{
			Node strNode = children.item(0);
			Element fElement = (Element) strNode;
			NodeList ChildStructures = fElement.getElementsByTagName("structure");
			for (int temp = 0; temp < ChildStructures.getLength(); temp++) {
				Node ChildStructuresN = ChildStructures.item(temp);
				Structure Ch = FillFields(ChildStructuresN);
				tag.addChild(Ch);
			}
		}
		tagswithoutlevel.add(tag);
		return tag;
	}
	public static void PrintNames (Structure str) {
		System.out.println(str.getName());
	}
}
