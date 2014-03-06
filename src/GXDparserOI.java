import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GXDparserOI {

	protected ArrayList<Integer> tagidentifiers;
	
	public static void main(String[] args) {
		ArrayList<Integer> tagidentifiers = new ArrayList<Integer>(); ;
		int childnumber = 7005;
		tagidentifiers.add(childnumber);
		try
		{
			for (int index = 0; index < tagidentifiers.size(); index ++)
			{
				int [] children = getchildren(tagidentifiers.get(index));
				int bindex = 0;
				while (children != null && bindex < children.length) 
				{ 
					int number = children[bindex];
					tagidentifiers.add(number); 
					System.out.println(number);
					bindex++;
				}
				
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public static int[] getchildren(int father)
	{
		int[] children = null;
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
				children = new int[size];
				for (int k = 1; k <= size; k++) 
				{ 
					rs.absolute(k);
					children[k-1] = rs.getInt(1); 
				}
			}
			else
			{
				children = null;
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return children;
	}
}
