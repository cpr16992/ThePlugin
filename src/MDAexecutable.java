import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class MDAexecutable {
	public ArrayList<Structure> MDATags = new ArrayList<Structure>();
	public Structure tag = new Structure(null, null);

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
					FillFields(mNode);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrintNames();
		//PrintChildren();
		System.out.println(MDATags.size());
	}
}
