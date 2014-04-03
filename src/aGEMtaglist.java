import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class aGEMtaglist {

	public ArrayList<Structure> tagidentifiers;
	public HashSet<Integer> MGIidentifiers;

	public aGEMtaglist (){
		tagidentifiers = new ArrayList<Structure>(); ;
		try {
			Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost/agem_31","root", "1609");
			Statement s = conexion.createStatement(); 
			ResultSet rs = s.executeQuery ("select * from tbvg_mgi_gxd_structure where _Structure_key = 7005;");
			rs.last();
			int size = rs.getRow();
			rs.first();
			for (int k = 0; k < size; k++)
			{
				Structure result = FillFields(rs, k);
				tagidentifiers.add(result);
			};
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		MGIidentifiers = (HashSet<Integer>) GXDtoMGIconverter(tagidentifiers);
	}
	private  ArrayList<Structure> extractchildren(int father)
	{
		ArrayList<Structure> children = new ArrayList<Structure>();
		Connection conexion;
		try {
			conexion = DriverManager.getConnection ("jdbc:mysql://localhost/agem_31","root", "1609");
			Statement s = conexion.createStatement(); 
			ResultSet rs = s.executeQuery ("select * from tbvg_mgi_gxd_structure where _Parent_key = " + father + ";");
			rs.last();
			int size = rs.getRow();
			rs.first();
			if (size >0)
			{
				for (int k = 0; k < size; k++)
				{
					Structure child = FillFields(rs, k);
					children.add(child);
					tagidentifiers.add(child);
				}
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return children;
	}

	private Set<Integer> GXDtoMGIconverter(ArrayList<Structure> tagidentifiers2)
	{
		Set<Integer> MGItags = new HashSet<Integer>();
		String query = new String();
		query = "";
		for (Structure n : tagidentifiers2)
		{
			String id = n.getId();
			query = query + id + ", ";
		}
		try {
			Connection conexion;
			conexion = DriverManager.getConnection ("jdbc:mysql://localhost/agem_31","root", "1609");
			Statement s = conexion.createStatement(); 
			query = query.substring(0, query.length()-2);
			query = "select * from tbvg_gxd_core where structure_id in (" + query + ");";
			ResultSet rs = s.executeQuery (query);
			while (rs.next()) 
			{ 
				MGItags.add((rs.getInt (2)));
			}
			conexion.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return MGItags;
	}

	private Structure FillFields(ResultSet rs, int k) throws SQLException {//setter for fields
		rs.absolute(k+1);
		Structure tag = new Structure(rs.getString(1), rs.getString(6));
		tag.setParentStructureId(rs.getString(2));
		tag.setStructureNameKey(rs.getString(3));
		tag.setEdinburghKey(rs.getString(5));
		tag.setTreeDepth(rs.getString(7));
		tag.setPrintStop(rs.getString(8));
		tag.setTopoSort(rs.getString(9));
		tag.addChildren(extractchildren(rs.getInt(1)));
		return tag;
	}
	public ArrayList<Structure> getGXDtags(){
		return tagidentifiers;
	}
	public HashSet<Integer> getMGIidentifiers(){
		return MGIidentifiers;
	}
	public  void printer(){
		int c = 0;
		for (Structure n : tagidentifiers)
		{
			System.out.println(n.getName());
			c++;
		}
		System.out.println(c);
	}
	public Structure search(String name){
		for (Structure k : tagidentifiers){
			if (k.getName().equalsIgnoreCase(name)){
				return k;
			}
		}
		return null;
	}
	public Structure searchbyID(String ID){
		for (Structure k : tagidentifiers){
			if (k.getId().equals(ID)){
				return k;
			}
		}
		return null;
	}
	public ArrayList<Structure> getChildren(String fathername){
		Structure father = search(fathername);
		return (ArrayList<Structure>) father.getChildren();
	}

	public void showChildren(String fathername){
		ArrayList<Structure> children = getChildren(fathername);
		for (Structure n: children){
			System.out.println(n.getName());
		}
	}
	public ArrayList<Structure> getAllDescendants(String fathername){
		ArrayList<Structure> children = getChildren(fathername);
		ArrayList<Structure> allDescendants = new ArrayList<Structure>();
		if (children.isEmpty() == false){
			for (Structure n: children){
				ArrayList<Structure> grandchildren = getAllDescendants(n.getName());
				allDescendants.addAll(grandchildren);
			}
		}
		allDescendants.addAll(children);
		return allDescendants;
	}

	public void showAllDescendants(String fathername){
		ArrayList<Structure> allDescendants = getAllDescendants(fathername);
		for (Structure n: allDescendants){
			System.out.println(n.getName());
		}
	}

	public Structure getFather(String name){
		Structure sibiling = search(name);
		Structure father = searchbyID(sibiling.getParentStructureId());
		return father;
	}

	public ArrayList<Structure> getAllAncestors(String name){
		Structure father = getFather(name);
		ArrayList<Structure> ancestors = new ArrayList<Structure>();
		if (name.equals("brain") == false){
			ArrayList <Structure> moreancestors = getAllAncestors(father.getName());
			if (moreancestors.isEmpty() == false){
				ancestors.addAll(moreancestors);
			}
		}
		if (father != null){
			ancestors.add(father);
		}
		return ancestors;
	}

	public void showAllAncestors(String name){
		ArrayList<Structure> ancestors = getAllAncestors(name);
		for (Structure n: ancestors){
			System.out.println(n.getName());
		}
	}
}
