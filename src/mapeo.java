import jxl.*; 

import java.io.*; 
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class mapeo {
	public Hashtable<Structure, ArrayList<Structure>> MDAtoaGEM = new Hashtable<Structure, ArrayList<Structure>>();
	public Hashtable<ArrayList<Structure>, Structure> aGEMtoMDA = new Hashtable<ArrayList<Structure>, Structure>();
	public MDAToSTR MDAlist = new MDAToSTR();
	public aGEMtaglist aGEMlist = new aGEMtaglist();
	public mapeo() { 
		try { 
			Workbook archivoExcel = Workbook.getWorkbook(new File("C:\\Users\\cporras\\git\\ThePlugin\\DOC\\mapeo.xls"));                                                                                                                                                    
			Sheet hoja = archivoExcel.getSheet(0); 
			int numFilas = hoja.getRows();
			ArrayList<Structure> MDAtags = MDAlist.getlist();
			for (Structure n: MDAtags) {
				ArrayList<Structure> aGEMcorrespondencias = new ArrayList<Structure>();
				for (int fila = 0; fila < numFilas; fila ++){
					String MDAcandidate = hoja.getCell(1, fila).getContents();
					if (MDAcandidate.equalsIgnoreCase(n.getName())){
						String aGEMname = hoja.getCell(0, fila).getContents();
						Structure aGEMfound = aGEMlist.search(aGEMname);
						aGEMcorrespondencias.add(aGEMfound);
					}
				}
				MDAtoaGEM.put(n, aGEMcorrespondencias);
				aGEMtoMDA.put(aGEMcorrespondencias, n);
			} 
		} catch (Exception ioe) { 
			ioe.printStackTrace(); 
		} 

	} 

	public ArrayList<Structure> FindCorrespondences(String MDAname){
		Structure MDAStr = MDAlist.searchtag(MDAname);
		ArrayList<Structure> correspondences = MDAtoaGEM.get(MDAStr);
		return correspondences;
	}

	public void ShowCorrespondences(String MDAname){
		ArrayList<Structure> MDAstruct = FindCorrespondences(MDAname);
		for (Structure k: MDAstruct){
			System.out.println(k.getName());
		}
	}

	public ArrayList<Structure> FindAllDownstreamCorrespondences(String MDAname){
		Structure father = MDAlist.searchtag(MDAname);
		ArrayList<Structure> queriedStructures = MDAlist.getAllDescendants(MDAname);
		queriedStructures.add(father);
		ArrayList<Structure> downstreamCorrespondences = new ArrayList<Structure>();
		for (Structure s:queriedStructures){
			ArrayList<Structure> correspondences = FindCorrespondences(s.getName());
			downstreamCorrespondences.addAll(correspondences);
		}
		return downstreamCorrespondences;
	}

	public void showDownstreamCorrespondences(String MDAname){
		ArrayList<Structure> list = FindAllDownstreamCorrespondences(MDAname);
		for (Structure k:list){
			System.out.println(k.getName());
		}
	}

	public Structure FindInverseCorrespondence(String aGEMname){
		Structure StrOI = aGEMlist.search(aGEMname);
		Enumeration<ArrayList<Structure>> aGtags = MDAtoaGEM.elements();
		Enumeration<Structure> MDAtags = MDAtoaGEM.keys();
		while (aGtags.hasMoreElements()){
			ArrayList<Structure> piecelist = aGtags.nextElement();
			Structure current = MDAtags.nextElement();
			if (piecelist.contains(StrOI))
			{
				return current;
			}
		}
		System.out.println("Structure not found");
		return null;
	}

	public void ShowInverseCorrespondence(String aGEMname){
		Structure corr = FindInverseCorrespondence(aGEMname);
		if (corr != null){
			System.out.println(corr.getName());
		}
	}
	
	public ArrayList<Structure> FindInverseDownstreamCorrespondences(String aGEMname){
		Structure StrOI = aGEMlist.search(aGEMname);
		ArrayList<Structure> queriedStructures = aGEMlist.getAllDescendants(aGEMname);
		queriedStructures.add(StrOI);
		ArrayList<Structure> downstreamCorrespondences = new ArrayList<Structure>();
		for (Structure s:queriedStructures){
			Structure correspondence = FindInverseCorrespondence(s.getName());
			if (downstreamCorrespondences.contains(correspondence) == false){
				downstreamCorrespondences.add(correspondence);	
			}
		}
		return downstreamCorrespondences;
	}
	
	public void ShowInverseDownstreamCorrespondences(String aGEMname){
		ArrayList<Structure> list = FindInverseDownstreamCorrespondences(aGEMname);
		for (Structure s: list){
			System.out.println(s.getName());
		}
	}

}