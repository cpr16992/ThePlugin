

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MDAToSTR {
	public ArrayList<Structure> MDATags = new ArrayList<Structure>();
	public Structure tag = new Structure(null, null);
	public MDAToSTR(){
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
					tag = FillFields(mNode);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	
	private Structure FillFields(Node nNode) {	
		Element eElement = (Element) nNode;
		Structure tag = new Structure((eElement.getAttribute("id")), (eElement.getAttribute("name")));
		tag.setColorHexTriplet((eElement.getAttribute("color")));
		tag.setAcronym((eElement.getAttribute("abbreviation")));
		if (eElement.hasChildNodes())
		{
			NodeList kList = eElement.getChildNodes();
			for (int u = 0; u < kList.getLength(); u++)
			{
				Node mNode = kList.item(u);
				Structure tagchild = FillFields(mNode);
				tag.addChild(tagchild);
			}
		}
		MDATags.add(tag);
		return tag;
	}
	
	public String[] strToString(){
		String[] listofS = new String[MDATags.size()];
		int count = 0;
		for (Structure k: MDATags){
			listofS[count] = k.getName();
			count++;
		}
		Arrays.sort(listofS);
		return listofS;
	}

	public void PrintNames() {
		for (Structure str : MDATags) {
			System.out.println(str.getName());
		}
	}
	
	public ArrayList<Structure> getlist()
	{
		return MDATags;
	}
	
	public void PrintChildren() {
		for (int s = 0; s<MDATags.size(); s++)
		{
			List<Structure> Children = MDATags.get(s).getChildren();
			for (Structure str: Children)
			{
				System.out.println(str.getName());
			}
		}
	}
	public void SortKinder(Structure parent){
		for (Structure kind : MDATags)
		{
			if (kind.isChild(parent)) {
				MDATags.add(kind);
				SortKinder(kind);
			}
		}
	}
	public void PrintNames (Structure str) {
		System.out.println(str.getName());
	}
	public String[] getTags(){
		String[] MDATagName = new String[MDATags.size()];
		for (int i = 0; i < MDATags.size(); i++)
		{
			MDATagName[i] = MDATags.get(i).getName();
		}
		return MDATagName;
	}
	public void showKinder (){
		Structure root = MDATags.get(0);
		List<Structure> lista = root.getChildren();
		for (Structure kind: lista)
		{
			System.out.println(kind.getName());
		};
	}
	
	public Structure searchtag(String name){
		for (Structure k : MDATags){
			if (k.getName().equalsIgnoreCase(name)){
				return k;
			}
		}
		return null;
	}
	
	public ArrayList<Structure> getChildTags(String name){
		Structure father =  searchtag(name);
		ArrayList<Structure> ChildTags = new ArrayList<Structure>();
		if (father.getChildren() != null){
			ChildTags.addAll(father.getChildren());
		}
		return ChildTags;
	}
	
	public ArrayList<Structure> getAllDescendants(String name){
		ArrayList<Structure> firstLevelChildren = getChildTags(name);
		ArrayList<Structure> descendants = new ArrayList<Structure>();
		if (firstLevelChildren != null){
			for (Structure s: firstLevelChildren){
				ArrayList<Structure> nextLevelChildren = getAllDescendants(s.getName());
				descendants.addAll(nextLevelChildren);
			}
			descendants.addAll(firstLevelChildren);
		}
		return descendants;
	}
	
	public void showAllDescendants(String name){
		ArrayList<Structure> descendants = getAllDescendants(name);
		for (Structure s: descendants){
			System.out.println(s.getName());
		}
	}
	
	public int getsize(){
		return MDATags.size();
	}

}
