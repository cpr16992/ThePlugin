import jxl.*; 

import java.io.*; 
import java.util.ArrayList;
import java.util.Hashtable;

public class mapeo {
	public Hashtable<Structure, ArrayList<Structure>> MDAtoaGEM = new Hashtable<Structure, ArrayList<Structure>>();
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
			} 
		} catch (Exception ioe) { 
			ioe.printStackTrace(); 
		} 

	} 
	
	public ArrayList<Structure> findcorrespondences(String MDAname){
		Structure MDAStr = MDAlist.searchtag(MDAname);
		ArrayList<Structure> correspondences = MDAtoaGEM.get(MDAStr);
		return correspondences;
	}
}