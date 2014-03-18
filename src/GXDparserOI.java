import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GXDparserOI {

	protected static ArrayList<Structure> tagidentifiers;
	protected static HashSet<Integer> MGIidentifiers;

	public static void main(String[] args) {
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
		int c = 0;
		for (int n : MGIidentifiers)
		{
			System.out.println(n);
			c++;
		}
		System.out.println(c);
	}
	public static ArrayList<Structure> getchildren(int father)
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
					if (tagidentifiers == null) System.out.println("NOOOOOOO");	
					tagidentifiers.add(child);
				}
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return children;
	}

	public static Set<Integer> GXDtoMGIconverter(ArrayList<Structure> tagidentifiers2)
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

	public static Structure FillFields(ResultSet rs, int k) throws SQLException {
			rs.absolute(k+1);
			Structure tag = new Structure();
			tag.setId(rs.getString(1));
			tag.setParentStructureId(rs.getString(2));
			tag.setStructureNameKey(rs.getString(3));
			tag.setEdinburghKey(rs.getString(5));
			tag.setName(rs.getString(6));
			tag.setTreeDepth(rs.getString(7));
			tag.setPrintStop(rs.getString(8));
			tag.setTopoSort(rs.getString(9));
			tag.addChildren(getchildren(rs.getInt(1)));
			return tag;
	}
}
